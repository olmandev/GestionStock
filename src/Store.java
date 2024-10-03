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

    public void sellProduct(String productName, int quantity) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                if (product.getQuantityStock() >= quantity) {
                    product.updateStock(quantity);
                    JOptionPane.showMessageDialog(null,quantity + " Units of " + productName +
                            " has been sold","PRODUCT SOLD",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Error, there isn't stock of " +
                            productName,"ERROR",0);
                }
                return;
            }
        }
    }
    public void showStock(){
        for (Product product : products)
            product.showDetails();
    }
}
