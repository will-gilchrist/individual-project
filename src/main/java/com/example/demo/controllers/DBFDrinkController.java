package com.example.demo.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.Beverages;
import com.example.demo.repo.DrinkRepo;

@RestController
@CrossOrigin("*")
public class DBFDrinkController {
	
	@Autowired
	private DrinkRepo repo;
	
//	@PostMapping("/addbeer/{name}/{price}/{type}/{colour}/{rating}/{location}")
//	public String SaveData(@PathVariable String name,
//						   @PathVariable float price,
//						   @PathVariable String type,
//						   @PathVariable int colour,
//						   @PathVariable int rating,
//						   @PathVariable String location) {
//		Beverages ref = new Beverages();
//		ref.setName(name);
//		ref.setPrice(price);
//		ref.setType(type);
//		ref.setColour(colour);
//		ref.setRating(rating);
//		ref.setLocation(location);
//		repo.save(ref);
//		
//		return "Data saved";
//	}
	
	@PostMapping("/addbeer")
	public Beverages addBeverage(@RequestBody Beverages beverages) {
		return repo.saveAndFlush(beverages);
	}
	
	@GetMapping("/findall")
	public ArrayList<Beverages> FindAll(){
		return repo.findAll();
	}
	
	@GetMapping("/findbyname/{name}")
	public ArrayList<Beverages> FindByName(@PathVariable String name){
		return repo.findByName(name);
	}
	
	@GetMapping("/pricelessthan/{p}")
	public ArrayList<Beverages> FindByPriceLessThan(@PathVariable float p){
		return repo.findByPriceLessThan(p);
	}
	
	@GetMapping("/ratingover/{r}")
	public ArrayList<Beverages> RatingOver(@PathVariable int r){
		return repo.findByRatingGreaterThanEqual(r);
	}
	
	@GetMapping("/findbytype/{type}")
	public ArrayList<Beverages> FindByType(@PathVariable String type){
		return repo.findByType(type);
	}
	
	@GetMapping("/orderbyprice")
	public ArrayList<Beverages> OrderByPrice(){
		return repo.findAllByOrderByPriceAsc();
	}
	
	@GetMapping("/orderbyname")
	public ArrayList<Beverages> OrderByName(){
		return repo.findAllByOrderByNameAsc();
	}

}
