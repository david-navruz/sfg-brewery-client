package guru.springframework.sfgbreweryclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import guru.springframework.sfgbreweryclient.web.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "sfg.brewery.client", ignoreUnknownFields = false)
@Component
public class CustomerClient {


    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apihost = "http://localhost:8080";

    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(UUID customerId) {
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + customerId, customerDto);
    }

    public void deleteCustomer(UUID customerId) {
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + customerId);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
