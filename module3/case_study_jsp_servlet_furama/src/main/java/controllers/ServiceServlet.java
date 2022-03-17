package controllers;

import models.*;
import services.IServiceService;
import services.impls.ServiceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", value = "/service")
public class ServiceServlet extends HttpServlet {
    private IServiceService iServiceService = new ServiceService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "list":
                listAllService(request, response);
                break;
            case "create":
                showServiceCreateForm(request, response);
                break;
//            case "update":
//                showUpdateCustomerForm(request, response);
//                break;
//            case "search":
//                searchCustomerByName(request, response);
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
                createService(request, response);
                break;
//            case "update":
//                updateEmployee(request, response);
//                break;
//            case "delete":
//                deleteEmployee(request, response);
//                break;
        }
    }

    private void listAllService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = iServiceService.getAllService();
        request.setAttribute("serviceList", serviceList);
        request.getRequestDispatcher("listService.jsp").forward(request, response);
    }

    private void showServiceCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("createservice.jsp");
        try {
            List<RentType> serviceRentTypeListCreate = iServiceService.getAllRentType();
            List<ServiceType> serviceServiceTypeListCreate = iServiceService.getAllServiceType();
            request.setAttribute("rentTypeListCreate", serviceRentTypeListCreate);
            request.setAttribute("serviceTypeListCreate", serviceServiceTypeListCreate);
            request.getRequestDispatcher("createService.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String serviceCode = request.getParameter("serviceCodeCreate");
        String serviceName = request.getParameter("serviceNameCreate");
        int serviceArea = Integer.parseInt(request.getParameter("serviceAreaCreate"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCostCreate"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeopleCreate"));
        String standardRoom = request.getParameter("standardRoomCreate");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenienceCreate");
        double poolArea = Double.parseDouble(request.getParameter("poolAreaCreate"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloorsCreate"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeIdCreate"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeIdCreate"));
        Service serviceCreate = new Service(serviceCode,serviceName,serviceArea,serviceCost,serviceMaxPeople,
                standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors,rentTypeId,serviceTypeId);
        iServiceService.createService(serviceCreate);
        request.setAttribute("messageCreate", "Add new service successfully!!!");
        request.getRequestDispatcher("createService.jsp").forward(request, response);
    }
}
