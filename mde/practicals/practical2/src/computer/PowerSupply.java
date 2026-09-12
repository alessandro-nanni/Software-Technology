/**
 */
package computer;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power Supply</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link computer.PowerSupply#getCapacityWatts <em>Capacity Watts</em>}</li>
 *   <li>{@link computer.PowerSupply#getEfficiency <em>Efficiency</em>}</li>
 * </ul>
 *
 * @see computer.ComputerPackage#getPowerSupply()
 * @model
 * @generated
 */
public interface PowerSupply extends EObject {
	/**
	 * Returns the value of the '<em><b>Capacity Watts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity Watts</em>' attribute.
	 * @see #setCapacityWatts(int)
	 * @see computer.ComputerPackage#getPowerSupply_CapacityWatts()
	 * @model required="true"
	 * @generated
	 */
	int getCapacityWatts();

	/**
	 * Sets the value of the '{@link computer.PowerSupply#getCapacityWatts <em>Capacity Watts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity Watts</em>' attribute.
	 * @see #getCapacityWatts()
	 * @generated
	 */
	void setCapacityWatts(int value);

	/**
	 * Returns the value of the '<em><b>Efficiency</b></em>' attribute.
	 * The literals are from the enumeration {@link computer.Efficiency}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Efficiency</em>' attribute.
	 * @see computer.Efficiency
	 * @see #setEfficiency(Efficiency)
	 * @see computer.ComputerPackage#getPowerSupply_Efficiency()
	 * @model required="true"
	 * @generated
	 */
	Efficiency getEfficiency();

	/**
	 * Sets the value of the '{@link computer.PowerSupply#getEfficiency <em>Efficiency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Efficiency</em>' attribute.
	 * @see computer.Efficiency
	 * @see #getEfficiency()
	 * @generated
	 */
	void setEfficiency(Efficiency value);

} // PowerSupply
