package proxibanque_V2.metier;

import java.util.ArrayList;

public class Client {

//Attributs
    private int idClient;
    private String nom;
    private String prenom;
    private String adresse;
    private String codepostal;
    private String ville;
    private String telephone;
    private int idConseiller;
    private ArrayList<Compte> comptes;

//Constructeur

    public Client(String nom, String prenom, String adresse, 
            String codepostal, String ville, String telephone, int idConseiller) {
        this.adresse = adresse;
        this.codepostal = codepostal;
        this.ville = ville;
        this.telephone = telephone;
        this.idConseiller = idConseiller;
    }
    
    public Client(int idclient, String nom, String prenom, String adresse, 
            String codepostal, String ville, String telephone, int idConseiller) {
    	this.nom = nom;
    	this.prenom=prenom;
    	this.idClient = idclient;
        this.adresse = adresse;
        this.codepostal = codepostal;
        this.ville = ville;
        this.telephone = telephone;
        this.idConseiller = idConseiller;
    }
    
    public Client() {
    	
    }

   


    public ArrayList<Compte> getComptes() {
    	return comptes;
	}

	public void setComptes(ArrayList<Compte> comptes) {
		this.comptes = comptes;
	}




	//Getters and Setters
    public int getIdClient() {
        return idClient;
    }
    
 public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public String getVille() {
        return ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public int getIdConseiller() {
        return idConseiller;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }


    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setIdConseiller(int idConseiller) {
        this.idConseiller = idConseiller;
    }

}
