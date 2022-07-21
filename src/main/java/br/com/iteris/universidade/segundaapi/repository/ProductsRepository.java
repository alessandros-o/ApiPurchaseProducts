package br.com.iteris.universidade.segundaapi.repository;

import br.com.iteris.universidade.segundaapi.domain.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {
    public Page<Product> findByIsDiscontinued(boolean IsDiscontinued, Pageable pageable);
}
