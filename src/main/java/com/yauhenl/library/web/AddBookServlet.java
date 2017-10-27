package com.yauhenl.library.web;

import com.yauhenl.library.domain.Book;
import com.yauhenl.library.service.LibraryService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LibraryService libraryService = LibraryService.getInstance();
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        libraryService.addBook(new Book(title, description));
        resp.sendRedirect("/");
    }
}
