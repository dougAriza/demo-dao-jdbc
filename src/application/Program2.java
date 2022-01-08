package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department department = null;
		
		System.out.println("=== TESTE 1: department insert");
//		Department newDep = new Department(null, "Cars");
//		departmentDao.insert(newDep);
		System.out.println("Id inserted!");
		
		System.out.println("\n=== TESTE 2: department findById");
		department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n=== TESTE : department update");
		department = departmentDao.findById(6);
		department.setName("Motocicles");
		departmentDao.update(department);
		System.out.println("Id updated");
		
	}

}
