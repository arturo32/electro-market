package br.electromarket.api.service;

import br.electromarket.api.model.Product;
import br.electromarket.api.model.dto.ProductDto;
import br.electromarket.api.repository.ProductRepository;
import br.electromarket.base.respository.GenericRepository;
import br.electromarket.base.service.GenericService;
import br.electromarket.base.service.PersistenceType;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService extends GenericService<Product, ProductDto, Long> {

	private final ProductRepository productRepository;

	private final FileSystemStorageService fileSystemStorageService;

	@Autowired
	ProductService(ProductRepository productRepository, FileSystemStorageService fileSystemStorageService) {
		this.productRepository = productRepository;
		this.fileSystemStorageService = fileSystemStorageService;
	}

	public Product saveWithFile(ProductDto productDto, MultipartFile multipartFile) {
		validate(productDto);
		fileSystemStorageService.store(multipartFile);
		Product product = convertToEntity(productDto);
		product.setImageFileName(multipartFile.getOriginalFilename());

		return this.productRepository.save(product);
	}

	@Override
	public ProductDto convertToDto(Product product) {
		return new ProductDto(product);
	}

	@Override
	public Product convertToEntity(ProductDto productDto) {
		Product product = new Product();
		product.setId(productDto.id());
		product.setName(productDto.name());
		product.setDescription(productDto.description());
		product.setPriceInCents(productDto.priceInCents());
		product.setImageFileName(productDto.imageFileName());
		return product;
	}

	@Override
	protected void validatePersistenceType(PersistenceType persistenceType, ProductDto productDto) {
		if(persistenceType.equals(PersistenceType.UPDATE)) {
			if(productDto.id() == null) {
				throw new RuntimeException("Product cannot be updated without ID!");
			}
			Optional<Product> productOptional = productRepository.findById(productDto.id());
			if(productOptional.isEmpty()) {
				throw new RuntimeException("Product not found!");
			}
		}
	}

	@Override
	protected void validate(ProductDto productDto) {

	}

	@Override
	protected GenericRepository<Product, Long> repository() {
		return this.productRepository;
	}
}
