package cn.mh.sb.webcrud.common;

import org.springframework.http.HttpStatus;

/**
 * @author: mahao
 * @date: 2019/11/23
 */
public class ApiResult {

    /**
     * 结果码
     */
    private String code;

    /**
     * 结果码描述
     */
    private String msg;


    public ApiResult() {

    }

    public ApiResult(ApiStatus status) {
        this.code = status.getCode();
        this.msg = status.getMsg();
    }

    public static ApiResult of(ApiStatus s) {
        return new ApiResult(s);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
