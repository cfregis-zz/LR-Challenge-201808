package br.com.liferay.challenge.general.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.liferay.challenge.products.repository.ProductRepository;

@Component
public class DeletionHelper {
	
	@Autowired
	public ProductRepository productRepository;
	

	public void deleteAll(){
		productRepository.deleteAll();
	}
	
}
