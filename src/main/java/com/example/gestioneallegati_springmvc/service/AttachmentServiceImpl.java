package com.example.gestioneallegati_springmvc.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gestioneallegati_springmvc.model.Attachment;
import com.example.gestioneallegati_springmvc.repository.AttachmentRepository;

@Service
public class AttachmentServiceImpl implements AttachmentService {

	@Autowired
	private AttachmentRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Attachment> listAllElements() {
		return (List<Attachment>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Attachment caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void aggiorna(Attachment entityInstance) {
		repository.save(entityInstance);
	}

	@Override
	@Transactional
	public void inserisciNuovo(Attachment entityInstance) {
		entityInstance.setDataCreazione(LocalDate.now());
		repository.save(entityInstance);
	}

	@Override
	@Transactional
	public void rimuoviById(Long idToRemove) {
		repository.deleteById(idToRemove);
	}

}
