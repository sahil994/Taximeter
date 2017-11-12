package com.sahil.interfaces;

import com.sahil.models.RegisterModel;
import org.springframework.data.repository.CrudRepository;

public interface RegisterUerRepository extends CrudRepository<RegisterModel, Integer> {

    public RegisterModel getByEmail(String email);

    public RegisterModel getByEmailAndPassword(String email,String Password);


    public RegisterModel getByUserName(String UserNmae);

    public RegisterModel findByEmail(String email);


    public RegisterModel findByEmailAndUserName(String email,String Username);



    public RegisterModel findByUserName(String UserNmae);


}
