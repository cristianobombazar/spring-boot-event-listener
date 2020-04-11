package com.example.eventslistners.util;

import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Util {

    public static String stackTraceToString(Throwable e) {
        if (e != null) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            return errors.toString();
        }
        return "";
    }

    public static String getResourcePath(WebRequest request) {
        return ((ServletWebRequest) request).getRequest().getRequestURL().toString();
    }

}
