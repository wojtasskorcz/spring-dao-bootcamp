package pl.edu.agh.bd.bootcamp.generation;

public interface DataGenerator {
	void generateCustomers(int n, int nDemographics);

	void generateShippers(int size);

	void generateOrders(int size);

	void generateCategories(int size);

	void generateProducts(int size);

	void generateSuppliers(int size);

	void generateEmployees(int size);

	void generateTerritoriesAndRegions(int size);

	void generateCustomerDemographics(int size);

	void generateDatabase(double scalingFactor);
}
