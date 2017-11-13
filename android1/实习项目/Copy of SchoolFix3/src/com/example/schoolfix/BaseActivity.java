package com.example.schoolfix;

import com.etc.mao.entity.Person;

import android.app.Activity;

public class BaseActivity  extends Activity {
	
	static Person  person=null;

	
	
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
	

}
