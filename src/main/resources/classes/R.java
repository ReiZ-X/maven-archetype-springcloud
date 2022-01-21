package ${{groupId}}.${{projectPkg}};

import ${{groupId}}.${{projectPkg}}.ResultCode;

public class R<T> {
    private boolean success;
    private long code;
    private String msg;
    private T data;

    protected R() {
    }

    protected R(long code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        if (code == (long)ResultCode.SUCCESS.getCode()) {
            this.success = true;
        } else {
            this.success = false;
        }

    }

    public static <T> R<T> ok() {
        return new R((long)ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), (Object)null);
    }

    public static <T> R<T> ok(T data) {
        return new R((long)ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
    }

    public static <T> R<T> ok(T data, String msg) {
        return new R((long)ResultCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> R<T> fail(ResultCode errorCode) {
        return new R((long)errorCode.getCode(), errorCode.getMsg(), (Object)null);
    }

    public static <T> R<T> fail(ResultCode errorCode, String msg) {
        return new R((long)errorCode.getCode(), msg, (Object)null);
    }

    public static <T> R<T> fail(String msg) {
        return new R((long)ResultCode.FAILURE.getCode(), msg, (Object)null);
    }

    public static <T> R<T> fail() {
        return fail(ResultCode.FAILURE);
    }

    public static <T> R<T> validateFail() {
        return fail(ResultCode.PARAM_VALID_ERROR);
    }

    public static <T> R<T> validateFail(String msg) {
        return new R((long)ResultCode.PARAM_VALID_ERROR.getCode(), msg, (Object)null);
    }

    public static <T> R<T> unauthorized(T data) {
        return new R((long)ResultCode.UN_AUTHORIZED.getCode(), ResultCode.UN_AUTHORIZED.getMsg(), data);
    }

    public static <T> R<T> forbidden(T data) {
        return new R((long)ResultCode.REQ_REJECT.getCode(), ResultCode.REQ_REJECT.getMsg(), data);
    }

    public boolean isSuccess() {
        return this.success;
    }

    public long getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "R(success=" + this.isSuccess() + ", code=" + this.getCode() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
    }
}