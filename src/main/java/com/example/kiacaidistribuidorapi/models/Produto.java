package com.example.kiacaidistribuidorapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity(name = "PRODUTOS")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonProperty(value = "ID")
	private Long id;
	
	@Column(name = "SKU")
	@JsonProperty(value = "SKU")
	private String SKU;
	
	@Column(name = "NOME")
	@JsonProperty(value = "nome")
	private String nome;
	
	@Column(name = "DESCRICAO")
	@JsonProperty(value = "descricao")
	private String descricao; 
	
	@ManyToOne
	@JoinColumn(name = "CATEGORIA_ID")
	@JsonProperty(value = "categoria")
	private Categoria categoria; 
	
	@ManyToOne
	@JoinColumn(name = "UNIDADE_MEDIDA_ID")
	@JsonProperty(value = "unidadeDeMedida")
	private UnidadeDeMedida unidadeDeMedida;
	 
	@Transient
	@JsonProperty(value = "quantidade")
	private Double quantidade; // esta field vai ser usada na entrada de insumos, não será saldo na tabela
	
	@Column(name = "VALOR")
	@JsonProperty(value = "valor")
	private Double valor;
	
	@Column(name = "ATIVO")
	@JsonProperty(value = "ativo")
	private Boolean ativo = false;
	
	@Transient
	//@Column(name = "NUMERO_NOTA_FISCAL")
	@JsonProperty(value = "numeroNotaFiscal")
	private String numeroNotaFiscal;
	
	@Column(name = "SALDO_EM_ESTOQUE")
	@JsonProperty(value = "saldoEmEstoque")
	private Double saldoEmEstoque;  
	
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public UnidadeDeMedida getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	public void setUnidadeDeMedida(UnidadeDeMedida unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getNumeroNotaFiscal() {
		return numeroNotaFiscal;
	}

	public void setNumeroNotaFiscal(String numeroNotaFiscal) {
		this.numeroNotaFiscal = numeroNotaFiscal;
	}

	public Double getSaldoEmEstoque() {
		return saldoEmEstoque;
	}

	public void setSaldoEmEstoque(Double saldoEmEstoque) {
		this.saldoEmEstoque = saldoEmEstoque;
	}
	
	
	
	
}
