import javax.swing.*;

public class Product {
    // Atributs
    private String name;
    private double price;
    private int quantityStock;

    // Method builder
    public Product(String name, double price, int quantityStock){
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    // Method to create new product
    public static Product createProduct() {
        String nameProduct = JOptionPane.showInputDialog("Chosse the name of the product: ");
        double priceProduct = 0;
        int quantityProduct = 0;

        // Loop for validate the input of the price
        while (true) {
            try {
                priceProduct = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of the product: " + nameProduct));
                if (priceProduct <= 0) {
                    JOptionPane.showMessageDialog(null, "Warning: The price of the product cannot be " +
                            "less than or equal to zero...", "WARNING", JOptionPane.WARNING_MESSAGE);
                } else {
                    break; // Valid price, we get out of the loop
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: The price of the product should be a number.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Loop for validate the input of the quantity
        while (true) {
            try {
                quantityProduct = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity of the product: " + nameProduct));
                if (quantityProduct <= 0) {
                    JOptionPane.showMessageDialog(null, "Warning: The quantity of the product cannot be " +
                            "less than or equal to zero...", "WARNING", JOptionPane.WARNING_MESSAGE);
                } else {
                    break; // Valid quantity, we get out of the loop
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: The quantity of the product should be a number.",
                        "ERROR", JOptionPane.ERROR);
            }
        }
        return new Product(nameProduct, priceProduct, quantityProduct);
    }

    // Methods Getters
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantityStock(){
        return quantityStock;
    }

    // Method for show the products
    public void showDetails(){
        JOptionPane.showMessageDialog(null,"PRODUCT\t PRICE\t STOCK\t " +
                "\n" + name + "\t" + price + "\t" + quantityStock);
    }

    // Method for update the stock when a product be sold
    public void updateStock(int quantitySold){
        quantityStock -= quantitySold;
    }

    public double aplyDiscount(double percentage){
        return (price * percentage / 100);
    }
}
