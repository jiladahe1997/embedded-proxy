package com.jiladahe1997.embeddedproxy.models;

import lombok.Data;

@Data
public class CommonReturn {
    Integer code;
    String message;
    Object data;

    public CommonReturn success(Object data) {
        this.setCode(0);
        this.setMessage("");
        this.setData(data);

        return this;
    }
}
