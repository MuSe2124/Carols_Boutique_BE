package za.co.carols_boutique.dao.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.co.carols_boutique.EmployeeBE.IDAOEmployee.DaoEmpImp;
import za.co.carols_boutique.models.Employee;


public class EmployeeDAOTest {
	
	DaoEmpImp emp;

	public EmployeeDAOTest() {
		this.emp = new DaoEmpImp();
	}

	@Test
	void testAddEmployee() {
		assertTrue(emp.addEmployee(new Employee("empoyeeTestID1", "EmployeeTestName", "EmployeeTestSurname", "EmployeeTestPass", "TestStoreID", false)));
	}

	Employee employee = null;

	@Test
	void testGetEmployee() {
		employee = emp.getEmployee("empoyeeTestID1", "TestPass", "TestStoreID");
		assertNotNull(employee);
	}

	@Test
	void testUpdateEmployee() {
		employee.setName("TestName2");
		assertTrue(emp.updateEmployee(employee));
	}

	@Test
	void checkNotMannager() {
		assertFalse(employee.getIsManager());
	}

	@Test
	void testPromoteToManager() {
		assertTrue(emp.promoteToManager("empoyeeTestID1"));
	}

	@Test
	void checkIsMannager() {
		assertTrue(employee.getIsManager());
	}

	@Test
	void testDeleteEmployee() {
		assertTrue(emp.deleteEmployee("empoyeeTestID1"));
	}
}
