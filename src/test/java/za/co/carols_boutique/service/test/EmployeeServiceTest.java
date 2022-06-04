package za.co.carols_boutique.service.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import za.co.carols_boutique.EmployeeBE.IDAOEmployee.DAOEmp;
import za.co.carols_boutique.EmployeeBE.IDAOEmployee.DaoEmpImp;
import za.co.carols_boutique.EmployeeBE.ServiceEmployee.EmpService;
import za.co.carols_boutique.EmployeeBE.ServiceEmployee.EmpServiceImp;
import za.co.carols_boutique.models.Employee;

public class EmployeeServiceTest {
	
	DAOEmp dao;
	EmpService service;
	Employee employee;

	public EmployeeServiceTest() {
		this.service = new EmpServiceImp();
		this.dao = new DaoEmpImp();
	}

	@Test
	void testAddEmployee() {
		employee = new Employee("empoyeeTest1", "TestName", "TestSurname", "TestPass", false);
		assertNotNull(service.register(employee));
	}

	@Test
	void testGetEmployee() {
		String response = service.login("empoyeeTest1", "TestPass", "TestStoreID");
		employee = dao.getEmployee("empoyeeTest1", "TestPass", "TestStoreID");
		assertNotNull(response);
	}

	@Test
	void testUpdateEmployee() {
		employee = new Employee("empoyeeTest1", "TestName2", "TestSurname2", "TestPass2", false);
		assertNotNull(service.updateEmployee(employee));
	}

	@Test
	void checkNotMannager() {
		assertFalse(employee.getIsManager());
	}

	@Test
	void testPromoteToManager() {
		assertNotNull(service.promoteToManager("empoyeeTest1"));
	}

	@Test
	void checkIsMannager() {
		assertTrue(employee.getIsManager());
	}

	@Test
	void testDeleteEmployee() {
		assertNotNull(service.deleteEmployee("empoyeeTest1"));
	}

	@Test
	void testAddEmployeeSuccess() {
		employee = new Employee("empoyeeTest1", "TestName", "TestSurname", "TestPass", false);
		assertTrue(service.register(employee).equals("Welcome " + employee.getName() + ", you have logged in successfully."));
	}

	@Test
	void testGetEmployeeSuccess() {
		String response = service.login("empoyeeTest1", "TestPass", "Store");
		employee = dao.getEmployee("empoyeeTest1", "TestPass", "Store");
		assertTrue(response.equals("Welcome " + employee.getName() + ", you have logged in successfully."));
	}

	@Test
	void testUpdateEmployeeSuccess() {
		employee = new Employee("TestName2", "TestSurname2", "TestPass2", "Store", false);
		assertTrue(service.updateEmployee(employee).equals("Employee updated successfully"));
	}

	@Test
	void testDeleteEmployeeSuccess() {
		assertTrue(service.deleteEmployee("empoyeeTest1").equals("Employee deleted successfully."));
	}

	@Test
	void testAddEmployeeFail() {
		employee = new Employee("empoyeeTest1", "TestName", "TestSurname", "TestPass", false);
		assertTrue(service.register(null).equals("Failed to register employee, please try again."));
	}

	@Test
	void testGetEmployeeFail() {
		String response = service.login(null, null, null);
		employee = dao.getEmployee(null, null, null);
		assertTrue(response.equals("Failed to log in, employee ID or password incorrect. Please try again."));
	}

	@Test
	void testUpdateEmployeeFail() {
		assertTrue(service.updateEmployee(null).equals("Failed to update employee, please try again."));
	}

	@Test
	void testDeleteEmployeeFail() {
		assertTrue(service.deleteEmployee(null).equals("Failed to delete employee, please try again."));
	}
}
