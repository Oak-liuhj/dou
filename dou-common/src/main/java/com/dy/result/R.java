package com.dy.result;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * 数据格式返回封装
 *
 * @author: liuhj
 * @date: 2021/8/9 16:18
 */
@Data
public class R<T> implements Serializable {

    private String code;
    private String msg;
    private Integer codeType;
    private boolean success;
    private T data;

    public R() {
        this.success = false;
    }

    public R(String code, String msg) {
        this(null, code, msg);
    }

    public R(String code, String msg, Integer codeType) {
        this(null, code, msg, codeType);
    }

    public R(T data, String code, String msg) {
        this.success = false;
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public R(T data, String code, String msg, Integer codeType) {
        this.success = false;
        this.data = data;
        this.msg = msg;
        this.code = code;
        this.codeType = codeType;
    }

    public R(T data, String code, String msg, Integer codeType, boolean success) {
        this.success = false;
        this.data = data;
        this.msg = msg;
        this.code = code;
        this.success = success;
        this.codeType = codeType;
    }

    public static <T> R<T> success(String code, String msg, Integer codeType) {
        return new R("0", code, msg, codeType, true);
    }

    public static <T> R<T> success(T data, String code, String msg, Integer codeType) {
        return new R(data, code, msg, codeType, true);
    }

    public static <T> R<T> failed(String code, String msg, Integer codeType) {
        return new R(null, code, msg, codeType, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        R<?> r = (R<?>) o;
        return success == r.success &&
                code.equals(r.code) &&
                msg.equals(r.msg) &&
                codeType.equals(r.codeType) &&
                data.equals(r.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, msg, codeType, success, data);
    }
}
