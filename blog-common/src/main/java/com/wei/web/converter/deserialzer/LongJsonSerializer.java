package com.wei.web.converter.deserialzer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @Author xinhao
 * @Date 2025/7/5 22:40
 */
public class LongJsonSerializer extends JsonSerializer<Long> {
    @Override
    public void serialize(Long aLong, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (aLong != null) {
            jsonGenerator.writeNumber(aLong);
        }
    }
}
