package com.bilisimegitim.postgreprj;

import java.sql.*;


public class VTDeneme {

	public static void main(String[] args) {
		
		int no = 0;
		String ad = null;
		String soyad = null;
		
		
		//Veritabani Baglanti classini Olusturuyoruz
		
try {
// Veritabani Driverini Tanitiyoruz
Class.forName("org.postgresql.Driver");

//Connection Objesini Olusturuyoruz
Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.0.238:5432/obs","postgres","postgres");

// Sorgu yazabilmek icin Statement objesi Yaratiyoruz
	Statement st = conn.createStatement();	
	
// Sorgudan Dönenleri Resulset Objesinde Tutacagiz.
	ResultSet rs = st.executeQuery("select no,ad,soyad from ogrenci order by no");
	
// Dönen Satirlari Yazdiralim.
	while(rs.next())
	{
		no = rs.getInt("no");
		ad = rs.getString("ad");
		soyad = rs.getString("soyad");
		System.out.println("No:"+no+ " Ad:"+ad+" Soyad"+soyad );
				
	}		
		rs.close();	// cok rem yedigi icin islem sonuna bunu koyalim cok ram yememesi icin.
			
		st.close(); // Islem sonrasi kapatmaliyiz
		conn.close(); // Islem sonrasi kapatmaliyiz
			
}
catch (Exception e) {
			
e.printStackTrace();
}
		
		
		
		
		
		
		

	}

}
