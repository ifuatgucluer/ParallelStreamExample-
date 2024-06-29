import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        // Büyük bir liste oluşturalım
        List<Integer> list = IntStream.rangeClosed(1, 10000).boxed().collect(Collectors.toList());

        // Normal Stream kullanarak işlemleri gerçekleştirelim
        long startTime = System.currentTimeMillis();
        list.stream().forEach(ParallelStreamExample::process);
        long endTime = System.currentTimeMillis();
        System.out.println("Stream işlem süresi: " + (endTime - startTime) + " ms");

        // ParallelStream kullanarak işlemleri gerçekleştirelim
        startTime = System.currentTimeMillis();
        list.parallelStream().forEach(ParallelStreamExample::process);
        endTime = System.currentTimeMillis();
        System.out.println("ParallelStream işlem süresi: " + (endTime - startTime) + " ms");
    }

    // Örnek işlem fonksiyonu
    private static void process(Integer i) {
        // Simülasyon amaçlı bekleme süresi
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
