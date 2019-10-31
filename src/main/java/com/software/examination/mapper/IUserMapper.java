package com.software.examination.mapper;

import com.software.examination.dto.SubjectDTO;
import com.software.examination.dto.UserDTO;
import com.software.examination.enity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author fsqiu
 * @date 2019/10/24 10:32
 */
@Mapper
@Component
public interface IUserMapper {
    Integer selectCount(String userName);

    UserDTO selectUser(String userName);

    Integer addOneUser(UserDO userDO);

    List<SubjectDTO> getAllSub();

    Integer updateUserInfo(UserDO userDO);

    List<UserDTO> selectAllUser(Map<String,Integer> myMap);

    Integer deleteUser(String userName);

    Integer getUserCount();
}
