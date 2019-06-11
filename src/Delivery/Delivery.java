package Delivery;

import Order.Order;
import User.UserControll;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Delivery {
    private Date date;
    private Order order;
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    public Delivery(Order order) {
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.MONTH, 1);
        date = c.getTime();
        this.order = order;
        deliveryInfo();

    }

    public void deliveryInfo() {
        System.out.println("Delivery information:");
        order.printInfoOfBuyingPoduct();
        System.out.println("cost : " + order.getFinalCost());
        System.out.println("delivery date : " + dateFormat.format(date));
        new UserControll().controlPage();

    }


}
