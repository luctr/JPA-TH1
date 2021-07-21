package repository.impl;

import model.Customer;
import repository.CustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(int id) {
        String sql = "select * from  customer where id =" + id;
        TypedQuery<Customer> query = (TypedQuery<Customer>) em.createNativeQuery(sql, Customer.class);
        return query.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() != null){
            em.merge(customer);
        }else {
            em.persist(customer);
        }

    }

    @Override
    public void remove(int id) {
        Customer customer = findById(id);
        if (customer != null){
            em.remove(customer);
        }
    }

    @Override
    public void edit(Customer customer) {
        em.merge(customer);
    }
}
