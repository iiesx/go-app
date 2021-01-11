package plus.xiexie.biz.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import plus.xiexie.biz.pojo.Pagination;

import java.util.List;

public class QueryVo <T> {

    private List<T> list;

    private Integer total;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Pagination paging;

    public QueryVo() {

    }

    public QueryVo(List<T> list, Integer total, Pagination paging) {
        this.list = list;
        this.total = total;
        this.paging = paging;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Pagination getPaging() {
        return paging;
    }

    public void setPaging(Pagination paging) {
        this.paging = paging;
    }
}
