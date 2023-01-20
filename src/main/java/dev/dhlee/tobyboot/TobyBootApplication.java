package dev.dhlee.tobyboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TobyBootApplication {

    public static void main(String[] args) {
        final ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        final WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("hello", new HttpServlet() {
                @Override
                protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
                    resp.setStatus(200);
                    resp.setHeader("Content-Type", "text/plain");
                    resp.getWriter().print("Hello Servlet");
                }
            }).addMapping("/hello");
        });
        webServer.start();

    }
}
