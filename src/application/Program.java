package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		 
		System.out.println("\n ==== TEST 1: seller findById====");
		Seller seller = sellerDao.findById(2);
		  System.out.println(seller);
		  
		  System.out.println("\n ==== TEST 2: seller findByDepartment ====");
		  Department dep = new Department(2, null);
//		  List<Seller> list = sellerDao.findByDepartment(dep);
//		  
//		  for(Seller s : list) {
//			  System.out.println(s);
//		  }
//		  
		  System.out.println("\n ==== TEST 3: seller findAll ====");
		  
		  for (Seller sellers : sellerDao.findAll()) {
			  System.out.println(sellers);
		  }
		  
		  
		
}
}
