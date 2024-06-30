package br.electromarket.api;

import br.electromarket.api.model.Product;
import br.electromarket.api.model.dto.ProductDto;
import br.electromarket.api.repository.ProductRepository;
import br.electromarket.api.service.FileSystemStorageService;
import br.electromarket.api.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@Mock
	ProductRepository productRepository;

	@Mock
	FileSystemStorageService fileSystemStorageService;

	@InjectMocks
	ProductService productService;

	Product product;
	final MultipartFile mockFile = mock(MockMultipartFile.class);

	@BeforeEach
	void setup() {
		product = new Product();
		product.setId(1L);
		product.setName("test");
		product.setDescription("test");
		product.setPriceInCents(1);
		product.setImageFileName("test.png");
	}


	@Test
	void saveProductSuccess() {
		this.productService.saveWithFile(new ProductDto(product), mockFile);
	}

	@Test
	void saveProductInvalidPrice() {
		product.setPriceInCents(-4);
		Exception ex = assertThrows(RuntimeException.class, ()->
			this.productService.saveWithFile(new ProductDto(product), mockFile)
		);
		assertEquals(ex.getMessage(), "Error: negative price.");

		product.setPriceInCents(1000000000);
		ex = assertThrows(RuntimeException.class, ()->
				this.productService.saveWithFile(new ProductDto(product), mockFile)
		);
		assertEquals(ex.getMessage(), "Error: price is above $100,000.");

	}
}
