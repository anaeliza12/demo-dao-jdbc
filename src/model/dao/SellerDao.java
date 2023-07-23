package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {
	
	public void insert(Seller department);

	public void update(Seller department);

	public void deleteById(Integer id);

	public Seller findById(Integer id);

	public List<Seller> findAll();


}
