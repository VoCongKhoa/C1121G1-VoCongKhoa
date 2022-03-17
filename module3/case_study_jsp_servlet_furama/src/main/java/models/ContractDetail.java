package models;

public class ContractDetail {
    //contract_detail_id, quantity, contract_id, attach_service_id
    private int contractDetailId;
    private int quantity;
    private Contract contract;
    private AttachService attachService;

    public ContractDetail() {
    }

    public ContractDetail(int contractDetailId, int quantity, Contract contract, AttachService attachService) {
        this.contractDetailId = contractDetailId;
        this.quantity = quantity;
        this.contract = contract;
        this.attachService = attachService;
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
