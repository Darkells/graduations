package com.dark.graduations.exception;

import com.dark.graduations.enums.ResultEnums;
import lombok.Getter;

@Getter
public class sellException extends RuntimeException {
    private Integer code;

    public sellException(ResultEnums resultEnums) {
        super(resultEnums.getMessage());

        this.code = resultEnums.getCode();
    }

    public sellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
