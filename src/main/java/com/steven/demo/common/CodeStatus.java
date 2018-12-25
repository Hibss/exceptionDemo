package com.steven.demo.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author steven.sheng
 * @Date 2018/12/25/025.
 */
public enum CodeStatus {
    SUCCESS(1,"成功"),
    FAIL(-1,"失败")
    ;

    @Getter
    @Setter
    private Integer code;
    @Getter
    @Setter
    private String msg;

    private CodeStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
