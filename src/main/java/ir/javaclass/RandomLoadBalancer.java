package ir.javaclass;

import java.util.Random;

public class RandomLoadBalancer implements LoadBalancer{

    private Random random;

    public RandomLoadBalancer(){
        random = new Random();
    }

    @Override
    public String getServerAddress() {
        int randomIndex = random.nextInt(ServerConfig.serverAddresses.size());
        return ServerConfig.serverAddresses.get(randomIndex);
    }
}
