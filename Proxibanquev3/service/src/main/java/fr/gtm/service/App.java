package fr.gtm.service;
import fr.gtm.domaine.Conseiller;


/**
 * Classe de test pour verifier la méthode de recuperation de la liste de client d'un conseiller donné
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
        System.out.println(Service_Conseiller.listerClientsConseiller(1L));        
    }
}
