package devilSpiderX.server.webServer.core.util;

import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

public class AjaxResp<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 7635332772845242522L;

    private final int code;
    @NotNull
    private final String msg;
    private T data;

    public AjaxResp(int code, @NotNull String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public AjaxResp(int code, @NotNull String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public @NotNull String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public AjaxResp<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JacksonUtil.toJSONString(this);
    }

    // 返回成功
    public static <T> AjaxResp<T> success() {
        return new AjaxResp<>(AjaxCode.SUCCESS, "OK");
    }

    public static <T> AjaxResp<T> success(String msg) {
        return new AjaxResp<>(AjaxCode.SUCCESS, msg);
    }

    public static <T> AjaxResp<T> success(T data) {
        return new AjaxResp<>(AjaxCode.SUCCESS, "OK", data);
    }

    public static <T> AjaxResp<T> success(String msg, T data) {
        return new AjaxResp<>(AjaxCode.SUCCESS, msg, data);
    }

    // 返回失败
    public static <T> AjaxResp<T> failure() {
        return new AjaxResp<>(AjaxCode.FAILURE, "Failure");
    }


    public static <T> AjaxResp<T> failure(String msg) {
        return new AjaxResp<>(AjaxCode.FAILURE, msg);
    }

    // 返回错误
    public static <T> AjaxResp<T> error() {
        return new AjaxResp<>(AjaxCode.ERROR, "Error");
    }


    public static <T> AjaxResp<T> error(String msg) {
        return new AjaxResp<>(AjaxCode.ERROR, msg);
    }

    // 返回警告
    public static <T> AjaxResp<T> warning() {
        return new AjaxResp<>(AjaxCode.WARNING, "Warning");
    }

    public static <T> AjaxResp<T> warning(String msg) {
        return new AjaxResp<>(AjaxCode.WARNING, msg);
    }

    // 返回未登录
    public static <T> AjaxResp<T> notLogin() {
        return new AjaxResp<>(AjaxCode.NOT_LOGIN, "未登录，请登录后再次访问");
    }

    public static <T> AjaxResp<T> notLogin(String msg) {
        return new AjaxResp<>(AjaxCode.NOT_LOGIN, msg);
    }

    // 返回无角色权限
    public static AjaxResp<String> notRole(String role) {
        return new AjaxResp<>(AjaxCode.NOT_ROLE, "没有%s角色权限".formatted(role), role);
    }

    // 返回无权限
    public static AjaxResp<String> notPermission(String permission) {
        return new AjaxResp<>(
                AjaxCode.NOT_PERMISSION,
                "没有%s权限".formatted(permission),
                permission
        );
    }

    // 返回一个自定义状态码的
    public static <T> AjaxResp<T> of(int code, String msg) {
        return new AjaxResp<>(code, msg);
    }

    public static <T> AjaxResp<T> of(int code, String msg, T data) {
        return new AjaxResp<>(code, msg, data);
    }

    public static <T> AjaxResp<T> of(AjaxResp<?> res, T data) {
        return new AjaxResp<>(res.getCode(), res.getMsg(), data);
    }

    public static <T> AjaxResp<T> of(AjaxResp<?> res, String msg, T data) {
        return new AjaxResp<>(res.getCode(), msg, data);
    }
}
