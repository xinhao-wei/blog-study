package com.wei.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author xinhao
 * @Date 2025/7/7 0:59
 */
@Data
public class AddUserDTO {

    /**
     * 用户ID
     */
    @TableId
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    private Integer status;
    /**
     * 创建者ID
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    @JsonDeserialize(using =  LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
