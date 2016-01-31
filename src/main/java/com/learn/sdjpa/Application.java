package com.learn.sdjpa;

import com.learn.sdjpa.dao.CustomerDao;
import com.learn.sdjpa.domain.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class Application {

    @SuppressWarnings("unused")
	private static void prepareTable() throws Exception {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://192.168.1.91:5432/postgres");
        ds.setUsername("postgres");
        ds.setPassword("welcome");
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate( "CREATE TABLE customer ( firstName varchar(50), lastName varchar(50), test JSONB )" );
        stmt.close();
        conn.close();
    }

    public static void main(String[] args) throws Exception {

        // prepareTable();

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(DataProvider.class);

        CustomerDao repository = context.getBean(CustomerDao.class);

        // save a couple of customers
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));

        // fetch all customers
        Iterable<Customer> customers = repository.findAll();
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer by ID
        Customer customer = repository.findOne(61L);
        System.out.println("Customer found with findOne(61L):");
        System.out.println("--------------------------------");
        System.out.println(customer);
        System.out.println();

        // fetch customers by last name
        List<Customer> bauers = repository.findByLastName("Bauer");
        System.out.println("Customer found with findByLastName('Bauer'):");
        System.out.println("--------------------------------------------");
        for (Customer bauer : bauers) {
            System.out.println(bauer);
        }

        context.close();
    }
}
