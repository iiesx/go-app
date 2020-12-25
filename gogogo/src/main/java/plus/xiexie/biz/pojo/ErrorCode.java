package plus.xiexie.biz.pojo;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    SERIALIZATION_EXP(HttpStatus.INTERNAL_SERVER_ERROR.value(), "biz.0001");

    private int status;

    private String code;

    ErrorCode(int status, String code) {
        this.status = status;
        this.code = code;
    }

    public Response reject(String message) {
        return new Response(this.status, new ErrorInfo(this.code, message));
    }

}
