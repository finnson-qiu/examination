package com.software.examination.service.impl;

import com.software.examination.dto.SubjectDTO;
import com.software.examination.dto.UserDTO;
import com.software.examination.enity.UserDO;
import com.software.examination.mapper.IUserMapper;
import com.software.examination.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fsqiu
 * @date 2019/10/24 10:46
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    /**
     * 登录功能，验证用户名和密码是否匹配，匹配则返回用户的权限编号，不匹配则返回0（代表该用户不存在），-1（代表用户名和密码不匹配）
     * @param userDTO
     * @return
     */
    @Override
    public Integer login(UserDTO userDTO) {
        if(userMapper.selectCount(userDTO.getUserName()) == 0){
            return 0;
        }
        else {
            UserDTO trueUser = userMapper.selectUser(userDTO.getUserName());
            if(trueUser.getPassword().equals(userDTO.getPassword())){
                return trueUser.getPermission();
            }
            else {
                return -1;
            }
        }
    }

    /**
     * 注册功能，往数据库里面添加一条数据
     * @param userDTO
     * @return
     */
    @Override
    public Integer register(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDTO,userDO);
        return userMapper.addOneUser(userDO);
    }

    /**
     * 获取所有科目信息
     * @return
     */
    @Override
    public List<SubjectDTO> getAllSubject() {
        return userMapper.getAllSub();
    }

    /**
     * 注册时实时验证要注册的用户名是否已经存在
     * @param userDTO
     * @return
     */
    @Override
    public Integer validateUser(UserDTO userDTO) {
        return userMapper.selectCount(userDTO.getUserName());
    }

    /**
     * 修改密码，验证用户名和身份证号是否匹配，匹配则修改数据库里对应用户名的记录
     * @param userDTO
     * @return
     */
    @Override
    public Integer changePassword(UserDTO userDTO) {
        if(userMapper.selectCount(userDTO.getUserName()) == 0){
            return -2;
        }
        else{
            UserDTO temp = userMapper.selectUser(userDTO.getUserName());
            String tempId = userDTO.getIdNumber();
            if (temp.getIdNumber().equals(tempId)){
                UserDO tempDO = new UserDO();
                BeanUtils.copyProperties(userDTO,tempDO);
                return userMapper.updateUserInfo(tempDO);
            }
            else {
                return -1;
            }
        }
    }

    /**
     * 获取对应用户名的用户所有信息
     * @param userDTO
     * @return
     */
    @Override
    public UserDTO getUserInfo(UserDTO userDTO) {
        return userMapper.selectUser(userDTO.getUserName());
    }

    /**
     * 获取所有用户的用户
     * @param myData
     * @return
     */
    @Override
    public List<UserDTO> getAllUser(Map<String, Integer> myData) {
        Integer pageNo = myData.get("pageNo");
        Integer pageSize = myData.get("pageSize");
        Integer currIndex = (pageNo-1)*pageSize;
        Map<String,Integer> myMap = new HashMap<>();
        myMap.put("currIndex",currIndex);
        myMap.put("pageSize",pageSize);
        return userMapper.selectAllUser(myMap);
    }

    /**
     * 更新用户权限
     * @param userDTO
     * @return
     */
    @Override
    public Integer updatePermission(UserDTO userDTO) {
        UserDO tempDO = new UserDO();
        BeanUtils.copyProperties(userDTO,tempDO);
        return userMapper.updateUserInfo(tempDO);
    }

    /**
     * 删除用户
     * @param userDTO
     * @return
     */
    @Override
    public Integer deleteUser(UserDTO userDTO) {
        return userMapper.deleteUser(userDTO.getUserName());
    }

    /**
     * 获取当前用户数量
     * @return
     */
    @Override
    public Integer getUserCount() {
        return userMapper.getUserCount();
    }
}
