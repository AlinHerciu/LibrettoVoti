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
}



