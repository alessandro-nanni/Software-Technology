/**
 */
package computer;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Memory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link computer.Memory#getType <em>Type</em>}</li>
 *   <li>{@link computer.Memory#getCapacityGB <em>Capacity GB</em>}</li>
 * </ul>
 *
 * @see computer.ComputerPackage#getMemory()
 * @model
 * @generated
 */
public interface Memory extends Component {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link computer.MemoryType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see computer.MemoryType
	 * @see #setType(MemoryType)
	 * @see computer.ComputerPackage#getMemory_Type()
	 * @model required="true"
	 * @generated
	 */
	MemoryType getType();

	/**
	 * Sets the value of the '{@link computer.Memory#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see computer.MemoryType
	 * @see #getType()
	 * @generated
	 */
	void setType(MemoryType value);

	/**
	 * Returns the value of the '<em><b>Capacity GB</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity GB</em>' attribute.
	 * @see #setCapacityGB(int)
	 * @see computer.ComputerPackage#getMemory_CapacityGB()
	 * @model required="true"
	 * @generated
	 */
	int getCapacityGB();

	/**
	 * Sets the value of the '{@link computer.Memory#getCapacityGB <em>Capacity GB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity GB</em>' attribute.
	 * @see #getCapacityGB()
	 * @generated
	 */
	void setCapacityGB(int value);

} // Memory
