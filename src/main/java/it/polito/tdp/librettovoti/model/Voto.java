package it.polito.tdp.librettovoti.model;
import java.time.LocalDate;

//POJO -Plain Old Java Object  --> semplicemente una classe
//Java Bean (oppure cosi) --> in entrambi i casi abbiamo contenitori di dati--> non ha logica

public class Voto {

	private String nome;  //nome dell'esame superato
	private int voto;  //come rappresentiamo il 30L
	private LocalDate data;  //data superamento esame
	
	public Voto(String nome, int voto, LocalDate data) {
		super();
		this.nome = nome;
		this.voto = voto;
		this.data = data;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public String toString() {  //posso farlo con il Wizard di eclipse
		return "Esame "+this.nome+" superato con "+this.voto+" il "+this.data; //scelgo il "layout" della riga
	}
}
