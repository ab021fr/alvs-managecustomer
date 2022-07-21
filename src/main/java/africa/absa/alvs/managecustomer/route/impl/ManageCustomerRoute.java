package africa.absa.alvs.managecustomer.route.impl;

import africa.absa.alvs.managecustomer.model.ALVSRouteParameters;
import africa.absa.alvs.managecustomer.processor.handlers.ProcessInOnlyHandler;
import africa.absa.alvs.managecustomer.route.ALVSManageCustomerGenericRoutes;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ManageCustomerRoute extends ALVSManageCustomerGenericRoutes {

     private final ProcessInOnlyHandler manageCustomerHandler;

    @Override
    public void configure() throws Exception {
        ALVSRouteParameters alvsRouteParameters = new ALVSRouteParameters();
        alvsRouteParameters.setProcessInOnlyHandler(manageCustomerHandler);
        sendToQueueInOutWithDestinationQueue(alvsRouteParameters);
        //Todo Initialize the rest of the parameters
    }
}
