package ef.controller;

import ef.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userList", urlPatterns = "/users/*")
public class UserListServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String path = req.getPathInfo();
        if (path == null) {
            printWriter.println(userService.getAllUsers());
        } else {
            Integer id = Integer.valueOf(path.substring(1));
            printWriter.println(userService.getUserByID(id));
        }
    }
}
