package br.com.truedev.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.truedev.ecommerce.dto.PathToFileDTO;
import br.com.truedev.ecommerce.service.upload.IUploadService;

@RestController
@CrossOrigin("*")
public class UploadController {
	
	@Autowired
	private IUploadService service;
	
	@PostMapping("/upload")
	public ResponseEntity<PathToFileDTO> uploadFile(@RequestParam(name="arquivo") MultipartFile arquivo){
		String filename = service.uploadFile(arquivo);
		if(filename != null) {
			PathToFileDTO pathToFile = new PathToFileDTO(filename);
			return ResponseEntity.status(201).body(pathToFile);
		}
		return ResponseEntity.badRequest().build();
	}

}
