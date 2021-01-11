package plus.xiexie.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import plus.xiexie.biz.pojo.ErrorCode;
import plus.xiexie.biz.pojo.Response;
import plus.xiexie.exception.*;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CommonExceptionHandler {

    private ResponseEntity<Response> getResponseEntity(ErrorCode errorCode, Exception e) {
        Response response = errorCode.reject(e.getMessage());
        return new ResponseEntity<>(response, errorCode.status());
    }

    // ObjectMapper序列化异常
    @ExceptionHandler(value = SerializationException.class)
    public ResponseEntity<Response> handleSerializationException(HttpServletRequest request, SerializationException e) {
        return getResponseEntity(ErrorCode.SERIALIZATION_EXP, e);
    }

    // 分页属性不合法
    @ExceptionHandler(value = PaginationFieldIllegalException.class)
    public ResponseEntity<Response> handlePaginationFieldIllegalException(HttpServletRequest request, PaginationFieldIllegalException e) {
        return getResponseEntity(ErrorCode.PAGINATION_ILLEGAL_EXP, e);
    }

    // 排序属性不合法
    @ExceptionHandler(value = SortFieldIllegalException.class)
    public ResponseEntity<Response> handleSortFieldIllegalException(HttpServletRequest request, SortFieldIllegalException e) {
        return getResponseEntity(ErrorCode.SORT_ILLEGAL_EXP, e);
    }

    // 业务异常-资源已存在
    @ExceptionHandler(value = SourceExistedException.class)
    public ResponseEntity<Response> handleSourceExistedException(HttpServletRequest request, SourceExistedException e) {
        return getResponseEntity(ErrorCode.SOURCE_EXISTED_EXP, e);
    }

    // 业务异常-资源未找到
    @ExceptionHandler(value = SourceNotFoundException.class)
    public ResponseEntity<Response> handleSourceNotFoundException(HttpServletRequest request, SourceNotFoundException e) {
        return getResponseEntity(ErrorCode.SOURCE_NOT_FOUND_EXP, e);
    }
}
