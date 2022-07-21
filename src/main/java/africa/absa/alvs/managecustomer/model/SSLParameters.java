package africa.absa.alvs.managecustomer.model;

import africa.absa.alvs.managecustomer.processor.handlers.ProcessInOnlyHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.camel.CamelContext;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class SSLParameters {

    private CamelContext camelContext;
    private String endpoint;
    private String keyStoreLocation;
    private String keyStorePass;
}

