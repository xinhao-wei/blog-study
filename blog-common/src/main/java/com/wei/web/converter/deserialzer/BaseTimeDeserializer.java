package com.wei.web.converter.deserialzer;

import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class BaseTimeDeserializer {
    private BaseTimeDeserializer() {
    }

    /**
     * 匹配日期格式 2024-06-12
     */
    private static final Pattern patternLocalDate = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
    private static final DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    /**
     * 匹配日期格式 2024/06/12
     */
    private static final Pattern patternLocalDateSlash = Pattern.compile("^\\d{4}/\\d{2}/\\d{2}$");
    private static final DateTimeFormatter localDateFormatterSlash = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    /**
     * 匹配日期格式 2024年06月12日
     */
    private static final Pattern patternLocalDateChinese = Pattern.compile("^\\d{4}年\\d{2}月\\d{2}日$");
    private static final DateTimeFormatter localDateFormatterChinese = DateTimeFormatter.ofPattern("yyyy年MM月dd日");

    /**
     * 匹配日期格式 2024-06-12 12:12:12
     */
    private static final Pattern patternLocalDateTime = Pattern.compile("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$");
    private static final DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /**
     * 匹配日期格式 2024/06/12 12:12:12
     */
    private static final Pattern patternLocalDateTimeSlash = Pattern.compile("^\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}$");
    private static final DateTimeFormatter localDateTimeFormatterSlash = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    /**
     * 匹配日期格式 2024年06月12日 12:12:12
     */
    private static final Pattern patternLocalDateTimeChinese = Pattern.compile("^\\d{4}年\\d{2}月\\d{2}日 \\d{2}:\\d{2}:\\d{2}$");
    private static final DateTimeFormatter localDateTimeFormatterChinese = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");


    /**
     * 匹配正确的转换日期模板
     *
     * @param source
     * @param flag   为true时匹配LocalDate的模板，false时匹配LocalDateTime的模板
     * @return
     */
    protected static DateTimeFormatter getMatchingPattern(String source, boolean flag) {
        if (flag) {
            if (patternLocalDate.matcher(source).matches()) {
                return localDateFormatter;
            } else if (patternLocalDateSlash.matcher(source).matches()) {
                return localDateFormatterSlash;
            } else if (patternLocalDateChinese.matcher(source).matches()) {
                return localDateFormatterChinese;
            }
        } else {
            if (patternLocalDateTime.matcher(source).matches()) {
                return localDateTimeFormatter;
            } else if (patternLocalDateTimeSlash.matcher(source).matches()) {
                return localDateTimeFormatterSlash;
            } else if (patternLocalDateTimeChinese.matcher(source).matches()) {
                return localDateTimeFormatterChinese;
            }
        }
        // 没有匹配到日期模板返回null
        return null;
    }
}
