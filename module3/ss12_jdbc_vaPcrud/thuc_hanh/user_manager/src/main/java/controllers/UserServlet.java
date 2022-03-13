package controllers;

import dao.UserDAO;
import models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet ", value = {"/UserList", ""})
public class UserServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    request.getRequestDispatcher("create.jsp").forward(request,response);
                    break;
                default:
                    getAllUser(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    String name = request.getParameter("name");
                    String email = request.getParameter("email");
                    String country = request.getParameter("country");
                    User user = new User(name, email, country);
                    userDAO.insertUser(user);
                    request.getRequestDispatcher("create.jsp").forward(request,response);
                    break;
                default:
                    getAllUser(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void getAllUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        request.setAttribute("userList", userDAO.selectAllUsers());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
