/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.korisnik;

import domain.Korisnik;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllKorisnik extends AbstractGenericOperation{
    
    private List<Korisnik> korisnici;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        korisnici = repository.getAll((Korisnik)param);
    }
    
    public List<Korisnik> getKorisnici(){
        return korisnici;
    }
    
}
