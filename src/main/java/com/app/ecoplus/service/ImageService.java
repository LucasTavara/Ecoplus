package com.app.ecoplus.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class ImageService {

	public Map<String, String> images(String esc){
		Map<String, String> imageMap = new HashMap<>();
		switch(esc){
			case ("Logo"):
				imageMap.put("LogoCinza", "/img/logo/LogoCinza.png");
				imageMap.put("LogoPreta","/img/logo/LogoPreta.png");
			case "Card":
				imageMap.put("Resi1", "/img/card/resi1.jpg");
				imageMap.put("Resi2", "/img/card/resi2.jpg");
				imageMap.put("Resi3", "/img/card/resi3.jpg");
				imageMap.put("Resi4", "/img/card/resi4.jpg");
			case "Devs":
				imageMap.put("AlineImg", "/img/devs/AlineGomes.png");
				imageMap.put("EdImg", "/img/devs/EdmilsonJunior.png");
				imageMap.put("LucasTavaresImg", "/img/devs/LucasTavares.png");
				imageMap.put("ThallesImg", "/img/devs/ThallesVieira.png");
			case "Fundo":
				imageMap.put("Fundo1", "/img/fundo/fundo1.jpg");
				imageMap.put("Fundo2", "/img/fundo/fundo2.jpg");
				imageMap.put("Fundo3", "/img/fundo/fundo3.jpg");
				imageMap.put("Fundo5", "/img/fundo/fundo5.jpg");
		}
		return imageMap;
	}


	public Map<String, String> imagesIndex(){

//		Logo
        Map<String, String> imageMap = new HashMap<>();
		imageMap.putAll(images("Logo"));
	    imageMap.put("Imagem1", "/img/imagem 1.jpg");
		imageMap.put("Imagem2", "/img/imagem 2.jpg");
		imageMap.put("Imagem3", "/img/imagem 3.jpg");
		imageMap.put("Imagem4", "/img/imagem 4.jpg");
		imageMap.put("Cadastro", "/img/cadastro.jpg");
		imageMap.put("Residuos", "/img/residuos.jpg");
		imageMap.put("Conexao", "/img/conexão.jpg");
		imageMap.put("Negociacao", "/img/negociacao.jpg");
	    return imageMap;
	}

	public Map<String, String> imagesSobrenos() {
//		Logo
		Map<String, String> imageMap = new HashMap<>();
//		Dev images
		imageMap.putAll(images("Logo"));
		imageMap.putAll(images("Devs"));
		return imageMap;
	}

	public Map <String, String> imagesPassword() {
		//Logo
		Map <String, String> imageMap = new HashMap<>();
		imageMap.putAll(images("Logo"));
		return imageMap;

	}
	public Map <String, String> imagesLogin() {

//		Logo
		Map<String, String> imageMap = new HashMap<>();
		imageMap.putAll(images("Logo"));
		imageMap.put("Facebook", "/img/facebook.png");
		imageMap.put("Twitter", "/img/twitter.png");
		imageMap.put("Google", "/img/google.png");
		return imageMap;

	}

	public Map<String, String> imagesFaq(){
//		Logo
		Map<String, String> imageMap = new HashMap<>();
		imageMap.putAll(images("Logo"));

		return imageMap;

	}


	public Map<String, String> imagesForm(){
//		Logo
		Map<String, String> imageMap = new HashMap<>();
		imageMap.putAll(images("Logo"));

		return imageMap;
	}

	public Map<String, String> imagesVendas(){
//		Logo
		Map<String, String> imageMap = new HashMap<>();
		imageMap.putAll(images("Logo"));

		imageMap.put("Residuos", "/img/residuos.jpg");

		return imageMap;
	}

	public Map <String, String> imagesInfor() {

//		Logo
		Map<String, String> imageMap = new HashMap<>();
		imageMap.putAll(images("Logo"));
		imageMap.put("LogoCinza", "/img/logo/LogoCinza.png");
		imageMap.put("LogoPreta", "/img/logo/LogoPreta.png");
		imageMap.put("residuo", "img/card/resi1.jpg");
		imageMap.put("residuo1", "img/card/resi2.jpg");
		imageMap.put("residuo2", "img/card/resi3.jpg");
		imageMap.put("residuo3", "img/card/resi4.jpg");
		return imageMap;

	}
}
