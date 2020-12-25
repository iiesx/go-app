package plus.xiexie.biz.mapper;

import plus.xiexie.biz.pojo.User;

import java.util.List;

public interface UserMapper {

    public List<User> getUsers();

    public User getUserById(String id);
}
