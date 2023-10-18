package com.SpringCrud.SpringVue.service;

import com.SpringCrud.SpringVue.DTO.CustomerDTO;
import com.SpringCrud.SpringVue.model.Customer;
import com.SpringCrud.SpringVue.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public String addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getName(),
                customerDTO.getEmail(),
                customerDTO.getPassword(),
                customerDTO.getAddress(),
                customerDTO.getMobile()
        );
        customerRepository.save(customer);
        return customer.toString();
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getCustomes = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for(Customer customer:getCustomes){
           CustomerDTO customerDTO = new CustomerDTO(
                   customer.getId(),
                   customer.getName(),
                   customer.getEmail(),
                   customer.getAddress(),
                   customer.getMobile()
           );
           customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) {
        if(customerRepository.existsById((int) customerDTO.getId())){
            Customer customer = customerRepository.getById((int) customerDTO.getId());
            customer.setName(customerDTO.getName());
            customer.setEmail(customerDTO.getEmail());
            customer.setPassword(customerDTO.getPassword());
            customer.setAddress(customerDTO.getAddress());
            customer.setMobile(customerDTO.getMobile());
            customerRepository.save(customer);
            return customer.toString();
        }else {
            System.out.println("Customer ID do not Exist");
        }
        return null;
    }

    @Override
    public String deleteCustomer(int id) {
        if (customerRepository.existsById((id))) {
            customerRepository.deleteById(id);
        } else {
            System.out.println("customer id not found");
        }

        return "Deletado";

    }
}
