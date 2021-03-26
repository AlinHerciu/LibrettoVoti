package it.polito.tdp.librettovoti;

import javafx.application.Application;
import static javafx.application.Application.launch;

import it.polito.tdp.librettovoti.model.Libretto;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	//modifico il modo in cui viene caricato il file FXML
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));  //legge il file e creo i nodi e il controller
        Parent root = loader.load(); //creo tutti gli oggetti di tipo nodo
        FXMLController controller = loader.getController(); //definisco un controller che deriva dall'operazione di caricamento del FXML
        
        //creo il modello e informato il controller di quale sia il modello su cui debe lavorare
        Libretto model = new Libretto();
        controller.setModel(model);  //facendo cosi mi mancherebbe una variabile controller
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
