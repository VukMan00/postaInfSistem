/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.otpremnica;

import domain.Otpremnica;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllOtpremnice extends AbstractGenericOperation{
    
    private List<Otpremnica> otpremnice;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        otpremnice = repository.getAll((Otpremnica)param);
    }
    
    public List<Otpremnica> getOtpremnice(){
        return otpremnice;
    }
    
}
