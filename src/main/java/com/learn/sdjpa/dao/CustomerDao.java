package com.learn.sdjpa.dao;

import com.learn.sdjpa.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerDao extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);

    @Query(value = "select c.* from customer c where c.test->>'myLast'=:LAST", nativeQuery = true)
    List<Customer> findByJsonbLastName(@Param("LAST") String lastName);
}
