package com.wei.web.converter.deserialzer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Configuration
public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {
    @Override
    public LocalDateTime convert(@Nullable String source) {
        // 日期格式转转换
        if (source == null || source.trim().length() == 0) {
            return null;
        }
        source = source.trim();
        DateTimeFormatter matchingPattern = BaseTimeDeserializer.getMatchingPattern(source, false);
        if (matchingPattern != null) {
            return LocalDateTime.parse(source, matchingPattern);
        } else {
            log.error("日期参数格式错误: " + source);
            return null;
        }
    }
}
