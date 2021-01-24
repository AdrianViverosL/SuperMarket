/**
Main Class where the excution of the SuperMarket is going to happen
This Class has some methods to perform actions related with the sorting of the products, and 
display printed

Created by Adrian Viveros L.
January 2021
**/

import java.util.*;
import java.util.stream.Collectors;


public class Main{

	static void LoadProducts(ArrayList<Product> productsArray){
		productsArray.add(new Liquid("Agua", 22, 5.5));
		productsArray.add(new Liquid("Leche", 29, 1.5));
		productsArray.add(new Vegetable("Papa", 24, "kg"));
		productsArray.add(new Egg("Huevo", 27, 12));
		//productsArray.add(new Liquid("Coke", 34, 6.5));
	}


	static ArrayList<String> SortProducts(ArrayList<Product> productsArray){

		ArrayList<String> sortedArray = new ArrayList<String>();

		for (Product i : productsArray){
			sortedArray.add(i.name);
			//System.out.println(i.name);
		}

		Collections.sort(sortedArray);

		return(sortedArray);
	}

	static ArrayList<Product> SortByPriceProducts(ArrayList<Product> productsArray){

		ArrayList<Product> priceSortedArray = new ArrayList<Product>();

		for (Product i : productsArray){
			priceSortedArray.add(i);
			//System.out.println(i.name);
		}

		Collections.sort(priceSortedArray);

		return(priceSortedArray);
	}
/**
	public static ArrayList<Product> SortbyPrice(ArrayList<Product> products){
		ArrayList<Product> sorted = new ArrayList<Product>();
		sorted.add(products.get(0));
		for (int i = 1; i < sorted.size(); i++){
			int j = i;
			while(j > 0 && products.get(i).compareTo(sorted.get(j - 1)) < 0){
				sorted.set(j , sorted.get(j - 1));
				j--;
			}
			sorted.set(j , products.get(i));
		}
		return sorted;
	}
**/

	static void PrintSectioner(){
		System.out.println("================================");
	}
	public static void main(String[] args){

		ArrayList<Product> pArray = new ArrayList<Product>();
		LoadProducts(pArray);

		ArrayList<String> namesArray = SortProducts(pArray);

		PrintSectioner();
		System.out.println("Todos los productos:");
		PrintSectioner();
		for (String i : namesArray){
			for(Product j : pArray){
				if ( i == j.name){
					System.out.println(j);
					//System.out.println(" - Nombre: " + i + " /// Precio: $" + j.price);
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
		List<Product> under25 = pArray
							.stream()
							.filter(x -> x.price <= 25)
							.collect(Collectors.toList());

		//System.out.println(under25);
		under25.forEach(System.out::println);

		PrintSectioner();
		ArrayList<Product> priceArray = SortByPriceProducts(pArray);
		System.out.println("Producto más barato: " + priceArray.get(0).name);
		System.out.println("Producto más caro: " + priceArray.get(pArray.size() - 1).name);
		
	}
}
