/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author flamenquim
 */
public class ScoutsMain {

    //! Configurar la Persistence Unit y la BD a usar en 'persistence.xml'
    //! Agregar el 'JavaDB.jar' en Librerias - necesario para conectar a la BD
    //! Conectar previamente a la BD: Services -> derby://localhost
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //! Use Persistence Unit Name to create 'emf' - defined at 'persistence.xml'
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ScoutsPU");
        EntityManager em = emf.createEntityManager();
       
        //! DB management - ...
        //! Edit Persistence Engine
        
        em.close();
        emf.close();
        //! Generates DB unit file
    }
}
