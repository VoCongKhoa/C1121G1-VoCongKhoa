package controllers;

import models.Customer;
import services.ICustomerService;
import services.impls.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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
                request.setAttribute("customerList", iCustomerService.getAllCustomer());
                request.getRequestDispatcher("listCustomer.jsp").forward(request, response);
                break;
            case "create":
                request.getRequestDispatcher("createCustomer.jsp").forward(request, response);
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
                String customerNameCreate = request.getParameter("customerNameCreate");
                String customerBirthdayCreate = request.getParameter("customerBirthdayCreate");
                int customerGenderCreate = Integer.parseInt(request.getParameter("customerGenderCreate"));
                String customerIdCardCreate = request.getParameter("customerIdCardCreate");
                String customerPhoneCreate = request.getParameter("customerPhoneCreate");
                String customerEmailCreate = request.getParameter("customerEmailCreate");
                String customerAddressCreate = request.getParameter("customerAddressCreate");
                int customerTypeIdCreate = Integer.parseInt(request.getParameter("customerTypeIdCreate"));
                Customer customerCreate = new Customer(customerNameCreate, customerBirthdayCreate, customerGenderCreate,
                        customerIdCardCreate, customerPhoneCreate, customerEmailCreate, customerAddressCreate,
                        customerTypeIdCreate);
                iCustomerService.createCustomer(customerCreate);
                request.getRequestDispatcher("listCustomer.jsp").forward(request, response);
                request.getRequestDispatcher("createCustomer.jsp").forward(request, response);
                break;
        }
    }
}
