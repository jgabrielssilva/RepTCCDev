package br.com.drogaria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {
	private Fabricante fabricanteCadastro;

	public Fabricante getFabricanteCadastro() {
		if (fabricanteCadastro == null) {
			fabricanteCadastro = new Fabricante();
		}
		return fabricanteCadastro;
	}

	public void setFabricanteCadastro(Fabricante fabricanteCadastro) {
		this.fabricanteCadastro = fabricanteCadastro;
	}

	public void salvar() {
		FacesUtil.adicionarMsgInfo(fabricanteCadastro.toString());

		FacesUtil.adicionarMsgInfo("Fabricante salvo com sucessso");
	}
}
