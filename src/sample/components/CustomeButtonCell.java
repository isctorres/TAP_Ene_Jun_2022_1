package sample.components;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import sample.models.ClientesDAO;
import sample.views.ClienteFRM;

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
