/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.korisnik;

import domain.Adresa;
import domain.BrojUlice;
import domain.Korisnik;
import domain.Mesto;
import operation.AbstractGenericOperation;
import repository.adresa.AddAdresa;
import repository.brojUlice.AddBrojUlice;
import repository.mesto.AddMesto;

/**
 *
 * @author Vuk
 */
public class AddKorisnik extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Korisnik korisnik = (Korisnik)param;
        BrojUlice brUlice = korisnik.getBrUlice();
        Adresa adresa = brUlice.getAdresa();
        
        new AddAdresa().execute(adresa);
        new AddBrojUlice().execute(brUlice);
        
        repository.addWithStructureType((Korisnik)param);
    }
    
}
