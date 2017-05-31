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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_bebidas")
@NamedQueries({ @NamedQuery(name = "Bebida.listar", query = "SELECT bebida FROM Bebida bebida"),
		@NamedQuery(name = "Bebida.buscarPorCodigo", query = "SELECT bebida FROM Bebida bebida WHERE codigo = :codigo") })
public class Bebida {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "beb_codigo")
	private Long codigo;

	@NotEmpty(message = "O campo Descrição é obrigatório")
	@Column(name = "beb_descricao", length = 50, nullable = false)
	private String descricao;

	@NotNull(message = "O campo preço é obrigatório")
	@DecimalMin(value = "0.00", message = "Informe um valor maior ou igual a 0(zero) para o campo Preço")
	@DecimalMax(value = "99999.99", message = "Informe um valor menor que 100.000(cem mil) para o campo Preço")
	@Digits(integer = 5, fraction = 2, message = "Informe um valor válido para o campo preço")
	@Column(name = "beb_preco", precision = 7, scale = 2, nullable = false)
	private BigDecimal preco;

	@NotNull(message = "O campo quantidade é obrigatório")
	@Min(value = 0, message = "Informe um valor maior ou igual a zero para o campo quantidade")
	@Max(value = 9999, message = "Informe um valor menor que dez mil para o campo quantidade")
	@Column(name = "beb_quantidade", nullable = false)
	private Integer quantidade;

	@NotNull(message = "O campo categoria é obrigatório")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_categorias_cat_codigo", referencedColumnName = "cat_codigo", nullable = false)
	private Categoria categoria;

	@NotNull(message = "O campo fabricante é obrigatório")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_fabricantes_fab_codigo", referencedColumnName = "fab_codigo", nullable = false)
	private Fabricante fabricante;

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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + ", quantidade="
				+ quantidade + ", categoria=" + categoria + ", fabricante=" + fabricante + "]";
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
		Bebida other = (Bebida) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
