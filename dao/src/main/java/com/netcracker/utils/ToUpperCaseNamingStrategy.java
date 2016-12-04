package com.netcracker.utils;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;




/** 
 * by v.ladynev from http://stackoverflow.com/
 * 
 */
public class ToUpperCaseNamingStrategy extends PhysicalNamingStrategyStandardImpl{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
	        return context.getIdentifierHelper().toIdentifier(
	            StringUtils.upperCase(name.getText(), Locale.ENGLISH));
	    }

}
