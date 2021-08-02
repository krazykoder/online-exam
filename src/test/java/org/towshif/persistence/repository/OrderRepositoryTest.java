package org.towshif.persistence.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.towshif.persistence.model.Order;
import com.towshif.persistence.model.OrderLine;
import com.towshif.persistence.repository.OrderRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class OrderRepositoryTest {
	@Inject
	private OrderRepository repository;

	@Test
	@Transactional
	public void testFind_souldBeFindOne() {
		Order result = repository.find(1L);
		assertThat(result, notNullValue());
		assertThat(result.getId(), equalTo(1L));
		assertThat(result.getOrderLines(), notNullValue());
		assertThat(result.getOrderLines().isEmpty(), equalTo(false));
		double amount = 0.0;
		for (OrderLine orderLine : result.getOrderLines())
			amount += orderLine.getAmount();
		assertThat(result.getTotalAmount(), equalTo(amount));
	}

	@Test
	public void testFind_SouldBeFindAll() {
		List<Order> results = repository.findAll();
		assertThat(results, notNullValue());
		assertThat(results.size(), equalTo(2));
	}

}
