package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        for (int i = 1; i<=n; i++ ){
            System.out.println("Product "+ i +" data:");
            System.out.print("Comum, usado, importado (c/u/i)? ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if(type == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new UsedProduct(name,price,date));
            } else if (type == 'i') {
                System.out.print("Customs fee: ");
                double taxa = sc.nextDouble();
                list.add(new ImportedProduct(name,price,taxa));
            }else {
                list.add(new Product(name,price));
            }
        }
        System.out.println();
        for(Product prod : list){
            String tag = prod.priceTag();
            System.out.println(tag);
        }

        sc.close();
    }
}
