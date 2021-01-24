/**
Product Class that is used to instance/create Product Objects of different types, as Liquids, Vegetables, and Eggs
**/

import java.util.*;

class Product implements Comparable<Product>{
	protected String name;
	protected int price;

	@Override
	public int compareTo(Product o){
		int comparePrice =((Product)o).price;
		return this.price - comparePrice;

	}

}

class Liquid extends Product{
	double totalAvailable;

	public Liquid(String pName, int pPrice, double pTotalAvailable){
		name = pName;
		price = pPrice;
		totalAvailable = pTotalAvailable;
	}

	@Override
	public String toString(){
		return String.format(" - Nombre: " + name + " /// Litros: "+ totalAvailable + " /// Precio: $" + price);
	}
}

class Vegetable extends Product{
	String unitMeasure; 

	public Vegetable(String pName, int pPrice, String unit){
		name = pName;
		price = pPrice;
		unitMeasure = unit;
	}

	@Override
	public String toString(){
		return String.format(" - Nombre: " + name + " /// Precio: $" + price + " /// Unidad de venta: "+ unitMeasure);
	}
}

class Egg extends Product{
	int pkgContent; 

	public Egg(String pName, int pPrice, int pContent){
		name = pName;
		price = pPrice;
		pkgContent = pContent;
	}

	@Override
	public String toString(){
		return String.format(" - Nombre: " + name + " /// Contenido: "+ pkgContent + " piezas" + " /// Precio: $" + price);
	}
}