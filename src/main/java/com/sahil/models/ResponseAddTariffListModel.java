package com.sahil.models;

import java.util.ArrayList;
import java.util.HashMap;

public class ResponseAddTariffListModel
{

    public String getYearnname() {
        return yearnname;
    }

    public void setYearnname(String yearnname) {
        this.yearnname = yearnname;
    }



    public String yearnname;

    public HashMap<String, ArrayList<SaveTariffHistoryModel>> getResponseSaveHistoryModels() {
        return responseSaveHistoryModels;
    }

    public void setResponseSaveHistoryModels(HashMap<String, ArrayList<SaveTariffHistoryModel>> responseSaveHistoryModels) {
        this.responseSaveHistoryModels = responseSaveHistoryModels;
    }

    public HashMap<String,ArrayList<SaveTariffHistoryModel>> responseSaveHistoryModels;

}
