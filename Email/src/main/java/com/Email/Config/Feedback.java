package com.Email.Config;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Feedback {

    @NotNull
    String name;

    @NotNull @Email
    String email;
    @NotNull @Min(10)
    String feedback;
}
