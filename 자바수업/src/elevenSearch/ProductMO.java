package elevenSearch;

public class ProductMO {
	private String ProductName,ProductPrice,ProductImage,SellerNickDelivery,Delivery;
	
	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(String productPrice) {
		ProductPrice = productPrice;
	}

	public String getProductImage() {
		return ProductImage;
	}

	public void setProductImage(String productImage) {
		ProductImage = productImage;
	}

	public String getSellerNickDelivery() {
		return SellerNickDelivery;
	}

	public void setSellerNickDelivery(String sellerNickDelivery) {
		SellerNickDelivery = sellerNickDelivery;
	}

	public String getDelivery() {
		return Delivery;
	}

	public void setDelivery(String delivery) {
		Delivery = delivery;
	}

	@Override
	public String toString() {
		return ProductName;
	}
	public String info() {
		String result = "상품명 : " + ProductName +"\n" + "가격 : " + ProductPrice +"\n" + "판매처 : " +SellerNickDelivery +"\n" + "배달료 : " + Delivery;
		return result;
	}
	
	
	

}
