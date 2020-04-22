package com.jiladahe1997.embeddedproxy.models.scheduling;

import lombok.Data;

import java.util.Date;

@Data
public class ScheduleResultVO {
    String handleName;
    Date triggerTime;
    boolean isSuccess;
}
