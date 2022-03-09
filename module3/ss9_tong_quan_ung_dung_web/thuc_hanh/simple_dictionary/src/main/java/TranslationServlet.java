import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslationServlet", value = "/translate")
public class TranslationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionaryMap = new HashMap<>();
        dictionaryMap.put("one", "Một");
        dictionaryMap.put("two", "Hai");
        dictionaryMap.put("three", "Ba");
        dictionaryMap.put("hello", "Xin chào");
        dictionaryMap.put("how", "Thế nào");
        dictionaryMap.put("book", "Quyển vở");
        dictionaryMap.put("computer", "Máy tính");

        String textSearch = request.getParameter("textSearch");
        response.setContentType("text/html;charset=UTF-8");
//        response.setCharacterEncoding("utf-8"); Hoặc dùng dòng này vẫn ok
        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html>");
        String result = dictionaryMap.get(textSearch);
        if(result != null){
            printWriter.println("Word: " + textSearch);
            printWriter.println("Result: " + result);
        } else {
            printWriter.println("Not found");
        }

        printWriter.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
