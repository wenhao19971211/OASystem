package com.geek.handler;

import com.geek.pojo.Emp;
import com.geek.pojo.ReleaseTabe;
import com.geek.service.ReleaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Date;

@Controller
public class ReleaseInfoHandler {
    @Autowired
    private ReleaseInfoService releaseInfoService;

    @PostMapping("releaseInfo")
    @ResponseBody
    public String releaseInfo(@SessionAttribute Emp loginEmp,String title, String content)
    {
        ReleaseTabe releaseTabe = new ReleaseTabe();
        releaseTabe.setReleaseTitle(title);
        releaseTabe.setReleaseContent(content);
        releaseTabe.setReleaseTime(new Date());
        boolean b = releaseInfoService.addInfo(releaseTabe);
        String flag = "success";
        if (!b)
        {
            flag = "failed";
        }

        return flag;
    }


}
