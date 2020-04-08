package com.base;


import com.base.controllers.DBmanager;
import com.base.controllers.views.MainController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * this class launch the app
 */
public class Launcher extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        DBmanager.getINSTANCE().openConnection();

        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("views/Main.fxml")); //recuperas todos los datos del fxml
        Parent root = fxmlLoader.load(); // guardas el contenedor padre del fxml
        MainController mainWindowController = fxmlLoader.getController();//creas una instancia de tu controlador para pasarle el stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        //stage.setMaximized(true);
        stage.sizeToScene();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {

                DBmanager.getINSTANCE().closeConnection();
//                Logica.getINSTANCE().guardarListaCuentasEmails();
//                Logica.getINSTANCE().writeSettings();
//                Logica.getINSTANCE().writeListaAlarmas();
//                Reloj2 r = mainWindowController.getIdReloj();
//                r.getTimer().cancel();
//                r.getTimer().purge();
            }
        });
        mainWindowController.setActualStage(stage);//le pasas el stage a tu controlador.
        stage.show();
//        if (Logica.getINSTANCE().getListaCuentasEmailSize() < 1) {
//            mainWindowController.formularioLogin();
//        }
    }
}