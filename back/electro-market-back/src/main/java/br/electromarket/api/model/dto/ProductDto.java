package br.electromarket.api.model.dto;

import br.electromarket.api.model.Product;

public record ProductDto(Long id, String name, String description,
						 Integer priceInCents, String imageFileName) {

	public ProductDto(Product product) {
		this(product.getId(), product.getName(), product.getDescription(), product.getPriceInCents(),
				product.getImageFileName());
	}
}
