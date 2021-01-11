package plus.xiexie.biz.pojo;

import plus.xiexie.exception.SortFieldIllegalException;

public enum StaticWord {

    ASC("asc"),
    DESC("desc"),
    EQ("eq"),
    LIKE("like");

    private String val;

    public String value() {
        return val;
    }

    StaticWord(String val){
        this.val = val;
    }

    public static String match(String val) {
        if(val != null) {
            for(StaticWord word : StaticWord.values()) {
                if(word.value().equals(val.toLowerCase())){
                    return word.value();
                }
            }
            throw new SortFieldIllegalException(String.format("升序或降序限定词为ASC或DESC[error order by field %s]", val));
        }
        return null;
    }
}
