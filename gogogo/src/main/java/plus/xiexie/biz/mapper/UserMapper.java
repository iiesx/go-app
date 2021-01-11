package plus.xiexie.biz.mapper;

import org.apache.ibatis.annotations.Param;
import plus.xiexie.biz.pojo.Querier;
import plus.xiexie.biz.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> getUsers(@Param("querier") Querier querier);

    Integer getUsersCount(@Param("querier") Querier querier);

    User getUserById(String id);

    Integer addUser(@Param("user") User user);

    Integer deleteUser(String id);

    Integer updateUserInfo(@Param("user") User user);
}
