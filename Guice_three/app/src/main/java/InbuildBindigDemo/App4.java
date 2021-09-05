package InbuildBindigDemo;

import java.util.logging.Logger;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;


//create run time binding <Logger> 
public class App4 {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new AppModule());
		TextEditor editor = injector.getInstance(TextEditor.class);
		editor.makeSpellCheck();
		

	}
}
	
	class TextEditor {
		private Logger logger;
		
		@Inject
		public TextEditor(Logger logger) {
			this.logger = logger;
		}
		public void makeSpellCheck() {
			logger.info("TextEditor.makeSpellCheck method ");
			
		}
	}
	
class AppModule extends AbstractModule{
	@Override
	protected void configure() {

}
	
}
	


