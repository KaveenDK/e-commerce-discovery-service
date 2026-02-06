package lk.ijse.edu.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * --------------------------------------------
 * @Author Dimantha Kaveen
 * @GitHub: https://github.com/KaveenDK
 * @Website: https://dimantha-kaveen-portfolio.web.app/
 * @Linkdin: https://www.linkedin.com/in/KaveeNDK/
 * --------------------------------------------
 * @Created 2/6/2026
 * @Project e-commerce
 * --------------------------------------------
 **/

@Configuration
public class RestTemplateConfig {
    
    @Bean
    @LoadBalanced
    public RestTemplate restTemplateConfig() {
        return new RestTemplate();
    }
}
