package plus.xiexie.util;

import java.util.UUID;

public class IDUtil {

    public static String generateCommonID() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
