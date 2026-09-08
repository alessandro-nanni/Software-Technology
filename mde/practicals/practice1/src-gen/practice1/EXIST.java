/**
 */
package practice1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EXIST</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link practice1.EXIST#getQuery <em>Query</em>}</li>
 * </ul>
 *
 * @see practice1.Practice1Package#getEXIST()
 * @model
 * @generated
 */
public interface EXIST extends Condition {
	/**
	 * Returns the value of the '<em><b>Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' reference.
	 * @see #setQuery(Query)
	 * @see practice1.Practice1Package#getEXIST_Query()
	 * @model required="true"
	 * @generated
	 */
	Query getQuery();

	/**
	 * Sets the value of the '{@link practice1.EXIST#getQuery <em>Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' reference.
	 * @see #getQuery()
	 * @generated
	 */
	void setQuery(Query value);

} // EXIST
