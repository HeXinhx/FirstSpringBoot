package com.example.controller;

import com.example.domain.Result;
import com.example.domain.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import com.example.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by hx on 2017/11/4.
 */
@RestController
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户列表
     * @return
     */
    @GetMapping(value = "/users")
    public List<User> userList(){
//        System.out.println("userList");
        logger.info("userList");
        return userRepository.findAll();
    }

    /**
     * 添加一个用户
     * @param user
     * @return
     */
    @PostMapping(value = "/users")
    public Result<User> userAdd(@Valid User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()){

            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        user.setGrade(user.getGrade());
        user.setName(user.getName());

        return ResultUtil.success(userRepository.save(user));
    }

    /**
     * 查找一个用户
     * @param id
     * @return
     */
    @GetMapping(value = "/users/{id}")
    public User userFindOne(@PathVariable("id") Integer id){
        return userRepository.findOne(id);
    }

    /**
     * 更新用户
     * @param id
     * @param grade
     * @param name
     * @return
     */
    @PutMapping(value = "/users/{id}")
    public User userUpdate(@PathVariable("id") Integer id,
                              @RequestParam("grade") String grade,
                              @RequestParam("name") String name){

        User user = new User();
        user.setId(id);
        user.setGrade(grade);
        user.setName(name);

        return userRepository.save(user);
    }

    /**
     * 删除用户
     * @param id
     */
    @DeleteMapping(value = "/users/{id}")
    public void userDelete(@PathVariable("id") Integer id){

         userRepository.delete(id);
    }

    /**
     * 查找用户
     * @param name
     * @return
     */
    @GetMapping(value = "/users/name/{name}")
    public List<User> userListByName(@PathVariable("name") String name){
        return userRepository.getUsersByName(name);
    }

    @PostMapping(value = "/users/addTwo")
    public void userAddTwo(){
        userService.insertTwo();
    }

    @GetMapping(value = "/users/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        userService.getAge(id);
    }


}
