/**
 * 
 */
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
@Table(name="magasin")
public class Magasin {

	@Id
	@Column(name="id_magasin")
	String idMagasin;
	
	public String getIdMagasin() {
		return idMagasin;
	}
	
	public void setIdMagasin(String idMagasin) {
		this.idMagasin = idMagasin;
	}
	
}
