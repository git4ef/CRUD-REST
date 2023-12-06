package ef.controller;

import ef.model.Event;
import ef.model.File;
import ef.model.User;
import ef.service.EventService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "eventUpdate", urlPatterns = "/events/update/*")
public class EventUpdateServlet extends HttpServlet {
    private EventService eventService = new EventService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String path = req.getPathInfo();
        Integer id = Integer.valueOf(path.substring(1));;
        String username = req.getParameter("username");
        String filename = req.getParameter("filename");
        String pathFile = req.getParameter("path");
        if (eventService.getEventByID(id) == null) {
            printWriter.println("Event not found");
        } else {
            eventService.updateEvent(new Event(id,new User(username),new File(filename,pathFile)));
            printWriter.println("Event updated");
        }
    }
}
