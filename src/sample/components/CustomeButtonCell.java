package sample.components;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import sample.models.ClientesDAO;
import sample.views.ClienteFRM;

import java.util.Optional;

public class CustomeButtonCell extends TableCell<ClientesDAO, String> {
    int opc;
    private Button btnCelda;
    private ClientesDAO objC;
    public CustomeButtonCell(int opc){
        this.opc = opc;
        if( opc == 1 )
            btnCelda = new Button("Editar");
        else
            btnCelda = new Button("Borrar");
        btnCelda.setOnAction(event -> eventoBoton(opc));
    }

    private void eventoBoton(int opc){
        objC = CustomeButtonCell.this.getTableView().getItems().get(CustomeButtonCell.this.getIndex());
        switch(opc){
            case 1: new ClienteFRM(CustomeButtonCell.this.getTableView(), objC); break;
            case 2: Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Mensaje del sistema");
                    alert.setHeaderText("Confirmacion de la acción...");
                    alert.setContentText("¿Deseas confirmar el borrado del registro?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if( result.get() == ButtonType.OK ) {
                        objC.ELIMINAR();
                        CustomeButtonCell.this.getTableView().setItems(objC.SELECCIONAR());
                        CustomeButtonCell.this.getTableView().refresh();
                    }
                    break;
        }
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if( !empty ){
            this.setGraphic(btnCelda);
        }
    }
}
