import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverter {

    static Scanner in = new Scanner(System.in);

    private static final String API_KEY = "56574dc3de9298379f00d30e"; 
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static void main(String[] args) 
    {

        System.out.println("Enter base currency ");
        String Base_cr = in.nextLine();

        System.out.println("Enter target currency");
        String Target_cr = in.nextLine();

        System.out.println("Enter amount");
        double amount = in.nextDouble();

        try {
            double convertedAmount = convertCurrency(Base_cr, Target_cr, amount);
            System.out.println(amount + " " + Base_cr + " = " + convertedAmount + " " + Target_cr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double convertCurrency(String Base_cr, String Target_cr, double amount) throws IOException, InterruptedException {
        String urlString = BASE_URL + API_KEY + "/latest/" + Base_cr;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();

        JSONObject json = new JSONObject(responseBody);
        JSONObject conversionRates = json.getJSONObject("conversion_rates");
        double exchangeRate = conversionRates.getDouble(Target_cr);

        return amount * exchangeRate;
    }
}
