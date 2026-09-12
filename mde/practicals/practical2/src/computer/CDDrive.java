/**
 */
package computer;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CD Drive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link computer.CDDrive#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see computer.ComputerPackage#getCDDrive()
 * @model
 * @generated
 */
public interface CDDrive extends Component {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link computer.CDDriveType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see computer.CDDriveType
	 * @see #setType(CDDriveType)
	 * @see computer.ComputerPackage#getCDDrive_Type()
	 * @model required="true"
	 * @generated
	 */
	CDDriveType getType();

	/**
	 * Sets the value of the '{@link computer.CDDrive#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see computer.CDDriveType
	 * @see #getType()
	 * @generated
	 */
	void setType(CDDriveType value);

} // CDDrive
