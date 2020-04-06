package com.bilisimegitim.postgreprj;

import java.sql.*;

import javax.swing.JOptionPane;

public class VTInsert {

	public static void main(String[] args) {
		
		
		//Bu uygulamanin amaci Burdan veri tabanina Veri Eklemek
		int no = 0;
		String ad = null;
		String soyad =null; //Exeupdate insert into ogrenci icin degiskenleri burda tanimliyoruz
		String sorgu = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.0.238:5432/obs","postgres","postgres");
			Statement st = conn.createStatement();	
			
			no = 14 ;
			ad = "Hamide";
			soyad ="Esen";
			
			sorgu ="insert into ogrenci(no,ad,soyad) values("+no+",'"+ad+"','"+soyad+"') ";
			// insert,update,delete  bu kod ile.Sadece selectler executeQuery ile calisir.
			
			
			System.out.println("Sorgu: "+sorgu);
			int sonuc = st.executeUpdate(sorgu);
			System.out.println("Sonuc:"+sonuc);// Basarili olur ise 1 Döner.Basarisiz olur ise Sifir Döner
			
			
			if (sonuc>0)
			{
				JOptionPane.showMessageDialog(null, no+"Basari ile Eklendi ","Ekleme Sonucu", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0); //GUI li java ekranlarinda btün ekranlari kapatip cikis yapar
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, no+"Eklenemedi ","Ekleme Sonucu", JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
					
				st.close(); // Islem sonrasi kapatmaliyiz
				conn.close(); // Islem sonrasi kapatmaliyiz
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		

	}

}
