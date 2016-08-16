package com.example.darth.search_recyclerview.utils;

import android.util.Log;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by diana on 8/15/16.
 */
public final class JsonMarshaller {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonMarshaller() { }

    public static <T> T fromJson(Class<T> clazz, String json) {
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            Log.e("JsonMarshaller", e.getMessage());
        }
        return null;
    }

    public static <T> T fromJsonWithListResponse(TypeReference reference, String json) {
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(json, reference);
        } catch (IOException e) {
            Log.e("JsonMarshaller", e.getMessage());
        }
        return null;
    }

    public static <T> String toJson(T object) {
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            Log.e("JsonMarshaller", e.getMessage());
        }
        return null;
    }
}