package com.example.gestioneallegati_springmvc.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "attachment")
public class Attachment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome_file")
	private String nomeFile;
	@Column(name = "content_type")
	private String contentType;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "datacreazione")
	private LocalDate dataCreazione;

	@Lob
	private byte[] payload;

	public Attachment() {
	}

	public Attachment(Long id, String nomeFile, String contentType, String descrizione, LocalDate dataCreazione,
			byte[] payload) {
		super();
		this.id = id;
		this.nomeFile = nomeFile;
		this.contentType = contentType;
		this.descrizione = descrizione;
		this.dataCreazione = dataCreazione;
		this.payload = payload;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public byte[] getPayload() {
		return payload;
	}

	public void setPayload(byte[] payload) {
		this.payload = payload;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(LocalDate dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

}
