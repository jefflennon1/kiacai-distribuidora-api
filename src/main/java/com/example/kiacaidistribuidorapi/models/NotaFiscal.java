package com.example.kiacaidistribuidorapi.models;

import java.util.Date;
import java.util.List;

public class NotaFiscal {
	
	 	private Long numero;
	 	
	    private Date dataEmissao;
	    
	    private String emitente;
	    
	    private String destinatario;
	    
	    private List<Produto> itens;
	    
	    private double valorTotal;
	    
	    
	   
	    public NotaFiscal(long numero, Date dataEmissao, String emitente, String destinatario, List<Produto> itens) {
	        this.numero = numero;
	        this.dataEmissao = dataEmissao;
	        this.emitente = emitente;
	        this.destinatario = destinatario;
	        this.itens = itens;
	        this.calcularValorTotal();
	    }
	    
	    // Métodos getters e setters
	    
	    public long getNumero() {
	        return numero;
	    }

	    public void setNumero(long numero) {
	        this.numero = numero;
	    }

	    public Date getDataEmissao() {
	        return dataEmissao;
	    }

	    public void setDataEmissao(Date dataEmissao) {
	        this.dataEmissao = dataEmissao;
	    }

	    public String getEmitente() {
	        return emitente;
	    }

	    public void setEmitente(String emitente) {
	        this.emitente = emitente;
	    }

	    public String getDestinatario() {
	        return destinatario;
	    }

	    public void setDestinatario(String destinatario) {
	        this.destinatario = destinatario;
	    }

	    public List<Produto> getItens() {
	        return itens;
	    }

	    public void setItens(List<Produto> itens) {
	        this.itens = itens;
	    }

	    public double getValorTotal() {
	        return valorTotal;
	    }

	    public void setValorTotal(double valorTotal) {
	        this.valorTotal = valorTotal;
	    }
	    
	    // Método para calcular o valor total com base nos itens
	    private void calcularValorTotal() {
	        this.valorTotal = 0;
	        for (Produto item : itens) {
	            this.valorTotal += item.getValor();
	        }
	    }

}
