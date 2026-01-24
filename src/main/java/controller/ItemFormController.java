package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ItemFormController {

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colPackSize;

    @FXML
    private TableView<?> tblItemFormView;

    @FXML
    private TextArea txtAreaDescription;

    @FXML
    private TextField txtCode;

    @FXML
    private TableColumn<?, ?> txtDescription;

    @FXML
    private TextField txtPackSize;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TableColumn<?, ?> txtQuantity;

    @FXML
    private TableColumn<?, ?> txtUnitPrice;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
