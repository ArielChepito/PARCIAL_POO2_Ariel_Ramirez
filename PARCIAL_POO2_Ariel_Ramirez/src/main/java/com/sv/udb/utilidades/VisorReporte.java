/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.utilidades;


import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.activation.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.query.JRJpaQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author AdminDesa
 */
@WebServlet(name = "VisorReporte", urlPatterns = {"/VisorReporte"})
public class VisorReporte extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response  
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)  {
        String nombRepo = (String) request.getParameter("nombRepo");
        String pathRepo = request.getServletContext().getRealPath("/reportes/" + nombRepo + ".jasper");
      
     
        
        try
        {
            //PARAMETROS
            Map params = new HashMap();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
            EntityManager em = emf.createEntityManager();
           params.put(JRJpaQueryExecuterFactory.PARAMETER_JPA_ENTITY_MANAGER, em);
           
            //CARGA DEL REPORTE
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(pathRepo);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, params);
            byte[] bytes = JasperExportManager.exportReportToPdf(print);
            OutputStream outStream = response.getOutputStream();
            try {
                response.addHeader("Content-disposition",
                        "inline;filename=" + nombRepo);
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                outStream.write(bytes, 0, bytes.length);
            } catch (IOException e) {
                System.out.println("Error en processRequest " + e.getMessage());
            } finally {
                outStream.flush();
                outStream.close();
            }
        }
        catch(Exception ex)
        {
            System.out.println("ERROR:"+ex.getMessage());
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
