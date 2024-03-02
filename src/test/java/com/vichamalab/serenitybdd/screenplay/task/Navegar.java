package com.vichamalab.serenitybdd.screenplay.task;

import com.vichamalab.serenitybdd.screenplay.page.WikiPage;

import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class Navegar implements Task {
	WikiPage paginaInicial;
	
	public static Navegar paginainicio() {
		return instrumented(Navegar.class);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Open.browserOn().the(paginaInicial));
		
	}

}
