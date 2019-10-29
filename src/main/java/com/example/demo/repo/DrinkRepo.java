package com.example.demo.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.Beverages;

@Repository
public interface DrinkRepo extends JpaRepository<Beverages, String>{
	
	public ArrayList<Beverages> findAll();
	public ArrayList<Beverages> findByName(String S);
	public ArrayList<Beverages> findByPriceLessThan(float p);
	public ArrayList<Beverages> findByRatingGreaterThanEqual(int r);
	public ArrayList<Beverages> findByType(String S);
	public ArrayList<Beverages> findAllByOrderByPriceAsc();
	public ArrayList<Beverages> findAllByOrderByNameAsc();
	
}
