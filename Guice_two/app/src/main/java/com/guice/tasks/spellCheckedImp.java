package com.guice.tasks;

import com.google.inject.Inject;

public class spellCheckedImp implements spellChecker {

//	private String dbUrl;
//	private String user;
//	private int timeout;
//
//	@Inject
//	public spellCheckedImp(String dbUrl, String user, int timeout) {
//		this.dbUrl = dbUrl;
//		this.user = user;
//		this.timeout = timeout;
//	}

	@Override
	public void checkSpelling() {
		System.out.println("Inside checkSpelling.");
//		System.out.println(dbUrl);
//		System.out.println(user);
//		System.out.println(timeout);
	}
}
