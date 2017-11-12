package com.sahil.services;

import com.sahil.errorModel.ErrorDTO;
import com.sahil.interfaces.RegisterUerRepository;
import com.sahil.models.LoginModel;
import com.sahil.models.RegisterModel;
import com.sahil.tokenConfig.JwtGenerator;
import com.sahil.tokenConfig.tokenmodel.UserTokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RegisterServices implements UserDetailsService {

    @Autowired
    RegisterUerRepository registerUerRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    JwtGenerator jwtGenerator;

    public RegisterServices(JwtGenerator jwtGenerator) {

        this.jwtGenerator = jwtGenerator;
    }

    public ResponseEntity saveUser(RegisterModel registerModel) {


        ResponseEntity responseEntity=null;
        ResponseUserModel responseUserModel = null;
        if (!registerModel.getEmail().equalsIgnoreCase("") && !registerModel.getUserName().equalsIgnoreCase("") && !registerModel.getPassword().equalsIgnoreCase("")) {



            if(registerUerRepository.getByEmail(registerModel.getEmail())!=null){

                ErrorDTO employeeException = new ErrorDTO();
                employeeException.setDescription("User email already exists in database");
                employeeException.setMessage("User  email already exists in database");
                responseEntity = new ResponseEntity(employeeException, HttpStatus.BAD_REQUEST);

            }
            else if(registerUerRepository.getByUserName(registerModel.getUserName())!=null){

                ErrorDTO employeeException = new ErrorDTO();
                employeeException.setDescription("Username already exists in database");
                employeeException.setMessage("Username already exists in database");
                responseEntity = new ResponseEntity(employeeException, HttpStatus.BAD_REQUEST);

            }
            else{

                registerUerRepository.save(registerModel);
                UserTokenModel userTokenModel = new UserTokenModel();
                userTokenModel.setEmail(registerModel.getEmail());
                userTokenModel.setUsername(registerModel.getUserName());
                String token = jwtGenerator.generate(userTokenModel);

                responseUserModel = new ResponseUserModel();
                responseUserModel.setToken(token);
                responseUserModel.setUserid(registerUerRepository.getByEmail(registerModel.getEmail()).getId());

         responseEntity=new ResponseEntity(responseUserModel,HttpStatus.OK);

            }

        }
        else{


            ErrorDTO employeeException = new ErrorDTO();
            employeeException.setDescription("Field Should Not Be Empty");
            employeeException.setMessage("Field Should Not Be Empty");
            responseEntity = new ResponseEntity(employeeException, HttpStatus.BAD_REQUEST);


        }

        return responseEntity;
    }


    public ResponseEntity authenticateUser(LoginModel loginModel) {

        ResponseUserModel responseUserModel = null;
        ResponseEntity responseEntity = null;
        if (!loginModel.getEmail().equalsIgnoreCase("") && !loginModel.getPassword().equalsIgnoreCase("")) {


            if (registerUerRepository.getByEmail(loginModel.getEmail())==null) {


                ErrorDTO employeeException = new ErrorDTO();
                employeeException.setDescription("User not exist in the database");
                employeeException.setMessage("User not exist in the database");
                responseEntity = new ResponseEntity(employeeException, HttpStatus.BAD_REQUEST);

            } else {

                RegisterModel registerModel = registerUerRepository.getByEmailAndPassword(loginModel.getEmail(), loginModel.getPassword());

                if (registerModel == null) {


                    ErrorDTO employeeException = new ErrorDTO();
                    employeeException.setDescription("Invalid Credentials");
                    employeeException.setMessage("Invalid Credentials");
                    responseEntity = new ResponseEntity(employeeException, HttpStatus.BAD_REQUEST);


                } else {


                    UserTokenModel userTokenModel = new UserTokenModel();
                    userTokenModel.setEmail(registerModel.getEmail());
                    userTokenModel.setUsername(registerModel.getUserName());

                    String token = jwtGenerator.generate(userTokenModel);
                    System.out.println("" + token);
                    responseUserModel = new ResponseUserModel();
                    responseUserModel.setToken(token);
                    responseUserModel.setUserid(registerModel.getId());



                    responseEntity = new ResponseEntity(responseUserModel, HttpStatus.OK);

                }


            }


        } else {

            ErrorDTO employeeException = new ErrorDTO();
            employeeException.setDescription("Wrong Username or password");
            employeeException.setMessage("Invalid Credentials");
            responseEntity = new ResponseEntity(employeeException, HttpStatus.BAD_REQUEST);


        }


        return responseEntity;
    }


}
