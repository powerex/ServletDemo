package ua.edu.npu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/session")
public class SessionDemo extends HttpServlet {
    private final static String indexPage = "/view/session.jsp";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final HttpSession session = req.getSession();

        final String state = (String) session.getAttribute("state");

        if (state != null){
            req.setAttribute("dataForView", session.getAttribute("state"));
        }

        Date dater = (Date)session.getAttribute("dater");
        if (dater != null) {
            req.setAttribute("last", dater);
        }
        dater = new Date();
        req.setAttribute("dater", dater);

        req.getRequestDispatcher(indexPage).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        final String dataFromUser = req.getParameter("data");

        final HttpSession session = req.getSession();

        final String currentState = (String) session.getAttribute("state");

        if (currentState != null) {
            session.setAttribute("state", currentState + " : " + dataFromUser + "(" + new Date() + ")");
        } else {
            session.setAttribute("state", dataFromUser+ "(" + new Date() + ")");
        }

        doGet(req, resp);
    }
}
