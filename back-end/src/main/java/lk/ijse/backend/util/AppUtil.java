package lk.ijse.backend.util;

import java.util.UUID;

public class AppUtil {
    public static String createNoteId(){
        return "NOTE-"+ UUID.randomUUID();
    }
}
