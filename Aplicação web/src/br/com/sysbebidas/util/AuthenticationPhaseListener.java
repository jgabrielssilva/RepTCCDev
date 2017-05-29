package br.com.sysbebidas.util;

import java.util.Map;
import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import br.com.sysbebidas.bean.AutenticacaoBean;
import br.com.sysbebidas.domain.Funcionario;

@SuppressWarnings("serial")
public class AuthenticationPhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();
		UIViewRoot uiViewRoot = facesContext.getViewRoot();
		String paginaAtual = uiViewRoot.getViewId();

		boolean serPaginaAutenticacao = paginaAtual.contains("autenticacao.xhtml");

		if (!serPaginaAutenticacao) {
			ExternalContext externalContext = facesContext.getExternalContext();
			Map<String, Object> mapa = externalContext.getSessionMap();
			AutenticacaoBean autenticacaoBean = (AutenticacaoBean) mapa.get("autenticacaoBean");

			Funcionario funcionario = autenticacaoBean.getFuncionarioLogado();
			if (funcionario.getCargo() == null) {
				FacesUtil.adicionarMsgErro("Funcionário não autenticado.");

				Application application = facesContext.getApplication();
				NavigationHandler navigationHandle = application.getNavigationHandler();
				navigationHandle.handleNavigation(facesContext, null, "/pages/autenticacao.xhtml?faces-redirect=true");
			}
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
}
