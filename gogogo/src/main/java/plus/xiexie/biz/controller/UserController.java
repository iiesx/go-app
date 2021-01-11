package plus.xiexie.biz.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plus.xiexie.biz.pojo.*;
import plus.xiexie.biz.service.UserService;
import plus.xiexie.biz.vo.AddedVo;
import plus.xiexie.biz.vo.DeletedVo;
import plus.xiexie.biz.vo.QueryVo;

@RequestMapping("/api/v1/users")
@RestController
@Api(tags = {"用户操作"})
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("查询用户列表")
    @GetMapping("")
    public Response<QueryVo<User>> getUsers(
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "offset", required = false) Integer offset,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "per", required = false) Integer per,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "order", defaultValue = "asc") String order,
            @RequestParam(value = "operator", defaultValue = "eq") String operator,
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "sex", required = false) String sex
    ) {
        UserFilter filter = new UserFilter(id, name, phone, email, sex);
        Querier<UserFilter> querier = new Querier<>(limit, offset, page, per, sort, order, operator, filter);
        QueryVo<User> queryVo = new QueryVo<>(userService.getUsers(querier),userService.getUsersCount(querier), querier.getPagination());
        return Response.success(queryVo);
    }

    @ApiOperation("根据id获取用户详细信息")
    @GetMapping("/{id}")
    public Response<User> getUserById(@PathVariable("id") String id) {
        return Response.success(userService.getUserById(id));
    }

    @ApiOperation("添加用户")
    @PostMapping("")
    public Response<AddedVo> addUser(@RequestBody User user) {
        return Response.success(new AddedVo(userService.addUser(user)));
    }

    @ApiOperation("根据id更新用户全部信息")
    @PutMapping("/{id}")
    public Response<User> updateUserInfos(@PathVariable("id") String id, @RequestBody User user) {
        return Response.success(userService.updateUserInfos(id, user));
    }

    @ApiOperation("根据id更新用户部分信息")
    @PatchMapping("/{id}")
    public Response<User> updateUserInfo(@PathVariable("id") String id, @RequestBody User user) {
        return Response.success(userService.updateUserInfo(id, user));
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public Response<DeletedVo> deleteUser(@PathVariable("id") String id) {
        return Response.success(new DeletedVo(userService.deleteUser(id)));
    }

}
