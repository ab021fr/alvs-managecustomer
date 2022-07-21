package africa.absa.alvs.managecustomer.route;

import africa.absa.alvs.managecustomer.model.ALVSRouteParameters;
import africa.absa.alvs.managecustomer.model.SSLParameters;
import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http.HttpComponent;
import org.apache.camel.support.jsse.KeyManagersParameters;
import org.apache.camel.support.jsse.KeyStoreParameters;
import org.apache.camel.support.jsse.SSLContextParameters;
import org.apache.camel.support.jsse.TrustManagersParameters;
import org.apache.http.conn.ssl.NoopHostnameVerifier;

import static africa.absa.alvs.managecustomer.common.Constants.JMS;
import static africa.absa.alvs.managecustomer.common.Constants.LOG_URI;

public abstract class ALVSManageCustomerGenericRoutes extends RouteBuilder {

    public void sendToQueueInOutWithDestinationQueue(final ALVSRouteParameters alvsRouteParameters) {

        from(String.format(JMS, alvsRouteParameters.getIncomingQueue()))//update uml
                .routeId(alvsRouteParameters.getServiceName())
                .choice()
                    .when(body().isNull()).setBody(constant(""))
                .end()
                .doTry()
                    .log("Request received from "+ alvsRouteParameters.getFromComponent() +"  [${body}]")
                    .bean(alvsRouteParameters.getProcessInOnlyHandler(), "decodeRequestMessage")
                    .log("Decoded message [${body}]")
                    .unmarshal(alvsRouteParameters.getFixedLengthDataFormat())
                    .bean(alvsRouteParameters.getProcessInOnlyHandler(), "processRequest")
                    .marshal(alvsRouteParameters.getSoapJaxbDataFormat())
                    .log("Transformed Request to " + alvsRouteParameters.getToComponent() + " ${body}")
                    .to(alvsRouteParameters.getEndpoint())
                    .bean(alvsRouteParameters.getProcessInOnlyHandler(),"validateStatusCode")
                    .unmarshal(alvsRouteParameters.getSoapJaxbDataFormat())
                    .bean(alvsRouteParameters.getProcessInOnlyHandler(),"processResponse")
                    .to(String.format(JMS, alvsRouteParameters.getDestinationQueue()))
                    .log("Message dispatched to queue : " + alvsRouteParameters.getDestinationQueue())
                .doCatch(Exception.class)
                    .bean(alvsRouteParameters.getProcessInOnlyHandler(), "handleError")
                    .to(String.format(JMS, alvsRouteParameters.getErrorQueue()))
                    .to(String.format(LOG_URI, alvsRouteParameters.getServiceName()))
                .end();
    }

    public Endpoint SSLParameters(SSLParameters sslParameters) throws Exception{
        KeyStoreParameters keyStoreParameters = new KeyStoreParameters();
        // Change this path to point to your truststore/keystore as jks files
        keyStoreParameters.setResource(sslParameters.getKeyStoreLocation());
        keyStoreParameters.setPassword(sslParameters.getKeyStorePass());

        KeyManagersParameters keyManagersParameters = new KeyManagersParameters();
        keyManagersParameters.setKeyStore(keyStoreParameters);
        keyManagersParameters.setKeyPassword(sslParameters.getKeyStorePass());

        TrustManagersParameters trustManagersParameters = new TrustManagersParameters();
        trustManagersParameters.setKeyStore(keyStoreParameters);

        SSLContextParameters sslContextParameters = new SSLContextParameters();
        sslContextParameters.setKeyManagers(keyManagersParameters);
        sslContextParameters.setTrustManagers(trustManagersParameters);

        HttpComponent httpComponent = sslParameters.getCamelContext().getComponent("https", HttpComponent.class);
        httpComponent.setSslContextParameters(sslContextParameters);
        //This is important to make your cert skip CN/Hostname checks
        httpComponent.setX509HostnameVerifier(NoopHostnameVerifier.INSTANCE);

        httpComponent.setX509HostnameVerifier((s, sslSession) -> {

            log.info(s + sslSession);
            return true;
        });
        return httpComponent.createEndpoint(sslParameters.getEndpoint());
    }
}
