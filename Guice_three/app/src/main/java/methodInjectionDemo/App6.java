package methodInjectionDemo;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class App6 {
   public static void main(String[] args) {
      Injector injector = Guice.createInjector(new TextEditorModule());
      TextEditor editor = injector.getInstance(TextEditor.class);
      
//      Method and field injections can be used to initialize using exiting object using injector.injectMembers() method
//      This is OnDemand injector
//      SpellChecker spellChecker = new SpellCheckerImpl();
//      injector.injectMembers(spellChecker);
      
      	editor.makeSpellCheck();
   }
   
}
//----------------------------------------------------------------------------------------------

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

//----------------------------------------------------------------------------------------------
//Binding Module
class TextEditorModule extends AbstractModule {

   @Override
   protected void configure() { 
      bind(String.class).annotatedWith(Names.named("JDBC")).toInstance("jdbc:mysql://localhost:5326/emp");
     // bind(String.class).annotatedWith(Names.named("NAME")).toInstance("Jaydeep");
   } 
}

//----------------------------------------------------------------------------------------------
@ImplementedBy(SpellCheckerImpl.class)
interface SpellChecker {
   public void checkSpelling();
}

//spell checker implementation
//----------------------------------------------------------------------------------------------
class SpellCheckerImpl implements SpellChecker {
 
   private String dbUrl;
   //Optional I jection is use when if this field or any method injection binding present then get otherwise not
   //field injection
   @Inject(optional = true) @Named("NAME")
   private String name;

   public SpellCheckerImpl(){}
   
   //method Injection
   @Inject 
   public void setDbUrl(@Named("JDBC") String dbUrl){
      this.dbUrl = dbUrl;
   }

   @Override
   public void checkSpelling() { 
      System.out.println("Inside checkSpelling." );
      System.out.println(dbUrl);
      System.out.println(name);
   }
}

//----------------------------------------------------------------------------------------------