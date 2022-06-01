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
		assert (service.register(employee));
	}

	@Test
	void testGetEmployee() {
		String response = service.login("empoyeeTest1", "TestPass");
		employee = dao.getEmployee("empoyeeTest1", "TestPass");
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
}
