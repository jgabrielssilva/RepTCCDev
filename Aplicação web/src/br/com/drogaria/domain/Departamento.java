package br.com.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_departamentos")

@NamedQueries({ @NamedQuery(name = "Departamento.listar", query = "SELECT departamento FROM Departamento departamento"),
		@NamedQuery(name = "Departamento.buscarPorCodigo", query = "SELECT departamento FROM Departamento departamento WHERE departamento.codigo = :codigo") })

public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dep_codigo")
	private Long codigo;

	@NotEmpty(message = "O campo descrição é obrigatório")
	@Size(min = 2, max = 50, message = "Tamanho de caracteres não respeitado. Aceito de 02 até 50 caracteres.")
	@Column(name = "dep_descricao", length = 50, nullable = false)
	private String descricao;

	// getters e setters
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
}
