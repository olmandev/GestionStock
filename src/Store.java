import javax.swing.*;
import java.util.ArrayList;

public class Store {
    // Atributs
    ArrayList<Product> products = new ArrayList<>();
    
    // Methods
    public void addProduct(Product product){
        products.add(product);
    }
    public int sizeArray(){
        return products.size();
    }

    public ArrayList<String> getProducts() {
        ArrayList<String> productsList = new ArrayList<>();
        for (Product i : products ){
            productsList.add(i.getName());
        }
        return productsList;
    }

    public void sellProduct(Object productName, int quantity, boolean discount) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                if (product.getQuantityStock() >= quantity) {
                    product.updateStock(true, quantity);

                    double subtotal = product.getPrice() * quantity;
                    double totalPay;
                    double totalDiscount = 0;
                    if (discount){
                        double percentageDiscount = Double.parseDouble(JOptionPane.showInputDialog("Enter the percentage of the discount: "));
                        totalDiscount = product.aplyDiscount(percentageDiscount) * quantity;
                        totalPay = (product.getPrice() * quantity) - totalDiscount;
                    }
                    else {
                        totalPay = subtotal;
                    }
                    //JOptionPane.showMessageDialog(null,"The total to pay is $." + totalPay);
                    JOptionPane.showMessageDialog(null,quantity + " Units of " + productName +
                            "\nsubTotal: $." + subtotal + "\nDiscount: $." + totalDiscount + "\nTotal: $." + totalPay,
                            "PRODUCT SOLD",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Error, there isn't enough stock of " +
                            productName,"ERROR",0);
                }
                return;
            }
        }
    }

    public void buyProduct() {
        Object selectedProduct = JOptionPane.showInputDialog(null, "Select the product to add more units: ",
                "PRODUCTS LIST",
                1, null, getProducts().toArray(), null);
        int unitsPurchased = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Enter the quantity of units purchased: "));

        for (Product producto : products) {
            if (selectedProduct.equals(producto.getName())) {
                producto.updateStock(false ,unitsPurchased);
            }
        }
    }

    public void showStock(Object nameProduct){
        for (Product product : products)
            if (nameProduct.equals(product.getName()))
                product.showDetails();
    }
}
