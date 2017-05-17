package br.com.sysbebidas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.sysbebidas.dao.CargoDAO;
import br.com.sysbebidas.domain.Cargo;

@FacesConverter("cargoConverter")
public class CargoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			Long codigo = Long.parseLong(valor);

			CargoDAO cargoDAO = new CargoDAO();
			Cargo cargo = cargoDAO.buscarPorCodigo(codigo);

			return cargo;
		} catch (RuntimeException ex) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
		try {
			Cargo cargo = (Cargo) objeto;
			Long codigo = cargo.getCodigo();
			return codigo.toString();
		} catch (RuntimeException ex) {
			return null;
		}
	}
}
