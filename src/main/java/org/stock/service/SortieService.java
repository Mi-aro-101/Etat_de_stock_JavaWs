/**
 * 
 */
package org.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.stock.model.EtatEntree;
import org.stock.model.SortieEtatEntree;
import org.stock.repository.EtatEntreeRepository;
import org.stock.repository.SortieRepository;

import jakarta.transaction.Transactional;

/**
 * @author Miaro
 *
 */
@Service
public class SortieService {
	
	@Autowired
	SortieRepository sortieRepo;
	
	@Autowired
	EtatEntreeRepository etatEntreeRepo;
	
	public ResponseEntity<String> insertSortie(SortieEtatEntree sortieEtatEntree){
		try {
			
			sortieRepo.save(sortieEtatEntree.getSortie());
			
			for(EtatEntree ee : sortieEtatEntree.getEtatEntree()) {
				ee.setIdEtatEntree(null);
			}
			
			Iterable<EtatEntree> persist = etatEntreeRepo.saveAll(sortieEtatEntree.getEtatEntree());
			
			return new ResponseEntity<String>("Insertion successful", HttpStatus.OK);

		} catch (Exception e) {
			sortieRepo.delete(sortieEtatEntree.getSortie());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
