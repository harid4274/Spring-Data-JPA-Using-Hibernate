package com.hari.springdata.customer.repos;

import org.springframework.data.repository.CrudRepository;

import com.hari.springdata.customer.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
