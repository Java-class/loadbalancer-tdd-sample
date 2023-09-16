import ir.javaclass.LoadBalancer;
import ir.javaclass.RandomLoadBalancer;
import ir.javaclass.RoundRobinLoadBalancer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoadBalancerTest {

    private LoadBalancer roundRoubingLoadBalancer;

    private LoadBalancer randomLoadBalancer;

    @Before
    public void init() {
        roundRoubingLoadBalancer = new RoundRobinLoadBalancer();
        randomLoadBalancer = new RandomLoadBalancer();
    }

    @Test
    public void getServerAddressNotNull(){
        //when
        String serverAddress = roundRoubingLoadBalancer.getServerAddress();

        //then
        Assert.assertNotNull(serverAddress);
    }

    @Test
    public void getServerAddressTwiceButDifferent(){
        //when
        String serverAddress1 = roundRoubingLoadBalancer.getServerAddress();
        String serverAddress2 = roundRoubingLoadBalancer.getServerAddress();

        //then
        Assert.assertNotEquals(serverAddress1, serverAddress2);

    }


    @Test
    public void getServerAddressByRoundRobinPolicy(){
        //when
        String serverAddress1 = roundRoubingLoadBalancer.getServerAddress();
        System.out.println("Address1: " + serverAddress1);
        String serverAddress2 = roundRoubingLoadBalancer.getServerAddress();
        System.out.println("Address2: " + serverAddress2);
        String serverAddress3 = roundRoubingLoadBalancer.getServerAddress();
        System.out.println("Address3: " + serverAddress3);
        String serverAddress4 = roundRoubingLoadBalancer.getServerAddress();
        System.out.println("Address4: " + serverAddress4);
        String serverAddress5 =  roundRoubingLoadBalancer.getServerAddress();
        System.out.println("Address5: " + serverAddress5);
        String serverAddress6 =  roundRoubingLoadBalancer.getServerAddress();
        System.out.println("Address6: " + serverAddress6);

        //then
        Assert.assertEquals(serverAddress1, serverAddress4);
        Assert.assertEquals(serverAddress2, serverAddress5);
        Assert.assertEquals(serverAddress3, serverAddress6);
    }

    @Test
    public void getServerAddressByRandomPolicy(){
        //when
        String serverAddress1 = randomLoadBalancer.getServerAddress();
        System.out.println("Address1: " + serverAddress1);
        String serverAddress2 = randomLoadBalancer.getServerAddress();
        System.out.println("Address2: " + serverAddress2);

        //then
        Assert.assertNotNull(serverAddress1, serverAddress2);
    }
}
