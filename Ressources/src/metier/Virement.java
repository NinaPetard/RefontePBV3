/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxibanque_V2.metier;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Nina
 */
public class Virement {
    
    private int idVirement;
	private Compte compteDebit;
    private Compte compteCredit;
    private double montant;
    private Date date;

    public Virement(Compte compteDebit, Compte compteCredit, double montant) {    	 
        this.compteDebit = compteDebit;
        this.compteCredit = compteCredit;
        this.montant = montant;
    }
    
    
    

    public Date getDate() {
		return date;
	}


	public int getIdVirement() {
		return idVirement;
	}




	public void setIdVirement(int idVirement) {
		this.idVirement = idVirement;
	}




	public void setDate(Date date) {
		this.date = date;
	}


	public Compte getCompteDebit() {
        return compteDebit;
    }

    public void setCompteDebit(Compte compteDebit) {
        this.compteDebit = compteDebit;
    }

    public Compte getCompteCredit() {
        return compteCredit;
    }

    public void setCompteCredit(Compte compteCredit) {
        this.compteCredit = compteCredit;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    
    
    
}
