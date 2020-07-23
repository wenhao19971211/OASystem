import com.geek.service.LeaveService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ServiceTest {
    @Autowired
    LeaveService leaveService;
    @Test
    public void leaveServiceTest(){
        leaveService.addLeave(1,5,"service请个假测试",new Date(),
                new Date(),1);
        System.out.println("测试成功");
    }
}
