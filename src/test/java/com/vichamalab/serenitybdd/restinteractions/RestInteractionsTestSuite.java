package com.vichamalab.serenitybdd.restinteractions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.vichamalab.serenitybdd.dto.ProductRequest;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

@ExtendWith(SerenityJUnit5Extension.class)
public class RestInteractionsTestSuite {
	
	@Tag("restinteractions")
	@Test
	@DisplayName("Listar productos usando Rest Interactions")
	public void listar_productos() {
		String baseUrl="localhost:8081";
		Actor authorizedUser = Actor.named("usuario autorizado").whoCan(CallAnApi.at(baseUrl));
		authorizedUser.attemptsTo(Get.resource("/api/v1/product/"));
		authorizedUser.should(seeThatResponse("El codigo de respuesta es 200 y el estado es verdadero",
				response -> response.statusCode(200)
				.body("status", equalTo(true))
				));
	}
	
	@Tag("restinteractions")
	@Test
	@DisplayName("Crear productos usando Rest Interactions")
	public String crearNuevoProducto() {
		ProductRequest productRequest = ProductRequest.builder()
				.name("Iphone 15")
				.description("Telefono Alta Gama")
				.price(1500)
				.build();
		
		String baseUrl="localhost:8081";
		
		Actor authorizedUser = Actor.named("usuario autorizado").whoCan(CallAnApi.at(baseUrl));
		//Action
		authorizedUser.attemptsTo(Post.to("/api/v1/product/")
		        .with( 
		        		request -> request.header("Content-Type","application/json")
		                .body(productRequest))); 
		//Validacion 
		authorizedUser.should(seeThatResponse("El codigo de respuesta es 201 y el estado es verdadero",
				response -> response.statusCode(201)
				.body("status", equalTo(true))
				));
		String skuResponse = SerenityRest.lastResponse().path("sku");
		return skuResponse;
	}
	
	@Tag("restinteractions")
	@Test
	@DisplayName("Eliminar productos usando Rest Interactions")
	public void eliminarProducto() {
		String baseUrl="localhost:8081";
		
		Actor authorizedUser = Actor.named("usuario autorizado").whoCan(CallAnApi.at(baseUrl));
		//Action
		authorizedUser.attemptsTo(Delete.from("/api/v1/product/{sku}/")
		        .with( 
		        		request -> request.header("Content-Type","application/json")
		                .pathParam("sku", this.crearNuevoProducto() ))); 
		//Validacion 
		authorizedUser.should(seeThatResponse("El codigo de respuesta es 201 y el estado es verdadero",
				response -> response.statusCode(201)
				.body("status", equalTo(true))
				));
	}

}
