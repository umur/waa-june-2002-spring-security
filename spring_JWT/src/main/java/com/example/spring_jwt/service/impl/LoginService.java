package com.example.spring_jwt.service.impl;

import com.example.spring_jwt.Model.LoginModel;
import com.example.spring_jwt.Model.ResponseModel;
import com.example.spring_jwt.service.IloginService;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements IloginService {

    public ResponseModel login(LoginModel loginModel)
    {
        ResponseModel responseModel = new ResponseModel();
        responseModel.token = "Bearer: "+ "token";
        return  responseModel;
    }
}
