package com.github.wellls.ead.authuser.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorRecordResponse(
        Integer errorCode,
        String errorMessage,
        Map<String, String>errorsDetails
) {
}
