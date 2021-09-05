package Guice_one;
import com.google.inject.AbstractModule;
import com.google.inject.Scope;
import com.google.inject.Scopes;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.guice.annotation.colorValue;
import com.guice.annotation.edgeValue;
import com.guice.request.drawRequest;
import com.guice.service.drawShap;
import com.guice.service.drawSqure;

public class AppModle extends AbstractModule {
	
	@Override
	protected void configure() {
		//over here with the use of Scope SINGLETON the value of both request will be same
		bind(drawShap.class).to(drawSqure.class).in(Scopes.SINGLETON);
		bind(drawRequest.class).in(Scopes.SINGLETON);
		
		//adding constant bind with toInstance
		bind(String.class).annotatedWith(Names.named("redColor")).toInstance("Red");
		bind(Integer.class).annotatedWith(edgeValue.class).toInstance(40);
		
		}

}
