package controllers;

import models.Customer;
import services.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = {"/customer", ""})
public class CustomerServlet extends HttpServlet {
    CustomerServiceImpl customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                int idEdit = Integer.parseInt(request.getParameter("id"));
                showEditForm(request, response, idEdit);
                break;
            case "delete":
                int idDelete = Integer.parseInt(request.getParameter("id"));
                customerService.remove(idDelete);
                request.setAttribute("customerList", customerService.findAll());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "view":
                int idView = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("customer", customerService.findById(idView));
                request.getRequestDispatcher("view.jsp").forward(request, response);
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
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                doCreate(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                doEdit(request, response, id);
                break;
//            case "delete":
//                int idDelete = Integer.parseInt(request.getParameter("id"));
//                customerService.remove(idDelete);
//
//                request.getRequestDispatcher("index.jsp").forward(request, response);
//                break;
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

    protected void showEditForm(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
        request.setAttribute("customer", customerService.findById(id));
        request.getRequestDispatcher("edit.jsp").forward(request, response);
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
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    protected void doEdit(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
        Customer customer = customerService.findById(id);
        customer.setName(request.getParameter("name"));
        customer.setEmail(request.getParameter("email"));
        customer.setAddress(request.getParameter("address"));
        customerService.edit(id, customer);
        request.setAttribute("message", "Successfully!!!");
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }
}
