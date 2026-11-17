package com.example.read_fy;

import com.example.read_fy.models.Product;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.Scanner;

@SpringBootApplication
public class ReadFyApplication {

	public static void main(String[] args) {

		try {
			URL urlObj = new URL("https://fakestoreapi.com/products/1");

			HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();

			connection.setRequestMethod("GET");

			connection.connect();

			int responseCode = connection.getResponseCode();

			if (responseCode != 200) {
				throw new RuntimeException("Erro");
			} else {
				String inline = "";

				Scanner scanner = new Scanner(urlObj.openStream());

				while (scanner.hasNext()) {
					inline += scanner.nextLine();
				}

				ObjectMapper objectMapper = new ObjectMapper();

				JsonNode node = objectMapper.readTree(inline);

				System.out.println(node.get("id"));
				System.out.println(node.get("title"));
				System.out.println(node.get("price"));
			}

		} catch(Exception e) {
			throw new RuntimeException("Erro para dar GET na API");
		}

		SpringApplication.run(ReadFyApplication.class, args);
	}

}
