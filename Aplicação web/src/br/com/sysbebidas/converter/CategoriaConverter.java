package br.com.sysbebidas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.sysbebidas.dao.CategoriaDAO;
import br.com.sysbebidas.domain.Categoria;

@FacesConverter("categoriaConverter")
public class CategoriaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			Long codigo = Long.parseLong(valor);

			CategoriaDAO categoriaDAO = new CategoriaDAO();
			Categoria categoria = categoriaDAO.buscarPorCodigo(codigo);

			return categoria;
		} catch (RuntimeException ex) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
		try {
			Categoria categoria = (Categoria) objeto;
			Long codigo = categoria.getCodigo();
			return codigo.toString();
		} catch (RuntimeException ex) {
			return null;
		}
	}
}
