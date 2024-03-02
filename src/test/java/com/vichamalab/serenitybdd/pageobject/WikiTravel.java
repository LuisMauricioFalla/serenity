package com.vichamalab.serenitybdd.pageobject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;

@DefaultUrl("https://wikitravel.org/en/Peru")
public class WikiTravel extends PageObject {
	
	@FindBy(id="searchInput")
	private WebElement casillaBusqueda;
	
	@FindBy(css="#mf-pagebanner > div.topbanner > div.name")
	private WebElement tituloPagina;
	
	public void cargarPagina() {
		this.open();
	}
	
	public void buscarPorPalabraClave (String palabraClave) {
		casillaBusqueda.sendKeys(palabraClave,Keys.ENTER);
	}
	
	public void seleccionarPrimerElemento() {
		List<WebElement> resultLinks = this.getDriver().findElements(By.cssSelector(".mw-search-result-heading > a"));
		resultLinks.get(0).click();
	}
	
	public void validarTitulo (String titulo) {
		assertThat(tituloPagina.getText().contains(titulo));
	}


}
