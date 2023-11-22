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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.stock.model.EtatEntree;
import org.stock.model.SortieEtatEntree;
import org.stock.repository.EtatEntreeRepository;
import org.stock.service.SortieService;

/**
 * @author Miaro
 *
 */
@RestController
@RequestMapping(path="api/etatentree")
public class EtatEntreeController {
	
	@Autowired
	EtatEntreeRepository etatentreerepo;
	
	@Autowired
	SortieService sortieService;
	
	@GetMapping("/actuel")
	public ResponseEntity<List<EtatEntree>> getEtatEntreeActuel(
			@RequestParam("date2") @DateTimeFormat(pattern="yyyy-mm-dd") LocalDate date2, 
			@RequestParam("idArticle") String idArticle, 
			@RequestParam("idMagasin") String idMagasin){
		
		List<EtatEntree> etatentrees = new ArrayList<>();
		
		try {
			etatentreerepo.findEtatEntreeActuel(date2, idArticle, idMagasin).forEach(etatentrees::add);
			return new ResponseEntity<>(etatentrees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/updates")
	public ResponseEntity<String> updateAll(@RequestBody  SortieEtatEntree etatsEntreesSorties){
		try {
			
			return sortieService.insertSortie(etatsEntreesSorties);
			
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
