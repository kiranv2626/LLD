package inventory;

public class Invoice {
    int totalPrice=100;
    int totalTax=50;
    int amountWithTax=150;
    public void generateInvoice(Order order){
        System.out.println("Invoice generated");
        System.out.println("Total Price: "+totalPrice);
        System.out.println("Total Tax: "+totalTax);
        System.out.println("Amount with Tax: "+amountWithTax);
    }



    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(int totalTax) {
        this.totalTax = totalTax;
    }

    public int getAmountWithTax() {
        return amountWithTax;
    }

    public void setAmountWithTax(int amountWithTax) {
        this.amountWithTax = amountWithTax;
    }
}
