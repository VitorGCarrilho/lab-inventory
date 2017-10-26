package br.unisal.labinventory.labinventory.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Product {
	
	@Id
	@NotNull(message="Serial Number não deve ser vazio")
	@Size(max=10, min=6)
	@NotEmpty
	private String serialNumber;	
	
	@Size(max=50)
	@NotNull
	@NotEmpty
	private String productName;	
	
	@Size(max=50)
	private String productType;
	
	@Size(max=250)
	private String productDescription;
	
	@Size(max=50)
	private String wardrobe;
	
	@Size(max=50)
	private String tower;
	
	@Size(max=50)
	private String drawer;
	
	private boolean available;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getWardrobe() {
		return wardrobe;
	}

	public void setWardrobe(String wardrobe) {
		this.wardrobe = wardrobe;
	}

	public String getTower() {
		return tower;
	}

	public void setTower(String tower) {
		this.tower = tower;
	}

	public String getDrawer() {
		return drawer;
	}

	public void setDrawer(String drawer) {
		this.drawer = drawer;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
}
