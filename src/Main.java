import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        // Buttons for the options
        Object buttons[] = {"Create Product","Buy Product","Sell Product"};

        while (true) {
            int option = JOptionPane.showOptionDialog(null, "Choose a option: ", "MENU", 0,
                    1, null, buttons, buttons[0]);

            switch (option){
                case 0:
                    store.addProduct(Product.createProduct());
                    break;

                case 1:
                    store.buyProduct();
                    break;

                case 2:
                    String nameCustom = JOptionPane.showInputDialog("Enter the name of the custom please: ");
                    int ageCustom = Integer.parseInt(JOptionPane.showInputDialog(" Enter the age of the custom please: "));
                    boolean discount;
                    if (ageCustom >= 60){
                        discount = true;
                    }
                    else {
                        discount = false;
                    }

                    Object productToSell = JOptionPane.showInputDialog(null,"Chosse the product",
                            "PRODUCTS",1,null,store.getProducts().toArray(),null);

                    store.showStock(productToSell);

                    int quantityToSell = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Enter the quantity to sell: "));
                    store.sellProduct(productToSell,quantityToSell,discount);
            }
        }
    }
}
