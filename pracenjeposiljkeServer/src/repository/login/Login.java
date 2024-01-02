/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.login;

import domain.GenericEntity;
import domain.UserLogin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.AbstractGenericOperation;
import repository.DatabaseFactoryRepository;

/**
 *
 * @author Vuk
 */
public class Login extends AbstractGenericOperation{
    
    private GenericEntity genericEntity;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        genericEntity = (GenericEntity) repository.authenticate((UserLogin)param);
    }
    
    public GenericEntity getObject(){
        return genericEntity;
    }
}
