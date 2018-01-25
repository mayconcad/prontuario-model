package br.com.saude.prontuario.model.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;

public class UtilsModel {

	/**
	 * Limpa os dados dos componentes de edição e de seus filhos,
	 * recursivamente. Checa se o componente é instância de EditableValueHolder
	 * e 'reseta' suas propriedades.
	 * <p>
	 * Quando este método, por algum motivo, não funcionar, parta para
	 * ignorância e limpe o componente assim:
	 * <p>
	 * <blockquote>
	 * 
	 * <pre>
	 * component.getChildren().clear()
	 * </pre>
	 * 
	 * </blockquote> :-)
	 *
	 * 
	 */
	public static void cleanSubmittedValues(UIComponent component) {
		if (component instanceof EditableValueHolder) {
			EditableValueHolder evh = (EditableValueHolder) component;
			evh.setSubmittedValue(null);
			evh.setValue(null);
			evh.setLocalValueSet(false);
			evh.setValid(true);
		}
		// Dependendo de como se implementa um Composite Component, ele retorna
		// ZERO
		// na busca por filhos. Nesse caso devemos iterar sobre os componentes
		// que o
		// compõe de forma diferente.
		if (UIComponent.isCompositeComponent(component)) {
			Iterator i = component.getFacetsAndChildren();
			while (i.hasNext()) {
				UIComponent comp = (UIComponent) i.next();

				// TODO: isolar em um método?
				if (comp.getChildCount() > 0) {
					for (UIComponent child : comp.getChildren()) {
						cleanSubmittedValues(child);
					}
				}
			}
		}
		// TODO: isolar em um método?
		if (component.getChildCount() > 0) {
			for (UIComponent child : component.getChildren()) {
				cleanSubmittedValues(child);
			}
		}
	}

	// converte o valor do cpf formatado para somente numeros em formato de
	// string
	public static String convertFormatCPF(String cpf) {
		return cpf.replace(".", "").replace("-", "").trim();
	}

	public static String pegarSeisCaracteres(String codElementoDespesa) {
		if (codElementoDespesa != null && codElementoDespesa.length() > 6)
			return codElementoDespesa.substring(0, 6);
		return codElementoDespesa;
	}

	public static String pegarPrimeirosCaracteres(String valor, int quant) {
		if (valor != null && valor.length() > quant)
			return valor.substring(0, quant);
		return valor;
	}

	public static BigDecimal convertStringToBigDecimal(String valorRepasse) {
		return new BigDecimal(valorRepasse.replace("R$", "").replace(".", "")
				.replace(",", ".").trim());
	}

	public static String convertBigDecimalToString(BigDecimal valor) {
		DecimalFormat formatoDois = new DecimalFormat("##,###,###,##0.00",
				new DecimalFormatSymbols(new Locale("pt", "BR")));
		formatoDois.setMinimumFractionDigits(2);
		formatoDois.setParseBigDecimal(true);
		return String.format("R$ %s", formatoDois.format(valor));
	}

	public static boolean possuiValorValido(Object... valores) {
		boolean result = true;
		for (Object object : valores) {
			if (object instanceof Collection) {
				if (((Collection) object).isEmpty())
					result = false;
			} else if (object == null || object.equals(""))
				result = false;
			result &= result;
		}
		return result;
	}
}
