package services.impls;

import models.RentType;
import models.Service;
import models.ServiceType;
import repositories.IServiceRepository;
import repositories.impls.ServiceRepository;
import services.IServiceService;

import java.util.List;

public class ServiceService implements IServiceService {
    IServiceRepository iServiceRepository = new ServiceRepository();

    @Override
    public List<Service> getAllService() {
        return iServiceRepository.getAllService();
    }

    @Override
    public List<RentType> getAllRentType() {
        return iServiceRepository.getAllRentType();
    }

    @Override
    public List<ServiceType> getAllServiceType() {
        return iServiceRepository.getAllServiceType();
    }

    @Override
    public void createService(Service serviceCreate) {
        iServiceRepository.createService(serviceCreate);
    }
}
