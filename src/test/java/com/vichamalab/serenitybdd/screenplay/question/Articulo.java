package com.vichamalab.serenitybdd.screenplay.question;

import com.vichamalab.serenitybdd.screenplay.page.WikiPage;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class Articulo {
	
	public static Question<String> titulo (){
		return actor -> Text.of(WikiPage.TITULO_PAGINA).answeredBy(actor);
	}
}
