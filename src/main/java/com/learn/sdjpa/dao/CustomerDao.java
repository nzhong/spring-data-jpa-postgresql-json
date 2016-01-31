package com.learn.sdjpa.dao;

import com.learn.sdjpa.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerDao extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
