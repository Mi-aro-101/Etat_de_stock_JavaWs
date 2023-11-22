/**
 * 
 */
package org.stock.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.stock.model.Sortie;
import org.stock.repository.SortieRepository;

/**
 * @author Miaro
 *
 */
@RestController
@RequestMapping(path="api/sortie")
public class SortieController {

	@Autowired
	SortieRepository sortierepo;
	
	@GetMapping("/interval")
	public ResponseEntity<List<Sortie>> findInterval(
			@RequestParam("date1") @DateTimeFormat(pattern="yyyy-mm-dd") LocalDate date1, 
			@RequestParam("date2") @DateTimeFormat(pattern="yyyy-mm-dd") LocalDate date2,
			@RequestParam("idMagasin") String idMagasin, 
			@RequestParam("idArticle") String idArticle){
		
		List<Sortie> sorties = new ArrayList<>();
		
		try {
			sortierepo.findInterval(date1, date2, idArticle, idMagasin).forEach(sorties::add);
			return new ResponseEntity<>(sorties, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody Sortie sortieObj){
		Sortie sortie = new Sortie();
		try {
			
			sortie.setIdSortie(sortieObj.getIdSortie());
			sortie.setArticle(sortieObj.getArticle());
			sortie.setMagasin(sortieObj.getMagasin());
			sortie.setQuantite(sortieObj.getQuantite());
			sortie.setDateSortie(sortieObj.getDateSortie());
			
			sortierepo.save(sortie);
			return new ResponseEntity<String>("Insertion avec success", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage()+""+sortieObj.getDateSortie(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
