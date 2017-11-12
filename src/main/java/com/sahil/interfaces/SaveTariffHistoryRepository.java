package com.sahil.interfaces;

import com.sahil.models.GetTimeHistoryModel;
import com.sahil.models.SaveTariffHistoryModel;
import org.springframework.data.repository.CrudRepository;

public interface SaveTariffHistoryRepository extends CrudRepository<SaveTariffHistoryModel, Integer> {


    public Iterable<SaveTariffHistoryModel> findAllByUserid(int id);

    public Iterable<SaveTariffHistoryModel> findAllByUseridAndStartDate(int id, String startDate);
    public Iterable<SaveTariffHistoryModel> findAllByUseridAndStartDateAndStarttime(int id, String startDate,String starttime);

}
