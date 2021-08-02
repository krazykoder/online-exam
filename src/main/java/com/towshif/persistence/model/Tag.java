package com.towshif.persistence.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.towshif.persistence.repository.TagRepository;

@Entity
public class Tag extends Model {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tagId;
	private String name;
	@ManyToMany
	@JoinTable(name = "product_tag", joinColumns = { @JoinColumn(name = "tagId") }, inverseJoinColumns = {
			@JoinColumn(name = "productId") })
	private List<Product> products;
	private Date createAt;
	private Date updateAt;
	static transient TagRepository repository;

// -- persistence methods --

	public static Tag find(long id) {
		return repository.find(id);
	}

	public static List<Tag> findAll() {
		return repository.findAll();
	}

	public Tag update() {
		repository.update(this);
		return this;
	}

	public Tag save() {
		repository.save(this);
		return this;
	}

// -- basic methods --

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (tagId == null) {
			if (other.tagId != null)
				return false;
		} else if (!tagId.equals(other.tagId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getName();
	}

// -- field accesor --

	public Long getId() {
		return tagId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tagId == null) ? 0 : tagId.hashCode());
		return result;
	}
}
