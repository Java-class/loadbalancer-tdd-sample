package ir.javaclass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerConfig {
    public static final List<String> serverAddresses = new ArrayList<>();

    static {
        serverAddresses.add("192.168.1.1");
        serverAddresses.add("192.168.1.2");
        serverAddresses.add("192.168.1.3");
    }
}
