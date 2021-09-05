package com.guice.service;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.guice.annotation.colorValue;
import com.guice.annotation.edgeValue;

public class drawSqure implements drawShap {
	
	private String color ;
	private Integer edge;
	
	@Inject
	
	//other way to use constant instant is using @Named   
	public drawSqure(@Named("redColor") String color,@edgeValue Integer edge) {
		this.color = color;
		this.edge = edge;
	}
	public void draw() {
		System.out.println("Squre Drawing with :: Color :"+color+" "+"edge :"+edge);
	}

}
