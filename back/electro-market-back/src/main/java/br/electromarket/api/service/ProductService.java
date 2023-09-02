package br.electromarket.api.service;

import br.electromarket.api.model.Product;
import br.electromarket.api.model.dto.ProductDto;
import br.electromarket.api.repository.ProductRepository;
import br.electromarket.base.respository.GenericRepository;
import br.electromarket.base.service.GenericService;
import br.electromarket.base.service.PersistenceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericService<Product, ProductDto, Long> {

	private final ProductRepository productRepository;

	@Autowired
	ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ProductDto convertToDto(Product entity) {
		return null;
	}

	@Override
	public Product convertToEntity(ProductDto productDto) {
		return null;
	}

	@Override
	protected void validatePersistenceType(PersistenceType persistenceType, ProductDto productDto) {

	}

	@Override
	protected void validate(ProductDto productDto) {

	}

	@Override
	protected GenericRepository<Product, Long> repository() {
		return this.productRepository;
	}
}
