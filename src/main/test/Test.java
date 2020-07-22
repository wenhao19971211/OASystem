import com.geek.handler.TaskSendHandler;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Test {
    @Autowired
    private TaskSendHandler taskSendHandler;

    @org.junit.Test
    public void test1()
    {
        Integer[] receiveEmpIds = new Integer[]{2,3};
        //String flag = taskSendHandler.addTask(1, "ceshi", "ceshi", new Date(), new Date(), receiveEmpIds);
        //System.out.println("flag:"+flag);
    }

}
