package com.geek.handler;

import com.alibaba.fastjson.JSONObject;
import com.geek.pojo.Emp;
import com.geek.pojo.ReleaseTabe;
import com.geek.service.ReleaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReleaseInfoHandler {
    @Autowired
    private ReleaseInfoService releaseInfoService;

    /**
     * 信息发布
     * @param loginEmp
     * @param title
     * @param content
     * @return
     */
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

    /**
     * 信息查询
     */
    @GetMapping("findReleaseInfo")
    @ResponseBody
    public String findReleaseInfo()
    {
        List<ReleaseTabe> releaseInfos = releaseInfoService.findReleaseInfo();
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",releaseInfos.size());
        map.put("data",releaseInfos);
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        //System.out.println(json);
        return json;
    }



}
