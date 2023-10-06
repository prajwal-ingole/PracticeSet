
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
interface Displayable {
    void display();
}
class Product implements Displayable {
    private int productId;
    private String productName;
    private double price;

    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
    public void display() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }
}

class CartItem implements Displayable {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void display() {
        System.out.println("Product Name: " + product.getProductName());
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: $" + (product.getPrice() * quantity));
    }
}

class Cart {
    List<CartItem> cartItems = new ArrayList<>();

    public void addCartItem(CartItem item) {
        cartItems.add(item);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }
}

public class Q7{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Add Item to Cart");
            System.out.println("2. Calculate Total Price");
            System.out.println("3. Display Cart Items");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter product price: $");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    Product product = new Product(productId, productName, price);
                    CartItem cartItem = new CartItem(product, quantity);
                    cart.addCartItem(cartItem);
                    System.out.println("Item added to the cart.");
                    break;
                case 2:
                    double totalPrice = cart.calculateTotalPrice();
                    System.out.println("Total Price of Items in Cart: $" + totalPrice);
                    break;
                case 3:
                    System.out.println("Cart Items:");
                    for (CartItem item : cart.cartItems) {
                        item.display();
                        System.out.println("-----------------------");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}