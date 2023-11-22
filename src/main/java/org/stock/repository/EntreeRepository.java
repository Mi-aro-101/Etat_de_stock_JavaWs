package org.stock.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.stock.model.Entree;

public interface EntreeRepository extends JpaRepository<Entree, String> {

	@Query("SELECT e FROM Entree e "
			+ "WHERE e.dateEntree>=:date1 and e.dateEntree<:date2 and "
			+ "e.article.idArticle=:idArticle and e.magasin.idMagasin=:idMagasin")
	List<Entree> findInterval(@Param("date1") LocalDate date1, @Param("date2")LocalDate date2,
			@Param("idArticle")String idArticle, @Param("idMagasin")String idMagasin);
	
	
	@Query("SELECT e FROM Entree e "
			+ "WHERE e.article.idArticle=:idArticle and e.magasin.idMagasin=:idMagasin "
			+ "ORDER BY dateEntree LIMIT 1")
	Optional<Entree> findFirst(String idArticle, String idMagasin);
	
}
