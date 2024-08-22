import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Currency {
    private static final Map<String, Double>  exchangeRates= new HashMap<>();
    static {
        exchangeRates.put("USD_TO_EUR", 0.85);
        exchangeRates.put("EUR_TO_USD", 1.18);
        exchangeRates.put("USD_TO_GBP", 0.75);
        exchangeRates.put("GBP_TO_USD", 1.33);
    }

    public static double getExchangeRates(String baseCurrency, String targetCurrency) {
        String key = baseCurrency + "_TO_" + targetCurrency;
        return exchangeRates.getOrDefault(key, 1.0);

    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Currency Converter");
        System.out.print("Enter base currency: ");
        String baseCurrency=sc.next().toUpperCase();
        System.out.print("enter target currency: ");
        String targetCurrency=sc.next().toUpperCase();

        double exchangeRates=getExchangeRates(baseCurrency,targetCurrency);
        System.out.println("Exchange Rate ("+baseCurrency+"to"+targetCurrency+"): "+exchangeRates);

        System.out.print("enter amount in "+ baseCurrency+":");
        double amount =sc.nextDouble();
        double ConvertedAmount=amount*exchangeRates;
        System.out.printf("Converted Amount : %.2f %s\n" , ConvertedAmount,targetCurrency);
        sc.close();
    }
}