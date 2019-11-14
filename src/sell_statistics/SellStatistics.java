package sell_statistics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SellStatistics {

    public static void main(String[] args) throws IOException {
        var data = parseFile("./data.txt");
        calculateTotalNumberOfProductSold(data).forEach(System.out::println);
    }

    private static List<SellStatisticInput> parseFile(String path) throws IOException {
        var entries = Files.readAllLines(Paths.get(path));

        List<SellStatisticInput> input = new ArrayList<>();
        entries.stream()
                .skip(1)
                .forEach(line -> {
                            var elements = line.split(" ");
                            var s_e_day = checkAndSplit(elements[1]);
                            var p_c = checkAndSplit(elements[2]);
                            var s_r = checkAndSplit(elements[3]);

                            input.add(new SellStatisticInput(
                                    StatisticEnum.valueOf(elements[0]),
                                    s_e_day.get(0),
                                    s_e_day.get(1),
                                    p_c.get(0),
                                    p_c.get(1),
                                    s_r.get(0),
                                    s_r.get(1)
                            ));
                        }
                );
        return input;
    }

    private static List<Integer> checkAndSplit(String element) {
        var array = element.contains(".") ? element.split("\\.") : new String[]{element};
        var split = Arrays
                .stream(array)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        if (split.size() == 1)
            split.add(0);

        return split;

    }

    private static List<Integer> calculateTotalNumberOfProductSold(List<SellStatisticInput> input) {
        List<Integer> result = new ArrayList<>();

        AtomicInteger count = new AtomicInteger(0);

        IntStream.range(0, input.size()).forEach(index -> {
            var currentItem = input.get(index);
            if (currentItem.getType().equals(StatisticEnum.Q)) {
                input.subList(0, index)
                        .stream()
                        .filter(before -> before.getType().equals(StatisticEnum.S))
                        .forEach(sell -> {
                            if (checkSellsFactors(sell, currentItem)) {
                                count.incrementAndGet();
                            }
                        });
                result.add(count.intValue());
                count.set(0);
            }
        });

        return result;
    }

    private static Boolean checkSellsFactors(SellStatisticInput sell, SellStatisticInput query) {

        return ((sell.getProductId() == query.getProductId()) || (query.getProductId() == -1))
                && ((sell.getStateId() == query.getStateId()) || (query.getStateId() == -1))
                && (query.getCategoryId() != 0 ? sell.getCategoryId() == query.getCategoryId() : sell.getCategoryId() >= query.getCategoryId())
                && (query.getRegionId() != 0 ? sell.getRegionId() == query.getRegionId() : sell.getRegionId() >= query.getRegionId())
                && (query.getEndDay() != 0 ? IntStream.rangeClosed(query.getStartDay(), query.getEndDay()).anyMatch(x -> x == sell.getStartDay()) : (sell.getStartDay() == query.getStartDay()));
    }
}
