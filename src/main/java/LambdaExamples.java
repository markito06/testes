import java.util.Arrays;
import java.util.List;

public class LambdaExamples {

    public static void main(String[] args) {
        List<Client> clients = Arrays.asList(new Client("Angelo", true, 1000),
                new Client("Helena", false, 1000),
                new Client("Maiara", false, 1000),
                new Client("Isadora", true, 1000));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 44, 32, 4, 9, 10, 22, 33);

        numbers.stream().filter(v -> v%2 == 0).forEach(System.out::println);

        clients.stream().filter(client -> client.getStatus().equals(Boolean.TRUE)).map(filtered -> filtered.getValue() + 1000).forEach(System.out::println);


        numbers.forEach(System.out::println);
    }
}
