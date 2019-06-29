import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ExchangeRates {

    public static Map<String, double[]> getRates(String[] currencies, String date) throws IOException{
        Map<String, double[]> map = new HashMap<>();
        for (String s : currencies) {
            map.put(s, getCurrInfo(s, date));
        }

        return map;
    }

    private static double[] getCurrInfo(String curr, String date) throws IOException {
        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/c/"+ curr.toLowerCase() +"/"+date+"/?format=json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        InputStreamReader isr = new InputStreamReader(con.getInputStream());
        Gson gson = new Gson();
        StringResponse sr = gson.fromJson(isr, StringResponse.class);
        Map <String, Double> map = new HashMap<>();

        return new double[]{sr.getRates().get(0).bid,sr.getRates().get(0).ask} ;
    }

}
