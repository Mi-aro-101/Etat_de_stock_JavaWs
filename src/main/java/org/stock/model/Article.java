package org.stock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Miaro
 *
 */
@Entity
@Table(name="article")
public class Article {
	
	@Id
	@Column(name="id_article")
	String idArticle;
	
	@Column(name="des_article")
	String desArticle;
	
	@Column(name="sortietype")
	int sortieType;
	
	public String getIdArticle() {
		return idArticle;
	}
	
	public String getDesArticle() {
		return desArticle;
	}
	
	public int getSortieType() {
		return sortieType;
	}
	
	public void setIdArticle(String id_article) {
		this.idArticle = id_article;
	}
	
	public void setDesArticle(String desArticle) {
		this.desArticle = desArticle;
	}
	
	public void setSortieType(int sortieType) {
		this.sortieType = sortieType;
	}
	
}
