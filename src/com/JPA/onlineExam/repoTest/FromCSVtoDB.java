
package com.JPA.onlineExam.repoTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.JPA.onlineExam.modeltest.Customer;
import com.JPA.onlineExam.repositorytest.CustomerRepository;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class FromCSVtoDB {
	@Autowired
	CustomerRepository repository;

	public CustomerRepository getRepository() {
		return repository;
	}

	public void setRepository(CustomerRepository repository) {
		this.repository = repository;
	}

	// Crontoller caller function 
	public void CreateData() throws IOException {
		List<Customer> customerList = CSVtoCustomerObject();
		customerList.forEach(x -> repository.save(x));
//		custlist1.forEach(x -> em.persist(x));
//		customerList.forEach(x -> em.merge(x));

	}

	// read the data from a CSV file 
	public List<Customer> CSVtoCustomerObject() throws IOException {

		String fileName = "data/customerDBSample.csv";
		URL url = getClass().getClassLoader().getResource(fileName);
		File file = new File(url.getPath());

		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Customer> beans = new CsvToBeanBuilder(new FileReader(file)).withType(Customer.class).build().parse();

		beans.forEach(System.out::println);

		return beans;
	}

	@Test
	// Local test functions with primitive entityManager 
	public void CreateUpdateData() throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<Customer> customerList = CSVtoCustomerObject();
//		custlist1.forEach(x -> em.persist(x));
		customerList.forEach(x -> em.merge(x));
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

	public void readDb() {

	}

	public void deleteDB() {

	}

	public void updateDB() {

	}

}