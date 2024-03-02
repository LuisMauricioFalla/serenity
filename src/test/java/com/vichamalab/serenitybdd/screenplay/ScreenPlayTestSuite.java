package com.vichamalab.serenitybdd.screenplay;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import com.vichamalab.serenitybdd.screenplay.question.Articulo;
import com.vichamalab.serenitybdd.screenplay.task.Buscar;
import com.vichamalab.serenitybdd.screenplay.task.Navegar;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.annotations.CastMember;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class ScreenPlayTestSuite {
	
	@Managed(driver="chrome")
	private WebDriver navegador;
	
	@CastMember(name="UsuarioAnonimo")
	Actor anonimo;
	
	@Test
	@DisplayName("Buscar en wikitravel usando screenplay")
	public void buscarPorPalabraClave() {
		anonimo.can(BrowseTheWeb.with(navegador));
		anonimo.has(Navegar.paginainicio());
		anonimo.attemptsTo(Buscar.porPalabraClave("arequipa"));
		anonimo.should(seeThat("El titulo del articulo", Articulo.titulo(),equalTo("Arequipa")));
	}

}
