import com.geek.dto.Result;
import com.geek.handler.EmailHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class HandlerTest {
    @Autowired
    private EmailHandler emailHandler;
    @Test
    public void EmailHandlerTest(){


    }

}
