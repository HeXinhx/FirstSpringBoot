package com.example.service;

import com.example.domain.User;
import com.example.enums.ResultEnum;
import com.example.exception.UserException;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hx on 2017/11/4.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void insertTwo(){

        User userA = new User();
        userA.setGrade("A");
        userA.setName("aa");

        userRepository.save(userA);

        User userB = new User();
        userB.setGrade("B");
        userB.setName("bb");

        userRepository.save(userB);
    }

    /**
     * 根据年龄查找用户信息
     * @param id
     * @throws Exception
     */
    public void getAge(Integer id) throws Exception{
        User user = userRepository.findOne(id);
        Integer age = user.getAge();
        if(age < 21){

            throw new UserException(ResultEnum.COLLEGE_STUDENT);

        }else if(age > 21 && age <25 ){

            throw new UserException(ResultEnum.GRADUATE_STUDENT);
        }
    }

    public User findOne(Integer id){
        return userRepository.findOne(id);
    }


}
