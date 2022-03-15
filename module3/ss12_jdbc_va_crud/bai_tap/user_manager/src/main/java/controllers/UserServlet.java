package controllers;

import models.User;
import services.impl.UserService;
import services.IUserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet ", value = {"/UserList", "/"})
public class UserServlet extends HttpServlet {
    IUserService iUserService = new UserService();

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
                case "update":
                    Integer id = Integer.valueOf(request.getParameter("id"));
                    User user = iUserService.selectUser(id);
                    request.setAttribute("user", user);
                    request.getRequestDispatcher("update.jsp").forward(request,response);
                    break;
                case "search":
                    String countrySearch = request.getParameter("countrySearch");
                    request.setAttribute("userList", iUserService.searchByCountry(countrySearch));
                    request.getRequestDispatcher("search.jsp").forward(request,response);
                    break;
                case "idSort":
                    request.setAttribute("userList", iUserService.sortById());
                    request.getRequestDispatcher("list.jsp").forward(request,response);
                    break;
                case "nameSort":
                    request.setAttribute("userList", iUserService.sortByName());
                    request.getRequestDispatcher("list.jsp").forward(request,response);
                    break;
                case "countrySort":
                    request.setAttribute("userList", iUserService.sortByCountry());
                    request.getRequestDispatcher("list.jsp").forward(request,response);
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
                    String nameCreate = request.getParameter("name");
                    String emailCreate = request.getParameter("email");
                    String countryCreate = request.getParameter("country");
                    User userCreate = new User(nameCreate, emailCreate, countryCreate);
                    iUserService.insertUser(userCreate);
                    request.getRequestDispatcher("create.jsp").forward(request,response);
                    break;
                case "update":
                    Integer idUpdate = Integer.valueOf(request.getParameter("id"));
                    User userUpdate = iUserService.selectUser(idUpdate);
                    userUpdate.setName(request.getParameter("name"));
                    userUpdate.setEmail(request.getParameter("email"));
                    userUpdate.setCountry(request.getParameter("country"));
                    iUserService.updateUser(userUpdate);
                    request.getRequestDispatcher("update.jsp").forward(request,response);
                    break;
                case "delete":
                    Integer idDelete = Integer.valueOf(request.getParameter("idDelete"));
                    iUserService.deleteUser(idDelete);
                    getAllUser(request,response);
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
        request.setAttribute("userList", iUserService.selectAllUsers());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
