/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.*;
import operation.AbstractGenericOperation;
import repository.adresa.*;
import repository.brojUlice.*;
import repository.dostavniSpisak.*;
import repository.korisnik.*;
import repository.login.*;
import repository.mesto.*;
import repository.posiljke.*;
import repository.posta.*;
import repository.dostavniSpisak.*;
import repository.linija.AddLinija;
import repository.linija.GetAllLinije;
import repository.linija.UpdateLinija;
import repository.otpremnica.AddOtpremnica;
import repository.otpremnica.GetAllOtpremnice;
import repository.otpremnica.UpdateOtpremnica;
import repository.placanje.AddPodaciPlacanja;
import repository.placanje.AddUplata;
import repository.placanje.AddUplatnica;
import repository.placanje.GetAllUplate;
import repository.placanje.GetUplata;
import repository.postanskiradnik.*;
import repository.potvrdaposiljke.*;
import repository.razduzuje.AddRazduzuje;
import repository.spisakRazmene.*;
import repository.upravljanjelinijama.AddUpravljanje;
import repository.upravljanjelinijama.DeleteUpravlja;
import repository.upravljanjelinijama.GetAllUpravljanja;
import repository.upravljanjelinijama.UpdateUpravlja;
import repository.vozac.AddVozac;
import repository.vozac.GetAllVozac;
import repository.vozac.UpdateVozac;
import repository.vrece.*;

/**
 *
 * @author Vuk
 */
public class Controller {    
    private static Controller controller;
    private AbstractGenericOperation operation;
    
    public Controller() {
    }
    
    public static Controller getInstance(){
        if(controller == null){
            controller =  new Controller();
        }
        
        return controller;
    }
    
    public Object get(Object object) throws Exception{
        if(object instanceof Adresnica) return getAdresnica(object);
        if(object instanceof Uplata) return getUplata(object);
        if(object instanceof PopisPosiljakaUSVreci) return getVreca(object);
        return null;
    }
    
    public Object getAll(Object object) throws Exception{
        if(object instanceof DostavljanjePosiljke) return getDostavljanjePosiljke(object);
        if(object instanceof Adresnica) return getPosiljke(object);
        if(object instanceof Korisnik) return getKorisnici(object);
        if(object instanceof Mesto) return getMesta(object);
        if(object instanceof PopisPosiljakaUSVreci) return getVrece(object);
        if(object instanceof SpisakRazmene) return getSpiskoviRazmene(object);
        if(object instanceof PotvrdaOPrijemuPosiljke) return getPotvrdePosiljke(object);
        if(object instanceof DostavniSpisak) return getDostavneSpiskove(object);
        if(object instanceof PostanskiRadnik) return getPostanskiRadnici(object);
        if(object instanceof Posta) return getPoste(object);
        if(object instanceof Uplata) return getUplate(object);
        if(object instanceof Otpremnica) return getOtpremnice(object);
        if(object instanceof Vozac) return getVozaci(object);
        if(object instanceof Upravlja) return getUpravljanja(object);
        if(object instanceof Linija) return getLinije(object);
        return null;
    }
    
    public Object getAllWithCondition(Object object) throws Exception{
        if(object instanceof Adresnica) return getPosiljkeVrece(object);
        if(object instanceof DostavljanjePosiljke) return getPrimljenePosiljkeKorisnik(object);
        return null;
    }
    
    public Object getAllWithPartition(Object object) throws Exception{
        if(object instanceof DostavljanjePosiljke) return getDostavljanePosiljkePartition(object);
        return null;
    }
    
    public void add(Object object) throws Exception{
        if(object instanceof Korisnik) addKorisnik(object);
        if(object instanceof Adresnica) addPosiljka(object);
        if(object instanceof PotvrdaOPrijemuPosiljke) addPotvrdaPosiljke(object);
        if(object instanceof DostavniSpisak) addDostavniSpisak(object);
        if(object instanceof DostavljanjePosiljke) addDostavljanjePosiljke(object);
        if(object instanceof PodaciPlacanja) addPodaciPlacanja(object);
        if(object instanceof Uplatnica) addUplatnica(object);
        if(object instanceof Uplata) addUplata(object);
        if(object instanceof Razduzuje) addRazduzuje(object);
        if(object instanceof Otpremnica) addOtpremnica(object);
        if(object instanceof Upravlja) addUpravlja(object);
        if(object instanceof Vozac) addVozac(object);
        if(object instanceof Linija) addLinija(object);
        if(object instanceof PopisPosiljakaUSVreci) addVreca(object);
    }
    
    public void update(Object object) throws Exception{
        if(object instanceof Korisnik) updateKorisnik(object);
        if(object instanceof Adresnica) updatePosiljka(object);
        if(object instanceof PotvrdaOPrijemuPosiljke) updatePotvrdaPosiljke(object);
        if(object instanceof DostavniSpisak) updateDostavniSpisak(object);
        if(object instanceof Otpremnica) updateOtpremnica(object);
        if(object instanceof Upravlja) updateUpravlja(object);
        if(object instanceof Vozac) updateVozac(object);
        if(object instanceof Linija) updateLinija(object);
        if(object instanceof PopisPosiljakaUSVreci) updateVreca(object);
    }
    
    public void delete(Object object) throws Exception{
        if(object instanceof Mesto) deleteMesto(object);
        if(object instanceof Adresa) deleteAdresa(object);
        if(object instanceof BrojUlice) deleteBrojUlice(object);
        if(object instanceof Korisnik) deleteKorisnik(object);
        if(object instanceof Adresnica) deletePosiljka(object);
        if(object instanceof DostavniSpisak) deleteDostavniSpisak(object);
        if(object instanceof Upravlja) deleteUpravlja(object);
        if(object instanceof PopisPosiljakaUSVreci) deleteVreca(object);
    }

    public GenericEntity login(UserLogin user) throws Exception{
        operation = new Login();
        operation.execute(user);
        return ((Login)operation).getObject();
    }

    private Object getDostavljanjePosiljke(Object argument) throws Exception {
        operation = new GetPrimljenePosiljke();
        operation.execute(argument);
        return ((GetPrimljenePosiljke)operation).getPrimljenePosiljke();
    }

    private Object getPosiljke(Object argument) throws Exception {
        operation = new GetPoslatePosiljke();
        operation.execute(argument);
        return ((GetPoslatePosiljke)operation).getPoslatePosiljke();
    }
    
    private Object getKorisnici(Object argument) throws Exception {
        operation = new GetAllKorisnik();
        operation.execute(argument);
        return ((GetAllKorisnik)operation).getKorisnici();
    }
    
    private Object getMesta(Object argument) throws Exception {
        operation = new GetAllMesto();
        operation.execute(argument);
        return ((GetAllMesto)operation).getMesta();
    }
    
    private Object getVrece(Object argument) throws Exception {
        operation = new GetAllVrece();
        operation.execute(argument);
        return ((GetAllVrece)operation).getVrece();
    }
    
    
    private Object getSpiskoviRazmene(Object argument) throws Exception {
        operation = new GetAllSpisakRazmene();
        operation.execute(argument);
        return ((GetAllSpisakRazmene)operation).getSpiskovi();
    }
    
    private Object getPotvrdePosiljke(Object argument) throws Exception {
        operation = new GetAllPotvrdePosiljke();
        operation.execute(argument);
        return ((GetAllPotvrdePosiljke)operation).getPotvrde();
    }
    
    private Object getDostavneSpiskove(Object argument) throws Exception {
        operation = new GetAllDostavniSpisak();
        operation.execute(argument);
        return ((GetAllDostavniSpisak)operation).getSpiskovi();
    }
    
    private Object getPostanskiRadnici(Object argument) throws Exception {
        operation = new GetAllPostanskiRadnici();
        operation.execute(argument);
        return ((GetAllPostanskiRadnici)operation).getPostanskiRadnici();
    }

    private Object getPoste(Object argument) throws Exception {
        operation = new GetAllPoste();
        operation.execute(argument);
        return ((GetAllPoste)operation).getPoste();
    }
    
    private Object getPosiljkeVrece(Object argument) throws Exception {
        operation = new GetAllPosiljkeVrece();
        operation.execute(argument);
        return ((GetAllPosiljkeVrece) operation).getPosiljkeVrece();
    }
    
    private Object getPrimljenePosiljkeKorisnik(Object argument) throws Exception {
        operation = new GetPrimljenePosiljkeKorisnik();
        operation.execute(argument);
        return ((GetPrimljenePosiljkeKorisnik)operation).getPrimljenePosiljke();
    }
    
    private Object getUplate(Object argument) throws Exception {
        operation = new GetAllUplate();
        operation.execute(argument);
        return ((GetAllUplate)operation).getUplate();
    }
    
    private Object getOtpremnice(Object argument) throws Exception{
        operation = new GetAllOtpremnice();
        operation.execute(argument);
        return ((GetAllOtpremnice)operation).getOtpremnice();
    }
    
    private Object getDostavljanePosiljkePartition(Object argument) throws Exception {
        operation = new GetDostavljanePosiljkePartition();
        operation.execute(argument);
        return ((GetDostavljanePosiljkePartition)operation).getDostavljanePosiljke();
    }
    
    private Object getVozaci(Object argument) throws Exception {
        operation = new GetAllVozac();
        operation.execute(argument);
        return ((GetAllVozac)operation).getVozaci();
    }
    
    private Object getUpravljanja(Object argument) throws Exception {
        operation = new GetAllUpravljanja();
        operation.execute(argument);
        return ((GetAllUpravljanja)operation).getUpravljanja();
    }
    
    private Object getAdresnica(Object argument) throws Exception {
        operation = new GetPosiljka();
        operation.execute(argument);
        return ((GetPosiljka)operation).getPosiljka();
    }

    private Object getUplata(Object argument) throws Exception {
        operation = new GetUplata();
        operation.execute(argument);
        return ((GetUplata)operation).getUplata();
    }
    
    private Object getVreca(Object argument) throws Exception {
         operation = new GetVreca();
         operation.execute(argument);
         return ((GetVreca)operation).getVreca();
    }
    
    private Object getLinije(Object argument) throws Exception {
        operation = new GetAllLinije();
        operation.execute(argument);
        return ((GetAllLinije)operation).getLinije();
    }
        
    private void addKorisnik(Object argument) throws Exception {
        operation = new AddKorisnik();
        operation.execute(argument);
    }
    
    private void addPosiljka(Object argument) throws Exception {
        operation = new AddPosiljka();
        operation.execute(argument);
    }
    
    private void addPotvrdaPosiljke(Object argument) throws Exception {
        operation = new AddPotvrdaPosiljke();
        operation.execute(argument);
    }
    
    private void addDostavniSpisak(Object argument) throws Exception {
        operation = new AddDostavniSpisak();
        operation.execute(argument);
    }
    
    private void addDostavljanjePosiljke(Object argument) throws Exception {
        operation = new AddDostavljanjePosiljke();
        operation.execute(argument);
    }
    
    private void addPodaciPlacanja(Object argument) throws Exception {
        operation = new AddPodaciPlacanja();
        operation.execute(argument);
    }

    private void addUplatnica(Object argument) throws Exception {
        operation = new AddUplatnica();
        operation.execute(argument);
    }
    
    private void addUplata(Object argument) throws Exception {
        operation = new AddUplata();
        operation.execute(argument);
    }
    
    private void addRazduzuje(Object argument) throws Exception {
        operation = new AddRazduzuje();
        operation.execute(argument);
    }
    
    private void addOtpremnica(Object argument) throws Exception {
        operation = new AddOtpremnica();
        operation.execute(argument);
    }
    
    private void addVozac(Object argument) throws Exception{
        operation = new AddVozac();
        operation.execute(argument);
    }
    
    private void addLinija(Object argument) throws Exception{
        operation = new AddLinija();
        operation.execute(argument);
    }
    
    private void addUpravlja(Object argument) throws Exception{
        operation = new AddUpravljanje();
        operation.execute(argument);
    }
    
    private void addVreca(Object argument) throws Exception{
        operation = new AddVreca();
        operation.execute(argument);
    }
    
    private void updateVreca(Object argument) throws Exception{
        operation = new UpdateVreca();
        operation.execute(argument);
    }
    
    private void updateVozac(Object argument) throws Exception{
        operation = new UpdateVozac();
        operation.execute(argument);
    }
        
    private void updateKorisnik(Object argument) throws Exception {
        operation = new UpdateKorisnik();
        operation.execute(argument);
    }
    
    private void updatePosiljka(Object argument) throws Exception {
        operation = new UpdatePosiljka();
        operation.execute(argument);
    }
    
    private void updatePotvrdaPosiljke(Object argument) throws Exception {
        operation = new UpdatePotvrdaPosiljke();
        operation.execute(argument);
    }
    
    private void updateDostavniSpisak(Object argument) throws Exception {
        operation = new UpdateDostavniSpisak();
        operation.execute(argument);
    }
    
    private void updateOtpremnica(Object argument) throws Exception{
        operation = new UpdateOtpremnica();
        operation.execute(argument);
    }
    
    private void updateUpravlja(Object argument) throws Exception{
        operation = new UpdateUpravlja();
        operation.execute(argument);
    }
    
    private void updateLinija(Object argument) throws Exception{
        operation = new UpdateLinija();
        operation.execute(argument);
    }

    private void deleteMesto(Object argument) throws Exception {
        operation = new DeleteMesto();
        operation.execute(argument);
    }

    private void deleteAdresa(Object argument) throws Exception {
        operation = new DeleteAdresa();
        operation.execute(argument);
    }

    private void deleteBrojUlice(Object argument) throws Exception {
        operation = new DeleteBrojUlice();
        operation.execute(argument);
    }

    private void deleteKorisnik(Object argument) throws Exception {
        operation = new DeleteKorisnik();
        operation.execute(argument);
    }

    private void deletePosiljka(Object argument) throws Exception {
        operation = new DeletePosiljka();
        operation.execute(argument);
    }

    private void deleteDostavniSpisak(Object argument) throws Exception{
        operation = new DeleteDostavniSpisak();
        operation.execute(argument);
    }
    
    private void deleteUpravlja(Object argument) throws Exception{
        operation = new DeleteUpravlja();
        operation.execute(argument);
    }

    private void deleteVreca(Object argument) throws Exception {
        operation = new DeleteVreca();
        operation.execute(argument);
    }    
}
