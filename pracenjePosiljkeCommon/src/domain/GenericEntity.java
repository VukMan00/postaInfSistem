/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 *
 * @author Vuk
 */
public interface GenericEntity extends Serializable{
    
    String getSelectValues();
    
    String getSelectValuesWithCondition();
    
    String getSelectValuesWithPartition();
    
    GenericEntity getObject(ResultSet rs);
    
    String getWhereCondition();

    public String getTableName();

    public String getColumnNamesForInsert();

    public String getInsertValues();

    public String getUpdateSetValues();

    public String getUpdateCondition();

    public String getDeleteCondition();

    public String getWhereGetCondition();

    public void setObjectStatement(PreparedStatement statement);
    
    public void setTypeMap(Connection connection);
}
