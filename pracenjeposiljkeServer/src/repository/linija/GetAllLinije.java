/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.linija;

import domain.Linija;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllLinije extends AbstractGenericOperation{

    private List<Linija> linije;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        linije = repository.getAll((Linija)param);
    }
    
    public List<Linija> getLinije(){
        return linije;
    }
    
}
