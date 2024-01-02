/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.posiljke;

import domain.Adresnica;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetPosiljka extends AbstractGenericOperation{
    
    private Adresnica posiljka;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        posiljka = (Adresnica) repository.get((Adresnica)param);
    }
    
    public Adresnica getPosiljka(){
        return posiljka;
    }
}
