package ua.edu.npu;

import com.fasterxml.jackson.databind.ObjectMapper;
import ua.edu.npu.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FromJsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        User testUser = new User(1, "Harry", 29);
        httpServletResponse.getWriter().println(
                new ObjectMapper().writeValueAsString(testUser)
        );
    }

}
