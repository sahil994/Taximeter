package com.sahil.interfaces;

import com.sahil.models.TariffLatLngModel;
import org.springframework.data.repository.CrudRepository;

public interface SaveTariffPosition extends CrudRepository<TariffLatLngModel,Integer> {
}
