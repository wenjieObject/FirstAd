package com.wenjie.adc.service.impl;

import com.wenjie.adc.mapper.UserMapper;
import com.wenjie.adc.pojo.User;
import com.wenjie.adc.service.UserService;
import com.wenjie.adc.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserServiceImpl implements UserService {

    @Override
    public List<User> userList(String username,String age) throws IOException {
//        // Resources - 资源加载工具, 默认去classpath加载资源
//        InputStream is = Resources.getResourceAsStream("mybatis.xml");
//        // SqlSessionFactoryBuilder - 工厂构建者
//        // SqlSessionFactory - 会话工厂
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//        // SqlSession - 会话, 用于所有mybatis中操作方法的调用
//        SqlSession sqlSession = factory.openSession();
//        // 调用方法进行查询
//        List<User> list = sqlSession.selectList("com.wenjie.adc.selAll");
//        // 关闭资源
//        sqlSession.close();
//
//        return list;
        SqlSession sqlSession=null;
        try{
            //获取session
            sqlSession=MyBatisUtil.openSession();
            //获取mapper对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            return mapper.selByPage(username,age,0,0);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(sqlSession !=null){
                sqlSession.close();
            }
        }
        return null;

    }

    @Override
    public void register(User user) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        //创建SimpleDateFormat对象实例并定义好转换格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            user.setRegTime(sdf.format(new Date()));
            //sqlSession.insert("insUser",user);
            //sqlSession.commit();
            //获取session
            sqlSession=MyBatisUtil.openSession();
            //获取mapper对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.insUser(user);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        sqlSession.close();
    }

    @Override
    public User login(String username, String password) {
        SqlSession sqlSession=null;
        try{
//            Map<String ,String>params=new HashMap<>();
//            params.put("username",username);
//            params.put("password",password);
//
//            sqlSession=MyBatisUtil.openSession();
//            return sqlSession.selectOne("sel4Login",params);

            //获取session
            sqlSession=MyBatisUtil.openSession();
            //获取mapper对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            return mapper.sel4Login(username,password);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(sqlSession !=null){
                sqlSession.close();
            }
        }
        return null;

    }
}
