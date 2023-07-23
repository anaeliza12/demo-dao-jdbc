package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {

		Department d = new Department(1, "Books");

		Seller s = new Seller(1, "Ana ", "anaeliza@gmail.com", new Date(), 3000.0);
		
		System.out.println(s);
	}

}
