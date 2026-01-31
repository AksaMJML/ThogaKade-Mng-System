package service;

import javafx.collections.ObservableList;
import model.dto.ItemDTO;

public interface ItemService {
    void addItem(String code, String description, String packSize, double unitPrice, int qtyOnHand);
    void updateItem(String code, String description, String packSize, double unitPrice, int qtyOnHand);
    void deleteItem(String code);
    ObservableList<ItemDTO> getAllItems();
}
