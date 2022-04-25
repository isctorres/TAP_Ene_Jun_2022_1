package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.ClientesDAO;

public class ClienteFRM extends Stage {

    private VBox vBox;
    private TextField txtNombre, txtTelefono, txtDireccion;
    private Button btnGuardar;
    private Scene escena;
    private ClientesDAO objC;
    private TableView<ClientesDAO> tbvClientes;

    public ClienteFRM(TableView<ClientesDAO> tbv,ClientesDAO objC){
        this.objC = ( objC == null ) ? new ClientesDAO() : objC;
        this.tbvClientes = tbv;
        CrearUI();
        this.setTitle("Agregar Cliente");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));
        txtNombre = new TextField();
        txtNombre.setText(this.objC.getNomcte());
        txtNombre.setPromptText("Nombre del cliente");
        txtTelefono = new TextField();
        txtTelefono.setText(this.objC.getTelcte());
        txtTelefono.setPromptText("Telefono del cliente");
        txtDireccion = new TextField();
        txtDireccion.setText(this.objC.getDircte());
        txtDireccion.setPromptText("Dirección del cliente");
        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(event -> {
            objC.setNomcte(txtNombre.getText());
            objC.setTelcte(txtTelefono.getText());
            objC.setDircte(txtDireccion.getText());
            objC.INSERTAR();

            tbvClientes.setItems(objC.SELECCIONAR());
            tbvClientes.refresh();

            this.close();
        });
        vBox.getChildren().addAll(txtNombre,txtTelefono,txtDireccion,btnGuardar);
        escena = new Scene(vBox,205,200);
    }

}
