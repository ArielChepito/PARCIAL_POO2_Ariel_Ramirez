/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.utilidades;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Ariel
 */
public class conexion {
  
    private DataSource ds;
    private Connection cn=null;
    
    private  DataSource getDs()
    {
        return ds;
    }
    public Connection getCn() throws SQLException, NamingException{
              ds=(DataSource) new InitialContext().lookup("jdbc/ParcialPool");
            cn = ds.getConnection();
         return cn;
        
    }
}
