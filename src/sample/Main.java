package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.components.Corredor;
import sample.models.Conexion;
import sample.views.ClientesBD;
import sample.views.Loteria;
import sample.views.Parseador;

public class Main extends Application implements EventHandler{

    private MenuBar mnbPrincipal;
    private Menu menCompetencia1, menCompetencia2;
    private MenuItem mitLoteria, mitParseador, mitClientes;
    private VBox vBox;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        vBox = new VBox();
        mnbPrincipal = new MenuBar();
        menCompetencia1 = new Menu("Competencia 1");
        menCompetencia2 = new Menu("Competencia 2");
        mnbPrincipal.getMenus().addAll(menCompetencia1,menCompetencia2);

        mitLoteria = new MenuItem("Loteria");
        mitLoteria.setOnAction(event -> Eventos(1));
        mitParseador = new MenuItem("Código Morse");
        mitParseador.setOnAction(event -> Eventos(2));
        mitClientes = new MenuItem("Taqueria");
        mitClientes.setOnAction(event -> Eventos(3));
        menCompetencia1.getItems().addAll(mitLoteria,mitParseador,mitClientes);

        vBox.getChildren().add(mnbPrincipal);

        primaryStage.addEventHandler(WindowEvent.WINDOW_SHOWING,this);
        primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Bienvenidos :)");
                alerta.setHeaderText("Mensaje del Sistema :)");
                alerta.setContentText("Manejo de eventos de la ventana usando dialogos");
                alerta.showAndWait();
            }
        });

        Scene escena = new Scene(vBox,300,200);
        escena.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(escena);
        primaryStage.show();
        primaryStage.setMaximized(true);

        // Abrir la conexion a la base de datos de manera global
        Conexion.crearConexion();

        new Corredor("Correcaminos").start();
        new Corredor("Alfredo Adame").start();
        new Corredor("Speedy Gonzalez").start();
        new Corredor("Darth Vader").start();
        new Corredor("Pedrito Sola").start();
    }

    private void Eventos(int i) {
        switch(i){
            case 1: new Loteria(); break;
            case 2: new Parseador(); break;
            case 3: new ClientesBD(); break;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Bienvenidos :)");
        alerta.setHeaderText("Mensaje del Sistema :)");
        alerta.setContentText("Manejo de eventos de la ventana usando dialogos");
        alerta.showAndWait();
    }
}
