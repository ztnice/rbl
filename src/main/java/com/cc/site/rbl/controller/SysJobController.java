package com.cc.site.rbl.controller;

import com.alibaba.fastjson.JSON;
import com.cc.site.rbl.entity.SysJob;
import com.cc.site.rbl.service.SysJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haozt
 * @since 2021/3/5
 */
@RestController
@RequestMapping("/job")
public class SysJobController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final SysJobService sysJobService;

    public SysJobController(SysJobService sysJobService) {
        this.sysJobService = sysJobService;
    }

    @GetMapping("/all")
    public String listAll(){
       List<SysJob> list = sysJobService.listAllSysJob();
       return JSON.toJSONString(list);
    }

    @GetMapping("/insert")
    public void insert(){

        SysJob sysJob = new SysJob();
        sysJob.setJobName("22313");
        sysJob.setJobStatus(1);
        sysJob.setJobStatusStr("23333");
        sysJob.setJobCron("* /1 * * ?");
        sysJob.setJobGroup("23");
        sysJob.setJobClassPath("2313");
        sysJob.setJobDataMap("");
        sysJob.setJobDescribe("测试");
        int result = sysJobService.insert(sysJob);
        System.out.println(result);

        logger.info("新增数据成功");


    }

    @GetMapping("/update")
    public void update(){
        SysJob sysJob = new SysJob();
        sysJob.setJobName("22313");
        sysJob.setJobStatus(1);
        sysJob.setJobStatusStr("23333");
        int result = sysJobService.update(sysJob);
        System.out.println(result);
        logger.info("修改数据成功");

    }

}
