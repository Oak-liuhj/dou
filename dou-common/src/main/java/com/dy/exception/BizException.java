package com.dy.exception;

import com.dy.result.R;
import lombok.Data;

/**
 * 业务异常
 *
 * @author: liuhj
 * @date: 2021/8/9 16:07
 */
@Data
public class BizException extends RuntimeException {

    private String code;
    private String message;

    public BizException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BizException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public BizException(Throwable throwable) {
        super(throwable);
    }

}
