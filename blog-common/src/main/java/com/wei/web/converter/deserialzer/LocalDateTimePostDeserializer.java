package com.wei.web.converter.deserialzer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 处理前端post请求的日期反序列化
 */
@Slf4j
@JsonComponent
public class LocalDateTimePostDeserializer {
    private LocalDateTimePostDeserializer() {

    }

    public static class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

        @Override
        public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String source = jsonParser.getText();
            if (source == null || source.trim().length() == 0) {
                return null;
            }
            source = source.trim();
            // 使用正则匹配不同格式的日期
            DateTimeFormatter matchingPattern = BaseTimeDeserializer.getMatchingPattern(source, false);
            if (matchingPattern != null) {
                return LocalDateTime.parse(source, matchingPattern);
            } else {
                log.error("日期参数格式错误: " + source);
                return null;
            }
        }
    }

    public static class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
        @Override
        public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String source = jsonParser.getText();
            if (source == null || source.trim().length() == 0) {
                return null;
            }
            source = source.trim();
            // 使用正则匹配不同格式的日期
            DateTimeFormatter matchingPattern = BaseTimeDeserializer.getMatchingPattern(source, true);
            if (matchingPattern != null) {
                return LocalDate.parse(source, matchingPattern);
            } else {
                log.error("日期参数格式错误: " + source);
                return null;
            }
        }
    }
}
