package br.com.saude.prontuario.model.utils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class ResourceBundleUtils {

	private ResourceBundleUtils() {

	}

	public static String ENTITY_RESOURCE_NAME = "entities";
	public static String WIDGETS_RESOURCE_NAME = "widgets";
	public static String MESSAGES_RESOURCE_NAME = "messages";
	public static String VALIDATION_RESOURCE_NAME = "ValidationMessages";

	public static final List<String> resourceNames = new LinkedList<String>( Arrays.asList( ENTITY_RESOURCE_NAME, WIDGETS_RESOURCE_NAME, VALIDATION_RESOURCE_NAME, MESSAGES_RESOURCE_NAME,"javax.faces.Messages","org.hibernate.validator.ValidationMessages" ) );

	public static String getLocalizedMessage( String key ) {
		return getLocalizedMessage( key, Locale.getDefault() );
	}

	public static String getLocalizedMessage( String key, Locale locale ) {

		List<ResourceBundle> bundles = new LinkedList<ResourceBundle>();

		for ( String resource : resourceNames ) {
			try {
				bundles.add( ResourceBundle.getBundle( resource, locale ) );
			} catch ( Exception e ) {
			}
		}

		for ( ResourceBundle bundle : bundles ) {
			if ( bundle.containsKey( key ) ) {
				return bundle.getString( key );
			}
		}

		return key;

	}

	public static Map<String, Object> getLocalizedParams( Map<String, Object> params, Locale locale ) {

		Map<String, Object> map = new LinkedHashMap<String, Object>();
		for ( String key : params.keySet() ) {
			Object value = params.get( key );
			if ( value instanceof String ) {
				map.put( key, getLocalizedMessage( (String) value, locale ) );
			} else if ( value instanceof Class<?> ) {
				map.put( key, getLocalizedMessage( ( (Class<?>) value ).getSimpleName() + ".entityName", locale ) );
			} else {
				map.put( key, value );
			}
		}

		return map;
	}

}
