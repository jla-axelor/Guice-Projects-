package com.guice.request;

import com.google.inject.Inject;
import com.guice.service.drawShap;

public class drawRequest {
	
	drawShap d;
	double a;
	@Inject
	public drawRequest(drawShap d) {
		a = Math.random();
		this.d = d;
	}
	
	public void makeRequest() {
		d.draw();
	}
	public drawShap getShap() {
		return d;
	}
	public double getID() {
		return a;
	}

}
