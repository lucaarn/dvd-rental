package de.pdbm.customer;

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

        customer.setStoreId(newCustomer.getStoreId());
        customer.setFirstName(newCustomer.getFirstName());
        customer.setLastName(newCustomer.getLastName());
        customer.setEmail(newCustomer.getEmail());
        //customer.setAddressId(newCustomer.getAddressId());
        customer.setActiveBool(newCustomer.getActiveBool());
        customer.setCreateDate(newCustomer.getCreateDate());
        customer.setLastUpdate(newCustomer.getLastUpdate());
        customer.setActive(newCustomer.getActive());

        return true;
    }

    @Transactional
    public boolean patchCustomer(Integer id, Customer newCustomer) {
        Customer customer = em.find(Customer.class, id);
        if (customer == null) {
            return false;
        }

        if (newCustomer.getStoreId() != null) {
            customer.setStoreId(newCustomer.getStoreId());
        }
        if (newCustomer.getFirstName() != null) {
            customer.setFirstName(newCustomer.getFirstName());
        }
        if (newCustomer.getLastName() != null) {
            customer.setLastName(newCustomer.getLastName());
        }
        if (newCustomer.getEmail() != null) {
            customer.setEmail(newCustomer.getEmail());
        }
        /*
        if (newCustomer.getAddressId() != null) {
            customer.setAddressId(newCustomer.getAddressId());
        }
         */
        if (newCustomer.getActiveBool() != null) {
            customer.setActiveBool(newCustomer.getActiveBool());
        }
        if (newCustomer.getCreateDate() != null) {
            customer.setCreateDate(newCustomer.getCreateDate());
        }
        if (newCustomer.getLastUpdate() != null) {
            customer.setLastUpdate(newCustomer.getLastUpdate());
        }
        if (newCustomer.getActive() != null) {
            customer.setActive(newCustomer.getActive());
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
