package com.upload.db.uploaddb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "img")
@IdClass(Img.class)
public class Img implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5071355562602330751L;

	@Id
	@Column(name = "nome", nullable = false, columnDefinition = "VARCHAR(50)")
    String nome;
	@Id
	@Column(name = "index", nullable = false)
	int index;
	@Id
	@Column(name = "total", nullable = false)
	int total;

	@Column(name = "bytes", columnDefinition = "text")
	String bytes;

	@Column(name = "upload", columnDefinition = "boolean default false")
	boolean upload;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getBytes() {
		return bytes;
	}

	public void setBytes(String bytes) {
		this.bytes = bytes;
	}

	public boolean isUpload() {
		return upload;
	}

	public void setUpload(boolean upload) {
		this.upload = upload;
	}
   

}