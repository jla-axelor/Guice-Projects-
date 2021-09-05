package com.guice.tasks;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class AppModule extends AbstractModule {
	
	@Override
	protected void configure() {
		
		bind(spellChecker.class).to(spellCheckedImp.class);
		
		//for another subclass binding 
		bind(spellCheckedImp.class).to(winWordSpellChecker.class);
	
	}
//	 @Provides
//	   public spellChecker provideSpellChecker(){
//
//	      String dbUrl = "jdbc:mysql://localhost:5326/emp";
//	      String user = "user";
//	      int timeout = 100;
//
//	      spellChecker SpellChecker = new spellCheckedImp(dbUrl, user, timeout);
//	      return SpellChecker;
//	   }
//	
	

}
