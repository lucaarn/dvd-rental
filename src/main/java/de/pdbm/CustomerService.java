package de.pdbm;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

@RequestScoped
public class CustomerService {
    @PersistenceContext
    EntityManager em;

    public List<Customer> getAllCustomers(int start, int amount) {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.all", Customer.class);
        query.setFirstResult(start);
        query.setMaxResults(amount);
        return query.getResultList();
    }

    public Customer getCustomer(Integer id) {
        return em.find(Customer.class, id);
    }

    @Transactional
    public void saveCustomer(Customer customer) {
        em.persist(customer);
    }

    @Transactional
    public boolean putCustomer(Integer id, Customer newCustomer) {
        Customer customer = em.find(Customer.class, id);
        if (customer == null) {
            return false;
        }

        customer.setFirstName(newCustomer.getFirstName());
        customer.setLastName(newCustomer.getLastName());
        em.merge(customer);
        return true;
    }

    @Transactional
    public boolean patchCustomer(Integer id, Customer newCustomer) {
        Customer customer = em.find(Customer.class, id);
        if (customer == null) {
            return false;
        }

        if (newCustomer.getFirstName() != null) {
            customer.setFirstName(newCustomer.getFirstName());
        }
        if (newCustomer.getLastName() != null) {
            customer.setLastName(newCustomer.getLastName());
        }
        return true;
    }

    @Transactional
    public boolean deleteCustomer(Integer id) {
        Customer customer = em.find(Customer.class, id);
        if (customer == null) {
            return false;
        }

        em.remove(customer);
        return true;
    }
}
