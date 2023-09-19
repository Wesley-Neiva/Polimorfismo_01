package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
				
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i<=n; i++) {
			System.out.print("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(ch == 'c') {
			list.add(new Product(name, price));
			
			}else if(ch == 'i') {
				System.out.print("Customs fee:");
				double customs = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customs));
						
			}else if(ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate manufacture = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new UsedProduct(name, price, manufacture));
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		
		for(Product emp: list) {
			System.out.println(emp.toString());
		}
		sc.close();
	}

}
