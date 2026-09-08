/**
 */
package practice1;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see practice1.Practice1Package
 * @generated
 */
public interface Practice1Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Practice1Factory eINSTANCE = practice1.impl.Practice1FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Select</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select</em>'.
	 * @generated
	 */
	Select createSelect();

	/**
	 * Returns a new object of class '<em>Union</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Union</em>'.
	 * @generated
	 */
	Union createUnion();

	/**
	 * Returns a new object of class '<em>Table Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Table Reference</em>'.
	 * @generated
	 */
	TableReference createTableReference();

	/**
	 * Returns a new object of class '<em>Column Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Column Selection</em>'.
	 * @generated
	 */
	ColumnSelection createColumnSelection();

	/**
	 * Returns a new object of class '<em>All Columns Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>All Columns Selection</em>'.
	 * @generated
	 */
	AllColumnsSelection createAllColumnsSelection();

	/**
	 * Returns a new object of class '<em>Comparison</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comparison</em>'.
	 * @generated
	 */
	Comparison createComparison();

	/**
	 * Returns a new object of class '<em>AND</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AND</em>'.
	 * @generated
	 */
	AND createAND();

	/**
	 * Returns a new object of class '<em>OR</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OR</em>'.
	 * @generated
	 */
	OR createOR();

	/**
	 * Returns a new object of class '<em>NOT</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>NOT</em>'.
	 * @generated
	 */
	NOT createNOT();

	/**
	 * Returns a new object of class '<em>EXIST</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EXIST</em>'.
	 * @generated
	 */
	EXIST createEXIST();

	/**
	 * Returns a new object of class '<em>Attribute Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Reference</em>'.
	 * @generated
	 */
	AttributeReference createAttributeReference();

	/**
	 * Returns a new object of class '<em>Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal</em>'.
	 * @generated
	 */
	Literal createLiteral();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Practice1Package getPractice1Package();

} //Practice1Factory
