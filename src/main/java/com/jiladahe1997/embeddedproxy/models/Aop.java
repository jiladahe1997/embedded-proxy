package com.jiladahe1997.embeddedproxy.models;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Aspect
@Component
public class Aop {
    @Pointcut(value = "execution(* com.jiladahe1997.embeddedproxy.services.AcmService.hihi())")
  public  void point(){}
  @Before(value = "point()")
   public void test()
  {
      System.out.println("我很好阿阿阿阿阿 阿阿阿阿阿阿阿阿阿阿阿 阿");
  }
    @After(value = "point()")
    public void tSest()
    {
        System.out.println("为什么神奇魔术球迷莫生气莫生气莫生气吗");
    }


}
