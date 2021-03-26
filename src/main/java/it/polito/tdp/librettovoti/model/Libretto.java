package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Libretto { //al suo interno contiene tanti coti

	//inserie nella classe libretto un elenco di 10 voti a piacere
	private List<Voto> voti; //utilizzo una lista per memorizzare un array generico di voti
	                         //questa è la dichiarazione della lista quindi effettivamente essa non esiste ancora
                             //List<TIPO DI DATO> nome della lista
							 //all'interno del codice per ora mi basta che sia un alista generica
	                         //poi che sia un ArrayList o una LinkedList lo decido successivamente
						     //<> indicano che la lista è un interfafaccia generica
							 //in questo caso la lista conterra ggetti di tipo Voto oppure sue sottoclassi
	private Map<String, Voto> votiMap; //identity Map
									   //Perchè creare anche una mappa di voti?
									   // In questo modo quando cerco un voto non devo scorrere tutti gli elementi come nelle liste
									   //tutti gli elementi sono facilmente accessibili grazie al nome dell'esame (nomeEsame --> voto)
	
	public Libretto() {
		this.voti = new ArrayList<>(); //qui effettivamente creo la classe e scelgo ArrayList (new)
									   //lo faccio perchè è richiesto e questa è la singola riga del codice
		                               //in cui io lo decido--> se dovessi cambiare cambio qui
		this.votiMap = new HashMap<>();
	}

	public void add(Voto v) { //questo metodo add è vitale in quanto ridefinito manualmente e possiamo implementare piu operazioni
		this.voti.add(v);   //in questo caso io sfrutto l'add delle liste senza preoccuparmi di come si inserisce il voto
		this.votiMap.put(v.getNome(), v);
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
	
	/**
	 * ricerca nel Libretto il voto di un esame, dato il nome del corso
	 * @param nomeCorso
	 * @return
	 */
	
	public Voto ricercaCorso(String nomeCorso) {
	//	Voto risultato = null;
	//	for(Voto v: this.voti) {
	//		if(v.getNome().equals(nomeCorso)) { //if mi seleziona effettivamente delle caselle 
	//			risultato = v;					//devo usare equals perche sto confrontando due oggetti
	//			break;
	//		}
	//	}
	//	return risultato;
		
		return this.votiMap.get(nomeCorso);
		}
	
	/**
	 * Verifica se nel libretto c'è già un voto con lo stesso esame e la stessa votazione
	 * @param v
	 * @return
	 */
	public boolean esisteDuplicato(Voto v) {
	//Questo metodo funzionerebbe con la lista ed è ottimo ma preferisco accedere alla Map perche è migliore
	//	boolean trovato = false;
	//	for(Voto vo: this.voti)  {  //invento un oggetto che mi scorre la lista dei voti gi apresenti nel libretto
	//		if(vo.getNome().equals(v.getNome()) && vo.getVoto()==v.getVoto())
	//			trovato= true;
	//		break;
	//	}
	//	return trovato;
	
	Voto trovato = this.votiMap.get(v.getNome()); //imposto un voto trovato con quello che mi passa il metodo
	if(trovato == null)  //se il metodo get della mappa non me lo trova allora non esiste duplicato
		return false;
	if(trovato.getVoto()==v.getVoto()) //se lo trova e ha anche uguale voto allora esiste duplicato
		return true;
	else
		return false;
	}
	/**
	 * Verifica se nel libretto c'è già un voto con lo stesso esame ma con votazione diversa
	 * @param v
	 * @return
	 */
	public boolean esisteConflitto(Voto v) {
	//	boolean trovato= false;
	//	for(Voto vo: this.voti)  {  //invento un oggetto che mi scorre la lista dei voti gi apresenti nel libretto
	//		if(vo.getNome().equals(v.getNome()) && vo.getVoto()!=v.getVoto())
	//			trovato = true;
	//		break;
	//	}
	//	return trovato;
		
		Voto trovato = this.votiMap.get(v.getNome());
		if(trovato==null)
			return false;
		if(trovato.getVoto()!=v.getVoto())
			return true;
		else
			return false;
		}
}



