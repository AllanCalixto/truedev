package br.com.truedev.ecommerce.service.upload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements IUploadService{

	@Override
	public String uploadFile(MultipartFile arquivo) {
		try {
			System.out.println("DEBUG - Nome original do arquivo: "+arquivo.getOriginalFilename());
			String pastaDestino = "/home/calixto/Área de Trabalho/front-flabijoux/images";
			Path path = Paths.get(pastaDestino + File.separator + arquivo.getOriginalFilename());
			Files.copy(arquivo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			
			return arquivo.getOriginalFilename();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

}
