package product;


import java.util.ArrayList;

interface IProductMgr {
	ArrayList<Product> products = new ArrayList<Product>();
	
	public void add(Product p);
	public ArrayList<Product> searchAll();
	
	public Product searchByNo(int No);
	public ArrayList<Product> searchByName(String Name);
	
	public ArrayList<Product> searchTV() ;
	public ArrayList<Product> searchRefrigerator();
	
	public boolean changePrice(int No,int changePrice);
	public boolean delete(int No);
}
