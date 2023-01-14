package com.example.orbe.domain.hobby.exceptoin;

import com.example.orbe.global.error.exception.BaseException;
import com.example.orbe.global.error.exception.ErrorCode;

public class AlreadyJoinedException extends BaseException {
    public static final BaseException EXCEPTION = new AlreadyJoinedException();
    private AlreadyJoinedException() {
        super(ErrorCode.ALREADY_JOINED);
    }
}
