package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
public class FXMLController {

	private Libretto model;
    
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEsame;

    @FXML
    private DatePicker pickerEsame;

    @FXML
    private TextField txtVoto;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	
    	//leggi e controlla i dati
    	String nomeEsame = txtEsame.getText(); //controllo solo che esista
    	if(nomeEsame.length()==0) {
		txtResult.setText("Errore: nome esame vuoto");
		return;
    	}
    	
    	String votoEsame = txtVoto.getText();
    	if(votoEsame.length()==0) {
    		txtResult.setText("ERRORE: campo voto vuoto");
    		return;
    	}
    	int votoInt=0;
    	try {
    		votoInt=Integer.parseInt(votoEsame);  			//Provo a trasformare la stringa di input in un intero
    	}catch(NumberFormatException e) { 					//se non funziona entro nel catch che mi riconosce l'eccezione
    		txtResult.setText("ERRORE: il voto deve essere numerico");
    		return;
    	}
    	if(votoInt<18 || votoInt>30) {
    		txtResult.setText("ERRORE: il voto deve essere compreso tra 18 e 30");
    		return;
    	}
    	
    	
    //	String dataEsame = txtData.getText();
    //	LocalDate data;
    //	try { 
    //		data = LocalDate.parse(dataEsame);
    //	}catch(DateTimeParseException ex) {
    //		txtResult.setText("ERRORE: il formato della data deve essere YYYY/MM/DD");
    //		return;
    //	}
    	
    	//eseguo con datePicker
    	LocalDate data =  pickerEsame.getValue(); //in questo modo fa lui tutti i controlli necessari
    	if(data==null) {
    		 txtResult.setText("ERRORE: la data è errata o mancante");
    		 return;
    	}
    	//esegui l'azione
    	Voto voto = new Voto(nomeEsame, votoInt, data);
    	model.add(voto);
    	
    	//aggiorna i risultati nella view
    	txtResult.setText(model.toString());
    	txtVoto.clear(); //svuoto alla fine quando ho avuto successo
    	txtEsame.clear();
    	pickerEsame.setValue(null);
    	
    }

    @FXML
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert pickerEsame != null : "fx:id=\"pickerEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
    }


    public void setModel(Libretto model) {
    	this.model=model;
    }
}
