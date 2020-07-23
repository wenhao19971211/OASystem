import com.geek.bo.TaskReceive_bo;
import com.geek.bo.TaskSend_bo;
import com.geek.handler.TaskSendHandler;
import com.geek.pojo.TaskReceive;
import com.geek.pojo.TaskSend;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Test {
    @Autowired
    private TaskSendHandler taskSendHandler;

    @org.junit.Test
    public void test1()
    {
        Integer[] receiveEmpIds = new Integer[]{2,3};
        String flag = taskSendHandler.addTask(1, "ceshi", "ceshi", new Date(), new Date(), receiveEmpIds);
        System.out.println("flag:"+flag);
    }

    @org.junit.Test
    public void test2()
    {
        TaskReceive_bo task = taskSendHandler.findTaskByStatus(6, 1, 2);
        for (TaskReceive taskReceive : task.getTaskReceives()) {
            System.out.println("taskReceive:"+taskReceive);
            System.out.println("taskReceive.getTaskSend():"+taskReceive.getTaskSend());
        }
        System.out.println(task.getTotal());
    }
    @org.junit.Test
    public void test3()
    {
        TaskSend_bo taskSend_bo = taskSendHandler.findTaskByempId(1, 1);
        for (TaskSend taskSend : taskSend_bo.getTaskSends()) {
            System.out.println("taskSend"+taskSend);
            for (TaskReceive taskReceive : taskSend.getTaskReceives()) {
                System.out.println("taskReceive"+taskReceive);
            }

        }
        System.out.println(taskSend_bo.getTotal());
    }
    @org.junit.Test
    public void test4()
    {
        System.out.println("test4");
        TaskSend_bo taskSend_bo = taskSendHandler.findTaskByTitle(1, "c", 1);
        System.out.println("size()"+taskSend_bo.getTaskSends().size());
        for (TaskSend taskSend : taskSend_bo.getTaskSends()) {
            System.out.println("taskSend:"+taskSend);
            for (TaskReceive taskReceive : taskSend.getTaskReceives()) {
                System.out.println("taskReceive"+taskReceive);
            }
        }
    }
    @org.junit.Test
    public void test5()
    {
        String flag = taskSendHandler.finishTask(28);
        System.out.println("flag:"+flag);
    }


}
