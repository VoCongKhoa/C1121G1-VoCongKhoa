package controllers;

import models.*;
import models.Contract;
import services.IContractService;
import services.impls.ContractService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", value = "/contract")
public class ContractServlet extends HttpServlet {
    private IContractService iContractService = new ContractService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "list":
                listAllContract(request, response);
                break;
            case "create":
                showContractCreateForm(request, response);
                break;
            case "contractDetail":
                showContractDetailList(request, response);
                break;
//            case "update":
//                showUpdateContractForm(request, response);
//                break;
//            case "search":
//                searchContractByName(request, response);
//                break;
//            case "idSort":
//                sortById(request, response);
//                break;
//            case "nameSort":
//                sortByName(request, response);
//                break;
//            case "birthdaySort":
//                sortByBirthday(request, response);
//                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContract(request, response);
                break;
//            case "update":
//                updateContract(request, response);
//                break;
//            case "delete":
//                deleteContract(request, response);
//                break;
        }
    }

    private void listAllContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contractList = iContractService.getAllContract();
        request.setAttribute("contractList", contractList);
        request.getRequestDispatcher("listContract.jsp").forward(request, response);
    }

    private void showContractCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("createContract.jsp");
        try {
            List<Service> serviceList = iContractService.getAllService();
            request.setAttribute("serviceListCreate", serviceList);
            request.getRequestDispatcher("createContract.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contractStartDate = request.getParameter("contractStartDateCreate");
        String contractEndDate = request.getParameter("contractEndDateCreate");
        double contractDeposit = Integer.parseInt(request.getParameter("contractDepositCreate"));
        double contractTotalMoney = Double.parseDouble(request.getParameter("contractTotalMoneyCreate"));
        int employeeId = Integer.parseInt(request.getParameter("employeeIdCreate"));
        Employee employee = iContractService.getEmployee(employeeId);
        int customerId = Integer.parseInt(request.getParameter("customerIdCreate"));
        Customer customer = iContractService.getCustomer(customerId);
        int serviceId = Integer.parseInt(request.getParameter("serviceIdCreate"));
        Service service = iContractService.getService(serviceId);
        Contract contractCreate = new Contract(contractStartDate, contractEndDate,
                contractDeposit, contractTotalMoney, employee, customer, service);
        iContractService.createContract(contractCreate);
        request.setAttribute("messageCreate", "Add new contract successfully!!!");
        request.getRequestDispatcher("createContract.jsp").forward(request, response);
    }

    private void showContractDetailList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ContractDetail> contractDetailList = iContractService.getAllContractDetail();
        request.setAttribute("contractDetailList", contractDetailList);
        request.getRequestDispatcher("listContractDetail.jsp").forward(request, response);
    }
}
