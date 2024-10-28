package de.pdbm.address;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@RequestScoped
public class AddressService {
    @PersistenceContext
    EntityManager em;

    public List<Address> getAllAddresses(int start, int amount) {
        TypedQuery<Address> query = em.createNamedQuery("Address.all", Address.class);
        query.setFirstResult(start);
        query.setMaxResults(amount);
        return query.getResultList();
    }

    public Address getAddress(Integer id) {
        return em.find(Address.class, id);
    }
}
