package za.co.carols_boutique.dao.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.co.carols_boutique.EmployeeBE.IDAOEmployee.DAOEmp;
import za.co.carols_boutique.EmployeeBE.IDAOEmployee.DaoEmpImp;
import za.co.carols_boutique.models.Employee;


public class EmployeeDAOTest {
	//Create default constructor employee and test the setter methods.
	
	DAOEmp emp;
	
	public EmployeeDAOTest() {
		this.emp = new DaoEmpImp();
	}
	
	@Test
	void testAddEmployee() {
		assertTrue(emp.addEmployee(new Employee("empoyeeTest1", "TestName", "TestSurname", "TestPass", false)));
	}
	
	Employee employee = null;
	
	@Test
	void testGetEmployee() {
		employee = emp.getEmployee("empoyeeTest1", "TestPass");
		assertNotNull(employee);
	}
	
	@Test
	void testUpdateEmployee() {
		assertTrue(emp.updateEmployee(employee));
	}
	
	@Test
	void checkNotMannager() {
		assertFalse(employee.getIsManager());
	}
	
	@Test
	void testPromoteToManager(){
		assertTrue(emp.promoteToManager("empoyeeTest1"));
	}
	
	@Test
	void checkIsMannager() {
		assertTrue(employee.getIsManager());
	}
	
	@Test 
	void testDeleteEmployee() {
		assertTrue(emp.deleteEmployee("empoyeeTest1"));
	}
}
