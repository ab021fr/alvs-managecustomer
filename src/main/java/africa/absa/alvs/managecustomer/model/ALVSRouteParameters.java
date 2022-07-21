package africa.absa.alvs.managecustomer.model;

import africa.absa.alvs.managecustomer.processor.handlers.ProcessInOnlyHandler;
import lombok.*;
import org.apache.camel.Endpoint;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.model.dataformat.SoapJaxbDataFormat;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ALVSRouteParameters {

    private String serviceName;
    private ProcessInOnlyHandler processInOnlyHandler;
    private String errorQueue;
    private String incomingQueue;
    private String destinationQueue;
    private BindyFixedLengthDataFormat fixedLengthDataFormat;
    private Endpoint endpoint;
    private String fromComponent;
    private String toComponent;
    private SoapJaxbDataFormat soapJaxbDataFormat;
}

