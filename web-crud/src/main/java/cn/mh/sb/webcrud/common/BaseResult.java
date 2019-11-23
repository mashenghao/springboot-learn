package cn.mh.sb.webcrud.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: mahao
 * @date: 2019/11/23
 */
@Data
public class BaseResult implements Serializable {

    private String code;
    private String message;
    private Object data;

    public BaseResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static BaseResult success(Object result) {
        return new BaseResult("200", "success", result);
    }

    public static BaseResult success() {
        return success(null);
    }

    public static BaseResult failure(Object result) {
        return new BaseResult("500", "server_error", result);
    }

    public static BaseResult failure() {
        return failure(null);
    }
}
