package com.wenjie.adc.test;

import com.wenjie.adc.mapper.Mapper;
import com.wenjie.adc.mapper.UserMapper;
import com.wenjie.adc.pojo.Student;
import com.wenjie.adc.pojo.User;
import com.wenjie.adc.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    @Test
    public void testMulTables() throws Exception{
        SqlSession sqlSession = MyBatisUtil.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);

        List<Student> allStudent = mapper.getAllStudent("男","Java");

        for (Student student : allStudent) {
            System.out.println(student.toString());
        }

    }

    @Test
    public void testDynamic() throws Exception{
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.selByPage("", "", 0, 0);

        for (User user : users) {
            System.out.println(user.toString());
        }


    }

    @Test
    public void testSelAll() throws Exception {
        // Resources - 资源加载工具, 默认去classpath加载资源
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        // SqlSessionFactoryBuilder - 工厂构建者
        // SqlSessionFactory - 会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // SqlSession - 会话, 用于所有mybatis中操作方法的调用
        SqlSession sqlSession = factory.openSession();
        // 调用方法进行查询
        List<User> list = sqlSession.selectList("selAll");
        for (User user : list) {
            System.out.println(user);
        }
        // 关闭资源
        sqlSession.close();
    }

}
