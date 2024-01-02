/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.posiljke;

import domain.Adresnica;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllPosiljkeVrece extends AbstractGenericOperation{
    
    private List<Adresnica> posiljkeVrece;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        posiljkeVrece = repository.getAllWithCondition((Adresnica)param);
    }
    
    public List<Adresnica> getPosiljkeVrece(){
        return posiljkeVrece;
    }
    
}
