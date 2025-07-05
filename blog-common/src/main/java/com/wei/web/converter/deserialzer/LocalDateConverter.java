package com.wei.web.converter.deserialzer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * LocalDate 转换器
 */
@Slf4j
@Configuration
public class LocalDateConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(@Nullable String source) {
        // 日期格式转转换
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
