package com.towshif.persistence.model;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.towshif.persistence.repository.CategoryRepository;
import com.towshif.persistence.repository.OrderRepository;
import com.towshif.persistence.repository.ProductRepository;
import com.towshif.persistence.repository.TagRepository;

@Named
public class RepositoryInjector {
	@Inject
	private CategoryRepository categoryRepository;

	@Inject
	private OrderRepository orderRepository;

	@Inject
	private ProductRepository productRepository;

	@Inject
	private TagRepository tagRepository;

	@PostConstruct
	public void inject() {
		Category.repository = categoryRepository;
		Order.repository = orderRepository;
		Product.repository = productRepository;
		Tag.repository = tagRepository;
	}
}
