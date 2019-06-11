package Discount;

import java.util.Random;

public class Discounts {
    private double discountPercent;
    private int discountAmount;
    private int rand;

    public Discounts() {
         rand = (int) (Math.random()*50+1);
         setDiscountPercent(rand);
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }


    public void setDiscountAmount(int discountAmount) {

        this.discountAmount = (int) (discountAmount*(getDiscountPercent()/100));

    }

    @Override
    public String toString() {
        return "Discounts{" +
                "discountPercent=" + discountPercent +
                ", discountAmount=" + discountAmount +
                '}';
    }
}
