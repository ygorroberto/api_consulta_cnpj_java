package one.digitalinnovation.gof.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Cnpj {

	@Id
	private String cnpj;
	private String razao_social;
	private String nome_fantasia;
	private int cep;
	private String uf;
	private String municipio;
	private String logradouro;
	private String bairro;
	private int cnae_fiscal;
	private Date data_inicio_atividade;
	private String descricao_situacao_cadastral;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCnae_fiscal() {
		return cnae_fiscal;
	}

	public void setCnae_fiscal(int cnae_fiscal) {
		this.cnae_fiscal = cnae_fiscal;
	}

	public Date getData_inicio_atividade() {
		return data_inicio_atividade;
	}

	public void setData_inicio_atividade(Date data_inicio_atividade) {
		this.data_inicio_atividade = data_inicio_atividade;
	}

	public String getDescricao_situacao_cadastral() {
		return descricao_situacao_cadastral;
	}

	public void setDescricao_situacao_cadastral(String descricao_situacao_cadastral) {
		this.descricao_situacao_cadastral = descricao_situacao_cadastral;
	}
}
