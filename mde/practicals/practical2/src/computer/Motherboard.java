/**
 */
package computer;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Motherboard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link computer.Motherboard#getType <em>Type</em>}</li>
 *   <li>{@link computer.Motherboard#getChipset <em>Chipset</em>}</li>
 *   <li>{@link computer.Motherboard#getSocket <em>Socket</em>}</li>
 *   <li>{@link computer.Motherboard#getPorts <em>Ports</em>}</li>
 * </ul>
 *
 * @see computer.ComputerPackage#getMotherboard()
 * @model
 * @generated
 */
public interface Motherboard extends Component {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link computer.MotherboardType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see computer.MotherboardType
	 * @see #setType(MotherboardType)
	 * @see computer.ComputerPackage#getMotherboard_Type()
	 * @model required="true"
	 * @generated
	 */
	MotherboardType getType();

	/**
	 * Sets the value of the '{@link computer.Motherboard#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see computer.MotherboardType
	 * @see #getType()
	 * @generated
	 */
	void setType(MotherboardType value);

	/**
	 * Returns the value of the '<em><b>Chipset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chipset</em>' attribute.
	 * @see #setChipset(String)
	 * @see computer.ComputerPackage#getMotherboard_Chipset()
	 * @model required="true"
	 * @generated
	 */
	String getChipset();

	/**
	 * Sets the value of the '{@link computer.Motherboard#getChipset <em>Chipset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chipset</em>' attribute.
	 * @see #getChipset()
	 * @generated
	 */
	void setChipset(String value);

	/**
	 * Returns the value of the '<em><b>Socket</b></em>' attribute.
	 * The literals are from the enumeration {@link computer.CPUSocket}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Socket</em>' attribute.
	 * @see computer.CPUSocket
	 * @see #setSocket(CPUSocket)
	 * @see computer.ComputerPackage#getMotherboard_Socket()
	 * @model required="true"
	 * @generated
	 */
	CPUSocket getSocket();

	/**
	 * Sets the value of the '{@link computer.Motherboard#getSocket <em>Socket</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Socket</em>' attribute.
	 * @see computer.CPUSocket
	 * @see #getSocket()
	 * @generated
	 */
	void setSocket(CPUSocket value);

	/**
	 * Returns the value of the '<em><b>Ports</b></em>' attribute list.
	 * The list contents are of type {@link computer.PortType}.
	 * The literals are from the enumeration {@link computer.PortType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' attribute list.
	 * @see computer.PortType
	 * @see computer.ComputerPackage#getMotherboard_Ports()
	 * @model ordered="false"
	 * @generated
	 */
	EList<PortType> getPorts();

} // Motherboard
