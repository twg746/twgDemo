package cn.twg;

import cn.twg.dao.UserDao;
import cn.twg.pojo.NewUser;
import cn.twg.pojo.QueryVo;
import cn.twg.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class myTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before

    public  void init() throws IOException {
        InputStream input= Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory =new SqlSessionFactoryBuilder().build(input);
    }
    @Test
    public void testDo(){
        SqlSession session=sqlSessionFactory.openSession();
        UserDao u =session.getMapper(UserDao.class);//用动态代理的方式自动生成接口的实现类
        User user =u.selectUserById(2);
        System.out.println(user.getName());
    }
    @Test
    public void testDo1(){
        SqlSession session=sqlSessionFactory.openSession();
        UserDao u =session.getMapper(UserDao.class);//用动态代理的方式自动生成接口的实现类
        QueryVo vo=new QueryVo();
        User user=new User();
        user.setName("%z%");
        user.setAge(20);
        vo.setUser(user);
        List<User> lst =u.findUserByQueryVo(vo);
        System.out.println(lst.size());
    }
    @Test
    public void testDo2(){
        SqlSession session=sqlSessionFactory.openSession();
        UserDao u =session.getMapper(UserDao.class);//用动态代理的方式自动生成接口的实现类
        List<NewUser> user =u.findUserByMap();
        System.out.println(user.size());
    }

    @Test
    public void testDo3(){
        SqlSession session=sqlSessionFactory.openSession();
        UserDao u =session.getMapper(UserDao.class);//用动态代理的方式自动生成接口的实现类
        User user=new User();
        //user.setId(6);
        //user.setName("%w%");
        List<User> lstuser =u.findUserIf(user);
        System.out.println(lstuser.size());
    }

}
