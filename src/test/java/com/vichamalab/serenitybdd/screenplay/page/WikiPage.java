package com.vichamalab.serenitybdd.screenplay.page;

import org.openqa.selenium.By;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://wikitravel.org/en/Peru")
public class WikiPage extends PageObject{
	
	public static final Target CASILLA_BUSQUEDA = Target.the("casilla de busqueda").located(By.cssSelector("#searchInput"));
	public static final Target TITULO_PAGINA = Target.the("titulo de pagina").locatedBy("#mf-pagebanner > div.topbanner > div.name");

}
