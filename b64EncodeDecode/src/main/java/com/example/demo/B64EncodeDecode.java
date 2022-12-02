package com.example.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class B64EncodeDecode {

	public static void main(String[] args) {
		
		byte[] inFileBytes = null;
		try {
			inFileBytes = Files.readAllBytes(Paths.get("eSign-APIv2.1.pdf"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		byte[] encoded = java.util.Base64.getEncoder().encode(inFileBytes);
		System.out.println(Arrays.toString(encoded));
		
		byte[] decoded = java.util.Base64.getDecoder().decode(encoded);
		try {
		FileOutputStream fos = new FileOutputStream("outputfile.pdf");
			fos.write(decoded);
			fos.flush();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
