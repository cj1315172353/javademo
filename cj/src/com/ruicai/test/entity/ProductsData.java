package com.ruicai.test.entity;

import java.util.ArrayList;
import java.util.List;

public class ProductsData {
	private int id;
	private String name;
	private int number;
	private double price;
	
	public ProductsData(int id, String name, int number, double price) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.price = price;
	}
	public ProductsData() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public static List<ProductsData> p=getProducts();
	public static List<ProductsData> getProducts(){
		List<ProductsData> products	=new ArrayList<ProductsData>();
		products.add(new ProductsData(1, "小米手机", 100, 1000));
		products.add(new ProductsData(2, "iPhone6", 200, 4000));
		products.add(new ProductsData(3, "小米机顶盒", 550, 150));
		products.add(new ProductsData(4, "中华小当家面包", 1000, 10));
		products.add(new ProductsData(5, "野生葫芦娃", 7, 10000));
		products.add(new ProductsData(6, "石头人皮肤", 1000, 100));
		products.add(new ProductsData(7, "越南新娘", 10, 100000));
	    return products;
	}
}	
	