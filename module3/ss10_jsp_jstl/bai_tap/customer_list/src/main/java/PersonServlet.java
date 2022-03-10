import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PersonServlet", value = "/person")
public class PersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("personList", getPersonList());
        request.getRequestDispatcher("index.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public List<Person> getPersonList() {
        Person person1 = new Person("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "<img style=\"width:15%\" src=\"person-1.jpg\">");
        Person person2 = new Person("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "<img style=\"width:15%\" src=\"person-2.jpg\">");
        Person person3 = new Person("Mai Văn Hoàn", "1983-08-22", "Nam Định", "<img style=\"width:15%\" src=\"person-3.jpg\">");
        Person person4 = new Person("Mai Văn Hoàn", "1983-08-23", "Hà Tây", "<img style=\"width:15%\" src=\"person-4.jpg\">");
        Person person5 = new Person("Mai Văn Hoàn", "1983-08-24", "Hà Nội", "<img style=\"width:15%\" src=\"person-5.jpg\">");
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        return personList;
    }
}
