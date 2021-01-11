package plus.xiexie.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import plus.xiexie.biz.mapper.UserMapper;
import plus.xiexie.biz.pojo.Querier;
import plus.xiexie.biz.pojo.User;
import plus.xiexie.biz.pojo.UserFilter;
import plus.xiexie.exception.SourceExistedException;
import plus.xiexie.exception.SourceNotFoundException;
import plus.xiexie.util.IDUtil;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> getUsers(Querier querier) {
        return userMapper.getUsers(querier);
    }

    public Integer getUsersCount(Querier querier) {
        return userMapper.getUsersCount(querier);
    }

    public User getUserById(String id) {
        User user = userMapper.getUserById(id);
        if(user != null){
            return userMapper.getUserById(id);
        } else {
          throw new SourceNotFoundException(String.format("无效的用户id，%s", id));
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public String addUser(User user) {
        UserFilter f1 = new UserFilter();
        f1.setName(user.getNickName());
        UserFilter f2 = new UserFilter();
        f2.setPhone(user.getPhone());
        UserFilter f3 = new UserFilter();
        f3.setEmail(user.getEmail());
        Querier<UserFilter> q1 = new Querier<>("eq", f1);
        Querier<UserFilter> q2 = new Querier<>("eq", f2);
        Querier<UserFilter> q3 = new Querier<>("eq", f3);
        List<User> u1 = userMapper.getUsers(q1);
        if(f1.getName() != null && !u1.isEmpty()){
            throw new SourceExistedException(String.format("昵称%s已存在",user.getNickName()));
        }
        List<User> u2 = userMapper.getUsers(q2);
        if(f2.getPhone() != null && !u2.isEmpty()){
            throw new SourceExistedException(String.format("手机号%s已存在",user.getPhone()));
        }
        List<User> u3 = userMapper.getUsers(q3);
        if(f3.getEmail() != null && !u3.isEmpty()){
            throw new SourceExistedException(String.format("邮箱%s已存在",user.getEmail()));
        }
        String id = IDUtil.generateCommonID();
        user.setId(id);
        userMapper.addUser(user);
        return id;
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer deleteUser(String id) {
        User user = userMapper.getUserById(id);
        if(user != null){
            return userMapper.deleteUser(id);
        } else {
            throw new SourceNotFoundException(String.format("无效的用户id，%s", id));
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public User updateUserInfos(String id, User user) {
        User u = userMapper.getUserById(id);
        if(u != null){
            userMapper.deleteUser(id);
            user.setId(id);
            user.setCreateDate(u.getCreateDate());
            userMapper.addUser(user);
            return userMapper.getUserById(id);
        } else {
            throw new SourceNotFoundException(String.format("无效的用户id，%s", id));
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public User updateUserInfo(String id, User user) {
        User u = userMapper.getUserById(id);
        if(u != null){
            user.setId(id);
            userMapper.updateUserInfo(user);
            return userMapper.getUserById(id);
        } else {
            throw new SourceNotFoundException(String.format("无效的用户id，%s", id));
        }
    }
}
