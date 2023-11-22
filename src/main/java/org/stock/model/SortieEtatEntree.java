/**
 * 
 */
package org.stock.model;

import java.util.List;

/**
 * @author Miaro
 *
 */
public class SortieEtatEntree {
	
	Sortie sortie;
	
	List<EtatEntree> etatEntree;
	
	public Sortie getSortie() {
		return sortie;
	}
	
	public List<EtatEntree> getEtatEntree() {
		return etatEntree;
	}
	
	public void setSortie(Sortie sortie) {
		this.sortie = sortie;
	}
	
	public void setEtatEntree(List<EtatEntree> etatEntree) {
		this.etatEntree = etatEntree;
	}
	
}
