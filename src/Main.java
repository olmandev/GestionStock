import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        // Buttons for the options
        Object buttons[] = {"Create Product","Add Product","Sell Product"};

        while (true) {
            int option = JOptionPane.showOptionDialog(null, "Choose a option: ", "MENU", 0,
                    1, null, buttons, buttons[0]);

            if (option == 0) {
                store.addProduct(Product.createProduct());

            } else if (option == 1) {
                JOptionPane.showInputDialog(null, "Select the product to add more units: ", "PRODUCTS LIST",
                        1, null, store.getProducts().toArray(), null);
            }
            else {
                break;
            }
        }

    }
}
