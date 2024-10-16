package com.portoflio.back.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EntityAlreadyExists extends RuntimeException{
    private String message;
}
