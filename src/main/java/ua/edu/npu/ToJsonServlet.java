package ua.edu.npu;

import com.fasterxml.jackson.databind.ObjectMapper;
import ua.edu.npu.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToJsonServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/view/form.html")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final String data = httpServletRequest.getParameter("data");
        final User user = new ObjectMapper().readValue(data, User.class);
        System.out.println(user);
        httpServletRequest.getRequestDispatcher("/").forward(httpServletRequest, httpServletResponse);
    }

}
