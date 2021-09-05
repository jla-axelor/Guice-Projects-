package com.guice.services;
import com.google.inject.Inject;
import com.guice.tasks.spellChecker;
public class textEditar {

	 private spellChecker spellChecker;
	   @Inject
	   public textEditar ( spellChecker spellChecker) {
	      this.spellChecker = spellChecker;
	   }
	   public void makeSpellCheck(){
	      spellChecker.checkSpelling();
	   } 
}
