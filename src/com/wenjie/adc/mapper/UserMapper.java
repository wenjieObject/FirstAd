package com.wenjie.adc.mapper;

import com.wenjie.adc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User sel4Login(@Param("username") String username,@Param("password") String password);

    /**
     * 注册
     * @param user
     */
    void insUser(User user);

    /**
     * 分页查询
     * @param index
     * @param size
     * @return
     */
    List<User> selByPage(@Param("username") String username,@Param("age") String age,@Param("index") int index,@Param("size") int size);

    /**
     * 查询所有
     * @return
     */
    int countUsers();
}
