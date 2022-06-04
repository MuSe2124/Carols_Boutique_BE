package za.co.carols_boutique.service.test;

import za.co.carols_boutique.dao.test.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import za.co.carols_boutique.StoreBE.IDAOStore.DAOStore;
import za.co.carols_boutique.StoreBE.ServiceStore.StoreServiceImp;
import za.co.carols_boutique.models.Store;

public class StoreServiceTest {
	
	StoreServiceImp dao;
	Store store;

	public StoreServiceTest() {
		this.dao = new StoreServiceImp();
		this.store = new Store("TestStoreID", "TestStoreName", "TestStoreLocation", "TestStorePassword");
	}

	@Test
	void testGetStore() {
		assertNotNull(dao.loginStore("TestStoreID", "TestStorePassword"));
	}

	@Test
	void testGetStoreSuccess() {
		assertTrue(dao.loginStore("TestStoreID", "TestStorePassword").equals(store.getName() + " had been logged in successfully."));
	}

	@Test
	void testAddStore() {
		assertNotNull(dao.registerStore(store));
	}

	@Test
	void testAddStoreSuccess() {
		assertNotNull(dao.registerStore(store));
	}

	@Test
	void testDeleteStore() {
		assertNotNull(dao.deleteStore("TestStoreID"));
	}

	@Test
	void testDeleteStoreSuccess() {
		assertTrue(dao.deleteStore("TestStoreID").equals("Store deleted successfully."));
	}
}
