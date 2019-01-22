package com.szr.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecondServlet extends HttpServlet {
    private static final long serialVersionUID = 3546530526142356148L;

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("SecondServlet...........");
    }
}
