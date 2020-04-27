package com.jiladahe1997.embeddedproxy.controllers;


import com.jiladahe1997.embeddedproxy.example.mapper.XxlJobLogDynamicSqlSupport;
import com.jiladahe1997.embeddedproxy.example.mapper.XxlJobLogMapper;
import com.jiladahe1997.embeddedproxy.example.model.XxlJobLog;
import com.jiladahe1997.embeddedproxy.models.CommonReturn;
import com.jiladahe1997.embeddedproxy.models.scheduling.ScheduleResultVO;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ScheduleResult {

    @Autowired
    XxlJobLogMapper xxlJobLogMapper;

    @RequestMapping("/api/schedule/result")
    public CommonReturn getScheduleResultByTaskHandleName(@RequestParam List<String> handleName) {
        List<ScheduleResultVO> ret = new ArrayList<>();
        handleName.forEach(e->{
            XxlJobLog lastJobLog = xxlJobLogMapper.selectOne(c->c
                    .where(XxlJobLogDynamicSqlSupport.executorHandler, SqlBuilder.isEqualTo(e))
                    .orderBy(XxlJobLogDynamicSqlSupport.handleTime.descending())
                    .limit(1)).get();
            ScheduleResultVO scheduleResultVO = new ScheduleResultVO();
            scheduleResultVO.setHandleName(lastJobLog.getExecutorHandler());
            scheduleResultVO.setSuccess(lastJobLog.getTriggerCode() == 200);
            scheduleResultVO.setTriggerTime(lastJobLog.getHandleTime());
            ret.add(scheduleResultVO);
        });


        return new CommonReturn().success(ret);
    }
}
