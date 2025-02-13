package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);

        System.out.print("digite um filme: ");
        var busca = leitura.nextLine();

        String endereco =
                "https://www.omdbapi.com/?t=" + busca.replace(" ",
                        "+") +
                "&apikey=72b4446d";
        try{

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
////    Titulo meuTitulo = gson.fromJson(json, Titulo.class);
            TituloOmdb meuTituloOmdb = gson.fromJson(json,
                    TituloOmdb.class);

            // try{
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println("titulo já convertido");
            System.out.println(meuTitulo);
        } catch(NumberFormatException e){
            System.out.println("aconteceu um erro");
            System.out.println(e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println("algum erro de argumento nas busca, " +
                    "verifique o endereço");

        }

        System.out.println("o programa finalizou coretamente");






    }
}
