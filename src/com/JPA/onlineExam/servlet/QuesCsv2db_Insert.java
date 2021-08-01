package com.JPA.onlineExam.servlet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.JPA.onlineExam.entity.Question;
import com.JPA.onlineExam.entity.QuestionTemp;
import com.opencsv.bean.CsvToBeanBuilder;

public class QuesCsv2db_Insert {

	public List<QuestionTemp> DatacsvToclass(String filepath) throws IllegalStateException, FileNotFoundException {

		List<QuestionTemp> Queslist = new CsvToBeanBuilder(new FileReader(filepath)).withType(QuestionTemp.class)
				.build().parse();

//		beans.forEach(System.out::println);

		return Queslist;

	}

	public List<Question> DataDetails() throws IllegalStateException, FileNotFoundException {
		// String filename =
		// "D:\\Workspace\\online_exam\\src\\com\\JPA\\onlineExam\\entity\\MCQDBSample1.csv";
		String filename = "data/MCQDBSample1.csv";

		ClassLoader classloader = getClass().getClassLoader();
		String filePath = classloader.getResource(filename).getPath();
		System.out.println(filePath);
		return DataDetails(filePath);

	}

	// @Test
	public List<Question> DataDetails(String filepath) throws IllegalStateException, FileNotFoundException {
		// System.out.println(filepath);
		List<QuestionTemp> queslist = DatacsvToclass(filepath);

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
	public void importTodb(EntityManager em) throws IllegalStateException, FileNotFoundException {

		// use persistence.xml configuration

//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<Question> queslist1 = this.DataDetails();
		queslist1.forEach(x -> em.merge(x));
		em.getTransaction().commit();
//		em.close();
//		emf.close();

	}

}
