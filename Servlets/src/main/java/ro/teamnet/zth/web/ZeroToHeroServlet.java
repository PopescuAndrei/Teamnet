/**
 * ZeroToHeroServlet.java
 * <p/>
 * Copyright (c) 2014 Teamnet. All Rights Reserved.
 * <p/>
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet.
 */

package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ZeroToHeroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write(handleRequest(req));
    }

    private String handleRequest(HttpServletRequest req) {
        String response = "Hello <b>" + req.getParameter("firstname") + " " + req.getParameter("lastname") + "</b>!Enjoy Zero To Hero!!!";
        return response;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        resp.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            if (req.getParameter("username").equals("andrei")) {
                out.print("1");
            } else {
                out.print("0");
            }
        }
    }
}
