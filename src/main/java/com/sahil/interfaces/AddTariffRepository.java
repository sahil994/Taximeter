package com.sahil.interfaces;

import com.sahil.models.AddTariffModel;
import org.springframework.data.repository.CrudRepository;

public interface AddTariffRepository extends CrudRepository<AddTariffModel,Integer>{

  public AddTariffModel findByCarName(String name);



}
