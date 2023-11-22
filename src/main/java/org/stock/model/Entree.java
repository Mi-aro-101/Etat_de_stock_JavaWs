/**
 * 
 */
package org.stock.model;

import java.time.LocalDate;
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
@Table(name="entree")
public class Entree {

	@Id
	@Column(name="id_entree")
	String idEntree;
	
	@ManyToOne
	@JoinColumn(name="id_article")
	Article article;
	
	@ManyToOne
	@JoinColumn(name="id_magasin")
	Magasin magasin;
	
	@Column(name="quantite")
	double quantite;
	
	@Column(name="prix")
	double prix;
	
	@Column(name="dateentree")
	LocalDate dateEntree;
	
	public String getIdEntree() {
		return idEntree;
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
	
	public double getPrix() {
		return prix;
	}
	
	public LocalDate getDateEntree() {
		return dateEntree;
	}
	
	public void setIdEntree(String idEntree) {
		this.idEntree = idEntree;
	}
	
	public void setArticle(Article article) {
		this.article = article;
	}
	
	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}
	
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public void setDateEntree(LocalDate dateEntree) {
		this.dateEntree = dateEntree;
	}
	
}
