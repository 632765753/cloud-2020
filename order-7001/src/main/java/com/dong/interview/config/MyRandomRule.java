package com.dong.interview.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

public class MyRandomRule extends AbstractLoadBalancerRule {

    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    public Server choose(ILoadBalancer lb,Object key) {
        List<Server> allServers = lb.getAllServers();
        Random random=new Random();
        int i = random.nextInt(allServers.size());
        return allServers.get(i);
    }

    public Server choose(Object key) {
        return choose(getLoadBalancer(),key);
    }
}
