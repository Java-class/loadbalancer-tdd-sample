package ir.javaclass;

import java.util.HashMap;

public class ServerPoolConfig {
    public static final HashMap<String, Integer> serverAddresses = new HashMap<>();

    static {
        serverAddresses.put("192.168.1.1", 5);
        serverAddresses.put("192.168.1.2", 10);
        serverAddresses.put("192.168.1.3", 2);
        serverAddresses.put("192.168.1.4", 5);
        serverAddresses.put("192.168.1.5", 10);
    }
}
