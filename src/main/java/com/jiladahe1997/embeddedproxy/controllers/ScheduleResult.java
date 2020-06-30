package com.jiladahe1997.embeddedproxy.controllers;


import com.jiladahe1997.embeddedproxy.example.mapper.AnnouncementDynamicSqlSupport;
import com.jiladahe1997.embeddedproxy.example.mapper.AnnouncementMapper;
import com.jiladahe1997.embeddedproxy.example.mapper.XxlJobLogDynamicSqlSupport;
import com.jiladahe1997.embeddedproxy.example.mapper.XxlJobLogMapper;
import com.jiladahe1997.embeddedproxy.example.model.Announcement;
import com.jiladahe1997.embeddedproxy.example.model.XxlJobLog;
import com.jiladahe1997.embeddedproxy.models.CommonReturn;
import com.jiladahe1997.embeddedproxy.models.Data.AdmAnceList;
import com.jiladahe1997.embeddedproxy.models.Data.UserAnceDetail;
import com.jiladahe1997.embeddedproxy.models.Data.UserAnceList;
import com.jiladahe1997.embeddedproxy.models.scheduling.ScheduleResultVO;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    AnnouncementMapper anmapper;


    @RequestMapping(value = "/api/add/announcement" ,method = RequestMethod.POST)//添加接口
    public CommonReturn addAnce(String title, String content, String type)  {
        Announcement data = new  Announcement();
        data.setTitle(title);
        data.setContent(content);
        data.setType(type);
        data.setViews(0);
        anmapper.insert(data);
        CommonReturn ret = new CommonReturn();
        ret.success(null);
        return ret;
    }

    @RequestMapping(value = "/api/send/user/list",method = RequestMethod.GET)//查询接口——公告列表——用户
    public CommonReturn userAnceList()  {
        List<Announcement> res =  anmapper.select(c->c.orderBy(AnnouncementDynamicSqlSupport.id.descending()).limit(3));
        List<UserAnceList> modif = new ArrayList<UserAnceList>();
        for(Announcement anceinfo : res) //保留id和title
        { UserAnceList listinf = new UserAnceList();
          listinf.setId(anceinfo.getId());
          listinf.setTitle(anceinfo.getTitle());
            modif.add(listinf);
        }
        CommonReturn ret = new CommonReturn();
        ret.success(modif);
        return ret;
    }


    @RequestMapping(value = "/api/send/user/detail",method = RequestMethod.POST)//查询接口——公告详情——用户
    public CommonReturn userAnceDetail(int id,String title) {
        List<Announcement> res =  anmapper.select(c->c.where(AnnouncementDynamicSqlSupport.id,SqlBuilder.isEqualTo(id))
                .and(AnnouncementDynamicSqlSupport.title,SqlBuilder.isEqualTo(title)));
        Announcement allinfo = res.get(0);
        UserAnceDetail ancDeatil = new UserAnceDetail();
        ancDeatil.setContent(allinfo.getContent());
        ancDeatil.setTime(allinfo.getTime());
        ancDeatil.setTitle(allinfo.getTitle());
        ancDeatil.setType(allinfo.getType());
        ancDeatil.setViews(allinfo.getViews());
        CommonReturn ret = new CommonReturn();
        ret.success(ancDeatil);
        return ret;


    }

    @RequestMapping(value = "/api/send/admin/list",method = RequestMethod.GET)//查询接口——公告列表——管理
    public CommonReturn adminAnceList()  {
        List<Announcement> res =  anmapper.select(c->c.orderBy(AnnouncementDynamicSqlSupport.id.descending()).limit(2));
        List<AdmAnceList> modif = new ArrayList<AdmAnceList>();
        for(Announcement allinfo : res)  //保留 id title time
        { AdmAnceList listinfo = new AdmAnceList();
          listinfo.setId(allinfo.getId());
          listinfo.setTilte(allinfo.getTitle());
          listinfo.setTime(allinfo.getTime());
          modif.add(listinfo);
        }
        CommonReturn ret = new CommonReturn();
        ret.success(modif);
        return ret;
    }

    @RequestMapping(value = "/api/send/admin/del",method = RequestMethod.POST)//删除接口
    public CommonReturn deleteAnce(int id, String title)  {
         anmapper.delete(c->c.where(AnnouncementDynamicSqlSupport.id,SqlBuilder.isEqualTo(id))
                 .and(AnnouncementDynamicSqlSupport.title,SqlBuilder.isEqualTo(title)));
        CommonReturn ret = new CommonReturn();
        ret.success(null);
        return ret;
    }




    @RequestMapping("/ad")
    public CommonReturn add() {


        List<Announcement> res =  anmapper.select(c->c);
        return new CommonReturn().success(res);

        /*return "<html>\n" +
                "<body>\n" +
                "\n" +
                "<form action=\"http://localhost:8081/tt\">\n" +
                "名字:<br>\n" +
                "<input type=\"text\" name=\"name\" value=\"Mickey\">\n" +
                "<br>\n" +
                "内容:<br>\n" +
                "<input type=\"text\" name=\"content\" value=\"Mouse\">\n" +
                "<br>\n" +
                "类型：\n" +
                "<input type=\"text\" name=\"type\" \">\n" +
                "<br>\n" +
                "<input type=\"submit\" value=\"Submit\">\n" +
                "</form> \n" +
                "\n" +
                "<p>如果您点击提交，表单数据会被发送到名为 demo_form.asp 的页面。</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
      */
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
            scheduleResultVO.setSuccess(lastJobLog.getTriggerCode() == 200);
            scheduleResultVO.setTriggerTime(lastJobLog.getHandleTime());
            ret.add(scheduleResultVO);
        });


        return new CommonReturn().success(ret);
    }

}
