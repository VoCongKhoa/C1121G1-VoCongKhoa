package controllers;

import models.Customer;
import models.CustomerType;
import services.ICustomerService;
import services.impls.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomerService iCustomerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "list":
                listAllCustomer(request, response);
                break;
            case "create":
                showCustomerCreateForm(request, response);
                break;
            case "update":
                showUpdateCustomerForm(request, response);
                break;
            case "search":
                searchCustomerByName(request, response);
                break;
            case "idSort":
                sortById(request, response);
                break;
            case "nameSort":
                sortByName(request, response);
                break;
            case "birthdaySort":
                sortByBirthday(request, response);
                break;
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
                createCustomer(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
        }
    }

    private void sortByBirthday(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerListSortByBirthday = iCustomerService.sortCustomerByBirthday();
        request.setAttribute("customerList", customerListSortByBirthday);
        request.getRequestDispatcher("listCustomer.jsp").forward(request, response);
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerListSortByName = iCustomerService.sortCustomerByName();
        request.setAttribute("customerList", customerListSortByName);
        request.getRequestDispatcher("listCustomer.jsp").forward(request, response);
    }

    private void sortById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerListSortById = iCustomerService.sortCustomerById();
        request.setAttribute("customerList", customerListSortById);
        request.getRequestDispatcher("listCustomer.jsp").forward(request, response);
    }

    private void searchCustomerByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerNameSearch = request.getParameter("customerNameSearch");
        List<Customer> customerListSearch = iCustomerService.searchCustomerByName(customerNameSearch);
        request.setAttribute("customerListSearch", customerListSearch);
        request.getRequestDispatcher("searchCustomer.jsp").forward(request, response);
    }

    private void listAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = iCustomerService.getAllCustomer();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("listCustomer.jsp").forward(request, response);
    }

    private void showCustomerCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("createCustomer.jsp");
        try {
            List<CustomerType> customerTypeListCreate = iCustomerService.getAllCustomerType();
            request.setAttribute("typeIdListCreate", customerTypeListCreate);
            request.getRequestDispatcher("createCustomer.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateCustomerForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int customerIdUpdate = Integer.parseInt(request.getParameter("id"));
        Customer customerUpdate = iCustomerService.getCustomer(customerIdUpdate);
        List<CustomerType> customerTypeListUpdate = iCustomerService.getAllCustomerType();
        request.setAttribute("customer", customerUpdate);
        request.setAttribute("typeIdList", customerTypeListUpdate);
        request.getRequestDispatcher("updateCustomer.jsp").forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCustomerDelete = Integer.parseInt(request.getParameter("idCustomerDelete"));
        iCustomerService.deleteCustomer(idCustomerDelete);
        listAllCustomer(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int customerIdUpdate = Integer.parseInt(request.getParameter("idUpdate"));
        Customer customerUpdate = iCustomerService.getCustomer(customerIdUpdate);
        customerUpdate.setCustomerCode(request.getParameter("customerCode"));
        customerUpdate.setCustomerName(request.getParameter("customerName"));
        customerUpdate.setCustomerBirthday(request.getParameter("customerBirthday"));
        customerUpdate.setCustomerGender(Integer.parseInt((request.getParameter("customerGender"))));
        customerUpdate.setCustomerIdCard(request.getParameter("customerIdCard"));
        customerUpdate.setCustomerPhone(request.getParameter("customerPhone"));
        customerUpdate.setCustomerEmail(request.getParameter("customerEmail"));
        customerUpdate.setCustomerAddress(request.getParameter("customerAddress"));
        customerUpdate.setCustomerTypeId(Integer.parseInt(request.getParameter("customerTypeId")));
        iCustomerService.updateCustomer(customerUpdate);
        request.setAttribute("messageUpdate", "Update new customer successfully!!!");
        request.getRequestDispatcher("updateCustomer.jsp").forward(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String customerCodeCreate = request.getParameter("customerCodeCreate");
        String customerNameCreate = request.getParameter("customerNameCreate");
        String customerBirthdayCreate = request.getParameter("customerBirthdayCreate");
        int customerGenderCreate = Integer.parseInt(request.getParameter("customerGenderCreate"));
        String customerIdCardCreate = request.getParameter("customerIdCardCreate");
        String customerPhoneCreate = request.getParameter("customerPhoneCreate");
        String customerEmailCreate = request.getParameter("customerEmailCreate");
        String customerAddressCreate = request.getParameter("customerAddressCreate");
        int customerTypeIdCreate = Integer.parseInt(request.getParameter("customerTypeIdCreate"));
        Customer customerCreate = new Customer(customerCodeCreate, customerNameCreate, customerBirthdayCreate,
                customerGenderCreate, customerIdCardCreate, customerPhoneCreate, customerEmailCreate,
                customerAddressCreate, customerTypeIdCreate);
        iCustomerService.createCustomer(customerCreate);
        request.setAttribute("messageCreate", "Add new customer successfully!!!");
        request.getRequestDispatcher("createCustomer.jsp").forward(request, response);
    }


}
