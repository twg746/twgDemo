package cn.twg.test;

import cn.twg.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class dTest {
    @Test
    public void testDo() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory会话工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //使用会话工厂对象创建会话
        SqlSession sql = factory.openSession();
        //执行sql语句
        int count = sql.selectOne("cn.twg.dao.getCount");
        //关闭会话

        sql.close();
        System.out.println(count);

    }

    @Test
    public void testDo1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory会话工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //使用会话工厂对象创建会话
        SqlSession sql = factory.openSession();
        //执行sql语句
        User u = sql.selectOne("cn.twg.dao.selectUserById", 1);
        //关闭会话

        sql.close();
        System.out.println(u.getName());
    }

    @Test
    public void testDo2() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory会话工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //使用会话工厂对象创建会话
        SqlSession sql = factory.openSession();
        //执行sql语句
        List<User> u = sql.selectList("cn.twg.dao.selectUserByName", "%三%");
        //关闭会话

        sql.close();
        System.out.println(u.size());
    }

    @Test
    public void testDo3() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory会话工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //使用会话工厂对象创建会话
        SqlSession sql = factory.openSession();
        //执行sql语句
        int count = sql.selectOne("cn.twg.dao.selectCount", "user");
        //关闭会话

        sql.close();
        System.out.println(count);
    }

    @Test
    public void testDo4() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory会话工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //使用会话工厂对象创建会话
        SqlSession sql = factory.openSession();
        User u = new User("zhangsan", "123", 23);
        //执行sql语句
        sql.insert("cn.twg.dao.addUser", u);
        //关闭会话
        sql.commit();
        sql.close();
        System.out.println("插入成功！");
    }

    @Test
    public void testDo5() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory会话工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //使用会话工厂对象创建会话
        SqlSession sql = factory.openSession();
        User u = new User("zhangsan", "123", 23);
        //执行sql语句
        sql.insert("cn.twg.dao.addUserGetID", u);
        //关闭会话
        sql.commit();
        sql.close();
        System.out.println(u.getId());
    }

    @Test
    public void testDo6() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory会话工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //使用会话工厂对象创建会话
        SqlSession sql = factory.openSession();
        User u = new User("zhangsan", "123", 23);
        //执行sql语句
        sql.insert("cn.twg.dao.addUserGetUuid", u);
        //关闭会话
        sql.commit();
        sql.close();
       // System.out.println(u.getUuid());
    }
    @Test
    public void testDo7() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory会话工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //使用会话工厂对象创建会话
        SqlSession sql = factory.openSession();

        //执行sql语句
        sql.delete("cn.twg.dao.deleteUser", 9);
        //关闭会话
        sql.commit();
        sql.close();
        System.out.println("删除成功！");
    }
    @Test
    public void testDo8() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory会话工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //使用会话工厂对象创建会话
        SqlSession sql = factory.openSession();
        User u=new User(3,"马老师","666",69);

        //执行sql语句
        sql.update("cn.twg.dao.updateUser",u);
        //关闭会话
        sql.commit();
        sql.close();
        System.out.println("修改成功！");
    }
}
