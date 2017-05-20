package br.com.sysbebidas.domain;



import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;


@Entity
@Table(name = "tbl_funcionarios")

@NamedQueries({ @NamedQuery(name = "Funcionario.listar", query = "SELECT funcionario FROM Funcionario funcionario"),
	@NamedQuery(name = "Funcionario.buscarPorCodigo", query = "SELECT funcionario FROM Funcionario funcionario WHERE funcionario.codigo = :codigo") })

public class Funcionario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "fun_codigo")
	private Long codigo;
	
	@NotEmpty(message ="O campo Nome é obrigatório")
	@Column(name = "fun_nome", length = 50, nullable = false)
	private String nome;
	
	@CPF(message = "O CPF informado é inválido")
	@Column(name = "fun_cpf", length = 14, nullable = false, unique = true)
	private String cpf;

	@NotEmpty(message ="O campo Senha é obrigatório")
	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo senha (6 - 8)")
	@Column(name = "fun_senha", length = 32, nullable = false)
	private String senha;

	@NotNull(message ="O campo Cargo é obrigatório")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_cargos_car_codigo", referencedColumnName = "car_codigo", nullable = false)
	private Cargo cargo;

	@NotNull(message ="O campo Data de Nascimento é obrigatório")
	@Temporal(value = TemporalType.DATE)
	@Column(name = "fun_datanascimento", nullable = false)
	private Date datanascimento;
	
	@NotNull(message ="O campo Admissão é obrigatório")
	@Temporal(value = TemporalType.DATE)
	@Column(name = "fun_admissao", nullable = false)
	private Date admissao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public Date getAdmissao() {
		return admissao;
	}

	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}

	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", cargo="
				+ cargo + ", datanascimento=" + datanascimento + ", admissao=" + admissao + "]";
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
		Funcionario other = (Funcionario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

  
	
	
	
}
