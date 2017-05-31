package br.com.sysbebidas.domain;

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

	@NotEmpty(message = "O campo descri��o � obrigat�rio")
	@Size(min = 2, max = 50, message = "Tamanho de caracteres n�o respeitado. Aceito de 02 at� 50 caracteres.")
	@Column(name = "dep_descricao", length = 50, nullable = false)
	private String descricao;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
