import java.util.List;
import java.util.Map;

public class StringResponse {
    private String table;
    private String currency;
    public String code;
    private List<Rates> rates;


    public  List<Rates> getRates() {
        return rates;
    }

/**{"table":"C",
 * "currency":"dolar amerykański",
 * "code":"USD",
 * "rates":[{
 *      "no":"064/C/NBP/2016",
 *      "effectiveDate":"2016-04-04",
 *      "bid":3.6929,
 *      "ask":3.7675
 *      }]}
 * */

}

class Rates{
    public String no;
    public String effectiveDate;
    public double bid;
    public double ask;
}