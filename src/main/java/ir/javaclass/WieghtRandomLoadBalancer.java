package ir.javaclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class WieghtRandomLoadBalancer implements LoadBalancer {
    private final Random random = new Random();

    @Override
    public String getServerAddress() {
        List<String> allServerAddress = new ArrayList<>();
        ServerPoolConfig.serverAddresses.keySet().forEach(item ->
                IntStream.range(0, ServerPoolConfig.serverAddresses.get(item)).forEach(index -> {
                            allServerAddress.add(item);
                        }
                ));
        return allServerAddress.get(random.nextInt(allServerAddress.size()));
    }
}
