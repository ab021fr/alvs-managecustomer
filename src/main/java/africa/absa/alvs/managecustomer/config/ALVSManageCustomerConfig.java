package africa.absa.alvs.managecustomer.config;

import africa.absa.alvs.managecustomer.processor.handlers.ProcessInOnlyHandler;
import africa.absa.alvs.managecustomer.processor.handlers.impl.ManageCustomerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ALVSManageCustomerConfig {

    @Bean(name = "manageCustomerHandler")
    public ProcessInOnlyHandler manageCustomerHandler(){
        return new ManageCustomerHandler();
    }

}
