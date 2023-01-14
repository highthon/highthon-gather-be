package com.example.orbe.global.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RegexProperty {
    public static final String PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{5,20}$";
}
