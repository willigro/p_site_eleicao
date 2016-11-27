package classesBasicas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_erro")
public class ErroSite {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_erroSite;
	private String descricao;
	
	/*GET'S & SET'S*/

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId_erroSite() {
		return id_erroSite;
	}
}
