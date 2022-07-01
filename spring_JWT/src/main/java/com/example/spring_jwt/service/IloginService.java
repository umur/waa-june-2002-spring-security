package com.example.spring_jwt.service;

import com.example.spring_jwt.Model.LoginModel;
import com.example.spring_jwt.Model.ResponseModel;

public interface IloginService {
     ResponseModel login(LoginModel loginModel);
}
