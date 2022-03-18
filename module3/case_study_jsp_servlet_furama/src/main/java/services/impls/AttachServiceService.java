package services.impls;

import models.AttachService;
import repositories.IAttachServiceRepository;
import repositories.impls.AttachServiceRepository;
import services.IAttachServiceService;

public class AttachServiceService implements IAttachServiceService {
    IAttachServiceRepository iAttachServiceRepository = new AttachServiceRepository();

    @Override
    public AttachService getAttachService(int attachServiceId) {
        return iAttachServiceRepository.getAttachService(attachServiceId);
    }
}
