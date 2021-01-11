package plus.xiexie.biz.pojo;

public class UserFilter {

    private String id;

    private String name;

    private String phone;

    private String email;

    private String sex;

    public UserFilter() {}

    public UserFilter(String id, String name, String phone, String email, String sex) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
