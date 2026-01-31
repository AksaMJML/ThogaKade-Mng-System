package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.dto.ItemDTO;

public class ItemFormController {

    ObservableList<ItemDTO> itemDTOObservableList = FXCollections.observableArrayList(
            new ItemDTO("I001", "Item 1 Description", "10 pcs", 15.5, 100),
            new ItemDTO("I002", "Item 2 Description", "5 pcs", 25.0, 50),
            new ItemDTO("I003", "Item 3 Description", "20 pcs", 5.75, 200)
    );


    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colPackSize;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableView<?> tblItemFormView;

    @FXML
    private TextArea txtAreaDescription;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtPackSize;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        System.out.println(itemDTOObservableList);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
