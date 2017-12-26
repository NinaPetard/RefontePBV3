
package proxibanque_V2.metier;

import java.util.ArrayList;


public class Conseiller {
    
    private int idConseiller;
    private String userid;
    private String nom;
    private String prenom;
    private String password;
    private ArrayList<Client> clients;

    public Conseiller(int idConseiller, String nom, String prenom, String password, ArrayList<Client> clients) {
        this.idConseiller = idConseiller;
        this.userid = idConseiller + nom;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.clients = clients;
    }
    
    public Conseiller() {
    }


    public int getIdConseiller() {
        return idConseiller;
    }

    public void setIdConseiller(int login) {
        this.idConseiller = login;
    }

    public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }
            
    
    
}
