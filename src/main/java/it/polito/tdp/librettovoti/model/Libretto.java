package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto { //al suo interno contiene tanti coti

	//inserie nella classe libretto un elenco di 10 voti a piacere
	private List<Voto> voti; //utilizzo una lista per memorizzare un array generico di voti
	                         //questa è la dichiarazione della lista quindi effettivamente essa non esiste ancora
                             //List<TIPO DI DATO> nome della lista
							 //all'interno del codice per ora mi basta che sia un alista generica
	                         //poi che sia un ArrayList o una LinkedList lo decido successivamente
						     //<> indicano che la lista è un interfafaccia generica
							 //in questo caso la lista conterra ggetti di tipo Voto oppure sue sottoclassi
	
	public Libretto() {
		this.voti = new ArrayList<>(); //qui effettivamente creo la classe e scelgo ArrayList (new)
									   //lo faccio perchè è richiesto e questa è la singola riga del codice
		                               //in cui io lo decido--> se dovessi cambiare cambio qui
	}

	public void add(Voto v) {
		this.voti.add(v);   //in questo caso io sfrutto l'add delle liste senza preoccuparmi di come si inserisce il voto
	}
	
	public String toString() { //sarebbe il vecchio descriviti
		//return this.voti.toString(); //qui non devo definire completamente il metodo toString ma uso quello della List
		
		//se lo voglio personalizzato??
		String s= "";
		for(Voto v: this.voti) {
			s = s + v.toString() + "\n";  //con v.toString() chiamo il metodo "descriviti" della classe voto
		}								  //scelgo il layout della colonna nella lista
		return s;
		}
	
	//METODI PER STAMPARE I VOTI UGUALI A UN DATO PUNTEGGIO
	
	/*public void stampaVotiUguali(int punteggio) {
		//il libretto stampa i voti da solo ma è un metodo molto limitante perche sa fare solo quello
	}
	
	public String votiUguali(int punteggio) {
		//calcola una stringa che contiene i voti e sarà poi il chiamante a stampare (piu generale--> piu utile)
		//solo il nome o tutto l'esame?
	}
	*/ 
	
	public List<Voto> listaVotiUguali(int punteggio) {
		//restituisce i voti uguali al criterio selezionato (con questo stampo l'oggetto intero)
		//volevi i voti uguali a 25?--> ti do tutti i voti completi uguali a 25 
		//il DIFETTO di questo metodo è che espone tutta la mia struttura dati interna del voto
		//e modificassi tutti i miei dati interni poi dovrei modificare tutti i metodi che restituiscono l'oggetto intero
	
	List<Voto> risultato = new ArrayList<>(); //nasce come lista vuota
	for(Voto v: this.voti) {
		if(v.getVoto()==punteggio)
			risultato.add(v); //abbiamo aggiunto ad una nuova lista un oggetto gia esistente in un altra (perche non ho new)
	}
	
	return risultato;
	}
	
	
	public Libretto votiUguali(int punteggio) {
		//in questo caso restituisco un sottolibretto con i voti richiesti
		Libretto risultato = new Libretto();
		for(Voto v: this.voti) {
			if(v.getVoto()==punteggio)
				risultato.add(v);
		}
		return risultato;
	}
}



