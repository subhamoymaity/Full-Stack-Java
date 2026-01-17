package com.subhamoy.tsvprocessor.repo;

import com.subhamoy.tsvprocessor.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
   List<Offer> findBySkuID(String skuID); // Retrieves offers by skuID
}
