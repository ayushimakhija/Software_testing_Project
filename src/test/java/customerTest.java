import com.fooddel.Services.CustomerService;
import com.fooddel.beans.Customer;
import com.fooddel.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Paths.get;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest//(classes = customerTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class customerTest {

    //@Autowired
    private CustomerService cs;



    @MockBean
    private CustomerRepository cr;



    @Test
    public  void getCustomerTest()
    {
        when(cr.findAll()).thenReturn(Stream.of(new Customer("pavan","singh","8686886135","hyderabad","pavansingh9900@gmail.com","pavan",false),new Customer("ayushman","khurana","8869054251","narsinghpur","ayushman9ym.19@gmail.com","ayush",false)).collect(Collectors.toList()));
        System.out.println("testcase 1 hit");
        assertEquals(2,cs.getCustomers().size());

    }

    @Test
    void test()
    {
        fail("Not Yet Implemented");
    }



    @Test
    void tests()
    {
        assertEquals(2,2);
    }

}
