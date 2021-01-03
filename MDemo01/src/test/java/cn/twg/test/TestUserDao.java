package cn.twg.test;

import cn.twg.dao.UserDaoImpl;
import cn.twg.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestUserDao {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public  void  init() throws IOException {
        InputStream input=Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(input);


    }
    @Test
    public  void testDo(){
        UserDaoImpl userDao=new UserDaoImpl(sqlSessionFactory);
        User u=userDao.getUserById(2);
        System.out.println(u.getName());
    }
}
