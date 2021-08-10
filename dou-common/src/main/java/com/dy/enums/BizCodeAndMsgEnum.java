package com.dy.enums;

import com.dy.exception.BizException;
import com.dy.result.R;
import lombok.Getter;

/**
 * 业务异常枚举类
 *
 * @author: liuhj
 * @date: 2021/8/9 16:11
 */
@Getter
public enum BizCodeAndMsgEnum {

    SUCCESS("10000", "成功");

    private final String code;
    private final String msg;
    public static final int CODE_TYPE = 1;

    BizCodeAndMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static BizCodeAndMsgEnum getByCode(String code) {
        for (BizCodeAndMsgEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }


    public void throwIt() {
        throw new BizException(code, msg);
    }

    public void throwIt(String msg) {
        throw new BizException(code, msg);
    }

    public R toR() {
        if (this == SUCCESS) {
            return R.success(code, msg, 0);
        }
        return R.failed(code, msg, CODE_TYPE);
    }

    public R toR(String msg) {
        if (this == SUCCESS) {
            return R.success(code, msg, 0);
        }
        return R.failed(code, msg, CODE_TYPE);
    }

    public static R success(Object data) {
        return R.success(data, SUCCESS.getCode(), SUCCESS.getMsg(), 0);
    }

    public static R success(String date) {
        return R.success(date, SUCCESS.getCode(), SUCCESS.getMsg(), 1);
    }
}
