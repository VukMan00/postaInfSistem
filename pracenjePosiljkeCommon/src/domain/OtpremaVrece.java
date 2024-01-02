/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Vuk
 */
public class OtpremaVrece implements Serializable{
    
    private PopisPosiljakaUSVreci vreca;
    private SpisakRazmene spisak;
    private Integer ukupanBrojPosiljki;
    private LocalDate datumZatvaranja;
    private LocalDateTime vremeZatvaranja;
    private PostanskiRadnik postanskiRadnik;

    public OtpremaVrece(PopisPosiljakaUSVreci vreca, SpisakRazmene spisak, Integer ukupanBrojPosiljki, LocalDate datumZatvaranja, LocalDateTime vremeZatvaranja, PostanskiRadnik postanskiRadnik) {
        this.vreca = vreca;
        this.spisak = spisak;
        this.ukupanBrojPosiljki = ukupanBrojPosiljki;
        this.datumZatvaranja = datumZatvaranja;
        this.vremeZatvaranja = vremeZatvaranja;
        this.postanskiRadnik = postanskiRadnik;
    }

    public PopisPosiljakaUSVreci getVreca() {
        return vreca;
    }

    public void setVreca(PopisPosiljakaUSVreci vreca) {
        this.vreca = vreca;
    }

    public SpisakRazmene getSpisak() {
        return spisak;
    }

    public void setSpisak(SpisakRazmene spisak) {
        this.spisak = spisak;
    }

    public Integer getUkupanBrojPosiljki() {
        return ukupanBrojPosiljki;
    }

    public void setUkupanBrojPosiljki(Integer ukupanBrojPosiljki) {
        this.ukupanBrojPosiljki = ukupanBrojPosiljki;
    }

    public LocalDate getDatumZatvaranja() {
        return datumZatvaranja;
    }

    public void setDatumZatvaranja(LocalDate datumZatvaranja) {
        this.datumZatvaranja = datumZatvaranja;
    }

    public LocalDateTime getVremeZatvaranja() {
        return vremeZatvaranja;
    }

    public void setVremeZatvaranja(LocalDateTime vremeZatvaranja) {
        this.vremeZatvaranja = vremeZatvaranja;
    }

    public PostanskiRadnik getPostanskiRadnik() {
        return postanskiRadnik;
    }

    public void setPostanskiRadnik(PostanskiRadnik postanskiRadnik) {
        this.postanskiRadnik = postanskiRadnik;
    }
    
    
    
}
