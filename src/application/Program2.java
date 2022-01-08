package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TESTE 1: department insert");
		Department newDep = new Department(null, "Cars");
		departmentDao.insert(newDep);
		System.out.println("Id inserted!");
		

	}

}
