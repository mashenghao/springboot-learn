package cn.mh.sb.webcrud.common;

/**
 * @program: springboot-learn
 * @Date: 2019/11/23 19:52
 * @Author: mahao
 * @Description:
 */
public enum ApiStatus {

    /**
     * 成功
     */
    SUCCESS("0", "success"),

    /**
     * 未知错误
     */
    UNKNOWN_ERROR("0x10001", "unkonwn error"),

    /**
     * 用户名错误或不存在
     */
    USERNAME_ERROR("0x10002", "username error or does not exist"),

    /**
     * 密码错误
     */
    PASSWORD_ERROR("0x10003", "password error"),

    /**
     * 用户名不能为空
     */
    USERNAME_EMPTY("0x10004", "username can not be empty");

    /**
     * 结果码
     */
    private String code;

    /**
     * 结果码描述
     */
    private String msg;


    ApiStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
