package com.wenjie.adc.service.impl;

import com.wenjie.adc.pojo.User;
import com.wenjie.adc.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class UserServiceImpl implements UserService {

    @Override
    public List<User> userList() throws IOException {
        // Resources - 资源加载工具, 默认去classpath加载资源
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        // SqlSessionFactoryBuilder - 工厂构建者
        // SqlSessionFactory - 会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // SqlSession - 会话, 用于所有mybatis中操作方法的调用
        SqlSession sqlSession = factory.openSession();
        // 调用方法进行查询
        List<User> list = sqlSession.selectList("com.wenjie.adc.selAll");
        // 关闭资源
        sqlSession.close();

        return list;


    }

    @Override
    public void register(User user) {
//        SqlSession sqlSession = MyBatisUtil.openSession();
//        //创建SimpleDateFormat对象实例并定义好转换格式
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//        try {
//            user.setRegTime(sdf.format(new Date()));
//            sqlSession.insert("insUser",user);
//            sqlSession.commit();
//        }catch (Exception e){
//            e.printStackTrace();
//            sqlSession.rollback();
//        }
//        sqlSession.close();
    }
}
