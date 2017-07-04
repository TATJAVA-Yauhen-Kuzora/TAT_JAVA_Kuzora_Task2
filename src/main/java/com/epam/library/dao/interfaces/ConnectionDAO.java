package com.epam.library.dao.interfaces;

import java.sql.Connection;

import com.epam.library.dao.connection.ConnectionSQLException;

public interface ConnectionDAO {

	Connection takeConnection() throws ConnectionSQLException;
}
