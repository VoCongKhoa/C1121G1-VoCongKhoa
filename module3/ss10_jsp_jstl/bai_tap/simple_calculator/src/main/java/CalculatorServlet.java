import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", value = "/calculate")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Calculator calculator = new Calculator();
        double firstOperator = Double.parseDouble(request.getParameter("first"));
        double secondOperator = Double.parseDouble(request.getParameter("second"));
        String operator = request.getParameter("operator");
        double result = 0;
        try {
            result = calculator.calculate(firstOperator, secondOperator, operator);
            String resultStr = firstOperator + " " + operator + " " + secondOperator + " = " + result;
            request.setAttribute("result", resultStr);
            request.getRequestDispatcher("calculate.jsp").forward(request, response);
        } catch (Exception e){
            request.setAttribute("error", "Error: Invalid number!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
