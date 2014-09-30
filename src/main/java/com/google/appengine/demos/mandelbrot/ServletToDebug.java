/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.google.appengine.demos.mandelbrot;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ludo
 */
@WebServlet(name = "ServletToDebug", urlPatterns = {"/ServletToDebug"})
public class ServletToDebug extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet ServletToDebug</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Java One Servlet ServletToDebug at " + request.getContextPath() + "</h1>");
      out.println("<h1>System.getProperties()</h1>");
      System.out.println("<ol>");
      Iterator keys = System.getProperties().keySet().iterator();
      while (keys.hasNext()) {
        String key = (String) keys.next();
        String value = System.getProperty(key).replaceAll("\\+", " ");
        out.println("<li>" + key + "=" + value);
      }
      out.println("</ol>");
      out.println("<h1>System.getenv()</h1>");
      System.out.println("<ol>");
      Map<String, String> variables = System.getenv();

      variables.entrySet().stream().forEach((entry) -> {
        String name = entry.getKey();
        String value = entry.getValue();
        out.println("<li>" + name + "=" + value);
      });
      out.println("</ol>");

      List<Person> personList = Person.createShortList();
      // Use Lambda instead
      // Print Asc
      //System.out.println("=== Sorted Asc SurName ===");
      Collections.sort(personList, (Person p1, Person p2) -> p1.getSurName().compareTo(p2.getSurName()));
      out.println("<h1>And now, the Java 8 Lambdas in Google App Engine....</h1>");
      System.out.println("<ol>");
      
      personList.stream().forEach(p -> {
        p.printName(out);
      });

      out.println("</ol>");
      out.println("</body>");
      out.println("</html>");
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
