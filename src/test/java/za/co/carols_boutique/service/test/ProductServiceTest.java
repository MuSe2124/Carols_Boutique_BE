package za.co.carols_boutique.service.test;

import za.co.carols_boutique.dao.test.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import za.co.carols_boutique.ProductBE.ServiceProduct.ProdServiceImp;
import za.co.carols_boutique.StoreBE.IDAOStore.DAOStore;
import za.co.carols_boutique.models.Product;
import za.co.carols_boutique.models.Store;

public class ProductServiceTest {
	
//	ProdServiceImp service = new ProdServiceImp();
//
//	public ProductServiceTest() {
//	}
//
//	@Test
//	void testGetProduct() {
//		assertNotNull(service.getProduct("TestProduct"));
//	}
//
//	Product product;
//
//	@Test
//	void testAddProduct() {
//		product = new Product("TestProduct", "TestProductName", "Test product descriptiom", 50.00F);
//		assertNotNull(service.addNewProduct(product));
//	}
//
//	@Test
//	void testAddProductSuccess() {
//		product = new Product("TestProduct", "TestProductName", "Test product descriptiom", 50.00F);
//		assertTrue(service.addNewProduct(product).equals("New product added successfully."));
//	}
//
//	@Test
//	void testAddProductToInventory() {
//		assertNotNull(service.addProductToInventory("", "TestProduct", "", 3));
//	}
//
//	@Test
//	void testAddProductToInventorySuccess() { //Add store id and employeeID
//		assertTrue(service.addProductToInventory("", "TestProduct", "", 3).equals("Product added successfully"));
//	}
//
//	@Test
//	void testRemoveProductFromInventory() {
//		assertNotNull(service.removeProductFromInventory("", "TestProduct", "", 3));
//	}
//
//	@Test
//	void testRemoveProductFromInventorySuccess() { //Add store id and employeeID
//		assertTrue(service.removeProductFromInventory("", "TestProduct", "", 3).equals("Product removed successfully"));
//	}
//
//	@Test
//	void testDeleteProduct() {
//		assertNotNull(service.deleteProduct("TestProduct"));
//	}
//
//	@Test
//	void testDeleteProductSuccess() {
//		assertTrue(service.deleteProduct("TestProduct").equals("Product removed successfully"));
//	}
}
