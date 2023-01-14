package com.example.orbe.domain.user.exception;

import com.example.orbe.global.error.exception.BaseException;
import com.example.orbe.global.error.exception.ErrorCode;


public class WrongPasswordException extends BaseException {
    public static final BaseException EXCEPTION = new WrongPasswordException();

    private WrongPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}
