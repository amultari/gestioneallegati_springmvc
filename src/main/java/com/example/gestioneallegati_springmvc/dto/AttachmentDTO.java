package com.example.gestioneallegati_springmvc.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.example.gestioneallegati_springmvc.model.Attachment;

public class AttachmentDTO {

	private Long id;
	private String nomeFile;
	private String contentType;
	private String descrizione;
	private LocalDate dataCreazione;

	private byte[] payload;

	public AttachmentDTO() {
	}

	public AttachmentDTO(Long id, String nomeFile, String contentType, String descrizione, LocalDate dataCreazione,
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public byte[] getPayload() {
		return payload;
	}

	public void setPayload(byte[] payload) {
		this.payload = payload;
	}

	public LocalDate getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(LocalDate dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Attachment buildModelFromDTO() {
		return new Attachment(this.getId(), this.getNomeFile(), this.getContentType(), this.getDescrizione(),
				this.getDataCreazione(), this.getPayload());
	}

	public static AttachmentDTO buildAttachmentDTOFromModel(Attachment attachmentModel) {
		AttachmentDTO result = new AttachmentDTO(attachmentModel.getId(), attachmentModel.getNomeFile(),
				attachmentModel.getContentType(), attachmentModel.getDescrizione(), attachmentModel.getDataCreazione(),
				attachmentModel.getPayload());
		return result;
	}

	public static List<AttachmentDTO> createAttachmentDTOListFromModelList(List<Attachment> modelListInput) {
		return modelListInput.stream()
				.map(attachmentItem -> new AttachmentDTO(attachmentItem.getId(), attachmentItem.getNomeFile(),
						attachmentItem.getContentType(), attachmentItem.getDescrizione(),
						attachmentItem.getDataCreazione(), attachmentItem.getPayload()))
				.collect(Collectors.toList());
	}

}
