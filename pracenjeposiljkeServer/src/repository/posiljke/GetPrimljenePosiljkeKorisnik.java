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
public class GetPrimljenePosiljkeKorisnik extends AbstractGenericOperation{
    
    private List<DostavljanjePosiljke> primljenePosiljke;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        primljenePosiljke = repository.getAllWithCondition((DostavljanjePosiljke)param);
    }
    
    public List<DostavljanjePosiljke> getPrimljenePosiljke(){
        return primljenePosiljke;
    }
}
