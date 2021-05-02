package ee.taltech.iti0200.cakeorder;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bakery {
    @SerializedName("order_id")
    int orderID;
    Double total = null;
    List<Cake> cakes;

    public int getOrderId() {
        return orderID;
    }

    public void setOrderId(int orderID) {
        this.orderID = orderID;
    }

    public void processCakes() {
        for (Cake cake : cakes) {
            cake.generateCake_id();
        }
    }

    public void makeDairyFree() {
        for (Cake cake : cakes) {
            cake.makeDairyFree();
        }
    }

    public void countTotalSum() {
        double totalSum = 0D;
        for (Cake cake : cakes) {
            totalSum += cake.calculatePrice();
        }
        this.total = totalSum;
    }

    public void removeBBDOver() {
        List<Cake> cakesToRemove = new ArrayList<>();
        for (Cake cake : cakes) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDateTime now = LocalDateTime.now();
                Date currentDate = simpleDateFormat.parse(dtf.format(now));
                Date bbDate = simpleDateFormat.parse(cake.getBBD());
                if (currentDate.compareTo(bbDate) >= 0) {
                    cakesToRemove.add(cake);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        cakes.removeAll(cakesToRemove);
    }
}
