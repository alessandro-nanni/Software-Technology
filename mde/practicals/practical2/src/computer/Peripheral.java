/**
 */
package computer;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Peripheral</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link computer.Peripheral#getRequiredPort <em>Required Port</em>}</li>
 * </ul>
 *
 * @see computer.ComputerPackage#getPeripheral()
 * @model abstract="true"
 * @generated
 */
public interface Peripheral extends Component {
	/**
	 * Returns the value of the '<em><b>Required Port</b></em>' attribute.
	 * The literals are from the enumeration {@link computer.PortType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Port</em>' attribute.
	 * @see computer.PortType
	 * @see #setRequiredPort(PortType)
	 * @see computer.ComputerPackage#getPeripheral_RequiredPort()
	 * @model required="true"
	 * @generated
	 */
	PortType getRequiredPort();

	/**
	 * Sets the value of the '{@link computer.Peripheral#getRequiredPort <em>Required Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Port</em>' attribute.
	 * @see computer.PortType
	 * @see #getRequiredPort()
	 * @generated
	 */
	void setRequiredPort(PortType value);

} // Peripheral
