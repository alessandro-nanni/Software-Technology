/**
 */
package practice1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link practice1.AttributeReference#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link practice1.AttributeReference#getTable <em>Table</em>}</li>
 * </ul>
 *
 * @see practice1.Practice1Package#getAttributeReference()
 * @model
 * @generated
 */
public interface AttributeReference extends Value {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' attribute.
	 * @see #setAttribute(String)
	 * @see practice1.Practice1Package#getAttributeReference_Attribute()
	 * @model
	 * @generated
	 */
	String getAttribute();

	/**
	 * Sets the value of the '{@link practice1.AttributeReference#getAttribute <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' attribute.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(String value);

	/**
	 * Returns the value of the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' reference.
	 * @see #setTable(TableReference)
	 * @see practice1.Practice1Package#getAttributeReference_Table()
	 * @model
	 * @generated
	 */
	TableReference getTable();

	/**
	 * Sets the value of the '{@link practice1.AttributeReference#getTable <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(TableReference value);

} // AttributeReference
