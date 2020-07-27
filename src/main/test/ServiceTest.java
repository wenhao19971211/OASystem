import com.geek.dao.DayOffDao;
import com.geek.dao.MessageDao;
import com.geek.pojo.*;
import com.geek.service.CheckWorkService;
import com.geek.service.ContractService;
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
    @Autowired
    ContractService contractService;
    @Autowired
    DayOffDao dayOffDao;
    @Autowired
    CheckWorkService checkWorkService;
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

//        Emp emp = empService.findManagerBydepId(60);
//        System.out.println(emp.getEmpName());
//        List<Emp> list = empService.findAll(1);
//        for (Emp emp : list) {
//            System.out.println(emp.getEmpName()+"\t"+emp.getDep().getDepName());
//        }
//        Contract contract =  contractService.findContractByEmpId(2);
//        System.out.println(contract.getContractId());
//        List<DayOff> list = dayOffDao.findAllDayOffBydepIdAndempId(0,1,1);
//        for (DayOff dayOff : list) {
//            System.out.println(dayOff.getStartTime()+"\t"+dayOff.getEndTime());
//        }
        List<CheckWork> list = checkWorkService.findById(5);
        for (CheckWork checkWork : list) {
            System.out.println(checkWork.getEmp().getEmpName()+"\t"+checkWork.getToday()+"\t"+checkWork.getIsLate());
        }
    }
}
