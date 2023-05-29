package com.example.gestioneallegati_springmvc.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.gestioneallegati_springmvc.dto.AttachmentDTO;
import com.example.gestioneallegati_springmvc.service.AttachmentService;

@Controller
@RequestMapping(value = { "", "/attachment" })
public class AttachmentController {

	@Autowired
	private AttachmentService attachmentService;

	@GetMapping
	public ModelAndView listAll() {
		List<AttachmentDTO> result = AttachmentDTO
				.createAttachmentDTOListFromModelList(attachmentService.listAllElements());
		return new ModelAndView("attachment/list", "attachment_list_attribute", result);
	}

	@GetMapping("/insert")
	public String createNew(Model model) {
		model.addAttribute("attachment_richiesta_permesso_attr", new AttachmentDTO());
		return "attachment/insert";
	}

	@PostMapping("/save")
	public String saveNewEntry(@RequestParam("file") MultipartFile file, AttachmentDTO attachment, Model model,
			RedirectAttributes redirectAttrs) {

		// la validazione è realizzata 'alla buona', in un progetto serio andrebbe
		// sistemata
		if (file == null || file.isEmpty() || attachment.getDescrizione().isBlank()) {
			model.addAttribute("errorMessage", "Inserire dei valori");
			return "attachment/insert";
		}

		try {
			attachment.setContentType(file.getContentType());
			attachment.setNomeFile(file.getOriginalFilename());
			attachment.setPayload(file.getBytes());
		} catch (IOException e) {
			throw new RuntimeException("Problema nell'upload file", e);
		}

		attachmentService.inserisciNuovo(attachment.buildModelFromDTO());

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/attachment";
	}

	@GetMapping("/showAttachment/{idAttachment}")
	public ResponseEntity<byte[]> showAttachment(@PathVariable(required = true) Long idAttachment) {

		AttachmentDTO file = AttachmentDTO
				.buildAttachmentDTOFromModel(attachmentService.caricaSingoloElemento(idAttachment));

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getNomeFile() + "\"")
				.body(file.getPayload());

	}

}
