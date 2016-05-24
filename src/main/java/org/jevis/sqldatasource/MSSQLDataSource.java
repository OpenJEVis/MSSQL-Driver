/**
 * Copyright (C) 2015 NeroBurner; Copyright (C) 2016 JingxuanMan
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation in version 3.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * This driver is part of the OpenJEVis project, further project information are
 * published at <http://www.OpenJEVis.org/>.
 */
package org.jevis.sqldatasource;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NeroBurner (AIT)
 * @author JingxuanMan (Envidatec)
 */
public class MSSQLDataSource extends SQLDriverAbstract {

    interface MSSQL extends SQLDriverAbstract.SQLServer {

        public final static String NAME = "MSSQL Server";
    }

    public String loadJDBC(String host, int port, String schema, String domain, String dbUser,
              String dbPW) throws ClassNotFoundException, SQLException {
        String url = "jdbc:jtds:sqlserver://" + host + ":" + port + "/" + schema;
        if (domain != null && !domain.isEmpty()) {
            url += ";domain=" + domain;
        }
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        System.out.println("Connection url: " + url);
        _con = DriverManager.getConnection(url, dbUser, dbPW);
        return url;
    }

    @Override
    protected String getClassName() {
        return MSSQL.NAME;
    }
}
