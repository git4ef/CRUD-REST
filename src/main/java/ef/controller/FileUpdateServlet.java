package ef.controller;

import ef.model.File;
import ef.service.FileService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "fileUpdate", urlPatterns = "/files/update/*")
public class FileUpdateServlet extends HttpServlet {
    private FileService fileService = new FileService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String path = req.getPathInfo();
        Integer id = Integer.valueOf(path.substring(1));;
        String name = req.getParameter("name");
        String pathFile = req.getParameter("path");
        if (fileService.getFileByID(id) == null) {
            printWriter.println("File not found");
        } else {
            fileService.updateFile(new File(id, name, pathFile));
            printWriter.println("File updated");
        }
    }
}
