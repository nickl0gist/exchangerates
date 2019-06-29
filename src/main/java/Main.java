import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] curencies = {"USD", "EUR", "GBP", "CHF"};
        String currentDate = "2019-06-28";
        Map<String, double[]> currentRates = ExchangeRates.getRates(curencies, currentDate);
        currentRates.entrySet()
                .forEach(x -> System.out.println("1 " + x.getKey() + " = " + x.getValue()[0] + " PLN"));

        ExchangeRates.getRates(curencies, currentDate)
                .entrySet()
                .forEach(x -> System.out.println("100 PLN = " + String.format("%.4f %s (%.4f)",100/x.getValue()[1], x.getKey(), x.getValue()[1])));

        String compareDate = "2019-05-28";
        System.out.println("You would have earned next amounts by buying them on " + compareDate + ":");
        Map<String, double[]> oldRates = ExchangeRates.getRates(curencies, compareDate);

        double earned;
        for (int i = 0; i < curencies.length; i++) {
            earned = 100.0 - 100.0/oldRates.get(curencies[i])[1]*currentRates.get(curencies[i])[0];
            System.out.println(String.format("%s -> %.2f PLN", curencies[i],earned));
        }
    }
}
