/**
 */
package practice1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comparison</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link practice1.Comparison#getLeft <em>Left</em>}</li>
 *   <li>{@link practice1.Comparison#getRight <em>Right</em>}</li>
 *   <li>{@link practice1.Comparison#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see practice1.Practice1Package#getComparison()
 * @model
 * @generated
 */
public interface Comparison extends Condition {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' reference.
	 * @see #setLeft(Value)
	 * @see practice1.Practice1Package#getComparison_Left()
	 * @model required="true"
	 * @generated
	 */
	Value getLeft();

	/**
	 * Sets the value of the '{@link practice1.Comparison#getLeft <em>Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Value value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' reference.
	 * @see #setRight(Value)
	 * @see practice1.Practice1Package#getComparison_Right()
	 * @model required="true"
	 * @generated
	 */
	Value getRight();

	/**
	 * Sets the value of the '{@link practice1.Comparison#getRight <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Value value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link practice1.ComparisonOp}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see practice1.ComparisonOp
	 * @see #setOperator(ComparisonOp)
	 * @see practice1.Practice1Package#getComparison_Operator()
	 * @model
	 * @generated
	 */
	ComparisonOp getOperator();

	/**
	 * Sets the value of the '{@link practice1.Comparison#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see practice1.ComparisonOp
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(ComparisonOp value);

} // Comparison
