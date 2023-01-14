package com.example.orbe.domain.image.exception;

import com.example.orbe.global.error.exception.BaseException;
import com.example.orbe.global.error.exception.ErrorCode;

public class InvalidFileExtensionException extends BaseException {
    public static final BaseException EXCEPTION = new InvalidFileExtensionException();

    private InvalidFileExtensionException() {
        super(ErrorCode.INVALID_FILE_EXTENSION);
    }
}
