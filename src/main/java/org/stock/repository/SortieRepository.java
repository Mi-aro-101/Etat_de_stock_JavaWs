/**
 * 
 */
package org.stock.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.stock.model.Sortie;

/**
 * @author Miaro
 *
 */
public interface SortieRepository extends JpaRepository<Sortie, String> {
	
	@Query("SELECT s FROM Sortie s "
			+ "WHERE s.dateSortie>=:date1 and s.dateSortie<:date2 and "
			+ "s.article.idArticle=:idArticle and s.magasin.idMagasin=:idMagasin")
	List<Sortie> findInterval(@Param("date1") LocalDate date1, @Param("date2")LocalDate date2,
			@Param("idArticle")String idArticle, @Param("idMagasin")String idMagasin);
	
}
