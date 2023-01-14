package com.example.orbe.global.exception;

import com.example.orbe.global.error.exception.BaseException;
import com.example.orbe.global.error.exception.ErrorCode;

public class ExpiredTokenException extends BaseException {
    public static final BaseException EXCEPTION = new ExpiredTokenException();
    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
