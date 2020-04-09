package com.example.eventslistners.util;

import com.example.eventslistners.ApplicationContextProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Objects;

public class ObjectMapperUtil {

    public static final String toString(Object object) {
        if (Objects.nonNull(object)) {
            try {
                return getInstance().writeValueAsString(object);
            } catch (JsonProcessingException e) {
                return null;
            }
        }
        return null;
    }

    public static final ObjectMapper getInstance() {
        return ApplicationContextProvider.getBean(ObjectMapper.class);
    }
}
