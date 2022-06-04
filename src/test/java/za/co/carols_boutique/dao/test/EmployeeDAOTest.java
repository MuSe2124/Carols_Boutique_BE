package za.co.carols_boutique.dao.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.co.carols_boutique.EmployeeBE.IDAOEmployee.DaoEmpImp;
import za.co.carols_boutique.StoreBE.IDAOStore.DAOStoreImp;
import za.co.carols_boutique.models.Employee;
import za.co.carols_boutique.models.Store;


public class EmployeeDAOTest {

	DaoEmpImp emp;
	Store store;

	public EmployeeDAOTest() {
		this.emp = new DaoEmpImp();
		this.store = new Store("Store", "StoreName", "Location", "Password");
	}

	@Test
	void testAddEmployee() {
		sImp = new DAOStoreImp();
		sImp.addStore(store);
		assertTrue(emp.addEmployee(new Employee("empoyeeTestID1", "EmployeeTestName", "EmployeeTestSurname", "EmployeeTestPass", "Store", false)));
	}

	Employee employee = null;

	DAOStoreImp sImp;

	@Test
	void testGetEmployee() {
		employee = emp.getEmployee("empoyeeTestID1", "EmployeeTestPass", "Store");
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
		sImp.deleteStore(store.getId());
	}
}
