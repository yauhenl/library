package com.yauhenl.library.web;

import com.yauhenl.library.domain.Book;
import com.yauhenl.library.service.LibraryService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Set the response message's MIME type
        resp.setContentType("text/html;charset=UTF-8");
        // Allocate a output writer to write the response message into the network socket
        LibraryService libraryService = LibraryService.getInstance();

        // Write the response message, in an HTML page
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>Library</title></head>");
            out.println("<body>");
            for (Book book : libraryService.getBooks().values()) {
                out.println(book.getTitle() + " " + book.getDescription());
                out.println("<br/>");
            }
            out.println("<form action=\"/addBook\" method=\"post\">");
            out.println("<input type=\"text\" name=\"title\" value=\"title\"/>");
            out.println("<input type=\"text\" name=\"description\" value=\"description\"/>");
            out.println("<input type=\"submit\" name=\"Add\"/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
