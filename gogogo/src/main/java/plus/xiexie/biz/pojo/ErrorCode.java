package plus.xiexie.biz.pojo;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    SERIALIZATION_EXP(500, "itn.0001"),

    SOURCE_EXISTED_EXP(500, "biz.source.existed"),

    SOURCE_NOT_FOUND_EXP(500, "biz.source.not.found"),

    PAGINATION_ILLEGAL_EXP(500, "pagination.field.illegal"),

    SORT_ILLEGAL_EXP(500, "sort.field.illegal");

    private int status;

    private String code;

    ErrorCode(int status, String code) {
        this.status = status;
        this.code = code;
    }

    public HttpStatus status() {
        return HttpStatus.resolve(this.status);
    }

    public Response reject(String message) {
        return new Response(this.status, new ErrorInfo(this.code, message));
    }

}
