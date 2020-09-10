package com.jiladahe1997.embeddedproxy.models.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserAnceDetail {
    String content;
    String type;
    String title;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date time;
    int views;
}
