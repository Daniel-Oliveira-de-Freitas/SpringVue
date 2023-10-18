package com.SpringCrud.SpringVue.service;

import com.SpringCrud.SpringVue.DTO.CustomerDTO;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomers();

    String updateCustomer(CustomerDTO customerDTO);

    String deleteCustomer(int id);
}
