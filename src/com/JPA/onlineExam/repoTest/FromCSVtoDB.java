
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

import com.JPA.onlineExam.model.Customer;
import com.opencsv.bean.CsvToBeanBuilder;

public class FromCSVtoDB {

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