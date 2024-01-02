/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.korisnik;

import domain.Adresa;
import domain.BrojUlice;
import domain.Korisnik;
import operation.AbstractGenericOperation;
import repository.adresa.UpdateAdresa;
import repository.brojUlice.DeleteBrojUlice;
import repository.brojUlice.UpdateBrojUlice;

/**
 *
 * @author Vuk
 */
public class UpdateKorisnik extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Korisnik korisnik = (Korisnik)param;
        BrojUlice brojUlice = korisnik.getBrUlice();
        Adresa adresa = korisnik.getBrUlice().getAdresa();
        
        new UpdateAdresa().execute(adresa);
        new UpdateBrojUlice().execute(brojUlice);
        repository.updateWithStructureType(korisnik);
    }
    
}
