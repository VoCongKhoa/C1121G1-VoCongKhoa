package repositories;

import models.Employee;
import models.RentType;
import models.Service;
import models.ServiceType;

import java.util.List;

public interface IServiceRepository {
    List<Service> getAllService();

    List<RentType> getAllRentType();

    List<ServiceType> getAllServiceType();

    void createService(Service serviceCreate);

    Service getService(int serviceId);

}
