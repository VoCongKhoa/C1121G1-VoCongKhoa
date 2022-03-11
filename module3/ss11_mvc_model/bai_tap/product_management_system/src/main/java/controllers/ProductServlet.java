package controllers;

import models.Product;
import services.ProductServiceImpl;
import services.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = {"/product", ""})
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                response.sendRedirect("create.jsp");
                break;
            case "update":
                int idUpdate = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("product", productService.searchById(idUpdate));
                request.getRequestDispatcher("update.jsp").forward(request,response);
                break;
            case "detail":
                int idDetail = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("product", productService.getDetail(idDetail));
                request.getRequestDispatcher("detail.jsp").forward(request,response);
                break;
            default:
                request.setAttribute("productList", productService.getAll());
                request.getRequestDispatcher("index.jsp").forward(request, response);
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
                Product product = new Product();
                product.setName(request.getParameter("name"));
                product.setPrice(Double.parseDouble(request.getParameter("price")));
                product.setDescription(request.getParameter("description"));
                product.setProducer(request.getParameter("producer"));
                if (productService.getAll().isEmpty()){
                    product.setId(1);
                } else {
                    product.setId(productService.getAll().size()+1);
                }
                productService.create(product);
                request.setAttribute("message", "Create a new product successfully!!!");
                request.getRequestDispatcher("create.jsp").forward(request,response);
                break;
            case "update":
                int idUpdate = Integer.parseInt(request.getParameter("idUpdate"));
                Product updateProduct = productService.searchById(idUpdate);
                updateProduct.setName(request.getParameter("name"));
                updateProduct.setPrice(Double.parseDouble(request.getParameter("price")));
                updateProduct.setDescription(request.getParameter("description"));
                updateProduct.setProducer(request.getParameter("producer"));
                productService.update(idUpdate,updateProduct);
                request.setAttribute("message", "Create a new product successfully!!!");
                request.getRequestDispatcher("update.jsp").forward(request,response);
                break;
            case "delete":
                Integer idDelete = Integer.parseInt(request.getParameter("idProduct"));
                productService.delete(idDelete);
                request.setAttribute("productList", productService.getAll());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
        }
    }
}
