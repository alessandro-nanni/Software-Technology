/**
 */
package practice1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link practice1.ColumnSelection#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link practice1.ColumnSelection#getAlias <em>Alias</em>}</li>
 *   <li>{@link practice1.ColumnSelection#getTable <em>Table</em>}</li>
 * </ul>
 *
 * @see practice1.Practice1Package#getColumnSelection()
 * @model
 * @generated
 */
public interface ColumnSelection extends Selection {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' attribute.
	 * @see #setAttribute(String)
	 * @see practice1.Practice1Package#getColumnSelection_Attribute()
	 * @model
	 * @generated
	 */
	String getAttribute();

	/**
	 * Sets the value of the '{@link practice1.ColumnSelection#getAttribute <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' attribute.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(String value);

	/**
	 * Returns the value of the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alias</em>' attribute.
	 * @see #setAlias(String)
	 * @see practice1.Practice1Package#getColumnSelection_Alias()
	 * @model
	 * @generated
	 */
	String getAlias();

	/**
	 * Sets the value of the '{@link practice1.ColumnSelection#getAlias <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias</em>' attribute.
	 * @see #getAlias()
	 * @generated
	 */
	void setAlias(String value);

	/**
	 * Returns the value of the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' reference.
	 * @see #setTable(TableReference)
	 * @see practice1.Practice1Package#getColumnSelection_Table()
	 * @model
	 * @generated
	 */
	TableReference getTable();

	/**
	 * Sets the value of the '{@link practice1.ColumnSelection#getTable <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(TableReference value);

} // ColumnSelection
