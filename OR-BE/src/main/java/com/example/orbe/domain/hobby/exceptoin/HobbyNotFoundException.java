package com.example.orbe.domain.hobby.exceptoin;

import com.example.orbe.global.error.exception.BaseException;
import com.example.orbe.global.error.exception.ErrorCode;

public class HobbyNotFoundException extends BaseException {
    public static final BaseException EXCEPTION = new HobbyNotFoundException();

    private HobbyNotFoundException() {
        super(ErrorCode.HOBBY_NOT_FOUND);
    }
}
