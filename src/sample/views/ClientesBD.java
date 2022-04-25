package sample.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.components.CustomeButtonCell;
import sample.models.ClientesDAO;

public class ClientesBD extends Stage{

    private Scene escena;
    private TableView<ClientesDAO> tbvClientes;
    private Button btnAgregar;
    private VBox vBox;
    private ClientesDAO cteDAO;

    public ClientesBD(){
        cteDAO = new ClientesDAO();
        CrearUI();
        this.setTitle("Clientes Taqueria :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        tbvClientes = new TableView<>();
        btnAgregar = new Button("Agregar Cliente");
        btnAgregar.setOnAction(event -> {
            new ClienteFRM(tbvClientes,null);
        });
        vBox = new VBox();
        vBox.getChildren().addAll(tbvClientes,btnAgregar);
        escena = new Scene(vBox,700,250);
        
        CrearTabla();
    }

    private void CrearTabla() {
        TableColumn<ClientesDAO,Integer> tbcIdCliente = new TableColumn<>("ID");
        tbcIdCliente.setCellValueFactory(new PropertyValueFactory<>("cvecte"));

        TableColumn<ClientesDAO,String> tbcNomCliente = new TableColumn<>("NOMBRE");
        tbcNomCliente.setCellValueFactory(new PropertyValueFactory<>("nomcte"));

        TableColumn<ClientesDAO,String> tbcTelCliente = new TableColumn<>("TELEFONO");
        tbcTelCliente.setCellValueFactory(new PropertyValueFactory<>("telcte"));

        TableColumn<ClientesDAO,String> tbcDirCliente = new TableColumn<>("DIRECCION");
        tbcDirCliente.setCellValueFactory(new PropertyValueFactory<>("dircte"));

        TableColumn<ClientesDAO,String> tbcEditar = new TableColumn<>("EDITAR");
        tbcEditar.setCellFactory(new Callback<TableColumn<ClientesDAO, String>, TableCell<ClientesDAO, String>>() {
            @Override
            public TableCell<ClientesDAO, String> call(TableColumn<ClientesDAO, String> param) {
                return new CustomeButtonCell(1);
            }
        });

        TableColumn<ClientesDAO,String> tbcBorrar = new TableColumn<>("Borrar");
        tbcBorrar.setCellFactory(new Callback<TableColumn<ClientesDAO, String>, TableCell<ClientesDAO, String>>() {
            @Override
            public TableCell<ClientesDAO, String> call(TableColumn<ClientesDAO, String> param) {
                return new CustomeButtonCell(2);
            }
        });

        tbvClientes.getColumns().addAll(tbcIdCliente,tbcNomCliente,tbcTelCliente,tbcDirCliente,tbcEditar,tbcBorrar);
        tbvClientes.setItems(cteDAO.SELECCIONAR());

    }


}
