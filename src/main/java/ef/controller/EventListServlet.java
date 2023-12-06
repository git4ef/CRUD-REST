package ef.controller;

import ef.service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "eventList", urlPatterns = "/events/*")
public class EventListServlet extends HttpServlet {
    private EventService eventService = new EventService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String path = req.getPathInfo();
        if (path == null) {
            printWriter.println(eventService.getAllEvents());
        } else {
            Integer id = Integer.valueOf(path.substring(1));
            printWriter.println(eventService.getEventByID(id));
        }
    }
}
