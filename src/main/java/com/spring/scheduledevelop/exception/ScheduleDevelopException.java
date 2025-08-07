package com.spring.scheduledevelop.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleDevelopException extends RuntimeException{

    private ErrorCode errorCode;
}
