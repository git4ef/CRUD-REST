package ef.controller;

import ef.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userDelete", urlPatterns = "/users/delete/*")
public class UserDeleteServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String path = req.getPathInfo();
        Integer id = Integer.valueOf(path.substring(1));
        if (userService.getUserByID(id) == null) {
            printWriter.println("User not found");
        } else {
            userService.deleteUserByID(id);
            printWriter.println("User deleted");
        }
    }
}
