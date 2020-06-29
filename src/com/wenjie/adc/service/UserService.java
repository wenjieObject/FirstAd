package com.wenjie.adc.service;

import com.wenjie.adc.pojo.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List<User> userList() throws IOException;

    void register(User user);
}
