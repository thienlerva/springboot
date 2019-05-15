package com.Email.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailMessage {

    String toAddress;
    String subject;
    String body;
}
