package com.JPA.onlineExam.DBTests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.JPA.onlineExam.entity.Question;
import com.JPA.onlineExam.entity.QuestionTemp;
import com.opencsv.bean.CsvToBeanBuilder;
import com.tow.libs.resourceManager;

public class Import_QuesCsv2DB {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<QuestionTemp> DatacsvToclass(String filename) throws IllegalStateException, FileNotFoundException {

		filename = "data/" + filename;
		
		// call file from resource manager
		resourceManager rm = new resourceManager();
		File fileobj = rm.getResourceFile(filename);

		List<QuestionTemp> Queslist = new CsvToBeanBuilder(new FileReader(fileobj)).withType(QuestionTemp.class).build()
				.parse();

//		beans.forEach(System.out::println);

		return Queslist;

	}

	public List<Question> DataDetails() throws IllegalStateException, FileNotFoundException {
		String filename = "MCQDBSample3.csv";
		return DataDetails(filename);

	}

	// @Test
	public List<Question> DataDetails(String fileName) throws IllegalStateException, FileNotFoundException {
		// System.out.println(filepath);
		List<QuestionTemp> queslist = DatacsvToclass(fileName);

		List<Question> queslist1 = new ArrayList<Question>();
		queslist1 = queslist.stream().map(cust -> {

			Question cust2 = new Question();

			cust2.setQuestion(cust.getQuestion());

			cust2.setChoice_1(cust.getChoice_1());
			cust2.setChoice_2(cust.getChoice_2());
			cust2.setChoice_3(cust.getChoice_3());
			cust2.setChoice_4(cust.getChoice_4());

			cust2.setAnswer(cust.getAnswer());

			return cust2;
		}).collect(Collectors.toList());

		return queslist1;
	}

	@Test
	public void importTodb() throws IllegalStateException, FileNotFoundException {

		// use persistence.xml configuration

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<Question> queslist1 = this.DataDetails();
//		System.out.println(queslist1);
		queslist1.forEach(x -> em.merge(x));
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

	public void importTodb(EntityManager em) throws IllegalStateException, FileNotFoundException {

		// use persistence.xml configuration

		em.getTransaction().begin();

		List<Question> queslist1 = this.DataDetails();
//		System.out.println(queslist1);
		queslist1.forEach(x -> em.merge(x));
		em.getTransaction().commit();

	}

}
