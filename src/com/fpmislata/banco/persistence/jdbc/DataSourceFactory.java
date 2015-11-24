
package com.fpmislata.banco.persistence.jdbc;

import javax.sql.DataSource;

public interface DataSourceFactory {
    public DataSource getDataSource();
}
