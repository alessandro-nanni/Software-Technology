/**
 */
package practice1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>NOT</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link practice1.NOT#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see practice1.Practice1Package#getNOT()
 * @model
 * @generated
 */
public interface NOT extends Condition {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' reference.
	 * @see #setCondition(Condition)
	 * @see practice1.Practice1Package#getNOT_Condition()
	 * @model required="true"
	 * @generated
	 */
	Condition getCondition();

	/**
	 * Sets the value of the '{@link practice1.NOT#getCondition <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Condition value);

} // NOT
