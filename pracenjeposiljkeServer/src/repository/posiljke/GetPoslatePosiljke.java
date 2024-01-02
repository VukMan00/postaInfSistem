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
public class GetPoslatePosiljke extends AbstractGenericOperation{
    
    private List<Adresnica> posiljke;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        posiljke = repository.getAll((Adresnica)param);
    }
    
    public List<Adresnica> getPoslatePosiljke(){
        return posiljke;
    }
    
}
