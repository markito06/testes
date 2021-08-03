import static javax.xml.bind.DatatypeConverter.printHexBinary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Stream;

public class MD5HashContent {

    public static final String file = "/home/marcos/Documentos/cadbenef/2021/migracao/CN1612200001.865";

    public static void main(String[] args) {

        Runtime r = Runtime.getRuntime();

        md5(r);
        countlines(r);
        hashSpeedTest();

    }

    private static void hashSpeedTest() {
        try {
            calculaHashJavaMd5ReadAllBytesWay();
            calculateHashJavaMd5AStreamWay();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }

    }

    private static void md5(Runtime r) {
        String command = "md5sum " + file + " | grep -ioh '[0-9a-f]\\{32\\}'";
        String hash = run(r, command);
        System.out.println(hash);
    }

    private static void countlines(Runtime r) {
        String command = "cat " + file + " | wc -l ";
        String nrLines = run(r, command);
        System.out.println(nrLines);
    }

    private static String run(Runtime r, String command) {
        String[] commands = { "bash", "-c", command };
        try {
            StringBuilder result = new StringBuilder();
            Process p = r.exec(commands);

            p.waitFor();
            BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";

            while ((line = b.readLine()) != null) {
                result.append(line);
            }

            b.close();

            return result.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private static void calculaHashJavaMd5ReadAllBytesWay() throws IOException, NoSuchAlgorithmException {

        long start = System.nanoTime();
        Path path = Paths.get(file);

        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(Files.readAllBytes(path));

        byte[] digest = md.digest();
        String myChecksum = printHexBinary(digest);

        System.out.println(myChecksum);

        long end = System.nanoTime();

        System.out.println("time : " + ((end - start) / 1000000) + " ms");

    }

    /**
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private static void calculateHashJavaMd5AStreamWay() throws IOException, NoSuchAlgorithmException {
        long start = System.nanoTime();
        Path path = Paths.get(file);
        MessageDigest md = MessageDigest.getInstance("MD5");

        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach((l) -> md.update(l.getBytes(StandardCharsets.UTF_8)));
        }

        byte[] digest = md.digest();
        String myChecksum = printHexBinary(digest);

        System.out.println(myChecksum);
        long end = System.nanoTime();
        System.out.println("time : " + ((end - start) / 1000000) + " ms");
    }

}
