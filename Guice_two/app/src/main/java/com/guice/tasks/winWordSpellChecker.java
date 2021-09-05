package com.guice.tasks;


//this class is also sub class of spellCheckedImp so we have to provide binding for 
// spellCheckedImp -> winWordSpellChecker 

//we can see that binding in AppModel
public class winWordSpellChecker extends spellCheckedImp {
	
//	public winWordSpellChecker(String dbUrl, String user, int timeout) {
//		super(dbUrl, user, timeout);
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public void checkSpelling() {
			
	System.out.println("This is spell cheking for winword spellching class");
	}

}
