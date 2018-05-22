/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Ogretimuyesi;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ridvan
 */
public class AkademisyenYonetici {
    private JTable AkademisyenTablo;
    private final static String SORGU_KALIP = "from Ogretimuyesi m";
    private Session session;
    private Vector<String> sutunlar = new Vector<>();
    private Vector<Object> satir;
    private DefaultTableModel model;
    public AkademisyenYonetici(JTable AkademisyenTablo) {
        this.AkademisyenTablo = AkademisyenTablo;
        sutunlar.add("Akademisyen ID");
        sutunlar.add("Sicil No");
        sutunlar.add("Ad");
        sutunlar.add("Soyad");
        sutunlar.add("Şehir");
        sutunlar.add("Tel No");
        
        model=(DefaultTableModel)AkademisyenTablo.getModel();
        model.setColumnIdentifiers(sutunlar);
    }

    public void AkademisyenGetir(String aranan, String filtre) {
        String sorguMetin = "";
        if (filtre.equalsIgnoreCase("ad")) {
            sorguMetin = SORGU_KALIP + " where m.adOgretimuyesi like '%" + aranan + "%'";
        }
        session.beginTransaction();
        List AkademisyenList = session.createQuery(sorguMetin).list();
        session.getTransaction().commit();
        AkademisyenGoster(AkademisyenList);

    }

    public void ac() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void kapat() {
        session.close();
    }

    private void AkademisyenGoster(List<Ogretimuyesi> AkademisyenList) {
        model.getDataVector().removeAllElements();
        for (Ogretimuyesi gelenMusteri : AkademisyenList) {
            satir=new Vector();
            satir.add(gelenMusteri.getIdOgretimuyesi());
            satir.add(gelenMusteri.getSicilNoOgretimuyesi());
            satir.add(gelenMusteri.getAdOgretimuyesi());
            satir.add(gelenMusteri.getSoyadOgretimuyesi());
            satir.add(gelenMusteri.getSehirOgretimuyesi());
            satir.add(gelenMusteri.getTelNoOgretimuyesi());
            
            model.addRow(satir);
        }
    }

    public void listele() {
        session.beginTransaction();
        List listem = session.createQuery(SORGU_KALIP).list();
        session.getTransaction().commit();
        AkademisyenGoster(listem);
    }
    public void YeniKayit(String sicil,String ad,String soyad,String sehir,String tel){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Ogretimuyesi e = new Ogretimuyesi(sicil,ad,soyad,sehir,tel);
        session.save(e);
        tx.commit();
        listele();
    }

    public void kayitSil(int gelenRow) {
        String silinecekID = model.getValueAt(gelenRow, 0).toString();
        int idNo=Integer.valueOf(silinecekID);
        session=HibernateUtil.getSessionFactory().openSession();
        
        Ogretimuyesi ogr=session.get(Ogretimuyesi.class, idNo);
        session.delete(ogr);
        listele();
    }

    public ArrayList bilgileriAl(int gelenRow) {
   
        ArrayList<String> donecek=new ArrayList<>();
        
        String sicilNo=model.getValueAt(gelenRow, 1).toString();
        String ad=model.getValueAt(gelenRow, 2).toString();
        String soyad=model.getValueAt(gelenRow, 3).toString();
        String sehir=model.getValueAt(gelenRow, 4).toString();
        String tel=model.getValueAt(gelenRow, 5).toString();
        
        donecek.add(sicilNo);
        donecek.add(ad);
        donecek.add(soyad);
        donecek.add(sehir);
        donecek.add(tel);
    
            
       return donecek;
    }
    
    public void guncelle(String gelenSicil,String gelenAd,String gelenSoyad,String gelenSehir,String gelenTel,int gelenRow)
    {
        String guncellenecekId=model.getValueAt(gelenRow, 0).toString();
        int guncellenecekIdNo=Integer.valueOf(guncellenecekId);
        session=HibernateUtil.getSessionFactory().openSession();
        Ogretimuyesi ogr=session.get(Ogretimuyesi.class,guncellenecekIdNo);
        
        
        ogr.setSicilNoOgretimuyesi(gelenSicil);
        ogr.setAdOgretimuyesi(gelenAd);
        ogr.setSoyadOgretimuyesi(gelenSoyad);
        ogr.setSehirOgretimuyesi(gelenSehir);
        ogr.setTelNoOgretimuyesi(gelenTel);
        
        session.update(ogr);
        listele();
        
    }
}
