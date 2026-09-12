/**
 */
package computer;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link computer.Component#getPowerConsumption <em>Power Consumption</em>}</li>
 * </ul>
 *
 * @see computer.ComputerPackage#getComponent()
 * @model abstract="true"
 * @generated
 */
public interface Component extends EObject {
	/**
	 * Returns the value of the '<em><b>Power Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Power Consumption</em>' attribute.
	 * @see #setPowerConsumption(int)
	 * @see computer.ComputerPackage#getComponent_PowerConsumption()
	 * @model required="true"
	 * @generated
	 */
	int getPowerConsumption();

	/**
	 * Sets the value of the '{@link computer.Component#getPowerConsumption <em>Power Consumption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Power Consumption</em>' attribute.
	 * @see #getPowerConsumption()
	 * @generated
	 */
	void setPowerConsumption(int value);

} // Component
