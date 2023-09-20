package ir.javaclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class WieghtRoundRobinLoadBalancer implements LoadBalancer {
    private final Random random = new Random();
    private final AtomicInteger position = new AtomicInteger(0);

    @Override
    public String getServerAddress() {
        String result = null;
        List<String> allServerAddress = new ArrayList<>();
        ServerPoolConfig.serverAddresses.keySet().forEach(item ->
                IntStream.range(0, ServerPoolConfig.serverAddresses.get(item)).forEach(index -> {
                            allServerAddress.add(item);
                        }
                ));
        synchronized (position) {
            if (position.get() > allServerAddress.size() - 1) {
                position.set(0);
            }
            result = allServerAddress.get(position.getAndIncrement());
        }
        return result;
    }
}
