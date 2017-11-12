package com.sahil.controller.usercontroller;


import com.sahil.errorModel.EmployeeException;
import com.sahil.errorModel.ErrorResponse;
import com.sahil.interfaces.RegisterUerRepository;
import com.sahil.models.*;
import com.sahil.services.SaveTariffHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("rest/api/tariff")
public class HistoryController {



    @Autowired
    SaveTariffHistoryService saveTariffHistoryService;

    @RequestMapping(value = "/history/save", method = RequestMethod.POST)
    public ResponseEntity saveHistory(@RequestBody SaveTariffHistoryModel saveTariffHistoryModel) {

        return saveTariffHistoryService.saveHistory(saveTariffHistoryModel);

    }



    @RequestMapping(value = "history/all", method = RequestMethod.GET)
    public  ArrayList<ResponseAddTariffListModel> getAllTariff() {


        return saveTariffHistoryService.getAllHistory();

    }

    @RequestMapping(value = "history/{year}", method = RequestMethod.GET)
    public  ResponseEntity getAllTariffByYear(@PathVariable("year") String year) {


        return saveTariffHistoryService.getHistoryByYear(year);

    }

    @RequestMapping(value = "history/day/", method = RequestMethod.POST)
    public  ResponseEntity getAllTariffByDay(@RequestBody GetDayHistoryModel getDayHistoryModel){

        System.out.println("called"+getDayHistoryModel.startDate);
        return saveTariffHistoryService.getHistoryByday(getDayHistoryModel.startDate);

    }

    @RequestMapping(value = "history/time/", method = RequestMethod.POST)
    public  ResponseEntity getAllTariffByTime(@RequestBody GetTimeHistoryModel getDayHistoryModel){


        return  saveTariffHistoryService.getHistoryByTime(getDayHistoryModel.startDate,getDayHistoryModel.starttime);
    }

  /*  @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
    }
*/
}

