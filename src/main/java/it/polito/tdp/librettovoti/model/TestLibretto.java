package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {

	public static void main(String[] args) {
		
		System.out.println("Test metodi di Libretto");
		Libretto libretto = new Libretto(); // creo un oggetto libretto
		
		Voto voto1 = new Voto("Analisi1", 30, LocalDate.of(2019, 2, 15)); // lo posso fare perchè creo un oggetto
		
		libretto.add(voto1);
		libretto.add(new Voto("Fisica1", 28, LocalDate.of(2019, 7, 15))); //in questo caso creo il nuovo oggetto qui
		libretto.add(new Voto("Informatica", 24, LocalDate.of(2019, 9, 15)));
		libretto.add(new Voto("Chimica", 25, LocalDate.of(2019, 2, 17)));
		//System.out.println(libretto);--> mi stampa il riferimento all'oggetto libretto se non ho definito i toString
		//per stampare i contenuti del libretto devo chiedere al libretto come stamparsi 
		
		System.out.println(libretto.toString()); //in questo modo posso stampare il contenuto del libretto
												 //toString potrebbe essere omesso
		
		List<Voto> venticinque = libretto.listaVotiUguali(25); //creo una nuova lista dove memorizzo i voti richiesti
		System.out.println(venticinque);					   //non c è il new perche lo fa il metodo chiamato
		
		Libretto venticinquee = libretto.votiUguali(25); //in questo modo ottengo un nuovo libretto
		System.out.println(venticinquee);
		
		Voto analisi1 = libretto.ricercaCorso("Analisi1");
		System.out.println(analisi1);
	}
}
