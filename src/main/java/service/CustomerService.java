package service;

import model.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void addCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String id);
    List<CustomerDTO> getAll();
}
