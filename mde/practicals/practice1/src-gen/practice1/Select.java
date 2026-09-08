/**
 */
package practice1;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Select</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link practice1.Select#getSelections <em>Selections</em>}</li>
 *   <li>{@link practice1.Select#getTables <em>Tables</em>}</li>
 *   <li>{@link practice1.Select#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see practice1.Practice1Package#getSelect()
 * @model
 * @generated
 */
public interface Select extends Query {
	/**
	 * Returns the value of the '<em><b>Selections</b></em>' containment reference list.
	 * The list contents are of type {@link practice1.Selection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selections</em>' containment reference list.
	 * @see practice1.Practice1Package#getSelect_Selections()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Selection> getSelections();

	/**
	 * Returns the value of the '<em><b>Tables</b></em>' containment reference list.
	 * The list contents are of type {@link practice1.TableReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tables</em>' containment reference list.
	 * @see practice1.Practice1Package#getSelect_Tables()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TableReference> getTables();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Condition)
	 * @see practice1.Practice1Package#getSelect_Condition()
	 * @model containment="true"
	 * @generated
	 */
	Condition getCondition();

	/**
	 * Sets the value of the '{@link practice1.Select#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Condition value);

} // Select
