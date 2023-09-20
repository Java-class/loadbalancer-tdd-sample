package ir.javaclass;

import java.util.Random;

public class RandomLoadBalancer implements LoadBalancer {

    private final Random random;

    public RandomLoadBalancer() {
        random = new Random();
    }

    @Override
    public String getServerAddress() {
        int randomIndex = random.nextInt(ServerPoolConfig.serverAddresses.size());
        return ServerPoolConfig.serverAddresses.keySet().stream().toList().get(randomIndex);
    }
}
