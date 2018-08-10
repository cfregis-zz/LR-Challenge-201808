package br.com.liferay.challenge.products.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.liferay.challenge.products.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

}

