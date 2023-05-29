package com.example.gestioneallegati_springmvc.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestioneallegati_springmvc.dto.AttachmentDTO;
import com.example.gestioneallegati_springmvc.model.Attachment;
import com.example.gestioneallegati_springmvc.service.AttachmentService;

@RestController
@RequestMapping("/api/attachment")
public class AttachmentRestController {

	@Autowired
	private AttachmentService attachmentService;

	@GetMapping
	public List<AttachmentDTO> getAll() {
		return AttachmentDTO.createAttachmentDTOListFromModelList(attachmentService.listAllElements());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AttachmentDTO createNew(@RequestBody AttachmentDTO attachmentDTO) {
		Attachment attachmentTransient = attachmentDTO.buildModelFromDTO();
		attachmentService.inserisciNuovo(attachmentTransient);
		return AttachmentDTO.buildAttachmentDTOFromModel(attachmentTransient);
	}

}
