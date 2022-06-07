package com.hari.springdata.customer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hari.springdata.customer.entities.Customer;
import com.hari.springdata.customer.repos.CustomerRepository;

@SpringBootTest
class CustomerdataApplicationTests {

	@Autowired
	CustomerRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("Raja");
		customer.setEmail("Raja@gmail.com");
		repository.save(customer);

		Customer customer1 = new Customer();
		customer1.setId(2);
		customer1.setName("Ravi");
		customer1.setEmail("ravi@gmail.com");
		repository.save(customer1);

		assertNotNull(customer);
	}

	@Test
	public void testRead() {
		Customer customer = repository.findById(1).get();
		assertNotNull(customer);
		assertEquals("Raja", customer.getName());
	}

	@Test
	public void testUpdate() {
		Customer customer = repository.findById(1).get();
		customer.setEmail("raja@gmail.com");
		repository.save(customer);

		assertEquals("raja@gmail.com", customer.getEmail());
	}

	@Test
	public void testDelete() {
		if (repository.existsById(2)) {
			repository.deleteById(2);
		}
	}
	
	@Test
	public void testCount() {
			long count = repository.count();
			System.out.println("Test Count : "+count);
	}
	

}
