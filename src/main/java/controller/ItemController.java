package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.ItemDTO;

import java.sql.*;

public class ItemController {

    public ObservableList<ItemDTO> getAllItems(){
        ObservableList<ItemDTO> itemDTOObservableList = FXCollections.observableArrayList();

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
        return itemDTOObservableList;
    }
}
