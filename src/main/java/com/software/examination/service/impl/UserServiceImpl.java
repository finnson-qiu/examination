package com.software.examination.service.impl;

import com.software.examination.dto.SubjectDTO;
import com.software.examination.dto.UserDTO;
import com.software.examination.enity.UserDO;
import com.software.examination.mapper.IUserMapper;
import com.software.examination.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fsqiu
 * @date 2019/10/24 10:46
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public Integer login(UserDTO userDTO) {
        if(userMapper.selectCount(userDTO.getUserName()) == 0){
            return 0;
        }
        else {
            UserDTO trueUser = userMapper.selectUser(userDTO.getUserName());
            if(trueUser.getPassword().equals(userDTO.getPassword())){
                return 1;
            }
            else {
                return -1;
            }
        }
    }

    @Override
    public Integer register(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDTO,userDO);
        return userMapper.addOneUser(userDO);
    }

    @Override
    public List<SubjectDTO> getAllSubject() {
        return userMapper.getAllSub();
    }

    @Override
    public Integer validateUser(UserDTO userDTO) {
        return userMapper.selectCount(userDTO.getUserName());
    }

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
                return userMapper.updatePassword(tempDO);
            }
            else {
                return -1;
            }
        }
    }
}
