package com.example.handle;

import com.example.domain.Result;
import com.example.exception.UserException;
import com.example.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hx on 2017/11/4.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result hanble(Exception e ){

        if(e instanceof UserException){
            UserException userException = (UserException) e;
            return ResultUtil.error(userException.getCode(),userException.getMessage());
        }else{
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(-1,"未知错误");
        }

    }
}
