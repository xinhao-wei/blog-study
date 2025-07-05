package com.wei.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wei.constant.ResponseConstant;
import com.wei.web.converter.deserialzer.LongJsonSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author xinhao
 * @Date 2025/7/5 22:13
 */
@Data
public class R <T> implements Serializable {
    private static final long serialVersionUID = 2405172041950251807L;

    /**
     * 成功
     */
    public static final int SUCCESS = ResponseConstant.SUCCESS;

    public static final String QUERY_SUCCESS_MESSAGE = "查询成功";

    /**
     * 失败
     */
    public static final int FAIL_STATE = ResponseConstant.FAIL;

    @JsonSerialize(using = LongJsonSerializer.class)
    private long total;

    private int code;

    private String msg;

    private T data;

    public static <T> R<T> ok() {
        return restResult(null, SUCCESS, null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, SUCCESS, null);
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> R<T> ok(T data, String msg, Long total) {
        return restResult(data, SUCCESS, msg, total);
    }

    public static <T> R<T> ok(T data, String msg, Integer code) {
        return restResult(data, code, msg);
    }


    public static <T> R<T> fail() {
        return restResult(null, FAIL_STATE, null);
    }

    public static <T> R<T> fail(T data, Integer code) {
        return restResult(data, code, null);
    }

    public static <T> R<T> ok(T data, Integer code) {
        return restResult(data, code, null);
    }

    public static <T> R<T> fail(String msg) {
        return restResult(null, FAIL_STATE, msg);
    }

    public static <T> R<T> fail(T data) {
        return restResult(data, FAIL_STATE, null);
    }

    public static <T> R<T> fail(T data, String msg) {
        return restResult(data, FAIL_STATE, msg);
    }

    public static <T> R<T> fail(int code, String msg) {
        return restResult(null, code, msg);
    }

    private static <T> R<T> restResult(T data, int code, String msg) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    private static <T> R<T> restResult(T data, int code, String msg, Long total) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        apiResult.setTotal(total);
        return apiResult;
    }
}
