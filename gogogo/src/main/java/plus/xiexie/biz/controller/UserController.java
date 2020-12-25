package plus.xiexie.biz.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plus.xiexie.biz.pojo.Response;
import plus.xiexie.biz.pojo.User;
import plus.xiexie.biz.service.UserService;
import plus.xiexie.biz.vo.AddedVo;
import plus.xiexie.biz.vo.DeletedVo;

import java.util.List;

@RequestMapping("/api/v1/users")
@RestController
@Api(tags = {"用户操作"})
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("查询用户列表")
    @GetMapping("")
    public Response<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return Response.success(users);
    }

    @ApiOperation("根据id获取用户详细信息")
    @GetMapping("/{id}")
    public Response<User> getUserById(@PathVariable("id") String id) {
        return Response.success(userService.getUserById(id));
    }

    @ApiOperation("添加用户")
    @PostMapping("")
    public Response<AddedVo> addUser() {
        return null;
    }

    @ApiOperation("根据id更新用户全部信息")
    @PutMapping("/{id}")
    public Response<User> updateUserInfos() {
        return null;
    }

    @ApiOperation("根据id更新用户部分信息")
    @PatchMapping("/{id}")
    public Response<User> updateUserInfo() {
        return null;
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public Response<DeletedVo> deleteUser() {
        return null;
    }

}
