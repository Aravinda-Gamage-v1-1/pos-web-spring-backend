package lk.ijse.backend.util;

import java.util.UUID;

public class AppUtil {
    public static String createCustomerId(){
        System.out.println("save customer7");
        String id = "Customer-"+ UUID.randomUUID();
        System.out.println("hi");
        return id;
    }
}
