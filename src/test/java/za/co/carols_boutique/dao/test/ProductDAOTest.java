/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package za.co.carols_boutique.dao.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.co.carols_boutique.ProductBE.IDAOProduct.DAOProduct;
import za.co.carols_boutique.models.Product;

/**
 *
 * @author Mustafaa Osman
 */
public class ProductDAOTest {

	DAOProduct dao;

	public ProductDAOTest() {
		this.dao = null;
	}

	@Test
	void testGetProduct() {
		assertNull(dao.getProduct("TestProduct"));
	}

	Product product;

	@Test
	void testAddProduct() {
		product = new Product("TestProduct", "TestProductName", "Test product descriptiom", 50.00F);
		assertTrue(dao.addNewProduct(product));
	}

	@Test
	void testAddProductToInventory() { //Add store id and employeeID
		assertTrue(dao.addProductToInventory("", "TestProduct", "", 3));
	}

	@Test
	void testRemoveProductFromInventory() { //Add store id and employeeID
		assertTrue(dao.removeProductFromInventory("", "TestProduct", "", 3));
	}

	@Test
	void testDeleteProduct() {
		assertTrue(dao.deleteProduct("TestProduct"));
	}
}
