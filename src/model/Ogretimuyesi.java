package model;
// Generated 20.May.2018 21:39:10 by Hibernate Tools 4.3.1



/**
 * Ogretimuyesi generated by hbm2java
 */
public class Ogretimuyesi  implements java.io.Serializable {


     private Integer idOgretimuyesi;
     private String sicilNoOgretimuyesi;
     private String adOgretimuyesi;
     private String soyadOgretimuyesi;
     private String sehirOgretimuyesi;
     private String telNoOgretimuyesi;

    public Ogretimuyesi() {
    }
    public Ogretimuyesi(int idOgretimuyesi) {
        this.idOgretimuyesi=idOgretimuyesi;
    }
    public Ogretimuyesi(String sicilNoOgretimuyesi, String adOgretimuyesi, String soyadOgretimuyesi, String sehirOgretimuyesi, String telNoOgretimuyesi) {
       this.sicilNoOgretimuyesi = sicilNoOgretimuyesi;
       this.adOgretimuyesi = adOgretimuyesi;
       this.soyadOgretimuyesi = soyadOgretimuyesi;
       this.sehirOgretimuyesi = sehirOgretimuyesi;
       this.telNoOgretimuyesi = telNoOgretimuyesi;
    }
   
    public Integer getIdOgretimuyesi() {
        return this.idOgretimuyesi;
    }
    
    public void setIdOgretimuyesi(Integer idOgretimuyesi) {
        this.idOgretimuyesi = idOgretimuyesi;
    }
    public String getSicilNoOgretimuyesi() {
        return this.sicilNoOgretimuyesi;
    }
    
    public void setSicilNoOgretimuyesi(String sicilNoOgretimuyesi) {
        this.sicilNoOgretimuyesi = sicilNoOgretimuyesi;
    }
    public String getAdOgretimuyesi() {
        return this.adOgretimuyesi;
    }
    
    public void setAdOgretimuyesi(String adOgretimuyesi) {
        this.adOgretimuyesi = adOgretimuyesi;
    }
    public String getSoyadOgretimuyesi() {
        return this.soyadOgretimuyesi;
    }
    
    public void setSoyadOgretimuyesi(String soyadOgretimuyesi) {
        this.soyadOgretimuyesi = soyadOgretimuyesi;
    }
    public String getSehirOgretimuyesi() {
        return this.sehirOgretimuyesi;
    }
    
    public void setSehirOgretimuyesi(String sehirOgretimuyesi) {
        this.sehirOgretimuyesi = sehirOgretimuyesi;
    }
    public String getTelNoOgretimuyesi() {
        return this.telNoOgretimuyesi;
    }
    
    public void setTelNoOgretimuyesi(String telNoOgretimuyesi) {
        this.telNoOgretimuyesi = telNoOgretimuyesi;
    }




}


