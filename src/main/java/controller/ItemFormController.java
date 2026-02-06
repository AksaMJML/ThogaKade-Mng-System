package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.ItemDTO;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ItemFormController implements Initializable {

    ObservableList<ItemDTO> itemDTOObservableList = FXCollections.observableArrayList();


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
    private TableView<ItemDTO> tblItemFormView;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loadAllItems();
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPackSize.setCellValueFactory(new PropertyValueFactory<>("packSize"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));

        tblItemFormView.setItems(itemDTOObservableList);

        //combo box data load

    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String code = txtCode.getText();
        String packSize = txtPackSize.getText();
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        int quantity = Integer.parseInt(txtQtyOnHand.getText());
        String description = txtAreaDescription.getText();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade" , "root" , "741897");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO item VALUES (?,?,?,?,? )");

            preparedStatement.setObject(1 , code);
            preparedStatement.setObject(2,description);
            preparedStatement.setObject(3,packSize);
            preparedStatement.setObject(4,unitPrice);
            preparedStatement.setObject(5,quantity);

            preparedStatement.execute();
            loadAllItems();
            clearFields();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade" ,  "root" , "741897");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM item WHERE ItemCode = ?");
            preparedStatement.setObject(1,txtCode.getText());
            preparedStatement.executeUpdate();
            loadAllItems();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
       // itemDTOObservableList.clear();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade" , "root" , "741897");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE item SET Description = ? , PackSize = ? , UnitPrice = ? , QtyOnHand = ? WHERE ItemCode = ?");
            preparedStatement.setObject(1, txtAreaDescription.getText());
            preparedStatement.setObject(2,txtPackSize.getText());
            preparedStatement.setObject(3,Double.parseDouble(txtUnitPrice.getText()));
            preparedStatement.setObject(4,Integer.parseInt(txtQtyOnHand.getText()));
            preparedStatement.setObject(5,txtCode.getText());

            preparedStatement.executeUpdate();
            loadAllItems();
            clearFields();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAllItems(){

        itemDTOObservableList.clear();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "741897");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM item");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ItemDTO itemDTO = new ItemDTO(
                        resultSet.getString("ItemCode"),
                        resultSet.getString("Description"),
                        resultSet.getString("PackSize"),
                        resultSet.getDouble("UnitPrice"),
                        resultSet.getInt("QtyOnHand")
                );
                itemDTOObservableList.add(itemDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearFields(){
        txtCode.clear();
        txtAreaDescription.clear();
        txtUnitPrice.clear();
        txtPackSize.clear();
        txtQtyOnHand.clear();
    }
}
