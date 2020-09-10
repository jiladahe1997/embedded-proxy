package com.jiladahe1997.embeddedproxy.controllers;


import com.jiladahe1997.embeddedproxy.example.mapper.AnnouncementDynamicSqlSupport;
import com.jiladahe1997.embeddedproxy.example.mapper.AnnouncementMapper;
import com.jiladahe1997.embeddedproxy.example.mapper.XxlJobLogDynamicSqlSupport;
import com.jiladahe1997.embeddedproxy.example.mapper.XxlJobLogMapper;
import com.jiladahe1997.embeddedproxy.example.model.Announcement;
import com.jiladahe1997.embeddedproxy.example.model.XxlJobLog;
import com.jiladahe1997.embeddedproxy.models.CommonReturn;
import com.jiladahe1997.embeddedproxy.models.Data.AceptId;
import com.jiladahe1997.embeddedproxy.models.Data.AdmAnceList;
import com.jiladahe1997.embeddedproxy.models.Data.UserAnceDetail;
import com.jiladahe1997.embeddedproxy.models.Data.UserAnceList;
import com.jiladahe1997.embeddedproxy.models.scheduling.ScheduleResultVO;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@RestController
public class ScheduleResult {

    @Autowired
    XxlJobLogMapper xxlJobLogMapper;
    @Autowired
    AnnouncementMapper anceMapper;


    @RequestMapping(value = "/api/admin/AddAncemt" ,method = RequestMethod.POST)//添加接口
    public CommonReturn addAnce(@RequestBody Announcement ancemt)  {
        ancemt.setViews(0);
        anceMapper.insert(ancemt);
        return new CommonReturn().success(null);
    }

    @RequestMapping(value = "/api/user/AncemtList",method = RequestMethod.GET)//查询接口——公告列表——用户
    public CommonReturn userAnceList()  {
        List<Announcement> res =  anceMapper.select(c->c);
        List<UserAnceList> modif = new ArrayList<UserAnceList>();
        res.stream().forEach(anceInfo->{ UserAnceList listinf = new UserAnceList();
            listinf.setId(anceInfo.getId());
            listinf.setTitle(anceInfo.getTitle());
            listinf.setTime(anceInfo.getTime());
            modif.add(listinf);});
        return new CommonReturn().success(modif);
    }

    @RequestMapping(value = "/api/user/AncemtDetl",method = RequestMethod.POST)//查询接口——公告详情——用户
    public CommonReturn userAnceDetail(@RequestBody AceptId paramId) {
        int id = paramId.getId();
        Announcement allinfo = anceMapper.selectOne(c->c.where(AnnouncementDynamicSqlSupport.id,SqlBuilder.isEqualTo(id))).get();
        UserAnceDetail ancDeatil = new UserAnceDetail();
        ancDeatil.setContent(allinfo.getContent());
        ancDeatil.setTime(allinfo.getTime());
        ancDeatil.setTitle(allinfo.getTitle());
        ancDeatil.setType(allinfo.getType());
        ancDeatil.setViews(allinfo.getViews());
        return new CommonReturn().success(ancDeatil);
    }

    @RequestMapping(value = "/api/admin/AncemtList",method = RequestMethod.GET)//查询接口——公告列表——管理
    public CommonReturn adminAnceList()  {
        List<Announcement> res = anceMapper.select(c->c);
        List<AdmAnceList> modif = new ArrayList<AdmAnceList>();
        res.stream().forEach(anceInfo->{ AdmAnceList listinfo = new AdmAnceList();
            listinfo.setId(anceInfo.getId());
            listinfo.setTitle(anceInfo.getTitle());
            listinfo.setTime(anceInfo.getTime());
            modif.add(listinfo);});
        return new CommonReturn().success(modif);
    }

    @RequestMapping(value = "/api/admin/DelAncemt",method = RequestMethod.POST)//删除接口
    public CommonReturn deleteAnce(@RequestBody AceptId paramId)  {
        anceMapper.delete(c->c.where(AnnouncementDynamicSqlSupport.id,SqlBuilder.isEqualTo(paramId.getId())));
        CommonReturn ret = new CommonReturn();
        ret.success(null);
        return ret;
    }

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
            scheduleResultVO.setSuccess(lastJobLog.getHandleCode() == 200);
            scheduleResultVO.setTriggerTime(lastJobLog.getHandleTime());
            ret.add(scheduleResultVO);
        });
        return new CommonReturn().success(ret);
    }

}
