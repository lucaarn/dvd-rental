package de.pdbm;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NamedQuery(name = "Customer.all", query = "select c from Customer c")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @NotNull
    @Column(name = "store_id")
    private Integer storeId;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    private String email;

    @NotNull
    @Column(name = "address_id")
    private Integer addressId;

    @NotNull
    @Column(name = "activebool")
    private Boolean activeBool;

    @NotNull
    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    private Integer active;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", storeId=" + storeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", addressId=" + addressId +
                ", activeBool=" + activeBool +
                ", createDate=" + createDate +
                ", lastUpdate=" + lastUpdate +
                ", active=" + active +
                '}';
    }

    //getter and setter
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Boolean getActiveBool() {
        return activeBool;
    }

    public void setActiveBool(Boolean activeBool) {
        this.activeBool = activeBool;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
