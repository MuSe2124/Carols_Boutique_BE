package za.co.carols_boutique.StoreBE.IDAOStore;

import za.co.carols_boutique.models.Employee;
import za.co.carols_boutique.models.Product;
import za.co.carols_boutique.models.Sale;
import za.co.carols_boutique.models.Store;

public interface DAOStore {
    
 Boolean addStore(Store store);
	//Boolean addEmployeeToStore(Employee employee);

	Boolean addSale(Sale sale);

	Store getStore(String storeID, String password);

	Boolean deleteStore(String storeID);
	//Boolean deleteEmployeeFromStore(String employeeID);

	Boolean updateTotal(String storeID);
}
