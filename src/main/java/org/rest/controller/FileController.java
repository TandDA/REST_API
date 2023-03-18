package org.rest.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.google.gson.Gson;
import org.rest.model.File;
import org.rest.service.FileService;
import org.rest.service.impl.FileServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FileController extends HttpServlet {
    private FileService fileService = new FileServiceImpl();
    private Gson gson = new Gson();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        String id = request.getParameter("id");
        PrintWriter out = response.getWriter();
        if (id == null) {
            out.print(gson.toJson(fileService.getAll()));
        } else {
            if (fileService.getById(Integer.parseInt(id)) == null){
                out.print("Error 404");
            }
            else {
                out.print(gson.toJson(fileService.getById(Integer.parseInt(id))));
            }
        }
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        fileService.save(gson.fromJson(request.getReader(), File.class));
        PrintWriter out = response.getWriter();
        out.print("File was saved");
        out.flush();
    }
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        fileService.update(gson.fromJson(req.getReader(), File.class));
        PrintWriter out = resp.getWriter();
        out.println("File was updated" );
        out.flush();
    }
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        String id = req.getParameter("id");
        fileService.deleteById(Integer.parseInt(id));
        PrintWriter out = resp.getWriter();
        out.println("File was deleted");
        out.flush();
    }
}
