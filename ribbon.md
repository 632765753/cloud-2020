##ribbon
    客户端的负载均衡工具
###负载均衡策略
    RoundRobinRule，RandomRule，RetryRule，ResponseTimeWeightedRule，WeightedResponseTimeRule，BestAvailableRule，PredicateBasedRule
    默认的负载均衡侧率是轮训；假如有轮训到的机器刚好宕机了，而且还没有从注册中心的服务列表中删除，调用就会报错。
    如果宕机了并且从注册中心的列表中删除了，那么调用的时候就不会调用到这个宕机的服务，等到这个服务重新启动起来，
    再次注册到注册中心后，又可以继续调用到这个服务了。
###切换负载均衡策略
只需要在配置文件里边添加如下的配置

    服务名称：
        ribbon:
            NFLoadBalancerRuleClassName: 负载均衡策略
案例如下：
            
    payment:
      ribbon:
        NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
这种切换方式，只是针对单个服务，要是想切换所以服务调用都使用统一一个负载均衡策略，实现方式如下：
    
    @Bean
    public IRule randomRule(){
        return new RandomRule();
    }

###自定义负载均衡算法
1.创建一个类继承com.netflix.loadbalancer.AbstractLoadBalancerRule这个抽象类，并且重写choose方法

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
2.在启动类上添加注解
    
    @RibbonClient(name="payment",configuration = MyRandomRule.class)
    name=服务名称，configuration=自定义的服务均衡策略
注意点：
    
    如果即在配置文件里边指定了对应的服务调用负载均衡策略，又再启动类上指定了对应的服务调用负载均衡策略，启动类上指定的生效，配置文件指定的就被覆盖了。    

###超时配置
    
    ribbon:
      ReadTimeout: 5000
      ConnectTimeout: 5000
默认配置都是1秒钟