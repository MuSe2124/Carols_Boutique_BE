package za.co.carols_boutique.dao.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import za.co.carols_boutique.StoreBE.IDAOStore.DAOStore;
import za.co.carols_boutique.models.Store;

public class StoreDAOTest {

	DAOStore dao;
	Store store;

	public StoreDAOTest() {
		this.dao = null;
		this.store = new Store("TestStoreID", "TestStoreName", "TestStoreLocation", "TestStorePassword");
	}

	@Test
	void testNotGetStore() {
		assertNull(dao.getStore("TestStoreID", "TestStorePassword"));
	}

	@Test
	void testAddStore() {
		assertTrue(dao.addStore(store));
	}

	@Test
	void testGetStore() {
		assertNotNull(dao.getStore("TestStoreID", "TestStorePassword"));
	}

	@Test
	void testDeleteStore() {
		assertTrue(dao.deleteStore("TestStoreID"));
	}
}
