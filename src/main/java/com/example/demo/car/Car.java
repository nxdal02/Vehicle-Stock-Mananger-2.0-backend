package com.example.demo.car;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table
public class Car {
	
	@Id
	@SequenceGenerator(name = "car_sequence", sequenceName = "car_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_sequence")
	private Long id;
	
	private String make, model, bodyType;
	private int seats, price;
	
	@Lob
	private byte[] image;
	
	public Car() {
	}
	
	public Car(String make, String model, String bodyType, int seats, int price) {
		
		this.make = make;
		this.model = model;
		this.bodyType = bodyType;
		this.seats = seats;
		this.price = price;
	}
	
	
    // Allows storing and image for each car
	public Car(byte[] image, String make, String model, String bodyType, int seats, int price) {
		
		this.image = image;
		this.make = make;
		this.model = model;
		this.bodyType = bodyType;
		this.seats = seats;
		this.price = price;
	}
	
	// Constructor with table generated ID
	public Car(Long id, byte[] image, String make, String model, String bodyType, int seats, int price) {
		
		this.id = id;
		this.image = image;
		this.make = make;
		this.model = model;
		this.bodyType = bodyType;
		this.seats = seats;
		this.price = price;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	public byte[] getImage() {
		return image;
	}
	
	
	public void setImage(byte[] image) {
		this.image = image;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getBodyType() {
		return bodyType;
	}


	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}


	public int getSeats() {
		return seats;
	}


	public void setSeats(int seats) {
		this.seats = seats;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model +  ", bodyType=" + bodyType + ", seats=" + seats + ", price=" + price + "]";
	}
	
}
