import redis.clients.jedis.Jedis;

public class RedisApp {

    public static void main(String[] args) {

        Jedis jedis = new Jedis();

        jedis.sadd("names", "marcos");
        jedis.sadd("names", "fabiana");
        jedis.sadd("names", "joao-paulo");
        jedis.sadd("names", "marco-antonio");

        jedis.smembers("names").stream().forEach((name)-> System.out.println(name));



    }
}
