package com.example.exception;

import com.example.enums.ResultEnum;

/**
 * Created by hx on 2017/11/4.
 */
public class UserException extends RuntimeException{

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    private Integer code;

    public UserException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }


}
