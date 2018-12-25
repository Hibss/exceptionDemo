package com.steven.demo.common;


import lombok.Getter;
import lombok.Setter;

/**
 * @Author steven.sheng
 * @Date 2018/12/25/025.
 */
public enum ResultCode {
    NOT_EXISTS(1001,"查询对象不存在");

    @Setter
    @Getter
    private Integer code;

    @Getter
    @Setter
    private String msg;

    private ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
