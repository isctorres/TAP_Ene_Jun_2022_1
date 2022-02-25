package sample.views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.events.EventoLoteria;


public class Loteria extends Stage implements EventHandler {

    private VBox vBox;
    private HBox hBox1, hBox2;
    private Button btnAtras, btnSiguiente, btnJugar;
    private Label lblTiempo;
    private GridPane gdpPlantilla;
    private Image imgCarta;
    private ImageView imvCarta;
    private Scene escena;
    private String[] arImagenes = {"barril.jpeg","botella.jpeg","catrin.jpeg","chavorruco.jpeg","concha.jpeg","graduada.jpeg","luchador.jpeg","maceta.jpeg"};
    private Button[][] arBtnPlantilla = new Button[4][2];

    public Loteria(){
        CrearUI();
        this.setTitle("Loteria :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {

        //EventoLoteria objEvento = new EventoLoteria();
        btnAtras     = new Button("Anterior");
        btnAtras.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventoLoteria(1));
        btnAtras.setPrefWidth(100);
        btnSiguiente = new Button("Siguiente");
        //btnSiguiente.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventoLoteria(2));
        btnSiguiente.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Hola evento 3");
            }
        });
        btnSiguiente.setPrefWidth(100);
        lblTiempo    = new Label("00:00");
        hBox1        = new HBox();
        hBox1.setSpacing(5);
        hBox1.getChildren().addAll(btnAtras,btnSiguiente,lblTiempo);

        gdpPlantilla = new GridPane();
        CrearPlantillas();
        imgCarta     = new Image("sample/images/tacos.jpeg");
        imvCarta     = new ImageView(imgCarta);
        imvCarta.setFitHeight(200);
        imvCarta.setFitWidth(150);

        hBox2        = new HBox();
        hBox2.setSpacing(5);
        hBox2.getChildren().addAll(gdpPlantilla, imvCarta);

        btnJugar     = new Button("Jugar");
        btnJugar.setPrefWidth(290);
        btnJugar.addEventHandler(MouseEvent.MOUSE_CLICKED,this);

        vBox         = new VBox();
        vBox.setPadding(new Insets(5));
        vBox.setSpacing(5);
        vBox.getChildren().addAll(hBox1,hBox2,btnJugar);

        escena = new Scene(vBox,300,360);
    }

    private void CrearPlantillas() {

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                Image imgCartP = new Image("sample/images/"+arImagenes[2]);
                ImageView imv = new ImageView(imgCartP);
                imv.setFitHeight(60);
                imv.setFitWidth(50);
                arBtnPlantilla[j][i] = new Button();
                arBtnPlantilla[j][i].setGraphic(imv);
                gdpPlantilla.add(arBtnPlantilla[j][i],i,j);
            }
        }
    }

    @Override
    public void handle(Event event) {
        System.out.println("Mi primer evento Fovifest :)");
    }
}