package com.project.User.Spring_Security.repository;

import com.project.User.Spring_Security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //@Query(nativeQuery = true, value = "select u from users u where u.email=:Email")
    //User getUserByUserEmail(@Param("Email")String Email);
    User getUserByEmail(String Email);
}
