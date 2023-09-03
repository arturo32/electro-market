package br.electromarket.api.controller;

import br.electromarket.api.model.dto.ProductDto;
import br.electromarket.api.service.ProductService;
import jakarta.validation.Valid;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;

	@Autowired
	ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<ProductDto> save(@RequestPart MultipartFile imageFile,
			@Valid @RequestPart(name = "product") ProductDto productDto) {
		return ResponseEntity.ok(this.productService.convertToDto(this.productService.saveWithFile(productDto, imageFile)));
	}

	@GetMapping
	public ResponseEntity<Collection<ProductDto>> findAll(@RequestParam(required = false) Integer limit,
			@RequestParam(required = false) Integer page) {
		if(limit == null) limit = 1000;
		if(page == null) page = 0;
		return ResponseEntity.ok(this.productService.findAllWithFile(limit, page));
	}

	@GetMapping({"/{id}"})
	public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
		return ResponseEntity.ok(this.productService.convertToDto(this.productService.findById(id)));
	}

	@PutMapping
	public ResponseEntity<ProductDto> update(@RequestBody @Valid ProductDto dto) {
		return ResponseEntity.ok(this.productService.convertToDto(this.productService.update(dto)));
	}

	@DeleteMapping({"/{id}"})
	public ResponseEntity<ProductDto> remove(@PathVariable("id") Long id) {
		this.productService.update(id);
		return ResponseEntity.ok().build();
	}


}
