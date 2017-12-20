/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nina.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author adminl
 */
public class Emf {
    private static EntityManagerFactory emf =null;
    
    
    public static synchronized EntityManagerFactory getEmf(){
        
        if(emf==null){
            emf = Persistence.createEntityManagerFactory("fr.nina_domaine_jar_1.0-SNAPSHOTPU");
        }
        return emf; 
    }
    
    
}
