package cn.twg.dao;

import cn.twg.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements  UserDao{
    protected SqlSessionFactory sqlSessionFactory;

    public  UserDaoImpl(SqlSessionFactory factory){
        this.sqlSessionFactory=factory;

    }
    public User getUserById(int id) {
     SqlSession session=sqlSessionFactory.openSession();
     User u =session.selectOne("cn.twg.dao.selectUserById",id);
     return u;
    }
}
