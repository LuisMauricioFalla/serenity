package com.vichamalab.serenitybdd.pageobject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;

@ExtendWith(SerenityJUnit5Extension.class)
public class PageObjectTestSuite {
	
	@Managed(driver="chrome")
	private WebDriver navegador;
	
	WikiTravel wikiTravel;
	
	@Test
	@DisplayName("Buscar en wiki usando Page Object")
	public void buscarPorPalabraClave() {
		String palabraClave = "Arequipa";
		wikiTravel.setDriver(navegador);
		wikiTravel.cargarPagina();
		wikiTravel.buscarPorPalabraClave(palabraClave);
		wikiTravel.seleccionarPrimerElemento();
		wikiTravel.validarTitulo(palabraClave);
		
	}

}
