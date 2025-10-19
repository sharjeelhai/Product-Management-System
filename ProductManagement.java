
import java.util.ArrayList;
import java.util.Scanner;


class Product {
    int id;
    String name;
    double price;
    String quantity; 

  
    Product(int id, String name, double price, String quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("------------------------");
    }
}

// Main Product Management class
public class ProductManagement {
    ArrayList<Product> products = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    // Add product
    void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = input.nextInt();
        input.nextLine(); 

        System.out.print("Enter Product Name: ");
        String name = input.nextLine();

        System.out.print("Enter Product Price: ");
        double price = input.nextDouble();
        input.nextLine(); 

        System.out.print("Enter Product Quantity : ");
        String quantity = input.nextLine();

        products.add(new Product(id, name, price, quantity));
        System.out.println("Product added successfully!\n");
    }

    // View all products
    void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.\n");
            return;
        }

        System.out.println("===== Product List =====");
        for (Product p : products) {
            p.display();
        }
    }

    void searchProduct() {
        if (products.isEmpty()) {
            System.out.println("No products to search.\n");
            return;
        }

        System.out.print("Enter Product ID to search: ");
        int searchId = input.nextInt();

        boolean found = false;
        for (Product p : products) {
            if (p.id == searchId) {
                System.out.println("Product Found:");
                p.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found.\n");
        }
    }

 
    void removeProduct() {
        if (products.isEmpty()) {
            System.out.println("No products to remove.\n");
            return;
        }

        System.out.print("Enter Product ID to remove: ");
        int removeId = input.nextInt();

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).id == removeId) {
                products.remove(i);
                System.out.println("Product removed successfully.\n");
                return;
            }
        }

        System.out.println("Product ID not found.\n");
    }

   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductManagement manager = new ProductManagement();
        int choice;

        do {
            System.out.println("===== Product Management System =====");
             System.out.println("===== Welcome to OrgaTaste =====");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product");
            System.out.println("4. Remove Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1 -> manager.addProduct();
                case 2 -> manager.viewProducts();
                case 3 -> manager.searchProduct();
                case 4 -> manager.removeProduct();
                case 5 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice! Try again.\n");
            }

        } while (choice != 5);
    }
}
