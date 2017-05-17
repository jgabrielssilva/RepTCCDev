package br.com.sysbebidas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.sysbebidas.dao.DepartamentoDAO;
import br.com.sysbebidas.domain.Departamento;

@FacesConverter("departamentoConverter")
public class DepartamentoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			Long codigo = Long.parseLong(valor);

			DepartamentoDAO departamentoDAO = new DepartamentoDAO();
			Departamento departamento = departamentoDAO.buscarPorCodigo(codigo);

			return departamento;
		} catch (RuntimeException ex) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
		try {
			Departamento departamento = (Departamento) objeto;
			Long codigo = departamento.getCodigo();
			return codigo.toString();
		} catch (RuntimeException ex) {
			return null;
		}
	}
}
