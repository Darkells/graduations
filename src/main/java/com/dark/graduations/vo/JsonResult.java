package com.dark.graduations.vo;

import lombok.Data;

/**
 * 响应对象
 */
@Data
public class JsonResult {

    //响应状态码
    private Integer status;

    //数据对象
    private Object data;

    private String msg;

    //自定义返回JSON对象
    public static JsonResult build(Integer status, Object data, String msg) {
        return new JsonResult(status, data, msg);
    }

    public JsonResult(Integer status, Object data, String msg) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "status=" + status +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
