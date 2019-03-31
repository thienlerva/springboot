package com.jpmc.quartzdemo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@ToString
public class ScheduleEmailRequest {

    @Email
    @NotEmpty
    String email;

    @NotEmpty
    String subject;

    @NotEmpty
    String body;

    @NotNull
    LocalDateTime dateTime;

    @NotNull
    ZoneId timeZone;
}
