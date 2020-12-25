package plus.xiexie.biz.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@ApiModel(description = "用户对象")
public class User implements Serializable {

    private static final long serialVersionUID = -2445250555671271429L;

    private String id;
    private String nickName;
    private String cnName;
    private String enName;
    private String phone;
    private String email;
    private String password;
    private String sex;
    private Integer age;

    @ApiModelProperty(value = "出生日期", dataType = "java.lang.String")
    private Date birthday;

    private String photo;
    private String primaryStage;
    private String juniorStage;
    private String seniorStage;
    private String collegeStage;
    private String qualification;
    private String wechat;
    private String qq;
    private String weibo;
    private String address;
    private String signature;
    private String salt;

    @ApiModelProperty(value = "创建时间", dataType = "java.lang.String", hidden = true)
    private Timestamp createDate;

    @ApiModelProperty(value = "更新时间", dataType = "java.lang.String", hidden = true)
    private Timestamp lastUpdateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(String primaryStage) {
        this.primaryStage = primaryStage;
    }

    public String getJuniorStage() {
        return juniorStage;
    }

    public void setJuniorStage(String juniorStage) {
        this.juniorStage = juniorStage;
    }

    public String getSeniorStage() {
        return seniorStage;
    }

    public void setSeniorStage(String seniorStage) {
        this.seniorStage = seniorStage;
    }

    public String getCollegeStage() {
        return collegeStage;
    }

    public void setCollegeStage(String collegeStage) {
        this.collegeStage = collegeStage;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
