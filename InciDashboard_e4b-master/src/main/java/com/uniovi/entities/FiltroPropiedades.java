package com.uniovi.entities;

import java.util.function.Predicate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * <p>Un filtro de propiedades es el encargado de recibiar una incidencia y comprobar si es peligrosa
 * para la configuración de este.</p>
 * <p>Un filtro pertence a un operario y un operario puede tener varios filtros, además de esto
 * un filtro puede tener un estado de entre varios, puede ser un filtro de igualdad, uno de 
 * diferencia, de mayor o de menor, ejecutandose dicha operacion sobre el valor de un campo
 * de la incidencia.</p>
 * 
 */
@Entity
public class FiltroPropiedades {
	
	/**
	 * Id del filtro en la base de datos, no es un valor que se deba asignar en el constructor.
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * fieldName es el campo que se buscará en la incidencia para comprobar su valor, es decir,
	 * se ejecutará una busqueda sobre los fields de la incidencia dada intentando encontrar
	 * una igualdad entre uno de los nombres y este campo.
	 */
	private String fieldName;
	
	/**
	 * value es el valor con el que se hará la comparación en caso de encontrar un campo con el
	 * mismo valor que fieldName, es decir, en caso de encontrar un campo con el nombre Temperatura
	 * este tendrá un valor, por ejemplo 30 y en esta clase tendremos otro valor, por ejemplo 50, 
	 * sobre estos dos valores se ejecutará la operación dada.
	 */
	private String value;
	
	/**
	 * operation contiene un entero con la operación de comparación que se va a ejecutar sobre
	 * los valores, las posibles operaciones van de 0 a 3 siendo cada una:<br>
	 * 0 -> Comparación de igualdad. <br>
	 * 1 -> Comparación de distintos. <br>
	 * 2 -> Comparación de mayor. <br>
	 * 3 -> Comparación de menor. <br>
	 */
	private int operation;
	
	/**
	 * Operario al que pertence el filtro dado.
	 */
	@ManyToOne
	@JoinColumn(name = "operario")
	private Operario operario;
	
	/**
	 * Predicados para ejecutar la operación que queremos sobre los valores de la incidencia
	 * y el filtro, se generan en un método auxiliar de la clase.
	 */
	@Transient
	private Predicate<Incidencia>[] aplicacionFiltro;
	
	/**
	 * Constructor vacio para poder generar los beans.
	 */
	public FiltroPropiedades() {}
	
	/**
	 * Constructor con paramétros para poder inicializar un filtro con valores.
	 * @param fieldName -> Nombre del campo que vamos a buscar.
	 * @param value -> Valor con el que vamos a comparar el valor del campo.
	 * @param operation -> Operación que vamos a ejecutar.
	 */
	public FiltroPropiedades(String fieldName, String value, int operation) {
		this.fieldName = fieldName;
		this.value = value;
		this.operation = operation;
	}
	
	/**
	 * Getter del atributo id.
	 * @return Retorna el id del filtro.
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Setter del atributo id.
	 * @param id -> Asigna un valor al atributo id.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter del atributo fieldName.
	 * @return Retorna el valor de fieldName.
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * Setter del atributo fieldName.
	 * @param fieldName -> fieldName a asignar.
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * Getter del atributo value.
	 * @return Retorna el contenido de value.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Setter del atributo value.
	 * @param value -> Valor a asignar.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Getter del atributo operation.
	 * @return Retorna el valor de la operación.
	 */
	public int getOperation() {
		return operation;
	}

	/**
	 * Setter del atributo operation.
	 * @param operation -> Valor de la operación a asignar.
	 */
	public void setOperation(int operation) {
		this.operation = operation;
	}

	/**
	 * Getter del atributo Operario.
	 * @return Retorna el operario asignado.
	 */
	public Operario getOperario() {
		return operario;
	}

	/**
	 * Setter del atributo Operario.
	 * @param operario -> Asigna al operario dado.
	 */
	public void setOperario(Operario operario) {
		this.operario = operario;
	}

	/**
	 * <p>Crea los filtros para las 4 posibles operaciones, se llamará a este método antes de
	 * aplicar el filtro, guarda en cada posición del array la operación para el código de dicha
	 * operación.</p>
	 * Es necesaria la etiqueta "unchecked" ya que hay que transformar la incialización de un
	 * predicado sin inferencia de tipo a un predicado de Incidencias.
	 */
	@SuppressWarnings("unchecked")
	private void createFilter() {
		aplicacionFiltro = (Predicate<Incidencia>[])new Predicate[4];
		aplicacionFiltro[0] = i -> i.getFields().get(fieldName).toUpperCase().equals(value.toUpperCase());
		aplicacionFiltro[1] = i -> !i.getFields().get(fieldName).toUpperCase().equals(value.toUpperCase());
		aplicacionFiltro[2] = i -> Double.parseDouble(i.getFields().get(fieldName)) > Double.parseDouble(value);
		aplicacionFiltro[3] = i -> Double.parseDouble(i.getFields().get(fieldName)) < Double.parseDouble(value);
	}
	
	/**
	 * Aplica el filtro de la operación asignada a la incidencia recibida.
	 * @param incidencia -> Incidencia a comprobar.
	 * @return Retorna true en caso de que se cumpla que la incidencia es peligrosa
	 * y false en caso de que la incidencia no se peligrosa.
	 */
	public boolean applicateFilter(Incidencia incidencia) {
		createFilter();
		return aplicacionFiltro[operation].test(incidencia);
	}
	
}
