/**
 * Copyright (C) 2016 JingxuanMan
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

import org.jevis.api.JEVisDataSource;
import org.jevis.api.JEVisException;
import org.jevis.api.JEVisObject;
import org.jevis.api.sql.JEVisDataSourceSQL;

/**
 *
 * @author JingxuanMan (Envidatec)
 */
public class MSSQLDataSourceMain {

    public static void main(String[] args) throws JEVisException {
        JEVisDataSource _client = new JEVisDataSourceSQL(
                  "openjevis.org", "13306", "jevis", "jevis", "jevistest");
        _client.connect("Sys Admin", "JEV34Env");
        JEVisObject mssqlServer = _client.getObject(4497l);
        MSSQLDataSource dz = new MSSQLDataSource();
        dz.initialize(mssqlServer);
        dz.run();
    }
}
