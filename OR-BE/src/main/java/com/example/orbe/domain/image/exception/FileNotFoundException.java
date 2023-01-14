package com.example.orbe.domain.image.exception;

import com.example.orbe.global.error.exception.BaseException;
import com.example.orbe.global.error.exception.ErrorCode;

public class FileNotFoundException extends BaseException {
    public static final BaseException EXCEPTION = new FileNotFoundException();

    private FileNotFoundException() {
        super(ErrorCode.FILE_NOT_FOUND);
    }
}
