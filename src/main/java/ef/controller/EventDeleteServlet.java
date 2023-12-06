package ef.controller;

import ef.service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "eventDelete", urlPatterns = "/events/delete/*")
public class EventDeleteServlet extends HttpServlet {
    private EventService eventService = new EventService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String path = req.getPathInfo();
        Integer id = Integer.valueOf(path.substring(1));
        if (eventService.getEventByID(id) == null) {
            printWriter.println("Event not found");
        } else {
            eventService.deleteEventByID(id);
            printWriter.println("Event deleted");
        }
    }
}
