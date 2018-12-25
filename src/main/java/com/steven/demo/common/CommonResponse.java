package com.steven.demo.common;

import java.io.Serializable;

/**
 * @Author steven.sheng
 * @Date 2018/12/25/025.
 */
public class CommonResponse<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public CommonResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public CommonResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResponse() {
    }

    public int getCode() {
        return this.code;
    }

    public CommonResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public CommonResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public CommonResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static CommonResponse fail(int code, String msg) {
        return new CommonResponse(code, msg);
    }

    public static CommonResponse fail(int code) {
        return (new CommonResponse()).setCode(code);
    }

    public static CommonResponse fail(CodeStatus codeStatus) {
        return (new CommonResponse()).setCode(codeStatus.getCode().intValue()).setMsg(codeStatus.getMsg());
    }

    public static CommonResponse fail(ResultCode resultCode) {
        return (new CommonResponse()).setCode(resultCode.getCode()).setMsg(resultCode.getMsg());
    }

    public static CommonResponse fail(String msg) {
        return (new CommonResponse()).setCode(-1).setMsg(msg);
    }

    public boolean _isOk() {
        return this.getCode() == 0;
    }

    public boolean _isFailed() {
        return this.getCode() != 0;
    }


    public static CommonResponse ok(Object data) {
        return (new CommonResponse()).setCode(0).setData(data);
    }

    public static CommonResponse ok(String msg) {
        return (new CommonResponse()).setCode(0).setMsg(msg);
    }
}