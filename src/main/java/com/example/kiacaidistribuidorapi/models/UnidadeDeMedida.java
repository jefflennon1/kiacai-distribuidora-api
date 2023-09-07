package com.example.kiacaidistribuidorapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "UNIDADES_DE_MEDIDA")
public class UnidadeDeMedida { 
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		@JsonProperty(value = "ID")
	    private  int id;
	    
		@Column(name = "DESCRICAO")
		@JsonProperty(value = "DESCRICAO")
	    private  String descricao;

	   

	    public int getId() {
	        return id;
	    }

	    public String getDescricao() {
	        return descricao;
	    }
}
