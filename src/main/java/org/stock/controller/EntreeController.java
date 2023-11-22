/**
 * 
 */
package org.stock.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.stock.model.Entree;
import org.stock.repository.EntreeRepository;

/**
 * @author Miaro
 *
 */
@RestController
@RequestMapping(path = "/api/entree")
public class EntreeController {

	@Autowired
	EntreeRepository entreerepo;
	
	@GetMapping("/interval")
	public ResponseEntity<List<Entree>> findInterval(
			@RequestParam("date1") @DateTimeFormat(pattern="yyyy-mm-dd") LocalDate date1, 
			@RequestParam("date2") @DateTimeFormat(pattern="yyyy-mm-dd") LocalDate date2,
			@RequestParam("idMagasin") String idMagasin, 
			@RequestParam("idArticle") String idArticle){
		
		List<Entree> entrees = new ArrayList<>();
		
		try {
			entreerepo.findInterval(date1, date2, idArticle, idMagasin).forEach(entrees::add);
			return new ResponseEntity<>(entrees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/first")
	public ResponseEntity<Optional<Entree>> findFirstEntree(
			@RequestParam("idArticle") String idArticle, 
			@RequestParam("idMagasin") String idMagasin){
		
		try {
			Optional<Entree> result = entreerepo.findFirst(idArticle, idMagasin);
			return new ResponseEntity<>(result, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
