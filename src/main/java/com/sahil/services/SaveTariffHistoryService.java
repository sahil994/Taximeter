package com.sahil.services;


import com.sahil.controller.usercontroller.Constants;
import com.sahil.errorModel.EmployeeException;
import com.sahil.errorModel.ErrorDTO;
import com.sahil.interfaces.RegisterUerRepository;
import com.sahil.interfaces.SaveTariffHistoryRepository;
import com.sahil.models.RegisterModel;
import com.sahil.models.ResponseAddTariffListModel;
import com.sahil.models.ResponseSaveHistoryModel;
import com.sahil.models.SaveTariffHistoryModel;
import com.sahil.tokenConfig.JwtValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SaveTariffHistoryService {

    @Autowired
    SaveTariffHistoryRepository saveTariffHistoryRepository;

    @Autowired
    RegisterUerRepository registerUerRepository;


    public ResponseEntity saveHistory(SaveTariffHistoryModel saveTariffHistoryModel) {

        int userid = registerUerRepository.getByEmail(Constants.email).getId();


      /*  String name =authentication.getName();
System.out.print("dfsddgv"+name);
        RegisterModel registerModel=registerUerRepository.getByUserName(name);
*/
        saveTariffHistoryModel.userid = userid;
        SaveTariffHistoryModel historyModel = saveTariffHistoryRepository.save(saveTariffHistoryModel);
        ResponseEntity responseEntity = null;
        ResponseSaveHistoryModel responseSaveHistoryModel = null;

        if (historyModel != null) {
            responseSaveHistoryModel = new ResponseSaveHistoryModel();
            responseSaveHistoryModel.setReason("Tariff Finished Successfully");
            responseEntity = new ResponseEntity(responseSaveHistoryModel, HttpStatus.OK);

        }

        return responseEntity;
    }

    public ArrayList<ResponseAddTariffListModel> getAllHistory() {
        ArrayList<ResponseAddTariffListModel> dataLists = new ArrayList<>();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println("help name" + name + authentication.getCredentials() + ">>");
        //RegisterModel registerModel=registerUerRepository.getByUserName(name);
        int userid = 1;


        List<SaveTariffHistoryModel> allHistoryList = (List<SaveTariffHistoryModel>) saveTariffHistoryRepository.findAllByUserid(userid);
        HashMap<String, ArrayList<SaveTariffHistoryModel>> hashMap = null;

        for (int i = 0; i < allHistoryList.size(); i++) {

            if (dataLists.size() > 0) {

                for (int j = 0; j < dataLists.size(); j++) {

                    if (dataLists.get(j).getResponseSaveHistoryModels().containsKey(allHistoryList.get(i).startDate.split("-")[0])) {
                        dataLists.get(j).getResponseSaveHistoryModels().get(allHistoryList.get(i).startDate.split("-")[0]).add(allHistoryList.get(i));

                    } else {

                        hashMap = new HashMap();
                        ArrayList<SaveTariffHistoryModel> arrayList = new ArrayList<>();
                        arrayList.add(allHistoryList.get(i));

                        ResponseAddTariffListModel responseAddTariffListModel = new ResponseAddTariffListModel();
                        responseAddTariffListModel.setYearnname(allHistoryList.get(i).startDate.split("-")[0]);

                        hashMap.put(allHistoryList.get(i).startDate.split("-")[0], arrayList);

                        responseAddTariffListModel.setResponseSaveHistoryModels(hashMap);

                        dataLists.add(responseAddTariffListModel);

                    }

                }
            } else {

                hashMap = new HashMap();
                ArrayList<SaveTariffHistoryModel> arrayList = new ArrayList<>();
                arrayList.add(allHistoryList.get(i));

                ResponseAddTariffListModel responseAddTariffListModel = new ResponseAddTariffListModel();
                responseAddTariffListModel.setYearnname(allHistoryList.get(i).startDate.split("-")[0]);

                hashMap.put(allHistoryList.get(i).startDate.split("-")[0], arrayList);

                responseAddTariffListModel.setResponseSaveHistoryModels(hashMap);

                dataLists.add(responseAddTariffListModel);


            }


        }

        return dataLists;
    }


    public ResponseEntity getHistoryByYear(String year) {
        ResponseEntity responseEntity;
        if (year.equalsIgnoreCase("")) {


            ErrorDTO employeeException = new ErrorDTO();
            employeeException.setDescription("Wrong year");
            employeeException.setMessage("Wrong year");
            responseEntity = new ResponseEntity(employeeException, HttpStatus.BAD_REQUEST);


        } else {

            ArrayList<ResponseAddTariffListModel> dataLists = new ArrayList<>();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String name = authentication.getName();
            int userid = registerUerRepository.getByEmail(Constants.email).getId();

            List<SaveTariffHistoryModel> allHistoryList = (List<SaveTariffHistoryModel>) saveTariffHistoryRepository.findAllByUserid(userid);

            HashMap<String, ArrayList<SaveTariffHistoryModel>> hashMap = null;

            for (int i = 0; i < allHistoryList.size(); i++) {


                System.out.println("testingggg" + allHistoryList.get(i).startDate.split("-")[0] + ">>>>" + year);
                if (allHistoryList.get(i).startDate.split("-")[0].equalsIgnoreCase(year)) {

                    if (dataLists.size() > 0) {

                        for (int j = 0; j < dataLists.size(); j++) {

                            if (dataLists.get(j).getResponseSaveHistoryModels().containsKey(allHistoryList.get(i).startDate.split("-")[0])) {
                                dataLists.get(j).getResponseSaveHistoryModels().get(allHistoryList.get(i).startDate.split("-")[0]).add(allHistoryList.get(i));

                            } else {

                                hashMap = new HashMap();
                                ArrayList<SaveTariffHistoryModel> arrayList = new ArrayList<>();
                                arrayList.add(allHistoryList.get(i));

                                ResponseAddTariffListModel responseAddTariffListModel = new ResponseAddTariffListModel();
                                responseAddTariffListModel.setYearnname(allHistoryList.get(i).startDate.split("-")[0]);

                                hashMap.put(allHistoryList.get(i).startDate.split("-")[0], arrayList);

                                responseAddTariffListModel.setResponseSaveHistoryModels(hashMap);

                                dataLists.add(responseAddTariffListModel);

                            }

                        }
                    } else {

                        hashMap = new HashMap();
                        ArrayList<SaveTariffHistoryModel> arrayList = new ArrayList<>();
                        arrayList.add(allHistoryList.get(i));

                        ResponseAddTariffListModel responseAddTariffListModel = new ResponseAddTariffListModel();
                        responseAddTariffListModel.setYearnname(allHistoryList.get(i).startDate.split("-")[0]);

                        hashMap.put(allHistoryList.get(i).startDate.split("-")[0], arrayList);

                        responseAddTariffListModel.setResponseSaveHistoryModels(hashMap);

                        dataLists.add(responseAddTariffListModel);

                    }


                }

            }

            responseEntity = new ResponseEntity(dataLists, HttpStatus.OK);

        }


        return responseEntity;
    }


    public ResponseEntity getHistoryByday(String startDate) {


        ResponseEntity responseEntity = null;
        System.out.println("testing calleddd" + startDate);

        if (!startDate.equalsIgnoreCase("")) {


            ArrayList<ResponseAddTariffListModel> dataLists = new ArrayList<>();

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String name = authentication.getName();
            // System.out.println("help name" + name + authentication.getCredentials() + ">>");
            //RegisterModel registerModel=registerUerRepository.getByUserName(name);
            int userid = 1;

            System.out.println("satrd" + startDate);

            ArrayList<SaveTariffHistoryModel> allHistoryList = (ArrayList<SaveTariffHistoryModel>) saveTariffHistoryRepository.findAllByUseridAndStartDate(userid, startDate);
            responseEntity = new ResponseEntity(allHistoryList, HttpStatus.OK);
        } else {
            ErrorDTO employeeException = new ErrorDTO();
            employeeException.setDescription("Wrong Start Date");
            employeeException.setMessage("Worng Start Date");
            responseEntity = new ResponseEntity(employeeException, HttpStatus.BAD_REQUEST);

        }
        return responseEntity;
    }


    public ResponseEntity<SaveTariffHistoryModel> getHistoryByTime(String startDate, String startTime) {


        int userid = registerUerRepository.getByEmail(Constants.email).getId();

        ResponseEntity responseEntity;
        if (startTime.equalsIgnoreCase("") || startTime.equalsIgnoreCase("")) {


            ErrorDTO employeeException = new ErrorDTO();
            employeeException.setDescription("Wrong start date or start time");
            employeeException.setMessage("Wrong start date or start time");
            responseEntity = new ResponseEntity(employeeException, HttpStatus.BAD_REQUEST);


        } else {

            ArrayList<SaveTariffHistoryModel> allHistoryList = (ArrayList<SaveTariffHistoryModel>) saveTariffHistoryRepository.findAllByUseridAndStartDateAndStarttime(userid, startDate, startTime);

            responseEntity = new ResponseEntity(allHistoryList, HttpStatus.OK);
        }

        return responseEntity;
    }


}
