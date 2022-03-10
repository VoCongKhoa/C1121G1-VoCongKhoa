package controllers;

import models.Customer;
import services.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", value = {"/customer", ""})
public class CustomerServlet extends HttpServlet {
    CustomerServiceImpl customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("do");
        if (action == null){
            action="";
        }
        switch (action) {
            case "create":
                showCreateForm(request,response);
//                doCreate(request,response);
//                Customer customer = new Customer();
//                customer.setName(request.getParameter("name"));
//                customer.setEmail(request.getParameter("email"));
//                customer.setAddress(request.getParameter("address"));
//                if (customerService.findAll().isEmpty()) {
//                    customer.setId(1);
//                } else {
//                    customer.setId(customerService.findAll().size() + 1);
//                }
//                customerService.create(customer);

                break;
            case "edit":
                showCreateForm(request,response);
                break;
            default:
                request.setAttribute("customerList", customerService.findAll());
                request.getRequestDispatcher("index.jsp").forward(request, response);
//            case "create":
//                break;
//            case "create":
//                break;
//            case "create":
//                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("do");
        if (action == null){
            action="";
        }
        switch (action) {
            case "create":
                doCreate(request,response);
//                Customer customer = new Customer();
//                customer.setName(request.getParameter("name"));
//                customer.setEmail(request.getParameter("email"));
//                customer.setAddress(request.getParameter("address"));
//                if (customerService.findAll().isEmpty()) {
//                    customer.setId(1);
//                } else {
//                    customer.setId(customerService.findAll().size() + 1);
//                }
//                customerService.create(customer);
                break;
            case "edit":

                break;
            default:
                request.setAttribute("customerList", customerService.findAll());
                request.getRequestDispatcher("index.jsp").forward(request, response);
//            case "create":
//                break;
//            case "create":
//                break;
//            case "create":
//                break;
        }
    }

    protected void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("create.jsp");
    }
    protected void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("edit.jsp");
    }
    protected void doCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();
        customer.setName(request.getParameter("name"));
        customer.setEmail(request.getParameter("email"));
        customer.setAddress(request.getParameter("address"));
        if (customerService.findAll().isEmpty()) {
            customer.setId(1);
        } else {
            customer.setId(customerService.findAll().size() + 1);
        }
        customerService.create(customer);
        request.setAttribute("message", "Successfully!!!");
        request.getRequestDispatcher("create.jsp").forward(request,response);
    }
}
