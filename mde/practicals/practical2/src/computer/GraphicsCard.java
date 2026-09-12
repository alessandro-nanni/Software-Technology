/**
 */
package computer;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graphics Card</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link computer.GraphicsCard#getModel <em>Model</em>}</li>
 *   <li>{@link computer.GraphicsCard#getVramGB <em>Vram GB</em>}</li>
 * </ul>
 *
 * @see computer.ComputerPackage#getGraphicsCard()
 * @model
 * @generated
 */
public interface GraphicsCard extends Component {
	/**
	 * Returns the value of the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' attribute.
	 * @see #setModel(String)
	 * @see computer.ComputerPackage#getGraphicsCard_Model()
	 * @model
	 * @generated
	 */
	String getModel();

	/**
	 * Sets the value of the '{@link computer.GraphicsCard#getModel <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' attribute.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(String value);

	/**
	 * Returns the value of the '<em><b>Vram GB</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vram GB</em>' attribute.
	 * @see #setVramGB(int)
	 * @see computer.ComputerPackage#getGraphicsCard_VramGB()
	 * @model required="true"
	 * @generated
	 */
	int getVramGB();

	/**
	 * Sets the value of the '{@link computer.GraphicsCard#getVramGB <em>Vram GB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vram GB</em>' attribute.
	 * @see #getVramGB()
	 * @generated
	 */
	void setVramGB(int value);

} // GraphicsCard
