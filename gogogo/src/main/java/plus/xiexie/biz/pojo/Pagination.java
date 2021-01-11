package plus.xiexie.biz.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import plus.xiexie.exception.PaginationFieldIllegalException;
import plus.xiexie.exception.SerializationException;

public class Pagination {

    private int limit;

    private int offset;

    @JsonIgnore
    private int page;

    @JsonIgnore
    private int per;

    public Pagination(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public static Pagination getInstance(Integer limit, Integer offset, Integer page, Integer per){
        // mysql:select * from article LIMIT 1,3 => select * from article LIMIT 3 OFFSET 1
        if(limit != null && offset != null) {
            if(limit < 0 || offset < 0) {
                throw new PaginationFieldIllegalException("limit,offset应不小于0");
            } else {

                return new Pagination(limit, offset);
            }
        }
        if(page != null && per != null) {
            if(page < 1 || per < 0) {
                throw new PaginationFieldIllegalException("per应不小于0,page应不小于1");
            } else {
                return new Pagination(per,(page - 1) * per);
            }
        }
        return null;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer() {
        return per;
    }

    public void setPer(int per) {
        this.per = per;
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
