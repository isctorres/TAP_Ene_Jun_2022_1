package sample.views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Parseador extends Stage implements EventHandler<KeyEvent> {

    private VBox vBox;
    private ToolBar tlbMenu;
    private TextArea txtEntrada, txtSalida;
    private FileChooser flcArchivo;
    private Button btnAbrir;
    private Scene escena;
    private Image imgAbrir;
    private ImageView imvAbrir;

    public Parseador(){
        CrearUI();
        this.setTitle("Traductor de Código Morse");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        tlbMenu = new ToolBar();
        imgAbrir = new Image("sample/images/7265_mail_open_icon.png");
        imvAbrir = new ImageView(imgAbrir);
        imvAbrir.setFitHeight(25);
        imvAbrir.setFitWidth(25);
        btnAbrir = new Button();
        btnAbrir.setGraphic(imvAbrir);
        btnAbrir.setOnAction(event -> {
           // aqui va el código
            flcArchivo = new FileChooser();
            flcArchivo.setTitle("Buscar archivo...");
            File archivo = flcArchivo.showOpenDialog(this);
        });
        tlbMenu.getItems().addAll(btnAbrir);
        //....
        txtEntrada = new TextArea();
        txtEntrada.setPromptText("Introduce el texto a parsear");
        txtEntrada.setOnKeyPressed(this);
        txtSalida = new TextArea();
        txtSalida.setEditable(false);
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(5));
        vBox.getChildren().addAll(tlbMenu,txtEntrada,txtSalida);
        escena = new Scene(vBox,500,300);
    }

    @Override
    public void handle(KeyEvent event) {
        System.out.println(event.getCode().toString());
    }
}
