package com.ruoyi.common.core.domain;

import java.io.Serializable;
import java.util.function.Supplier;

import com.ruoyi.common.core.constant.Constants;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 响应信息主体
 *
 * @author ruoyi
 */
@Slf4j
@Getter
@Setter
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int SUCCESS = Constants.SUCCESS;

    /**
     * 失败
     */
    public static final int FAIL = Constants.FAIL;

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 正确返回
     * @param <T>
     * @return
     */
    public static <T> R<T> ok() {
        return restResult( SUCCESS, null,null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(SUCCESS, null,data);
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(SUCCESS, msg,data);
    }

    public static <T> R<T> fail() {
        return restResult(FAIL, null,null);
    }

    public static <T> R<T> fail(String msg) {
        return restResult( FAIL, msg,null);
    }

    public static <T> R<T> fail(T data) {
        return restResult(FAIL, null,data);
    }

    public static <T> R<T> fail(T data, String msg) {
        return restResult(FAIL, msg,data);
    }

    public static <T> R<T> fail(int code, String msg) {
        return restResult(code, msg,null);
    }

    /**
     * 封装返回结果
     * @param runnable 函数式接口
     * @param <T> 返回类型
     * @return T
     */
    public static <T> R<T> run(Runnable runnable) {
        try {
            runnable.run();
            return ok();
        }catch (Exception e) {
            log.info(e.getMessage());
            return fail();
        }
    }

    /**
     * 封装返回结果
     * @param supplier 供给型函数式接口
     * @param <T> 函数式接口返回值
     * @return T
     */
    public static <T> R<T> run(Supplier<T> supplier) {
        try {
            return ok(supplier.get());
        }catch (Exception e) {
            log.info(e.getMessage());
            return fail(e.getMessage());
        }
    }

    /**
     * 构造函数
     * @param code 返回码
     * @param msg 返回信息
     * @param data 返回数据
     * @param <T> 返回数据类型
     * @return R
     */
    private static <T> R<T> restResult(int code, String msg,T data) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

}
