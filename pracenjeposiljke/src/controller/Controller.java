/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import communication.*;
import domain.Adresa;
import domain.Adresnica;
import domain.BrojUlice;
import domain.DostavljanjePosiljke;
import domain.DostavniSpisak;
import domain.Korisnik;
import domain.Linija;
import domain.Mesto;
import domain.Otpremnica;
import domain.PodaciPlacanja;
import domain.PopisPosiljakaUSVreci;
import domain.Posta;
import domain.PostanskiRadnik;
import domain.PotvrdaOPrijemuPosiljke;
import domain.Razduzuje;
import domain.SpisakRazmene;
import domain.Uplata;
import domain.Uplatnica;
import domain.Upravlja;
import domain.UserLogin;
import domain.Vozac;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Vuk
 */
public class Controller {
    private final Socket socket;
    private final Sender sender;
    private final Receiver receiver;
    private Request request;
    private Response response;
    private static Controller instance;
    
     private Controller() throws IOException{
        socket = new Socket("localhost",9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);   
    }
     
    public static Controller getInstance() throws IOException{
        if(instance==null){
            instance = new Controller();
        }
        return instance;
    }
    
    public Object authenticate(UserLogin userLogin) throws Exception{
        try {
            request = new Request(Operation.LOGIN, userLogin);
            sender.send(request);
            response = (Response) receiver.receive();
            return response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public Adresnica getPosiljka(Adresnica posiljka) throws Exception{
        try {
            request = new Request(Operation.GET, posiljka);
            sender.send(request);
            response = (Response) receiver.receive();
            return (Adresnica)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public Uplata getUplata(Uplata uplata) throws Exception{
        try {
            request = new Request(Operation.GET, uplata);
            sender.send(request);
            response = (Response) receiver.receive();
            return (Uplata)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public Uplatnica getUplatnica(Uplatnica uplatnica) throws Exception{
        try {
            request = new Request(Operation.GET, uplatnica);
            sender.send(request);
            response = (Response) receiver.receive();
            return (Uplatnica)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public PopisPosiljakaUSVreci getVreca(PopisPosiljakaUSVreci vreca) throws Exception{
        try {
            request = new Request(Operation.GET, vreca);
            sender.send(request);
            response = (Response) receiver.receive();
            return (PopisPosiljakaUSVreci)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<DostavljanjePosiljke> getPrimljenePosiljke(DostavljanjePosiljke dp) throws Exception{
        try {
            request = new Request(Operation.GET_ALL, dp);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<DostavljanjePosiljke>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<DostavljanjePosiljke> getPredatePosiljkePoKvartalu(DostavljanjePosiljke dp) throws Exception{
        try {
            request = new Request(Operation.GET_ALL_PARTITION, dp);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<DostavljanjePosiljke>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<Adresnica> getPosiljke(Adresnica adresnica) throws Exception{
        try {
            request = new Request(Operation.GET_ALL, adresnica);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<Adresnica>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<PopisPosiljakaUSVreci> getVrece(PopisPosiljakaUSVreci vreca) throws Exception{
        try {
            request = new Request(Operation.GET_ALL,vreca);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<PopisPosiljakaUSVreci>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<SpisakRazmene> getSpiskoviRazmene(SpisakRazmene spisak) throws Exception{
        try {
            request = new Request(Operation.GET_ALL, spisak);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<SpisakRazmene>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<Korisnik> getKorisnici(Korisnik korisnik) throws Exception{
        try {
            request = new Request(Operation.GET_ALL, korisnik);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<Korisnik>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<Mesto> getMesta(Mesto mesto) throws Exception{
        try {
            request = new Request(Operation.GET_ALL, mesto);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<Mesto>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<PotvrdaOPrijemuPosiljke> getPotvrdePosiljke(PotvrdaOPrijemuPosiljke potvrda) throws Exception {
        try {
            request = new Request(Operation.GET_ALL, potvrda);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<PotvrdaOPrijemuPosiljke>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<DostavniSpisak> getDostavneSpiskove(DostavniSpisak dostavniSpisak) throws Exception{
        try {
            request = new Request(Operation.GET_ALL, dostavniSpisak);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<DostavniSpisak>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<PostanskiRadnik> getPostanskiRadnici(PostanskiRadnik radnik) throws Exception{
        try {
            request = new Request(Operation.GET_ALL, radnik);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<PostanskiRadnik>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<Posta> getPoste(Posta posta) throws Exception{
        try {
            request = new Request(Operation.GET_ALL, posta);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<Posta>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    
    public List<Adresnica> getPosiljkeVrece(Adresnica adresnica) throws Exception {
        try {
            request = new Request(Operation.GET_ALL_CONDITION, adresnica);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<Adresnica>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<DostavljanjePosiljke> getPrimljenePosiljkeKorisnika(DostavljanjePosiljke dp) throws Exception{
        try {
            request = new Request(Operation.GET_ALL_CONDITION, dp);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<DostavljanjePosiljke>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<Uplata> getUplate(Uplata uplata) throws Exception{
        try {
            request = new Request(Operation.GET_ALL, uplata);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<Uplata>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<Otpremnica> getOtpremnice(Otpremnica otpremnica) throws Exception{
        try {
            request = new Request(Operation.GET_ALL, otpremnica);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<Otpremnica>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<Vozac> getVozace(Vozac vozac) throws Exception{
        try {
            request = new Request(Operation.GET_ALL, vozac);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<Vozac>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<Upravlja> getUpravljanjaLinijama(Upravlja upravlja) throws Exception{
        try {
            request = new Request(Operation.GET_ALL, upravlja);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<Upravlja>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public List<Linija> getLinije(Linija linija) throws Exception{
        try {
            request = new Request(Operation.GET_ALL, linija);
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<Linija>)response.getResult();
        } catch (Exception ex) {
            throw response.getException();
        }
    }
    
    public void addKorisnik(Korisnik korisnik) throws Exception{
        request = new Request(Operation.ADD, korisnik);
        sender.send(request);
        response = (Response) receiver.receive();
    }
    
    public void addPosiljka(Adresnica adresnica) throws Exception{
        request = new Request(Operation.ADD,adresnica);
        sender.send(request);
        response = (Response) receiver.receive();
    }
    
    public void addPotvrdaOPrijemuPosiljke(PotvrdaOPrijemuPosiljke potvrda) throws Exception{
        request = new Request(Operation.ADD, potvrda);
        sender.send(request);
        response = (Response)receiver.receive();
    }
    
    public void addDostavniSpisak(DostavniSpisak dostavniSpisak) throws Exception{
        request = new Request(Operation.ADD, dostavniSpisak);
        sender.send(request);
        response = (Response)receiver.receive();
    }
    
    public void addDostavljanjePosiljke(DostavljanjePosiljke dostavljanaPosiljka) throws Exception{
        request = new Request(Operation.ADD, dostavljanaPosiljka);
        sender.send(request);
        response = (Response)receiver.receive();
    }
    
    public void addPodaciPlacanja(PodaciPlacanja podaciPlacanja) throws Exception{
        request = new Request(Operation.ADD, podaciPlacanja);
        sender.send(request);
        response = (Response) receiver.receive();
    }
    
    public void addUplatnica(Uplatnica uplatnica) throws Exception{
        request = new Request(Operation.ADD, uplatnica);
        sender.send(request);
        response = (Response) receiver.receive();
    }
    
    public void addUplata(Uplata uplata) throws Exception {
        request = new Request(Operation.ADD, uplata);
        sender.send(request);
        response = (Response) receiver.receive();
    }
    
    public void addRazduzuje(Razduzuje razduzuje) throws Exception{
        request = new Request(Operation.ADD, razduzuje);
        sender.send(request);
        response = (Response) receiver.receive();
    }
    
    public void addOtpremnica(Otpremnica otpremnica) throws Exception{
        request = new Request(Operation.ADD, otpremnica);
        sender.send(request);
        response = (Response) receiver.receive();
    }
    
    public void addUpravlja(Upravlja upravlja) throws Exception{
        request = new Request(Operation.ADD, upravlja);
        sender.send(request);
        response = (Response) receiver.receive();
    }
    
    public void addVozac(Vozac vozac) throws Exception{
        request = new Request(Operation.ADD, vozac);
        sender.send(request);
        response = (Response) receiver.receive();
    }
    
    public void addLinija(Linija linija) throws Exception{
        request = new Request(Operation.ADD, linija);
        sender.send(request);
        response = (Response) receiver.receive();
    }
    
    public void addVreca(PopisPosiljakaUSVreci vreca) throws Exception{
        request = new Request(Operation.ADD, vreca);
        sender.send(request);
        response = (Response) receiver.receive();
    }
    
    public void updateKorisnik(Korisnik korisnik) throws Exception {
        request = new Request(Operation.UPDATE, korisnik);
        sender.send(request);
        response = (Response)receiver.receive();
    }
    
    public void updatePosiljka(Adresnica adresnica) throws Exception{
        request = new Request(Operation.UPDATE, adresnica);
        sender.send(request);
        response = (Response)receiver.receive();
    }
    
    public void updatePotvrdaPosiljke(PotvrdaOPrijemuPosiljke potvrda) throws Exception{
        request = new Request(Operation.UPDATE, potvrda);
        sender.send(request);
        response = (Response)receiver.receive();
    }
    
    public void updateDostavniSpisak(DostavniSpisak dostavniSpisak) throws Exception{
        request = new Request(Operation.UPDATE, dostavniSpisak);
        sender.send(request);
        response = (Response)receiver.receive();
    }
    
    public void updateOtpremnica(Otpremnica otpremnica) throws Exception{
        request = new Request(Operation.UPDATE, otpremnica);
        sender.send(request);
        response = (Response)receiver.receive();
    }
    
    public void updateUpravlja(Upravlja upravlja) throws Exception{
        request = new Request(Operation.UPDATE, upravlja);
        sender.send(request);
        response = (Response)receiver.receive();
    }
    
    public void updateVozac(Vozac vozac) throws Exception{
        request = new Request(Operation.UPDATE, vozac);
        sender.send(request);
        response = (Response)receiver.receive();
    }
    
    public void updateLinija(Linija linija) throws Exception{
        request = new Request(Operation.UPDATE, linija);
        sender.send(request);
        response = (Response)receiver.receive();
    }
    
    public void updateVreca(PopisPosiljakaUSVreci vreca) throws Exception{
        request = new Request(Operation.UPDATE, vreca);
        sender.send(request);
        response = (Response) receiver.receive();
    }
    
    public void deleteMesto(Mesto mesto) throws Exception{
        request = new Request(Operation.DELETE, mesto);
        sender.send(request);
        response = (Response) receiver.receive();
    }

    public void deleteBrojUlice(BrojUlice brojUlice) throws Exception{
        request = new Request(Operation.DELETE, brojUlice);
        sender.send(request);
        response = (Response) receiver.receive();
    }

    public void deleteAdresa(Adresa adresa) throws Exception {
        request = new Request(Operation.DELETE, adresa);
        sender.send(request);
        response = (Response) receiver.receive();
    }

    public void deleteKorisnik(Korisnik korisnik) throws Exception {
        request = new Request(Operation.DELETE, korisnik);
        sender.send(request);
        response = (Response) receiver.receive();
    }
    
    public void deletePosiljka(Adresnica adresnica) throws Exception{
        request = new Request(Operation.DELETE, adresnica);
        sender.send(request);
        response = (Response) receiver.receive();
    }

    public void deleteDostavniSpisak(DostavniSpisak dostavniSpisak) throws Exception{
        request = new Request(Operation.DELETE, dostavniSpisak);
        sender.send(request);
        response = (Response) receiver.receive();
    }
    
    public void deleteUpravlja(Upravlja upravlja) throws Exception{
        request = new Request(Operation.DELETE, upravlja);
        sender.send(request);
        response = (Response) receiver.receive();
    }
    
    public void deleteVreca(PopisPosiljakaUSVreci vreca) throws Exception{
        request = new Request(Operation.DELETE, vreca);
        sender.send(request);
        response = (Response) receiver.receive();
    }

}
