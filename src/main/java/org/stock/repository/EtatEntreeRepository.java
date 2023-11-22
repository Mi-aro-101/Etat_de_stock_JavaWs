/**
 * 
 */
package org.stock.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.stock.model.EtatEntree;

/**
 * @author Miaro
 *
 */
public interface EtatEntreeRepository extends CrudRepository<EtatEntree, Integer> {
	
	/**
	 * Query that will retrieve each last row of grouped etatentree by entree
	 * That means the last update of the etatentree
	 * if there is more than one entree in a etat entree then it does retrive only the last (the non obsolete one)
	 */
	@Query(value="Select distinct on(ee.id_entree) ee.* from etatentree ee"
			+ " join entree e on ee.id_entree = e.id_entree"
			+ " where ee.dateetat <= :dateFinale and"
			+ " e.id_article=:idArticle and e.id_magasin=:idMagasin"                                                          
			+ " order by ee.id_entree, ee.dateetat DESC", nativeQuery = true)
	List<EtatEntree> findEtatEntreeActuel(@Param("dateFinale") LocalDate dateFinale, @Param("idArticle")String idArticle, @Param("idMagasin")String idMagasin);

}
