package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class OrderDetailController {

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableView<?> tblOrderDetailView;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtOrderId;

    @FXML
    private TextField txtQuantity;

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

