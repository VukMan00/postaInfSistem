/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.posiljke;

import domain.DostavljanjePosiljke;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetDostavljanePosiljkePartition extends AbstractGenericOperation{
    
    private List<DostavljanjePosiljke> dostavljanePosiljke;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        dostavljanePosiljke = repository.getAlllWithPartition((DostavljanjePosiljke)param);
    }
    
    public List<DostavljanjePosiljke> getDostavljanePosiljke(){
        return dostavljanePosiljke;
    }
    
}
