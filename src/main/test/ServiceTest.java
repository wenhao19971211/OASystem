import com.geek.bo.CheckWork_bo;
import com.geek.bo.Prize_bo;
import com.geek.dao.*;
import com.geek.pojo.*;
import com.geek.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    CheckWorkDao checkWorkDao;
    @Autowired
    WorkOnDao workOnDao;
    @Autowired
    ContractDao contractDao;
    @Autowired
    DepartureDao departureDao;
    @Autowired
    ReAndPuService reAndPuService;
    @Autowired
    DepartureService departureService;
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
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date start = null;
//        Date end = null;
//        try {
//            start = sdf.parse("2020-07-01");
//            end = sdf.parse("2020-08-01");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        List<CheckWork> list = checkWorkDao.findById(5,start,end);
//        List<WorkOn> workOnList = workOnDao.findByIdAndMonth(5,start,end);
//        System.out.println(workOnList.size());
//        for (CheckWork checkWork : list) {
//            for (WorkOn workOn : workOnList) {
//                System.out.println(workOn.getEmp().getEmpName()+"\t"+workOn.getToday());
//            }
//
//        }
//        List<CheckWork_bo> list = checkWorkService.findById(1,start,end);
//        for (CheckWork_bo checkWork_bo : list) {
//            System.out.println(checkWork_bo.getToday()+"\t"+checkWork_bo.getWorkInTime()+"\t"+checkWork_bo.getWorkOutTime()+"\t"+checkWork_bo.getIsLate());
//        }

//        List<Contract> list = contractService.findAll();
//        for (Contract contract : list) {
//            System.out.println(contract.getContractId()+"\t"+contract.getEmp().getEmpName());
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String start = "2020-07-28";
//        String end = "2025-07-28";
//        Date startTime = null;
//        Date endTime = null;
//        try {
//            startTime = sdf.parse(start);
//            endTime = sdf.parse(end);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        contractService.updateById(1,15000,startTime,endTime,1);
//        List<Departure> list = departureDao.findDeparture(0,5);
//        for (Departure departure : list) {
//            System.out.println(departure.getReason());
//        }
//        List<Departure> list = departureDao.findDepartures(0,5);
//        for (Departure departure : list) {
//            System.out.println(departure.getReason());
//        }
//        List<ReAndPu> list = reAndPuService.findById(1);
//        for (ReAndPu reAndPu : list) {
//            System.out.println(reAndPu.getEmp().getEmpName()+"\t"+reAndPu.getMoney()+"\t"+reAndPu.getCause()+"\t"+reAndPu.getType()+"\t"+reAndPu.getItem());
//        }
//        Departure departure = new Departure(5,50,"qwe",new Date(),"qwe",1);
//        departureDao.addDeparture(departure);
//        List<Departure> list =  departureService.findDeparture(1,0,5);
//        System.out.println(list.size());
//          List<ReAndPu> list = reAndPuService.findAll();
//        for (ReAndPu reAndPu : list) {
//            System.out.println(reAndPu.getEmp().getEmpName());
//        }
//        Prize_bo prize_bo = reAndPuService.findById(1);
//        System.out.println(prize_bo.getCause());
//        ReAndPu reAndPu = new ReAndPu();
//        reAndPu.setEmpId(1);
//        reAndPu.setType(1);
//        reAndPu.setItem(1);
//        reAndPu.setCause("工作认真");
//        reAndPu.setMoney(300);
//        reAndPu.setReAndPuTime(new Date());
//        reAndPuService.addPrize(reAndPu);
    }
}
