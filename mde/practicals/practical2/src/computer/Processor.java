/**
 */
package computer;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link computer.Processor#getModel <em>Model</em>}</li>
 *   <li>{@link computer.Processor#getSocket <em>Socket</em>}</li>
 *   <li>{@link computer.Processor#getCores <em>Cores</em>}</li>
 * </ul>
 *
 * @see computer.ComputerPackage#getProcessor()
 * @model
 * @generated
 */
public interface Processor extends Component {
	/**
	 * Returns the value of the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' attribute.
	 * @see #setModel(String)
	 * @see computer.ComputerPackage#getProcessor_Model()
	 * @model
	 * @generated
	 */
	String getModel();

	/**
	 * Sets the value of the '{@link computer.Processor#getModel <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' attribute.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(String value);

	/**
	 * Returns the value of the '<em><b>Socket</b></em>' attribute.
	 * The literals are from the enumeration {@link computer.CPUSocket}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Socket</em>' attribute.
	 * @see computer.CPUSocket
	 * @see #setSocket(CPUSocket)
	 * @see computer.ComputerPackage#getProcessor_Socket()
	 * @model required="true"
	 * @generated
	 */
	CPUSocket getSocket();

	/**
	 * Sets the value of the '{@link computer.Processor#getSocket <em>Socket</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Socket</em>' attribute.
	 * @see computer.CPUSocket
	 * @see #getSocket()
	 * @generated
	 */
	void setSocket(CPUSocket value);

	/**
	 * Returns the value of the '<em><b>Cores</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cores</em>' attribute.
	 * @see #setCores(int)
	 * @see computer.ComputerPackage#getProcessor_Cores()
	 * @model required="true"
	 * @generated
	 */
	int getCores();

	/**
	 * Sets the value of the '{@link computer.Processor#getCores <em>Cores</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cores</em>' attribute.
	 * @see #getCores()
	 * @generated
	 */
	void setCores(int value);

} // Processor
