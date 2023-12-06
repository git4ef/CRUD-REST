package ef.controller;

import ef.model.Event;
import ef.model.User;
import ef.service.EventService;
import ef.service.FileService;
import ef.service.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "uploadServlet", urlPatterns = "/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadServlet extends HttpServlet {
    private String filePath = "C://upload//";
    private java.io.File file;
    private UserService userService = new UserService();
    private EventService eventService = new EventService();
    private FileService fileService = new FileService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
      filePath = getServletContext().getRealPath("") + File.separator + "/WEB-INF/upload/";

        diskFileItemFactory.setRepository(new File(filePath));
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        String username = request.getParameter("username");
        try {
            List fileItems = upload.parseRequest(request);

            Iterator iterator = fileItems.iterator();
            while (iterator.hasNext()) {
                FileItem fileItem = (FileItem) iterator.next();
                if (!fileItem.isFormField()) {
                    String fileName = fileItem.getName();
                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(filePath +
                                fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        file = new File(filePath +
                                fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    fileItem.write(file);
                    writer.println(fileName + " is uploaded.");
                    eventService.saveEvent(new Event(userService.saveUser(new User(username)), fileService.saveFile(new ef.model.File(fileName, filePath))));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}