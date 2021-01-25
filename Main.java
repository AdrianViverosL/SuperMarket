/**
Main Class where the excution of the SuperMarket is going to happen
This Class has some methods to perform actions related with the products sorting, and 
console display

More details below. 

Created by Adrian Viveros L.
January 2021
**/

import java.util.*;
import java.util.stream.Collectors;


public class Main{

	static void LoadProducts(ArrayList<Product> productsArray){
		//This method is used to load products in an ArrayList to made them available
		productsArray.add(new Liquid("Agua", 22, 5.5));
		productsArray.add(new Liquid("Leche", 29, 1.5));
		productsArray.add(new Vegetable("Papa", 24, "kg"));
		productsArray.add(new Egg("Huevo", 27, 12));
		//productsArray.add(new Liquid("Coke", 34, 6.5));
	}


	static ArrayList<String> SortProducts(ArrayList<Product> productsArray){
		//This method sort products in alphabetically way
		ArrayList<String> sortedArray = new ArrayList<String>();

		for (Product i : productsArray){
			sortedArray.add(i.name);
		}

		Collections.sort(sortedArray);

		return(sortedArray);
	}

	static ArrayList<Product> SortByPriceProducts(ArrayList<Product> productsArray){
		//This method sorts products by its price, generates a top of them on an ArrayList
		ArrayList<Product> priceSortedArray = new ArrayList<Product>();

		for (Product i : productsArray){
			priceSortedArray.add(i);
		}

		Collections.sort(priceSortedArray);

		return(priceSortedArray);
	}

	static void PrintSectioner(){
		//Just for format
		System.out.println("================================");
	}
	public static void main(String[] args){

		ArrayList<Product> pArray = new ArrayList<Product>();  //This Array will contain all the objects loaded
		LoadProducts(pArray);

		ArrayList<String> namesArray = SortProducts(pArray);	//This Array stores the Strings for all the objects names

		PrintSectioner();
		System.out.println("Todos los productos:");
		PrintSectioner();
		for (String i : namesArray){	//Matches Names array with its objects
			for(Product j : pArray){	//to print it into the console.
				if ( i == j.name){
					System.out.println(j);
				}
			}
		}

		PrintSectioner();
		System.out.println("Productos de precio menor a $25:");
		PrintSectioner();
/**
		for (String i : namesArray){
			for(Product j : pArray){
				if ( i == j.name){
					if (j.price < 25){
						System.out.println(j);
					}
					//System.out.println(" - Nombre: " + i + " /// Precio: $" + j.price);
				}
			}
		}**/
		//int aSize = pArray.size();

		//Filter products under $25 using Stream
		List<Product> under25 = pArray
							.stream()
							.filter(x -> x.price <= 25)
							.collect(Collectors.toList());

		under25.forEach(System.out::println);

		PrintSectioner();
		ArrayList<Product> priceArray = SortByPriceProducts(pArray); //This array will store the products sorted by its price
		System.out.println("Producto más barato: " + priceArray.get(pArray.size() - 1).name);
		System.out.println("Producto más caro: " + priceArray.get(0).name);
		
	}
}
