package com.Beykent.uSwapp.dataAccess.abstracts;

import com.Beykent.uSwapp.core.entities.User;
import com.Beykent.uSwapp.core.utilities.results.DataResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
