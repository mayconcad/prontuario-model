package br.com.saude.prontuario.model.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.springframework.security.crypto.codec.Hex;

import br.com.saude.prontuario.model.entities.BaseEntity;
import br.com.saude.prontuario.model.vos.BaseVO;

public class DataConverterUtils {

	/**
	 * @description Converte um BigDecimal no formato do valor monetário
	 *              Brasileiro
	 * @param value
	 * @return String
	 */
	public static String currencyFormatter(BigDecimal value) {
		return currencyFormatter(value, null);
	}

	/**
	 * @description Converte um BigDecimal no formato do valor monetário da
	 *              localidade informada
	 * @param value
	 * @param locale
	 * @return String
	 */
	public static String currencyFormatter(BigDecimal value, Locale locale) {
		DecimalFormat format = new DecimalFormat("¤ ###,###,##0.00",
				new DecimalFormatSymbols(
						locale == null ? new Locale("pt", "BR") : locale));
		return format.format(value);
	}

	/**
	 * @description Converte um conjunto de entidades para um conjunto de VO's
	 * @param entities
	 * @param classVO
	 * @return Set<BaseVO>
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <V extends BaseVO> Set<V> converterForVOs(
			Set<? extends BaseEntity> entities, Class<V> classVO) {
		Set<V> vos = new HashSet<V>();
		V vo = null;
		try {
			vo = classVO.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		if (entities != null)
			for (BaseEntity baseEntity : entities)
				try {
					vos.add(converterEntityForVO(vo, baseEntity));
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

		return vos;
	}

	/**
	 * @description Converte uma entidade em um VO
	 * @param vo
	 * @param entity
	 * @return BaseVO
	 * @throws IllegalAccessException
	 */
	public static <V extends BaseVO> V converterEntityForVO(V vo,
			BaseEntity entity) throws IllegalAccessException {
		for (Field fieldEntity : entity.getClass().getDeclaredFields()) {
			if (fieldEntity.getName().equalsIgnoreCase("serialVersionUID"))
				continue;
			for (Field fieldVO : vo.getClass().getDeclaredFields())
				if (fieldVO.getName().equals(fieldEntity.getName())) {
					fieldEntity.setAccessible(true);
					fieldVO.setAccessible(true);
					fieldVO.set(vo, fieldEntity.get(entity));
				}
		}
		return vo;
	}

	public static String sha256(String original)
			throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(original.getBytes());
		byte[] digest = md.digest();
		return new String(Hex.encode(digest));
	}
}
