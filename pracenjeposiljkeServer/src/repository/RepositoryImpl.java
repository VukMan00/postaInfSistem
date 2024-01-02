/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain.GenericEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vuk
 */
public class RepositoryImpl implements DbRepository<GenericEntity>{

    @Override
    public void add(GenericEntity entity) throws Exception{
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(entity.getTableName())
                    .append(" (").append(entity.getColumnNamesForInsert()).append(")")
                    .append(" VALUES (")
                    .append(entity.getInsertValues())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            try(Statement statement = connection.createStatement()){
                statement.executeUpdate(query);
            }
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    
    @Override
    public void addWithStructureType(GenericEntity entity) throws Exception {
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(entity.getTableName())
                    .append(" (").append(entity.getColumnNamesForInsert()).append(")")
                    .append(" VALUES (")
                    .append(entity.getInsertValues())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            entity.setTypeMap(connection);
            try(PreparedStatement statement = connection.prepareStatement(query)){
                entity.setObjectStatement(statement);
                System.out.println(entity);
                statement.executeUpdate();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void update(GenericEntity entity) throws Exception {
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ")
                    .append(entity.getTableName())
                    .append(" SET ").append(entity.getUpdateSetValues())
                    .append(" WHERE ").append(entity.getUpdateCondition());
            String query = sb.toString();
            System.out.println(query);
            try(Statement statement = connection.createStatement()){
                statement.executeUpdate(query);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    
    @Override
    public void updateWithStructureType(GenericEntity entity) throws Exception {
        try{
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append(" UPDATE ")
              .append(entity.getTableName())
              .append(" SET ").append(entity.getUpdateSetValues())
              .append(" WHERE ").append(entity.getUpdateCondition());
            String query = sb.toString();
            System.out.println(query);
            try(PreparedStatement statement = connection.prepareStatement(query)){
                entity.setObjectStatement(statement);
                System.out.println(entity);
                statement.executeUpdate();
            }
        }catch(Exception ex){
            throw ex;
        }
    }

    @Override
    public void delete(GenericEntity entity) throws Exception {
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ")
                    .append(entity.getTableName())
                    .append(" WHERE ").append(entity.getDeleteCondition());
            String query = sb.toString();
            System.out.println(query);
            try(Statement statement = connection.createStatement()){
                statement.executeUpdate(query);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public GenericEntity get(GenericEntity entity) throws Exception {
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append(entity.getSelectValues())
                    .append(" WHERE ").append(entity.getWhereGetCondition());
            String query = sb.toString();
            System.out.println(query);
            try(Statement statement = connection.createStatement()){
                ResultSet rs = statement.executeQuery(query);
                if(rs.next()){
                    return entity.getObject(rs);
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        
        return null;
    }

    @Override
    public List<GenericEntity> getAll(GenericEntity entity) throws Exception {
        List<GenericEntity> entities = new ArrayList<>();
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append(entity.getSelectValues());
            String query = sb.toString();
            System.out.println(query);
            
            try(Statement statement = connection.createStatement()){
                ResultSet rs = statement.executeQuery(query);

                while(rs.next()){
                    entities.add(entity.getObject(rs));
                }
            }
            
            return entities;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    @Override
    public List<GenericEntity> getAllWithCondition(GenericEntity entity) throws Exception{
        List<GenericEntity> entities = new ArrayList<>();
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append(entity.getSelectValuesWithCondition());
            String query = sb.toString();
            System.out.println(query);
            
            try(Statement statement = connection.createStatement()){
                ResultSet rs = statement.executeQuery(query);

                while(rs.next()){
                    entities.add(entity.getObject(rs));
                }
            }
            
            return entities;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    @Override
    public List<GenericEntity> getAlllWithPartition(GenericEntity entity) throws Exception {
        List<GenericEntity> entities = new ArrayList<>();
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append(entity.getSelectValuesWithPartition());
            String query = sb.toString();
            System.out.println(query);
            
            try(Statement statement = connection.createStatement()){
                ResultSet rs = statement.executeQuery(query);

                while(rs.next()){
                    entities.add(entity.getObject(rs));
                }
            }
            
            return entities;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public GenericEntity authenticate(GenericEntity genericEntity) throws Exception{
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append(genericEntity.getSelectValues())
              .append(genericEntity.getWhereCondition());
            
            String query = sb.toString();
            System.out.println(query);
            try(Statement statement = connection.createStatement()){
                ResultSet rs = statement.executeQuery(query);
                while(rs.next()){
                    return genericEntity.getObject(rs);
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return null;
    }
}
