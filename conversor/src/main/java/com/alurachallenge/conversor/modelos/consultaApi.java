package com.alurachallenge.conversor.modelos;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class consultaApi {

    public void  buscadorDeMoneda(Divisas divisaDeOrigen, Divisas sumaFinal, Divisas divisaConversion, double valoringresado) throws IOException, InterruptedException  {

        double conversion = 0.00;

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/9d7a30b82555189b92b0cf76/latest/USD"  );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);
        JsonObject tasasConversion = jsonObject.getAsJsonObject("conversion_rates");

        var valorMoneda = tasasConversion.get(String.valueOf(divisaConversion)).getAsDouble();

        if (divisaDeOrigen.equals(divisaConversion)) {
            conversion = valoringresado / valorMoneda;

        } else {
            conversion = valoringresado * valorMoneda;
        }
        System.out.println("El monto para cambiar es:  " + valoringresado + " " + divisaDeOrigen +" Valor del cambio: "+ conversion + " " + sumaFinal);


    }
}

