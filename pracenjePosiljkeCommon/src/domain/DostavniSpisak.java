/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vuk
 */
public class DostavniSpisak implements GenericEntity{
    
    private Integer oznakaDostavnogSpiska;
    private LocalDate datumStampe;
    private LocalDateTime vremeStampe;
    private PopisPosiljakaUSVreci vreca;
    private Posta posta;
    private PostanskiRadnik postar;
    private PostanskiRadnik obracunskiRadnik;
    
    public DostavniSpisak(){
        
    }

    public DostavniSpisak(Integer oznakaDostavnogSpiska, LocalDate datumStampe, LocalDateTime vremeStampe,PopisPosiljakaUSVreci vreca, Posta posta, PostanskiRadnik postar, PostanskiRadnik obracunskiRadnik) {
        this.oznakaDostavnogSpiska = oznakaDostavnogSpiska;
        this.datumStampe = datumStampe;
        this.vremeStampe = vremeStampe;
        this.vreca = vreca;
        this.posta = posta;
        this.postar = postar;
        this.obracunskiRadnik = obracunskiRadnik;
    }

    public Integer getOznakaDostavnogSpiska() {
        return oznakaDostavnogSpiska;
    }

    public void setOznakaDostavnogSpiska(Integer oznakaDostavnogSpiska) {
        this.oznakaDostavnogSpiska = oznakaDostavnogSpiska;
    }

    public LocalDate getDatumStampe() {
        return datumStampe;
    }

    public void setDatumStampe(LocalDate datumStampe) {
        this.datumStampe = datumStampe;
    }

    public LocalDateTime getVremeStampe() {
        return vremeStampe;
    }

    public void setVremeStampe(LocalDateTime vremeStampe) {
        this.vremeStampe = vremeStampe;
    }

    public Posta getPosta() {
        return posta;
    }

    public void setPosta(Posta posta) {
        this.posta = posta;
    }

    public PostanskiRadnik getPostar() {
        return postar;
    }

    public void setPostar(PostanskiRadnik postar) {
        this.postar = postar;
    }

    public PostanskiRadnik getObracunskiRadnik() {
        return obracunskiRadnik;
    }

    public void setObracunskiRadnik(PostanskiRadnik obracunskiRadnik) {
        this.obracunskiRadnik = obracunskiRadnik;
    }

    public PopisPosiljakaUSVreci getVreca() {
        return vreca;
    }

    public void setVreca(PopisPosiljakaUSVreci vreca) {
        this.vreca = vreca;
    }

    @Override
    public String toString() {
        return oznakaDostavnogSpiska.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.oznakaDostavnogSpiska);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DostavniSpisak other = (DostavniSpisak) obj;
        return Objects.equals(this.oznakaDostavnogSpiska, other.oznakaDostavnogSpiska);
    }
    
    @Override
    public String getSelectValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ds.oznakaDostavnogSpiska,ds.datumStampe,ds.vremeStampe,ds.oznakaVrece, ")
          .append("p.redniBroj AS redniBrojPoste,p.naziv AS nazivPoste, ")
          .append("po.sifraRadnika AS sifraRadnikaPostara,po.imePrezime AS imePrezimePostara, ")
          .append("obr.sifraRadnika AS sifraRadnikaObracunskogRadnika,obr.imePrezime AS imePrezimeObracunskogRadnika")
          .append(" FROM ").append(getTableName()).append(" ds ")
          .append("INNER JOIN VUK.postanski_radnik po ON ds.sifraPostara=po.sifraRadnika ")
          .append("INNER JOIN VUK.postanski_radnik obr ON ds.sifraObracunskogRadnika=obr.sifraRadnika ")
          .append("INNER JOIN VUK.posta p ON ds.redniBrojPoste=p.redniBroj ");
        return sb.toString();
    }

    @Override
    public GenericEntity getObject(ResultSet rs) {
        try {
            oznakaDostavnogSpiska = rs.getInt("oznakaDostavnogSpiska");
            datumStampe = rs.getDate("datumStampe").toLocalDate();
            vremeStampe = rs.getTimestamp("vremeStampe").toLocalDateTime();
            Integer oznakaVrece = rs.getInt("oznakaVrece");
            Integer redniBrojPoste = rs.getInt("redniBrojPoste");
            String nazivPoste = rs.getString("nazivPoste");
            Integer sifraRadnikaPostar = rs.getInt("sifraRadnikaPostara");
            String imePrezimePostar = rs.getString("imePrezimePostara");
            Integer sifraRadnikaObracunskiRadnik = rs.getInt("sifraRadnikaObracunskogRadnika");
            String imePrezimeObracunskiRadnik = rs.getString("imePrezimeObracunskogRadnika");
            
            posta = new Posta(redniBrojPoste, nazivPoste);
            postar = new PostanskiRadnik(sifraRadnikaPostar, imePrezimePostar, TipRadnika.POSTAR, posta);
            obracunskiRadnik = new PostanskiRadnik(sifraRadnikaObracunskiRadnik, imePrezimeObracunskiRadnik, TipRadnika.OBRACUNSKI_RADNIK, posta);
            vreca = new PopisPosiljakaUSVreci();
            vreca.setOznakaVrece(oznakaVrece);
            
            return new DostavniSpisak(oznakaDostavnogSpiska, datumStampe, vremeStampe, vreca, posta, postar, obracunskiRadnik);
        } catch (SQLException ex) {
            Logger.getLogger(DostavniSpisak.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName() {
        return "VUK.dostavni_spisak";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "oznakaDostavnogSpiska,datumStampe,vremeStampe,redniBrojPoste,sifraPostara,sifraObracunskogRadnika,oznakaVrece";
    }

    @Override
    public String getInsertValues() {
        String datumStampeFormmated = formatDatumStampe();
        String vremeStampeFormmated = formatVremeStampe();
        StringBuilder sb = new StringBuilder();
        sb.append(oznakaDostavnogSpiska).append(",")
          .append("TO_DATE(").append("'").append(datumStampeFormmated).append("','DD-MM-YYYY'),")
          .append("TO_TIMESTAMP(").append("'").append(vremeStampeFormmated).append("','DD-MM-YYYY HH24:MI:SS'),")
          .append(posta.getRedniBroj()).append(",")
          .append(postar.getSifraRadnika()).append(",")
          .append(obracunskiRadnik.getSifraRadnika()).append(",")
          .append(vreca.getOznakaVrece());
        return sb.toString();
    }

    @Override
    public String getUpdateSetValues() {
        String datumStampeFormmated = formatDatumStampe();
        String vremeStampeFormmated = formatVremeStampe();
        StringBuilder sb = new StringBuilder();
        sb.append("datumStampe=").append("TO_DATE(").append("'").append(datumStampeFormmated).append("','DD-MM-YYYY'),")
          .append("vremeStampe=").append("TO_TIMESTAMP(").append("'").append(vremeStampeFormmated).append("','DD-MM-YYYY HH24:MI:SS'),")
          .append("redniBrojPoste=").append(posta.getRedniBroj()).append(",")
          .append("sifraPostara=").append(postar.getSifraRadnika()).append(",")
          .append("sifraObracunskogRadnika=").append(obracunskiRadnik.getSifraRadnika()).append(",")
          .append("oznakaVrece=").append(vreca.getOznakaVrece());
        return sb.toString();
    }

    @Override
    public String getUpdateCondition() {
        return "oznakaDostavnogSpiska=" + oznakaDostavnogSpiska;
    }

    @Override
    public String getDeleteCondition() {
        return "oznakaDostavnogSpiska=" + oznakaDostavnogSpiska;
    }

    @Override
    public String getWhereGetCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setObjectStatement(PreparedStatement statement) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setTypeMap(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String formatDatumStampe() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDatumStampe = dtf.format(datumStampe);
        return formattedDatumStampe;
    }

    private String formatVremeStampe() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedVremeStampe = dtf.format(vremeStampe);
        return formattedVremeStampe;
    }

    @Override
    public String getSelectValuesWithCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSelectValuesWithPartition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
