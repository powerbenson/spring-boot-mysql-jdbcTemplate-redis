package tw.idb.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.idb.user.dao.UserDao;
import tw.idb.user.vo.User;

@Service("userService")
public class UserService {

    @Autowired
    UserDao userDao;

    public User getUser(String userid) {
        return userDao.getUser(userid);
    }
}
