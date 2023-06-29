package guru.springframework.sfgbreweryclient.web.client;

import guru.springframework.sfgbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerClientTest {

    @Autowired
    private CustomerClient customerClient;


    @Test
    void getCustomerById() {
        CustomerDto dto = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }


    @Test
    void testSaveNewCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("Joe").build();
        URI uri = customerClient.saveNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }


    @Test
    void updateCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("Jim").build();
        customerClient.updateCustomer(UUID.randomUUID(), customerDto);
    }


    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }

}
