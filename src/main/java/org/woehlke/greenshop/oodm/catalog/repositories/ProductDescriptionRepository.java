package org.woehlke.greenshop.oodm.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.catalog.entities.ProductDescription;
import org.woehlke.greenshop.oodm.catalog.entities.ProductDescriptionId;

public interface ProductDescriptionRepository extends 
	JpaRepository<ProductDescription,ProductDescriptionId> {
	
}
