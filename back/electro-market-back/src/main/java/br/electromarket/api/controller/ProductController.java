package br.electromarket.api.controller;

import br.electromarket.api.model.Product;
import br.electromarket.api.model.dto.ProductDto;
import br.electromarket.api.service.ProductService;
import br.electromarket.base.controller.GenericController;
import br.electromarket.base.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController extends GenericController<Product, ProductDto, Long> {

	private final ProductService productService;

	@Autowired
	ProductController(ProductService productService) {
		this.productService = productService;
	}

	@Override
	protected GenericService<Product, ProductDto, Long> service() {
		return this.productService;
	}


}
