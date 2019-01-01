package test;

import com.springwalk.sample.SampleApplication;
import com.springwalk.sample.repo.CustomerRepository;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import com.springwalk.sample.model.Customer;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleApplication.class)
public class CustomerRepositoryIntegrationTest {

    @Autowired
    CustomerRepository repository;

    @Test
    public void myTest() throws Exception {

        Customer customer = new Customer();
        customer.setId(100l);
        customer.setFirstName("John");
        customer.setLastName("Wick");

        repository.save(customer);

        List<?> queryResult = repository.findByLastName("Wick");

        assertFalse(queryResult.isEmpty());
        assertNotNull(queryResult.get(0));
    }
}
