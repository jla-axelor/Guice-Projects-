package providerDemo;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.Provides;

//Provider and Provider class
public class App2 {

	public static void main(String[] args) {
		 Injector injector = Guice.createInjector(new TextEditorModule());
	      TextEditor editor = injector.getInstance(TextEditor.class);
	      editor.makeSpellCheck();

	}

}


class TextEditor {
	   private SpellChecker spellChecker;
	   @Inject
	   public TextEditor( SpellChecker spellChecker) {
	      this.spellChecker = spellChecker;
	   }
	   public void makeSpellCheck(){
	      spellChecker.checkSpelling();
	   } 
	}

//

class SpellCheckerprovider implements Provider<SpellChecker>{
	
	@Override
	public SpellChecker get() {
		 String dbUrl = "jdbc:mysql://localhost:5326/emp";
	      String user = "user";
	      int timeout = 100;
	      SpellChecker SpellChecker = new SpellCheckerImpl(dbUrl, user, timeout);
	      return SpellChecker;
	}
	
}


//Binding Module
class TextEditorModule extends AbstractModule {

 @Override
 protected void configure() {
	 //this provider binding is used when we can create extra provider class 
	 bind(SpellChecker.class).toProvider(SpellCheckerprovider.class);
 } 

 // Guice provides a way to create bindings with complex objects using @Provides annotation.
 //without binding in configure() method we can directly bind here
 //over here we created provider in binding  module other way to add provider with different class 
 
 
// @Provides
// public SpellChecker provideSpellChecker(){
//
//    String dbUrl = "jdbc:mysql://localhost:5326/emp";
//    String user = "user";
//    int timeout = 100;
//
//    SpellChecker SpellChecker = new SpellCheckerImpl(dbUrl, user, timeout);
//    return SpellChecker;
// }
 
}


//spell checker interface
interface SpellChecker {
public void checkSpelling();
}

//spell checker implementation
class SpellCheckerImpl implements SpellChecker {

 private String dbUrl;
 private String user;
 private Integer timeout;

 @Inject
 public SpellCheckerImpl(String dbUrl, 
    String user, 
    Integer timeout){
    this.dbUrl = dbUrl;
    this.user = user;
    this.timeout = timeout;
 } 

 @Override
 public void checkSpelling() { 
    System.out.println("Inside checkSpelling." );
    System.out.println(dbUrl);
    System.out.println(user);
    System.out.println(timeout);
 }
}
