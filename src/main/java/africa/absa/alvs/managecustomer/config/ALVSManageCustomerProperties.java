package africa.absa.alvs.managecustomer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "ceb")
public class ALVSManageCustomerProperties {

    private List<Map<String, String>> send;
}
