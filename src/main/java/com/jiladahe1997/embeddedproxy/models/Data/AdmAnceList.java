package com.jiladahe1997.embeddedproxy.models.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AdmAnceList {
int id;
String tilte;
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
Date time;
}
