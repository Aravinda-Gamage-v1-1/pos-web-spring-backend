package lk.ijse.backend.util;

import java.util.UUID;

public class AppUtil {
    public static String createCustomerId(){
        String id = "Customer-"+ UUID.randomUUID();
        return id;
    }
}
