package ro.teamnet.zth.web;

import ro.teamnet.zth.file.LogFileWriter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Andrei on 5/5/2015.
 */
public class HeadersLogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * This filter  logs current request headers to filesystem
     *
     * @param request  - Client request
     * @param response - Client response
     * @param chain    - Filters chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //TODO completeaza cu cod astfel incat sa poti loga headerele de pe request intr-un fisier.
        // Clasa care va scrie intr-un fisier de log este LogFileWriter metoda   logHeader
        LogFileWriter lfw = new LogFileWriter();
        Enumeration headerNames = request.getParameterNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getParameter(key);
            lfw.logHeader(key, value);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}