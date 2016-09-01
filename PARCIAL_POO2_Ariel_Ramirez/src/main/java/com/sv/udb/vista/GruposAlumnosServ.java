/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.AlumnosCtrl;
import com.sv.udb.controlador.GruposAlumnosCtrl;
import com.sv.udb.modelo.Alumnos;
import com.sv.udb.modelo.Grupos;
import com.sv.udb.modelo.GruposAlumnos;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ariel
 */
@WebServlet(name = "GruposAlumnosServ", urlPatterns = {"/GruposAlumnosServ"})
public class GruposAlumnosServ extends HttpServlet {

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
                
                
                Alumnos alum = new Alumnos(Integer.parseInt(request.getParameter("cmbAlumno")));
                Grupos grup = new Grupos(Integer.parseInt(request.getParameter("cmbGrupo")));
                GruposAlumnos obje = new GruposAlumnos();
                
                obje.setCodiAlum(alum);
                obje.setCodiGrup(grup);
                obje.setEstaGrupAlum('A');
              
                mens = new GruposAlumnosCtrl().guar(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
                request.getRequestDispatcher("/alumnosgrupos.jsp").forward(request, response);
            }
            else if(CRUD.equals("Alumnos"))
            {
                
                          
                request.setAttribute("codi", request.getParameter("cmbGrupo"));
                request.getRequestDispatcher("/datosAlumnos.jsp").forward(request, response);
            }
           
           
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        } catch (NumberFormatException | ServletException | IOException e) {
            
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
