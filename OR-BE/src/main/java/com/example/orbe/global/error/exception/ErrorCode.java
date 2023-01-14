package com.example.orbe.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(404, "User not found"),

    EXPIRED_TOKEN(401,"Token Expired" ),
    INVALID_TOKEN(401,"Invalid Token"),

    USER_ALREADY_EXISTS(409, "User already exists"),

    COMPANY_ALREADY_EXISTS(409, "Company already exists"),

    HOBBY_NOT_FOUND(404, "Hobby Not Found"),

    HOBBY_IS_FULL(409, "Hobby is full"),

    INVALID_PASSWORD(401, "password missmatch"),

    FILE_NOT_FOUND(404, "file not found"),

    INVALID_FILE_EXTENSION(400, "Invalid file extension"),

    NO_AUTHORITY(403, "No Authority"),
    TODO_NOT_FOUND(404, "Todo not found"),

    ALREADY_JOINED(409, "Hobby already joined")

    ;

    private final Integer status;
    private final String message;
}
