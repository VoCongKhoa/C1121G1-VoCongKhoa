import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateDiscountServlet", value = "/discount")
public class CalculateDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double price = Double.parseDouble(request.getParameter("price"));
        double discountPercent = Double.parseDouble(request.getParameter("discount-percent"));
        double discountAmount = price * discountPercent * 0.01;
        PrintWriter printWriter = new PrintWriter(response.getWriter());
        printWriter.println("<html>");
        printWriter.println("<label>Discount Amount:\n" +
                "      <input type=\"text\" value=" + discountAmount + ">\n" +
                "    </label><br><br>\n" +
                "    <label>Discount Price:\n" +
                "      <input type=\"text\" value=" + (price - discountAmount) + ">\n" +
                "    </label>");
        printWriter.println("</html>");
    }
}
