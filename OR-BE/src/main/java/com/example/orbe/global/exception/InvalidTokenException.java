package com.example.orbe.global.exception;

import com.example.orbe.global.error.exception.BaseException;
import com.example.orbe.global.error.exception.ErrorCode;

public class InvalidTokenException extends BaseException {
    public static final BaseException EXCEPTION = new InvalidTokenException();
    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
