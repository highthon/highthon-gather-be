package com.example.orbe.domain.todo.exception;

import com.example.orbe.global.error.exception.BaseException;
import com.example.orbe.global.error.exception.ErrorCode;

public class NoAuthorityException extends BaseException {
    public static final BaseException EXCEPTION = new NoAuthorityException();

    private NoAuthorityException() {
        super(ErrorCode.NO_AUTHORITY);
    }
}
