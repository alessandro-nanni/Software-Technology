/**
 */
package computer;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hard Disk</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link computer.HardDisk#getType <em>Type</em>}</li>
 *   <li>{@link computer.HardDisk#getCapacityGB <em>Capacity GB</em>}</li>
 * </ul>
 *
 * @see computer.ComputerPackage#getHardDisk()
 * @model
 * @generated
 */
public interface HardDisk extends Component {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link computer.StorageType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see computer.StorageType
	 * @see #setType(StorageType)
	 * @see computer.ComputerPackage#getHardDisk_Type()
	 * @model required="true"
	 * @generated
	 */
	StorageType getType();

	/**
	 * Sets the value of the '{@link computer.HardDisk#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see computer.StorageType
	 * @see #getType()
	 * @generated
	 */
	void setType(StorageType value);

	/**
	 * Returns the value of the '<em><b>Capacity GB</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity GB</em>' attribute.
	 * @see #setCapacityGB(int)
	 * @see computer.ComputerPackage#getHardDisk_CapacityGB()
	 * @model required="true"
	 * @generated
	 */
	int getCapacityGB();

	/**
	 * Sets the value of the '{@link computer.HardDisk#getCapacityGB <em>Capacity GB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity GB</em>' attribute.
	 * @see #getCapacityGB()
	 * @generated
	 */
	void setCapacityGB(int value);

} // HardDisk
