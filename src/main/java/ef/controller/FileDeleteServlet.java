package ef.controller;

import ef.service.FileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "fileDelete", urlPatterns = "/files/delete/*")
public class FileDeleteServlet extends HttpServlet {
    private FileService fileService = new FileService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String path = req.getPathInfo();
        Integer id = Integer.valueOf(path.substring(1));
        if (fileService.getFileByID(id) == null) {
            printWriter.println("File not found");
        } else {
            fileService.deletePostByID(id);
            printWriter.println("File deleted");
        }
    }
}
