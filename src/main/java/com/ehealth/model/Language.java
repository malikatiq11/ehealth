package com.ehealth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Language {
	
	@Id
	@GeneratedValue
	public int LanguageId;
	public String LanguageName;

	public int getlanguageId() {
		return LanguageId;
	}
	public void setLanguageId(int languageId) {
		LanguageId = languageId;
	}
	public String getlanguageName() {
		return LanguageName;
	}
	public void setLanguageName(String languageName) {
		LanguageName = languageName;
	}
	
}
