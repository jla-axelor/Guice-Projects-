package JustInTimeBindingDemo;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class App5 {
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
class TextEditorModule extends AbstractModule {

   @Override
   protected void configure() { 
//      bind(SpellChecker.class).to(SpellCheckerImpl.class);
      bind(String.class)
         .annotatedWith(Names.named("JDBC"))
         .toInstance("jdbc:postgresql://localhost:5500/myDb");
   } 
}

//spell checker interface

//without adding binding in binding module class we can use @ImplementedBy 
@ImplementedBy(SpellCheckerImpl.class)
interface SpellChecker {
   public void checkSpelling();
}

//class SpellcheckProvider implements Provider<SpellChecker>{
//	
//	@Override
//	public SpellChecker get() {
//		 String dbUrl = "jdbc:mysql://localhost:5326/emp";
//	      String user = "user";
//	      Integer timeout = 100;
//	      
//	     SpellChecker checker = new SpellCheckerImpl(dbUrl,user,timeout);
//	     return checker;
// 	
//	}	
//}

//spell checker implementation
class SpellCheckerImpl implements SpellChecker {

   @Inject @Named("JDBC")	
   private String dbUrl;
//   private String user;
//   private Integer timeout;
//
//   @Inject
//   public SpellCheckerImpl(String dbUrl,String user,Integer timeout)
//   {
//      this.dbUrl = dbUrl;
//      this.user = user;
//      this.timeout = timeout;
//   } 
//
//   @Override
//   public void checkSpelling() { 
//      System.out.println("Inside checkSpelling." );
//      System.out.println(dbUrl);
//      System.out.println(user);
//      System.out.println(timeout);
//   }

   public SpellCheckerImpl(){}

   @Override
   public void checkSpelling() { 
      System.out.println("Inside checkSpelling. " );
      System.out.println(dbUrl); 
   }
}
