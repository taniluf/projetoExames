package br.com.exames.bean;


public class Agenda {
	
	private int id;
	private String numCPF;
	private String codExame;
	private String nomePessoa;
	private String nomeExame;
	private String dataExame;
	private String horaExame;
	private String obsResultExame;
	
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	public String getNomeExame() {
		return nomeExame;
	}
	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNumCPF() {
		return numCPF;
	}
	public void setNumCPF(String numCPF) {
		this.numCPF = numCPF;
	}
	public String getCodExame() {
		return codExame;
	}
	public void setCodExame(String codExame) {
		this.codExame = codExame;
	}
	public String getDataExame() {
		return dataExame;
	}
	public void setDataExame(String dataExame) {
		this.dataExame = dataExame;
	}
	public String getHoraExame() {
		return horaExame;
	}
	public void setHoraExame(String horaExame) {
		this.horaExame = horaExame;
	}
	public String getObsResultExame() {
		return obsResultExame;
	}
	public void setObsResultExame(String obsResultExame) {
		this.obsResultExame = obsResultExame;
	}
	
			
}