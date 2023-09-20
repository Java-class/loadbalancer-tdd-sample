import ir.javaclass.LoadBalancer;
import ir.javaclass.RandomLoadBalancer;
import ir.javaclass.RoundRobinLoadBalancer;
import ir.javaclass.WieghtRoundRobinLoadBalancer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoadBalancerTest {

    private LoadBalancer roundRoubingLoadBalancer;

    private LoadBalancer randomLoadBalancer;

    private LoadBalancer weigthRandomLoadBalancer;

    private LoadBalancer weightRoundRobbinLoadBalancer;

    @Before
    public void init() {
        roundRoubingLoadBalancer = new RoundRobinLoadBalancer();
        randomLoadBalancer = new RandomLoadBalancer();
        weigthRandomLoadBalancer = new RandomLoadBalancer();
        weightRoundRobbinLoadBalancer = new WieghtRoundRobinLoadBalancer();
    }


    /// add server address method and tests.

    @Test
    public void getServerAddressNotNull() {
        //when
        String serverAddress = roundRoubingLoadBalancer.getServerAddress();

        //then
        assertNotNull(serverAddress);

    }

    @Test
    public void getServerAddressTwiceButDifferent() {
        //when
        String serverAddress1 = roundRoubingLoadBalancer.getServerAddress();
        String serverAddress2 = roundRoubingLoadBalancer.getServerAddress();

        //then
        Assert.assertNotEquals(serverAddress1, serverAddress2);

    }


    @Test
    public void getServerAddressByRoundRobinPolicy() {
        //when
        String serverAddress1 = roundRoubingLoadBalancer.getServerAddress();
        String serverAddress2 = roundRoubingLoadBalancer.getServerAddress();
        String serverAddress3 = roundRoubingLoadBalancer.getServerAddress();
        String serverAddress4 = roundRoubingLoadBalancer.getServerAddress();
        String serverAddress5 = roundRoubingLoadBalancer.getServerAddress();
        String serverAddress6 = roundRoubingLoadBalancer.getServerAddress();
        String serverAddress7 = roundRoubingLoadBalancer.getServerAddress();
        String serverAddress8 = roundRoubingLoadBalancer.getServerAddress();
        String serverAddress9 = roundRoubingLoadBalancer.getServerAddress();
        String serverAddress10 = roundRoubingLoadBalancer.getServerAddress();

        //then
        Assert.assertEquals(serverAddress1, serverAddress6);
        Assert.assertEquals(serverAddress2, serverAddress7);
        Assert.assertEquals(serverAddress3, serverAddress8);
        Assert.assertEquals(serverAddress4, serverAddress9);
        Assert.assertEquals(serverAddress5, serverAddress10);
    }

    @Test
    public void getServerAddressByRandomPolicy() {
        //when
        String serverAddress1 = randomLoadBalancer.getServerAddress();
        System.out.println("Address1: " + serverAddress1);
        String serverAddress2 = randomLoadBalancer.getServerAddress();
        System.out.println("Address2: " + serverAddress2);

        //then
        Assert.assertNotNull(serverAddress1, serverAddress2);
    }

    @Test
    public void testWeightRandom() {
        String serverAddress1 = weigthRandomLoadBalancer.getServerAddress();
        assertNotNull(serverAddress1);
        String serverAddress2 = weigthRandomLoadBalancer.getServerAddress();
        assertNotNull(serverAddress2);
    }

    @Test
    public void testWeightRoundRobbin() {
        String serverAddress1 = weightRoundRobbinLoadBalancer.getServerAddress();
        assertNotNull(serverAddress1);
    }
}
