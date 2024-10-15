package lk.ijse.backend.util;

import java.time.LocalDateTime;
import java.util.UUID;

public class AppUtil {
    public static LocalDateTime getCurrentDateTime() { return LocalDateTime.now(); }
    public static String createCustomerId(){ return "Customer-"+ UUID.randomUUID().toString(); }
    public static String createItemId(){ return "Item-"+ UUID.randomUUID().toString(); }
    public static String createOrderId(){ return "Order-"+ UUID.randomUUID().toString(); }
}
