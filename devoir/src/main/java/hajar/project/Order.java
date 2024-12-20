package hajar.project;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    int id;
    String date;
    float amount;
    int customerId;

}
