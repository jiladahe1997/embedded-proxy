package com.jiladahe1997.embeddedproxy;

import com.jiladahe1997.embeddedproxy.controllers.ScheduleResult;
import com.jiladahe1997.embeddedproxy.example.mapper.XxlJobLogDynamicSqlSupport;
import com.jiladahe1997.embeddedproxy.example.model.XxlJobLog;
import com.jiladahe1997.embeddedproxy.models.Aop;
import com.jiladahe1997.embeddedproxy.scheduling.JobKeil;
import com.jiladahe1997.embeddedproxy.scheduling.MainExecutor;
import com.jiladahe1997.embeddedproxy.services.AcmService;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import com.jiladahe1997.embeddedproxy.example.mapper.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import java.io.IOException;

import java.text.DateFormat;
import java.util.Date;
import java.util.Optional;


@SpringBootApplication
//@ComponentScan("com.jiladahe1997.embeddedproxy.models")
//@EnableAspectJAutoProxy(proxyTargetClass = true)

public class EmbeddedproxyApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext con=SpringApplication.run(EmbeddedproxyApplication.class, args);
		//ScheduleResult x=new ScheduleResult();
		XxlJobLogMapper x=con.getBean(XxlJobLogMapper.class);
Object o= null;
		//o=   con.getBean(com.jiladahe1997.embeddedproxy.models.Aop.class);

		Optional<XxlJobLog>  a=x.selectOne(c->c
				.where(XxlJobLogDynamicSqlSupport.id,SqlBuilder.isEqualTo((long)1)));

		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(a.get().getHandleMsg());
		System.out.println(o==null);
		con.getBean(AcmService.class).hihi();
		System.out.println(DateFormat.getDateInstance().getTimeZone());
	//con.getBean(Aop.class).test();





	}

}
