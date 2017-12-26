
package proxibanque_V2.metier;

public class Compte {
	private int idCompte;
	private double solde;
	private Client client;
	private String type;
	private double interet;
	private double decouvert;
	
	public Compte(int idCompte, double solde, Client client, String type, double interet, double decouvert) {
		this.idCompte = idCompte;
		this.solde = solde;
		this.client = client;
		this.type = type;
		this.decouvert = decouvert;
		this.interet = interet;
	}
	
	public Compte(int idCompte, double solde,  String type, double interet, double decouvert) {
		this.idCompte = idCompte;
		this.solde = solde;
		this.type = type;
		this.decouvert = decouvert;
		this.interet = interet;
	}

	public Compte(int idCompte, double solde, Client client, String type, double parametre) {
		this.idCompte = idCompte;
		this.solde = solde;
		this.client = client;
		this.type = type;

		if (type.equals("Courant")) {
			this.interet = 0;
			this.decouvert = parametre;
		}

		if (type.equals("Epargne")) {
			this.interet = parametre;
			this.decouvert = 0;}
		
		
	}
	public Compte() {
	}



	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getInteret() {
		return interet;
	}

	public void setInteret(double interet) {
		this.interet = interet;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
