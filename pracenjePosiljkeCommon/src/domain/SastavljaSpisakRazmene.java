/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Vuk
 */
public class SastavljaSpisakRazmene implements Serializable{
    
    private SpisakRazmene spisak;
    private PostanskiRadnik postanskiRadnik;
    private Integer ukupanBrojVreca;

    public SastavljaSpisakRazmene(SpisakRazmene spisak, PostanskiRadnik postanskiRadnik, Integer ukupanBrojVreca) {
        this.spisak = spisak;
        this.postanskiRadnik = postanskiRadnik;
        this.ukupanBrojVreca = ukupanBrojVreca;
    }

    public SpisakRazmene getSpisak() {
        return spisak;
    }

    public void setSpisak(SpisakRazmene spisak) {
        this.spisak = spisak;
    }

    public PostanskiRadnik getPostanskiRadnik() {
        return postanskiRadnik;
    }

    public void setPostanskiRadnik(PostanskiRadnik postanskiRadnik) {
        this.postanskiRadnik = postanskiRadnik;
    }

    public Integer getUkupanBrojVreca() {
        return ukupanBrojVreca;
    }

    public void setUkupanBrojVreca(Integer ukupanBrojVreca) {
        this.ukupanBrojVreca = ukupanBrojVreca;
    }
    
    
    
}
