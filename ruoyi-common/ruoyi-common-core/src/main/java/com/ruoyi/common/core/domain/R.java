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

    public static <T> R<T> ok() {
        return restResult(null, SUCCESS, null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, SUCCESS, null);
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> R<T> fail() {
        return restResult(null, FAIL, null);
    }

    public static <T> R<T> fail(String msg) {
        return restResult(null, FAIL, msg);
    }

    public static <T> R<T> fail(T data) {
        return restResult(data, FAIL, null);
    }

    public static <T> R<T> fail(T data, String msg) {
        return restResult(data, FAIL, msg);
    }

    public static <T> R<T> fail(int code, String msg) {
        return restResult(null, code, msg);
    }

    /**
     * 封装的返回
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

    public static <T> R<T> run(Supplier<T> supplier) {
        try {
            return ok(supplier.get());
        }catch (Exception e) {
            log.info(e.getMessage());
            return fail(e.getMessage());
        }
    }

    private static <T> R<T> restResult(T data, int code, String msg) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

}
