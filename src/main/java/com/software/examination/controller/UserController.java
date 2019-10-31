package com.software.examination.controller;

import com.software.examination.dto.SubjectDTO;
import com.software.examination.dto.UserDTO;
import com.software.examination.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author fsqiu
 * @date 2019/10/24 10:32
 */
//跨域问题解决注解
@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 登录，验证用户名和密码是否配对并且往前端返回该用户的权限
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/login")
    public Integer login(@RequestBody UserDTO userDTO){
        return userService.login(userDTO);
    }

    /**
     * 注册，增加新用户
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/register")
    public Integer register(@RequestBody UserDTO userDTO){
        return userService.register(userDTO);
    }

    /**
     * 获取所有科目信息
     * @return
     */
    @GetMapping(value = "/subject")
    public List<SubjectDTO> getAllSubject(){
        return userService.getAllSubject();
    }

    /**
     * 验证该用户是否存在
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/validateUser")
    public Integer validateUser(@RequestBody UserDTO userDTO){
        return userService.validateUser(userDTO);
    }

    /**
     * 修改密码，前端传来用户名和新密码还有身份证号码，后端验证身份证号是否和用户名匹配
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/changePassword")
    public Integer change(@RequestBody UserDTO userDTO){
        return userService.changePassword(userDTO);
    }

    /**
     * 根据用户名获取用户权限，从前端传来用户名
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/getPermission")
    public Integer getPermission(@RequestBody UserDTO userDTO){
        return userService.getUserInfo(userDTO).getPermission();
    }

    /**
     * 获取所有除了超级管理员以外的用户，供前端显示给超级管理员管理
     * @param myData
     * @return
     */
    @PostMapping(value = "/getAllUser")
    public List<UserDTO> getAllUser(@RequestBody Map<String,Integer> myData){
        return userService.getAllUser(myData);
    }

    /**
     * 更新用户权限
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/updatePermission")
    public Integer updatePermission(@RequestBody UserDTO userDTO){
        return userService.updatePermission(userDTO);
    }

    /**
     * 后端api，删除用户，接收用户名，根据用户名删除用户
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/deleteUser")
    public Integer deleteUser(@RequestBody UserDTO userDTO){
        return userService.deleteUser(userDTO);
    }

    /**
     * 后端api，获取当前非超级管理员的数量，用于分页时知道用户数总数
     * @return
     */
    @GetMapping(value = "/userCount")
    public Integer getUserCount(){
        return userService.getUserCount();
    }
}
