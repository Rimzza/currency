package by.rimza.service;

import by.rimza.model.Currency;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class CurrencyService {

    public static Currency getCurrency(String currency) {
        Currency cr = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("https://api.nbrb.by/exrates/rates/" + currency + "?parammode=2");
            String responseBody = httpClient.execute(request, new BasicResponseHandler());
            JSONObject json = new JSONObject(responseBody);
            cr = currencyByJSON(json);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cr;
    }

    private static Currency currencyByJSON(JSONObject json) {
        Currency currency = new Currency();
        try {
            currency.setCur_id(json.getInt("Cur_ID"));
            currency.setDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(json.getString("Date")));
            currency.setCur_abbreviation(json.getString("Cur_Abbreviation"));
            currency.setCur_name(json.getString("Cur_Name"));
            currency.setCur_officialRate(json.getDouble("Cur_OfficialRate"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return currency;

    }


}
