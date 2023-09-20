package ir.javaclass;

import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinLoadBalancer implements LoadBalancer{
    private final AtomicInteger position = new AtomicInteger(0);

    public String getServerAddress() {
        String result = null;
        synchronized (position) {
            if (position.get() > ServerPoolConfig.serverAddresses.size() - 1) {
                position.set(0);
            }
            result = ServerPoolConfig.serverAddresses.keySet().stream().toList().get(position.getAndIncrement());
        }
        return result;
    }

}
