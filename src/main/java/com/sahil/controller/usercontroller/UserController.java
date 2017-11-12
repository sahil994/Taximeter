package com.sahil.controller.usercontroller;


import com.sahil.models.LoginModel;
import com.sahil.models.RegisterModel;
import com.sahil.services.RegisterServices;
import com.sahil.services.ResponseUserModel;
import com.sahil.tokenConfig.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    RegisterServices registerServices;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity registerUser(@RequestBody RegisterModel registerModel) {

        return registerServices.saveUser(registerModel);

    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity authenticateUser(@RequestBody LoginModel loginModel) {
        System.out.print(">>>>" + loginModel.getPassword() + ">>>>" + loginModel.getEmail());


        return registerServices.authenticateUser(loginModel);

    }


}
