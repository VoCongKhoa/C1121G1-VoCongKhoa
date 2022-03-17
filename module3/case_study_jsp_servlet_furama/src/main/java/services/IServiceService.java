package services;

import models.RentType;
import models.Service;
import models.ServiceType;

import java.util.List;

public interface IServiceService {
    List<Service> getAllService();

    List<RentType> getAllRentType();

    List<ServiceType> getAllServiceType();

    void createService(Service serviceCreate);
}
