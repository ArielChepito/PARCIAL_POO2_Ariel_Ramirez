/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Alumnos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Laboratorio
 */
public class AlumnosCtrl {
     /**
     * Método para guardar un lugar de acceso en la base de datos
     * @param obje Alumnos objeto de tipo lugar de acceso
     * @return resp boolean true si ha sido guardado exitosamente
     */
    public boolean guar(Alumnos obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.persist(obje);
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
    
     /**
     * Método para consultar todos los lugares de accesos en la base de datos
     * @return resp List lista de objetos de tipo Alumnos
     */
     public List<Alumnos>  ConsTodo()
    {
        List<Alumnos> resp = new ArrayList<>();
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
           EntityManager em = emf.createEntityManager();
        try
        {
          TypedQuery<Alumnos> query =em.createNamedQuery("Alumnos.findAll", Alumnos.class);
           resp = query.getResultList();
        }
        catch(Exception ex)
        {
            
        }
        return resp;
       
    }
     
       /**
      * Método para modificar registros en la base de datos
      * @param obje Alumnos objeto de tipo lugar de acceso
      * @return resp boolean true si ha sido modificado exitosamente
      */
        public boolean modi(Alumnos obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
         Alumnos lugar = null;
        tx.begin();
        try
        {
            //No olvidar la funcion merge, esa es una exelente funcion si el form tiene todos los datos
            // por que por ejemplo, aquí solo voy a modificar el nombre y por lo anto solo ese campo esta
            //en el form, pero los demas como estado y fecha no, así que como recibe nada, hace update con nada
            //por eso, en este caso, es masconveniente setear uno por uno
            lugar = em.find(Alumnos.class, obje.getCodiAlum());
            lugar.setNombAlum(obje.getNombAlum());
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
    
     /**
      * Método para dar de baja registros actualizando su estado
      * @param empId Long llave primaria del registro a modificar
      * @return resp boolean true si ha sido eliminado exitosamente
      */
    public boolean elim(int empId)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();       
        tx.begin();
        Alumnos respo = null;
        try{
            respo = em.find(Alumnos.class, empId);
            if(respo != null)
            {
                em.remove(respo);
                tx.commit();
                resp = true; 
            }
        }catch(Exception e){
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }

       
 

     
     
    public Alumnos get(Long empId){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        Alumnos resp = null;
        
        try{
            resp = em.find(Alumnos.class, empId);
            
        }catch(Exception e){
            e.printStackTrace();
        }                
        return resp;
    }
}
