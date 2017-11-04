package com.example.repository;

import com.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by hx on 2017/11/4.
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    //通过姓名查询
    public List<User> getUsersByName(String name);
}
