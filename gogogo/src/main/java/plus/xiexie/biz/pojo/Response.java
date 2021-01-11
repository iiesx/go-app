package plus.xiexie.biz.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import plus.xiexie.exception.SerializationException;

public class Response<T> {

    private int status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ErrorInfo error;

    public Response(int status, T result) {
        this.status = status;
        this.result = result;
    }

    public Response(int status, ErrorInfo error) {
        this.status = status;
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public ErrorInfo getError() {
        return error;
    }

    public void setError(ErrorInfo error) {
        this.error = error;
    }

    public static <E> Response<E> success(E e){
        return new Response<E>(HttpStatus.OK.value(), e);
    }

    public static Response error() {
        return new Response(1,new ErrorInfo("biz.1001", "biz error caused by wrong connection"));
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e.getMessage());
        }
    }

}
