package com.moviebookingapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ForgetPasswordDto {
    private String password;
    private int securityQuestion;
    private String securityAnswer;
}
