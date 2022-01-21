package ${{groupId}}.${{projectPkg}};

public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAILURE(400, "操作失败"),
    ILLEGAL_REQUEST(400, "非法请求"),
    PARAM_MISS(400, "缺少必填参数"),
    PARAM_TYPE_ERROR(400, "参数类型错误"),
    PARAM_BIND_ERROR(400, "参数绑定错误"),
    PARAM_VALID_ERROR(400, "参数验证错误"),
    UN_AUTHORIZED(401, "请求未经授权"),
    REQ_REJECT(403, "请求拒绝"),
    NOT_FOUND(404, "404 未找到"),
    METHOD_NOT_SUPPORTED(405, "请求方法不支持"),
    INTERNAL_SERVER_ERROR(500, "系统错误"),
    USER_SESSION_EXPIRE(999, "用户session过期"),
    RECORD_NOT_FOUND_ERROR(10001, "Record Not Found"),
    USER_NO_MENU_AUTH(10002, "用户没有菜单权限");

    final int code;
    final String msg;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    private ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
