package plus.xiexie.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plus.xiexie.biz.mapper.UserMapper;
import plus.xiexie.biz.pojo.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }
}
