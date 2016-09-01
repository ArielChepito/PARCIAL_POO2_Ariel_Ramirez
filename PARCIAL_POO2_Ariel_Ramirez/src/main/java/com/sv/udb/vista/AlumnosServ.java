/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.AlumnosCtrl;
import com.sv.udb.modelo.Alumnos;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Laboratorio
 */
@WebServlet(name = "AlumnosServ", urlPatterns = {"/AlumnosServ"})
public class AlumnosServ extends HttpServlet {

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
         try {
            boolean esValido = request.getMethod().equals("POST");
        if(esValido)
        {
            String mens = "";
            String CRUD = request.getParameter("lugaAcceBton");
            if(CRUD.equals("Guardar"))
            {
                Alumnos obje = new Alumnos();
                obje.setNombAlum(request.getParameter("nomb"));
                obje.setApelAlum(request.getParameter("apel"));   
                
                    SimpleDateFormat dateformat3 = new SimpleDateFormat("dd-MM-yyyy");
                     Date date1 = dateformat3.parse(request.getParameter("fech"));

                obje.setFechNaciAlum(date1);
                obje.setMailAlum(request.getParameter("emai"));
                obje.setTeleAlum(request.getParameter("tele"));
                obje.setDireAlum(request.getParameter("dire"));
                String string = request.getParameter("cmbGenero");
                char c = string.charAt(0);
                obje.setGeneAlum(c);
              
                mens = new AlumnosCtrl().guar(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else if(CRUD.equals("Eliminar"))
            {
                
                 int CodiLuga = Integer.parseInt(request.getParameter("codiRadi") == null ? 
                            "0" : request.getParameter("codiRadi"));
                mens = new AlumnosCtrl().elim(CodiLuga) ? "Datos Eliminados" : "Datos no eliminados"; 
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else if(CRUD.equals("Consultar"))
            {
//                Long CodiLuga = Long.parseLong(request.getParameter("codiRadi") == null ? 
//                            "0" : request.getParameter("codiRadi"));
//                    Alumnos objeLuga = new AlumnosCtrl().get(CodiLuga);
//                    if(objeLuga != null)
//                    {
//                        //System.out.println(objeLuga.getCodiAlumnos() +" "+objeLuga.getNombAlumnos());
//                        request.setAttribute("codi", objeLuga.getCodiAlumnos());
//                        request.setAttribute("nomb", objeLuga.getNombAlumnos());
//                     }
//                    request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else if(CRUD.equals("Modificar"))
            {
//                 Alumnos obje = new Alumnos();
//                obje.setNombAlumnos(request.getParameter("nomb"));
//                obje.setEsta(1);
//                obje.setCodiAlumnos(Long.parseLong(request.getParameter("codi")));
//                mens = new AlumnosCtrl().modi(obje) ? "Datos modificados" : "Datos no modificados";
//                 request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
           
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        } catch (Exception e) {
            
             System.out.println("ERROR:"+e.getMessage());
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
