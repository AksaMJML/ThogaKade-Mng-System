package service;

import javafx.collections.ObservableList;
import model.dto.ItemDTO;

public interface ItemService {
    void addItem(ItemDTO itemDTO);
    void updateItem(ItemDTO itemDTO);
    void deleteItem(String code);
    ObservableList<ItemDTO> getAllItems();
}
