package com.learn.e04.nio2;

public class Tablet {
	
	private String tabletName;
	private String manufacturer;
	private String manufactureDate;
	private String expiryDate;
	
	public String getTabletName() {
		return tabletName;
	}
	public void setTabletName(String tabletName) {
		this.tabletName = tabletName;
	}
	public Tablet(String tabletName, String manufacturer, String manufactureDate, String expiryDate) {
		this.tabletName = tabletName;
		this.manufacturer = manufacturer;
		this.manufactureDate = manufactureDate;
		this.expiryDate = expiryDate;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "Tablet [tabletName=" + tabletName + ", manufacturer=" + manufacturer + ", manufactureDate="
				+ manufactureDate + ", expiryDate=" + expiryDate + "]";
	}
	
	

}
