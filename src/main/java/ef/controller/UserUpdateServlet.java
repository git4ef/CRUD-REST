package ef.controller;

import ef.model.User;
import ef.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userUpdate", urlPatterns = "/users/update/*")
public class UserUpdateServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String path = req.getPathInfo();
        Integer id = Integer.valueOf(path.substring(1));
        String name = req.getParameter("name");
        if (userService.getUserByID(id) == null) {
            printWriter.println("User not found");
        } else {
            userService.updateUser(new User(id, name));
            printWriter.println("User updated");
        }
    }
}
