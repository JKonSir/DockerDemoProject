package org.mycompany.controllers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by konstantinamp on 7/9/17.
 */
@ControllerAdvice(annotations = RestController.class)
public class GeneralAdviceController {

    private static final Logger LOG = LoggerFactory.getLogger(GeneralAdviceController.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> generalError(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", ex.getMessage() != null ? ex.getMessage() : "Unknown error");
        map.put("type", ex.getClass().getSimpleName());
        map.put("stack", ExceptionUtils.getStackTrace(ex));

        LOG.error(ex.getMessage(), ex);

        return map;
    }
}
