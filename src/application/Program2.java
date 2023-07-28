package application;

import java.util.Arrays;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao department = DaoFactory.createDepartment();
		
//		System.out.println("===== TEST 1  department insert =====");
//		Department dep = new Department(0, "Foods");
//		department.insert(dep);
//		System.out.println("Department Inserted!");


//		System.out.println("===== TEST 2  department update =====");
//		department.update(new Department(3, "Styles"));
//		System.out.println("Department updated!");
	
	
//		System.out.println("===== TEST 3  department delete =====");
//		department.deleteById(10);
//		System.out.println("Department deleted!");
	
	
//		System.out.println("===== TEST 4  department findfById =====");
//		Department dep = department.findById(1);
//		
//		System.out.println(dep);
//	
	
		System.out.println("===== TEST 5  department findAll =====");
		List<Department> dep2 = department.findAll();
		System.out.println(dep2);
	
	
	
	
	}
}
