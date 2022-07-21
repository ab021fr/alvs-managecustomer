package africa.absa.alvs.managecustomer.processor.handlers.impl;

import africa.absa.alvs.managecustomer.processor.handlers.ProcessInOnlyHandler;
import org.apache.camel.Exchange;

public class ManageCustomerHandler implements ProcessInOnlyHandler {
    @Override
    public void processRequest(Exchange exchange) throws Exception {

    }

    @Override
    public void processResponse(Exchange exchange) throws Exception {

    }

    @Override
    public void handleError(Exchange exchange) {
        Exception exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT,Exception.class);
        exchange.setProperty("result","NoResult");
        //Todo Log exception

    }
}
