/**
 */
package practice1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Union</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link practice1.Union#getLeft <em>Left</em>}</li>
 *   <li>{@link practice1.Union#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see practice1.Practice1Package#getUnion()
 * @model
 * @generated
 */
public interface Union extends Query {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Query)
	 * @see practice1.Practice1Package#getUnion_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Query getLeft();

	/**
	 * Sets the value of the '{@link practice1.Union#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Query value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Query)
	 * @see practice1.Practice1Package#getUnion_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Query getRight();

	/**
	 * Sets the value of the '{@link practice1.Union#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Query value);

} // Union
