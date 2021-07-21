package service.impl;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CustomerRepository;
import service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {

        customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }

    @Override
    public void edit(Customer customer) {
        customerRepository.edit(customer);
    }
}
