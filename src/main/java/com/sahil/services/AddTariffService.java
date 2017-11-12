package com.sahil.services;

import com.sahil.interfaces.AddTariffRepository;
import com.sahil.models.AddTariffModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddTariffService {

    @Autowired
    AddTariffRepository addTariffRepository;

    public void addTariff(AddTariffModel tariffModel) {

        if(validate(tariffModel)){

           addTariffRepository.save(tariffModel);

        }


    }

    public boolean validate(AddTariffModel tariffModel) {


        if (!tariffModel.getBaseFeeRate().equalsIgnoreCase("") && !tariffModel.getFreeKilometerRate().equalsIgnoreCase("") && !tariffModel.getFreeMinuteRate().equalsIgnoreCase("") && !tariffModel.getTimeMinuteRate().equalsIgnoreCase("") && !tariffModel.getRateKilometerRate().equalsIgnoreCase("") && !tariffModel.getTrafficMinuteRate().equalsIgnoreCase("") && !tariffModel.getIdealMinuteRate().equalsIgnoreCase("") && !tariffModel.getExtraPlusMinuteRate().equalsIgnoreCase("")) {


            return true;


        }
      return false;
    }


}
