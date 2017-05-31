package br.com.sysbebidas.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_cargos")
@NamedQueries({ @NamedQuery(name = "Cargo.listar", query = "SELECT cargo FROM Cargo cargo"),
		@NamedQuery(name = "Cargo.buscarPorCodigo", query = "SELECT cargo FROM Cargo cargo WHERE cargo.codigo = :codigo") })
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "car_codigo")
	private Long codigo;

	@NotEmpty(message = "O campo descrição é obrigatório")
	@Size(min = 2, max = 50, message = "Tamanho de caracteres não respeitado. Aceito de 02 até 50 caracteres.")
	@Column(name = "car_descricao", length = 50, nullable = false)
	private String descricao;

	@NotNull(message = "O campo Piso salarial é obrigatório")
	@DecimalMin(value = "0.00", message = "Informe um valor maior ou igual a 0(zero) para o campo Piso salarial")
	@DecimalMax(value = "99999.99", message = "Informe um valor menor que 100.000(cem mil) para o campo Piso salarial")
	@Column(name = "car_pisosalarial", precision = 7, scale = 2, nullable = false)
	private BigDecimal pisosalarial;

	@NotNull(message = "O campo departamento é obrigatório")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_departamentos_dep_codigo", referencedColumnName = "dep_codigo", nullable = false)
	private Departamento departamento;

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

	public BigDecimal getPisosalarial() {
		return pisosalarial;
	}

	public void setPisosalarial(BigDecimal pisosalarial) {
		this.pisosalarial = pisosalarial;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Cargo [codigo=" + codigo + ", descricao=" + descricao + ", pisosalarial=" + pisosalarial
				+ ", departamento=" + departamento + "]";
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
		Cargo other = (Cargo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
