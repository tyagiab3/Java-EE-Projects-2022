package com.practice.pojo;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "customers")
@XmlRootElement
public class Customers {
	private int customer_id;
	private String first_name;
	private String last_name;
	private String phone;
	private String email;
	private String street;
	private String city;
	private String state;
	private String zip_code;

	public Customers() {

	}

	public Customers(int customer_id, String first_name, String last_name, String phone, String email,
			String street, String city, String state, String zip_code) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.email = email;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	@Override
	public String toString() {
		return "Customers [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", phone=" + phone + ", email=" + email + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", zip_code=" + zip_code + "]\n";
	}
}
