package application;

import java.util.Date;
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
		List<Seller> list = sellerDao.findByDepartment(dep);

		for (Seller s : list) {
			System.out.println(s);
		}

		System.out.println("\n ==== TEST 3: seller findAll ====");

		for (Seller sellers : sellerDao.findAll()) {
			System.out.println(sellers);
		}

		System.out.println("\n ==== TEST 4: seller insert ====");

		seller = new Seller(null, "Flavia", "flavia@gmail.com", new Date(), 4900.0, dep);

		sellerDao.insert(seller);
		System.out.println("Inserted " + seller.getId());
		
		
		System.out.println("\n ==== TEST 5: seller update ====");
		sellerDao.update(new Seller(23, "Flavia Calina Da Silva", "flavia@gmail.com", new Date(), 4900.0, dep));

		System.out.println("\n ==== TEST 6: seller delete ====");
		sellerDao.deleteById(4);
		System.out.println("Seller deleted!");
	}
}
