/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.postanskiradnik;

import domain.PostanskiRadnik;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllPostanskiRadnici extends AbstractGenericOperation{
    
    private List<PostanskiRadnik> postanskiRadnici;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        postanskiRadnici = repository.getAll((PostanskiRadnik)param);
    }
    
    public List<PostanskiRadnik> getPostanskiRadnici(){
        return postanskiRadnici;
    }
    
}
