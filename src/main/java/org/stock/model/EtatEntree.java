/**
 * 
 */
package org.stock.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * @author Miaro
 *
 */
@Entity
@Table(name="etatentree")
public class EtatEntree {
	@Id
	@Column(name="id_etat_entree")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="etatentree_generator")
	@SequenceGenerator(name = "etatentree_generator", sequenceName = "etatentreeactuel_id_etat_entree_actuel_seq", allocationSize = 1)
	Integer idEtatEntree;
	
	@ManyToOne
	@JoinColumn(name="id_entree")
	Entree entree;
	
	@ManyToOne
	@JoinColumn(name="id_sortie", nullable = true)
	Sortie sortie;
	
	@Column(name="quantitereste")
	double quantiteReste;
	
	@Column(name="dateetat")
	LocalDate dateEtat;
	
	public Integer getIdEtatEntree() {
		return idEtatEntree;
	}
	
	public Entree getEntree() {
		return entree;
	}
	
	public Sortie getSortie() {
		return sortie;
	}
	
	public double getQuantiteReste() {
		return quantiteReste;
	}
	
	public LocalDate getDateEtat() {
		return dateEtat;
	}
	
	public void setIdEtatEntree(Integer idEtatEntree) {
		this.idEtatEntree = idEtatEntree;
	}
	
	public void setEntree(Entree entree) {
		this.entree = entree;
	}
	
	public void setSortie(Sortie sortie) {
		this.sortie = sortie;
	}
	
	public void setQuantiteReste(double quantiteReste) {
		this.quantiteReste = quantiteReste;
	}
	
	public void setDateEtat(LocalDate dateEtat) {
		this.dateEtat = dateEtat;
	}
}
