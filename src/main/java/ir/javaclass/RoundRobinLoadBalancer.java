package ir.javaclass;

import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinLoadBalancer implements LoadBalancer{
    private AtomicInteger position = new AtomicInteger(0);

    public String getServerAddress() {
        if(position.get() > ServerConfig.serverAddresses.size()-1){
            position.set(0);
        }
        String serverAddress = ServerConfig.serverAddresses.get(position.getAndIncrement());
        return serverAddress;
    }

}
