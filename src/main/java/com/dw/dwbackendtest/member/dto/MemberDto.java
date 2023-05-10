package com.dw.dwbackendtest.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
public class MemberDto {
    @Getter
    public static class Post {
        @NotBlank
        private String name;
        @NotBlank
        private String accountName;
        @NotBlank
        private String password;
        @NotBlank
        private String employeeCode;
        @NotBlank
        private String email;
        private String phone;
    }

    @Data
    public static class Response {
        private String name;
        private String accountName;
        private String employeeCode;
        private String phone;
        private String email;
    }
}
