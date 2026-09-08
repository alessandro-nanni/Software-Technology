/**
 */
package practice1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AND</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link practice1.AND#getLeft <em>Left</em>}</li>
 *   <li>{@link practice1.AND#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see practice1.Practice1Package#getAND()
 * @model
 * @generated
 */
public interface AND extends Condition {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' reference.
	 * @see #setLeft(Condition)
	 * @see practice1.Practice1Package#getAND_Left()
	 * @model required="true"
	 * @generated
	 */
	Condition getLeft();

	/**
	 * Sets the value of the '{@link practice1.AND#getLeft <em>Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Condition value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' reference.
	 * @see #setRight(Condition)
	 * @see practice1.Practice1Package#getAND_Right()
	 * @model required="true"
	 * @generated
	 */
	Condition getRight();

	/**
	 * Sets the value of the '{@link practice1.AND#getRight <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Condition value);

} // AND
