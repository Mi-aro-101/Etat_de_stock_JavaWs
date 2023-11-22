/**
 * 
 */
package org.stock.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Miaro
 *
 */
@Entity
@Table(name="sortie")
public class Sortie {

	@Id
	@Column(name="id_sortie")
	String idSortie;
	
	@ManyToOne
	@JoinColumn(name="id_article")
	Article article;
	
	@ManyToOne
	@JoinColumn(name="id_magasin")
	Magasin magasin;
	
	@Column(name="quantite")
	double quantite;
	
	@Column(name="datesortie")
	@JsonFormat(pattern="yyyy-MM-dd")
	LocalDate dateSortie;
	
	public String getIdSortie() {
		return idSortie;
	}
	
	public Article getArticle() {
		return article;
	}
	
	public Magasin getMagasin() {
		return magasin;
	}
	
	public double getQuantite() {
		return quantite;
	}
	
	public LocalDate getDateSortie() {
		return dateSortie;
	}
	
	public void setIdSortie(String idSortie) {
		this.idSortie = idSortie;
	}
	
	public void setArticle(Article article) {
		this.article = article;
	}
	
	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}
	
	public void setQuantite(double quantite)throws Exception {
		if(quantite < 0) {
			throw new Exception("Valeur de quantite invalide");
		}
		this.quantite = quantite;
	}
	
	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}
}
