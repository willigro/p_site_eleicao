package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import classesBasicas.Candidato;
import classesBasicas.Cargo;
import classesBasicas.Cidade;
import classesBasicas.Estado;
import classesBasicas.Partido;
import classesBasicas.Projeto;
import facade.Facade;

@ManagedBean
@ViewScoped
public class CandidatoSelecionadoBean implements Serializable {

	private Facade fachada;
	private Candidato candidato;
	private Projeto projeto;
	private List<Projeto> lista_projeto;

	public CandidatoSelecionadoBean() {
		this.candidato = new Candidato();
		this.fachada = new Facade();
		this.projeto = new Projeto();

	}

	// Methods
	public void catchIdCandidato() {
		try {
			this.candidato = (Candidato) fachada.retornarVariavel();
			System.out.println(this.candidato.getId_cand());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Projeto> getLista_projeto() {
		try {
			this.projeto.getCanditado_proj().setId_cand(this.candidato.getId_cand());
			lista_projeto = this.fachada.consultarProjetosFiltradosIdCand(this.projeto);
			System.out.println(lista_projeto.get(0).getId_proj());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista_projeto;
	}

	public String editar() throws Exception {
		try {

			System.out.println("ID DEPOIS DO BOTÃO EDITAR: " + candidato.getId_cand());
			System.out.println("NUMERO DEPOIS DO BOTÃO EDITAR: " + candidato.getNumero_cand());
			System.out.println("CIDADE ID DEPOIS DO BOTÃO EDITAR: " + candidato.getCidade_cand().getId_cid());
			System.out.println("CIDADE ID DEPOIS DO BOTÃO EDITAR: " + candidato.getCidade_cand().getNome_cid());

			fachada.alterarCandidato(candidato);
			mensagemSucessoEdit("Editado com Sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			mensagemFalhaEdit(e.getMessage());
		}
		return "paginaEditarCand";
	}

	private void mensagemSucessoEdit(String texto) {
		FacesContext mensagem = FacesContext.getCurrentInstance();
		mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado com Sucesso", texto));
	}
	
	private void mensagemFalhaEdit(String texto) {
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: ", texto);

		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	// Getters e Setters
	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		System.out.println("candS set: " + this.candidato.getId_cand());
		this.candidato = candidato;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}
