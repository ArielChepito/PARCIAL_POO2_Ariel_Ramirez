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

/**
 *
 * @author Ariel
 */
public class conexion {
    @Resource(mappedName = "jdbc/ParcialPool")
    private DataSource ds;
    private Connection cn=null;
    
    private  DataSource getDs()
    {
        return ds;
    }
    public Connection getCn() throws SQLException{
              
            cn = ds.getConnection();
         return cn;
        
    }
}
