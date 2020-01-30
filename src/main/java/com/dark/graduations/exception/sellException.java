package com.dark.graduations.exception;

import com.dark.graduations.enums.ResultEnums;
import lombok.Getter;

@Getter
public class sellException extends RuntimeException {
    private Integer code;

    /**
     * 秒杀错误
     * @param resultEnums　错误码
     */
    public sellException(ResultEnums resultEnums) {
        super(resultEnums.getMessage());
        this.code = resultEnums.getCode();
    }

    /**
     * 秒杀错误信息
     * @param code  错误码
     * @param message　错误信息
     */
    public sellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
