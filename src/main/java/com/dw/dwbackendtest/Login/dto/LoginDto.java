package com.dw.dwbackendtest.Login.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class LoginDto {

    @Data
    public static class Post{
        @NotBlank
        private String accountName;
        @NotBlank
        private String password;
    }
}
