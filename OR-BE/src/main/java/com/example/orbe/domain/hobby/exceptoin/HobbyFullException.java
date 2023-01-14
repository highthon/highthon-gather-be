package com.example.orbe.domain.hobby.exceptoin;

import com.example.orbe.global.error.exception.BaseException;
import com.example.orbe.global.error.exception.ErrorCode;

public class HobbyFullException extends BaseException {
    public static final BaseException EXCEPTION = new HobbyFullException();

    private HobbyFullException() {
        super(ErrorCode.HOBBY_IS_FULL);
    }
}
