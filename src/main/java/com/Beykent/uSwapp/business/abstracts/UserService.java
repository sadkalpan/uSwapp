package com.Beykent.uSwapp.business.abstracts;

import com.Beykent.uSwapp.core.entities.User;
import com.Beykent.uSwapp.core.utilities.results.DataResult;
import com.Beykent.uSwapp.core.utilities.results.Result;

import javax.xml.crypto.Data;
import java.util.List;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}
