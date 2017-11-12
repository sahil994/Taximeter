package com.sahil.controller.usercontroller;


import com.sahil.errorModel.ErrorDTO;
import com.sahil.interfaces.AddTariffRepository;
import com.sahil.interfaces.RegisterUerRepository;
import com.sahil.interfaces.SaveTariffPosition;
import com.sahil.models.AddTariffModel;
import com.sahil.models.ResponseAddTariffModel;
import com.sahil.models.TariffLatLngModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/api/tariff")
public class TariffController {


    @Autowired
    AddTariffRepository addTariffRepository;

    @Autowired
    RegisterUerRepository registerUerRepository;

    @Autowired
    SaveTariffPosition saveTariffPosition;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addTariff(@RequestBody AddTariffModel tariffModel) {
        ResponseEntity responseEntity = null;

        AddTariffModel addTariffModel = addTariffRepository.findByCarName(tariffModel.getCarName());

        ResponseAddTariffModel responseAddTariffModel = null;
        if (addTariffModel == null) {

            AddTariffModel addTariffModel1 = addTariffRepository.save(tariffModel);

            responseAddTariffModel = new ResponseAddTariffModel();
            responseAddTariffModel.setResponse("Sucessfully Added");
            responseAddTariffModel.setTariffid(addTariffModel1.getId());

            responseEntity = new ResponseEntity(responseAddTariffModel, HttpStatus.OK);


        } else {

            ErrorDTO employeeException = new ErrorDTO();
            employeeException.setDescription("Tariff name already exist in the database");
            employeeException.setMessage("Tariff name already exist in the database");
            responseEntity = new ResponseEntity(employeeException, HttpStatus.BAD_REQUEST);

        }

        return responseEntity;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<AddTariffModel> getAllTariff() {


        Iterable<AddTariffModel> addTariffModels = addTariffRepository.findAll();

        return addTariffModels;
    }


    @RequestMapping(value = "latlng/add", method = RequestMethod.POST)
    public ResponseEntity addTariffLatLng(@RequestBody TariffLatLngModel tariffModel) {

        int userid = registerUerRepository.getByEmail(Constants.email).getId();
        tariffModel.setUserid(userid);

        TariffLatLngModel tariffLatLngModel = saveTariffPosition.save(tariffModel);

        ResponseAddTariffModel responseAddTariffModel = new ResponseAddTariffModel();
        responseAddTariffModel.setResponse("Sucessfully Added");

        ResponseEntity responseEntity = new ResponseEntity(responseAddTariffModel, HttpStatus.OK);


        return responseEntity;
    }

    @CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
    @RequestMapping(value = "latlng/all", method = RequestMethod.GET)
    public Iterable<TariffLatLngModel> getTariffPostions() {


        Iterable<TariffLatLngModel> addTariffModels = saveTariffPosition.findAll();

        return addTariffModels;
    }



}

