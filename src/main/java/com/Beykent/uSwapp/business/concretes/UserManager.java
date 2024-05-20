package com.Beykent.uSwapp.business.concretes;

import com.Beykent.uSwapp.business.abstracts.UserService;
import com.Beykent.uSwapp.core.entities.User;
import com.Beykent.uSwapp.core.utilities.results.DataResult;
import com.Beykent.uSwapp.core.utilities.results.Result;
import com.Beykent.uSwapp.core.utilities.results.SuccessDataResult;
import com.Beykent.uSwapp.core.utilities.results.SuccessResult;
import com.Beykent.uSwapp.dataAccess.abstracts.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanıcı eklendi");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email)
                ,"Kullanıcı bulundu");
    }
}
