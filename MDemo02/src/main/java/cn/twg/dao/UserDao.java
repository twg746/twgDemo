package cn.twg.dao;

import cn.twg.pojo.NewUser;
import cn.twg.pojo.QueryVo;
import cn.twg.pojo.User;

import java.util.List;

public interface UserDao {
    User selectUserById(int id);

   List<User> findUserByQueryVo(QueryVo vo);

    List<NewUser>findUserByMap();

    List<User> findUserIf(User u);

}
