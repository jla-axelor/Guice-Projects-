package constructorBindingDemo;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.google.inject.name.Names;


//get Constructor binding
public class App3 {
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

//Binding Module

// in binding module we have to  get constructor 
class TextEditorModule extends AbstractModule {

   @Override
   protected void configure() {
      try {
    	  //we can get constructor with given below 
    	  //here String.class states for constructor with String variable in SpellCheckerImpl class
         bind(SpellChecker.class)
            .toConstructor(SpellCheckerImpl.class.getConstructor(String.class));
      } catch (NoSuchMethodException | SecurityException e) {
         System.out.println("Required constructor missing");
      } 
      //after getting constructor we have to constant bind here
      bind(String.class)
         .annotatedWith(Names.named("JDBC"))
         .toInstance("jdbc:mysql://localhost:5326/emp");
   } 
}

//spell checker interface
interface SpellChecker {
   public void checkSpelling();
}

//spell checker implementation
class SpellCheckerImpl implements SpellChecker {

   private String dbUrl;

   public SpellCheckerImpl(){}
   
   //over here we declared String constructor with name binding  
   public SpellCheckerImpl(@Named("JDBC") String dbUrl){
      this.dbUrl = dbUrl;
   } 

   @Override
   public void checkSpelling() { 
      System.out.println("Inside checkSpelling." );
      System.out.println(dbUrl); 
   }
}

//OUTPUT 
//Inside checkSpelling.
//jdbc:mysql://localhost:5326/emp


