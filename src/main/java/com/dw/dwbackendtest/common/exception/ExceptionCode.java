package com.dw.dwbackendtest.common.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member not found"),
    MEMBER_EXISTS(409, "Member exists"),
    AVATAR_EXISTS(409, "Avatar exists"),
    COMPANY_NOT_FOUND(404, "Company not found"),
    COMPANY_CODE_EXISTS(409, "Company Code exists"),
    ACCOUNT_NOT_FOUND(404, "Account not found"),
    CANNOT_CHANGE_ACCOUNT(403, "Account can not change"),
    NOT_IMPLEMENTATION(501, "Not Implementation"),
    INVALID_ACCOUNT_STATUS(400, "Invalid account status");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
