package plus.xiexie.biz.pojo;

public class Querier<T>{

    private Pagination pagination;

    private String sort;

    private String order;

    private String operator;

    private T filter;

    public Querier(String operator, T filter) {
        this.operator = StaticWord.match(operator);
        this.filter = filter;
    }

    public Querier(Integer limit, Integer offset, Integer page, Integer per,String sort, String order, String operator, T filter) {
        this.pagination = Pagination.getInstance(limit, offset, page, per);
        this.sort = sort;
        this.order = StaticWord.match(order);
        this.operator = StaticWord.match(operator);
        this.filter = filter;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public T getFilter() {
        return filter;
    }

    public void setFilter(T filter) {
        this.filter = filter;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
