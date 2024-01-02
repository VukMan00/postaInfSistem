/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.korisnik;

import domain.Adresa;
import domain.BrojUlice;
import domain.Korisnik;
import operation.AbstractGenericOperation;
import repository.adresa.DeleteAdresa;
import repository.brojUlice.DeleteBrojUlice;

/**
 *
 * @author Vuk
 */
public class DeleteKorisnik extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Korisnik korisnik = (Korisnik)param;
        Adresa adresa = korisnik.getBrUlice().getAdresa();
        BrojUlice brUlice = korisnik.getBrUlice();
        
        repository.delete(korisnik);
        new DeleteBrojUlice().execute(brUlice);
        new DeleteAdresa().execute(adresa);
    }
    
}
