import com.geek.dao.MessageDao;
import com.geek.pojo.Emp;
import com.geek.pojo.Message;
import com.geek.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ServiceTest {
    @Autowired
    MessageDao messageDao;
    @Autowired
    EmpService empService;
    @Test
    public void test(){
//        List<Message> list = messageDao.findAllById(1);
//        for (Message message : list) {
//            String type = "";
//            if (message.getMessageType()==2){
//                type = "请假";
//            }
//            else if (message.getMessageType() == 3){
//                type = "报销";
//            }
//            System.out.println(message.getEmp().getEmpName()+"\t"+type+"\t"+message.getMessageContent());
//        }
//        List<Message> list = messageDao.findNoExamineById(1);
//        System.out.println(list.size());
//        for (Message message : list) {
//            System.out.println(message.getMessageType()+"\t"+message.getMessageContent());
//        }
//        Emp emp = empService.findEmpById(1);
//        System.out.println(emp.getEmpName());
    }
}
