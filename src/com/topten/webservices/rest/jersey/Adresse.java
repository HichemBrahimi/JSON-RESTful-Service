package com.topten.webservices.rest.jersey;

public class Adresse{
	
	private String Typeofaddress;
	private String City;
	private String Country;
	private String AddressLine;
	public String getTypeofaddress() {
		return Typeofaddress;
	}
	public void setTypeofaddress(String typeofaddress) {
		Typeofaddress = typeofaddress;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getAddressLine() {
		return AddressLine;
	}
	public void setAddressLine(String addressLine) {
		AddressLine = addressLine;
	}
	
	
}