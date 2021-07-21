package repository;

import model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void remove(int id);

    void edit(Customer customer);
}
