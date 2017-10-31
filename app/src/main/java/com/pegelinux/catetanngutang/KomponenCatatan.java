package com.pegelinux.catetanngutang;

public class KomponenCatatan {
	
	private double hutang;
	private String jatuhTempo;
	private String nama;
	
	public KomponenCatatan(String nama,double hutang,String jatuhTempo){
		
		this.nama = nama;
		this.hutang = hutang;
		this.jatuhTempo = jatuhTempo;
		
	}

	public Double getHutang() {
		return hutang;
	}

	public void setHutang(Double hutang) {
		this.hutang = hutang;
	}

	public String getJatuhTempo() {
		return jatuhTempo;
	}

	public void setJatuhTempo(String jatuhTempo) {
		this.jatuhTempo = jatuhTempo;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

}
