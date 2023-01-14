package com.example.orbe.domain.todo.exception;

import com.example.orbe.global.error.exception.BaseException;
import com.example.orbe.global.error.exception.ErrorCode;

public class TodoNotFoundException extends BaseException {
    public static final BaseException EXCEPTION = new TodoNotFoundException();

    private TodoNotFoundException() {
        super(ErrorCode.TODO_NOT_FOUND);
    }
}
