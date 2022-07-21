package africa.absa.alvs.managecustomer.processor.handlers;

import com.ibm.msg.client.wmq.WMQConstants;
import org.apache.camel.Exchange;
import org.apache.camel.component.jms.JmsMessage;


public interface ProcessInOnlyHandler {

    default void decodeRequestMessage(Exchange exchange) throws Exception {

        JmsMessage message = (JmsMessage) exchange.getIn();
        String codePage = message.getJmsMessage().getStringProperty(WMQConstants.JMS_IBM_CHARACTER_SET);

        byte[] receivedMessage = (byte[]) exchange.getIn().getBody();
        String stringMessage = new String(receivedMessage, codePage);

        exchange.getIn().setBody(stringMessage);
    }
    void processRequest(Exchange exchange) throws Exception;
    void processResponse(Exchange exchange) throws Exception;
    void handleError(Exchange exchange);

    default void validateStatusCode(Exchange exchange) throws Exception {

        Integer statusCode = (Integer) exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE);

        if(statusCode == null || statusCode <200 || statusCode>299){
            throw new Exception();
        }
    }
}
