package com.jabcneto.exception;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ExceptionResponse implements Serializable {
    private String message;
    private Integer code;
}
