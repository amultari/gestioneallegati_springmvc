package com.example.gestioneallegati_springmvc.service;

import java.util.List;

import com.example.gestioneallegati_springmvc.model.Attachment;

public interface AttachmentService {
	public List<Attachment> listAllElements();

	public Attachment caricaSingoloElemento(Long id);

	public void aggiorna(Attachment entityInstance);

	public void inserisciNuovo(Attachment entityInstance);

	public void rimuoviById(Long idToRemove);
}
