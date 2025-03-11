import java.util.Scanner;

public class CurrencyConverter {

    // Conversion rates as of the knowledge cutoff in October 2023
    private static final double USD_TO_EUR = 0.85;
    private static final double USD_TO_GBP = 0.73;
    private static final double EUR_TO_USD = 1.18;
    private static final double EUR_TO_GBP = 0.86;
    private static final double GBP_TO_USD = 1.37;
    private static final double GBP_TO_EUR = 1.16;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");
        System.out.println("Available currencies: USD, EUR, GBP");

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the source currency (USD, EUR, GBP): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency (USD, EUR, GBP): ");
        String toCurrency = scanner.next().toUpperCase();

        double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);

        if (convertedAmount != -1) {
            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
        } else {
            System.out.println("Invalid currency conversion.");
        }

        scanner.close();
    }

    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        switch (fromCurrency) {
            case "USD":
                if (toCurrency.equals("EUR")) {
                    return amount * USD_TO_EUR;
                } else if (toCurrency.equals("GBP")) {
                    return amount * USD_TO_GBP;
                }
                break;
            case "EUR":
                if (toCurrency.equals("USD")) {
                    return amount * EUR_TO_USD;
                } else if (toCurrency.equals("GBP")) {
                    return amount * EUR_TO_GBP;
                }
                break;
            case "GBP":
                if (toCurrency.equals("USD")) {
                    return amount * GBP_TO_USD;
                } else if (toCurrency.equals("EUR")) {
                    return amount * GBP_TO_EUR;
                }
                break;
            default:
                return -1; // Invalid conversion
        }
        return -1; // Invalid conversion
    }
}