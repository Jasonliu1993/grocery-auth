package com.jwebcoder.groceryauth.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JacksonTools {

    private static final Logger logger = LoggerFactory.getLogger(JacksonTools.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T readValueForObject(String value, Class<T> clazz) {
        T object = null;
        try {
            object = mapper.readValue(value, clazz);
        } catch (IOException e) {
            logger.error("解析JSon出现问题，JSon:{}", value, e);
        }
        return object;
    }

    public String writteObjectToValue(Object o) {
        String json = null;
        try {
            json = mapper.writeValueAsString(o);
        } catch (IOException e) {
            logger.error("转换到JSon时出现问题", e);
        }
        return json;
    }

}
