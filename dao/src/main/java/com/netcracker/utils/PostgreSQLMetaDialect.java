package com.netcracker.utils;

import org.hibernate.cfg.reveng.dialect.JDBCMetaDataDialect;
import org.hibernate.cfg.reveng.dialect.MetaDataDialect;

/**
 * A implementation of the {@link MetaDataDialect} for the PostgreSQL Database.
 * This is basically a wrapper around {@link JDBCMetaDataDialect} to provide case sensitive
 * access to postgresql databases.
 * 
 * @see <a href=https://hibernate.atlassian.net/browse/HBX-1000?page=com.atlassian.jira.plugin.system.issuetabpanels%3Aall-tabpanel>hibernate.atlassian.net</a>
 */

public class PostgreSQLMetaDialect extends JDBCMetaDataDialect {

	/*
	 * (non-Javadoc)
	 * @see org.hibernate.cfg.reveng.dialect.AbstractMetaDataDialect#needQuote(java.lang.String)
	 */
	public boolean needQuote(String name) {		

		if(null != name && 0 != name.compareTo(name.toUpperCase())) {
			return true;
		} else {
			return super.needQuote(name);
		}
	}
}