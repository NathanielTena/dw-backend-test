package com.dw.dwbackendtest.junket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

public class JunketDto {
    @Getter
    public static class Post {
        @NotBlank
        private String junketCode;
        @NotBlank
        private String junketName;
    }

    @Data
    public static class Response {
        private String junketCode;
        private String junketName;
    }

    @Getter
    public static class Patch {
        @NotNull
        private Long junketId;
        @NotBlank
        private String junketCode;
        @NotBlank
        private String junketName;
    }
}
