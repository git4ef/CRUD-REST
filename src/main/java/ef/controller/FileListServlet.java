package ef.controller;

import ef.service.FileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "fileList", urlPatterns = "/files/*")
public class FileListServlet extends HttpServlet {
    private FileService fileService = new FileService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String path = req.getPathInfo();
        if (path == null) {
            printWriter.println(fileService.getAllFiles());
        } else {
            Integer id = Integer.valueOf(path.substring(1));
            printWriter.println(fileService.getFileByID(id));
        }
    }
}
