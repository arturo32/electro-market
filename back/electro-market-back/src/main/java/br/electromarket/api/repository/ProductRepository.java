package br.electromarket.api.repository;

import br.electromarket.api.model.Product;
import br.electromarket.base.respository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends GenericRepository<Product, Long> {
}
