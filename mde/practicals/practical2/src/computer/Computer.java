/**
 */
package computer;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link computer.Computer#getMotherboard <em>Motherboard</em>}</li>
 *   <li>{@link computer.Computer#getProcessor <em>Processor</em>}</li>
 *   <li>{@link computer.Computer#getGraphicsCard <em>Graphics Card</em>}</li>
 *   <li>{@link computer.Computer#getMemory <em>Memory</em>}</li>
 *   <li>{@link computer.Computer#getHardDisks <em>Hard Disks</em>}</li>
 *   <li>{@link computer.Computer#getCdDrive <em>Cd Drive</em>}</li>
 *   <li>{@link computer.Computer#getPeripherals <em>Peripherals</em>}</li>
 *   <li>{@link computer.Computer#getPowerSupply <em>Power Supply</em>}</li>
 * </ul>
 *
 * @see computer.ComputerPackage#getComputer()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='MotherboardProcessorCompatible'"
 * @generated
 */
public interface Computer extends EObject {
	/**
	 * Returns the value of the '<em><b>Motherboard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Motherboard</em>' containment reference.
	 * @see #setMotherboard(Motherboard)
	 * @see computer.ComputerPackage#getComputer_Motherboard()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Motherboard getMotherboard();

	/**
	 * Sets the value of the '{@link computer.Computer#getMotherboard <em>Motherboard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Motherboard</em>' containment reference.
	 * @see #getMotherboard()
	 * @generated
	 */
	void setMotherboard(Motherboard value);

	/**
	 * Returns the value of the '<em><b>Processor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processor</em>' containment reference.
	 * @see #setProcessor(Processor)
	 * @see computer.ComputerPackage#getComputer_Processor()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Processor getProcessor();

	/**
	 * Sets the value of the '{@link computer.Computer#getProcessor <em>Processor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processor</em>' containment reference.
	 * @see #getProcessor()
	 * @generated
	 */
	void setProcessor(Processor value);

	/**
	 * Returns the value of the '<em><b>Graphics Card</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graphics Card</em>' containment reference.
	 * @see #setGraphicsCard(GraphicsCard)
	 * @see computer.ComputerPackage#getComputer_GraphicsCard()
	 * @model containment="true"
	 * @generated
	 */
	GraphicsCard getGraphicsCard();

	/**
	 * Sets the value of the '{@link computer.Computer#getGraphicsCard <em>Graphics Card</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graphics Card</em>' containment reference.
	 * @see #getGraphicsCard()
	 * @generated
	 */
	void setGraphicsCard(GraphicsCard value);

	/**
	 * Returns the value of the '<em><b>Memory</b></em>' containment reference list.
	 * The list contents are of type {@link computer.Memory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory</em>' containment reference list.
	 * @see computer.ComputerPackage#getComputer_Memory()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Memory> getMemory();

	/**
	 * Returns the value of the '<em><b>Hard Disks</b></em>' containment reference list.
	 * The list contents are of type {@link computer.HardDisk}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hard Disks</em>' containment reference list.
	 * @see computer.ComputerPackage#getComputer_HardDisks()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<HardDisk> getHardDisks();

	/**
	 * Returns the value of the '<em><b>Cd Drive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cd Drive</em>' containment reference.
	 * @see #setCdDrive(CDDrive)
	 * @see computer.ComputerPackage#getComputer_CdDrive()
	 * @model containment="true"
	 * @generated
	 */
	CDDrive getCdDrive();

	/**
	 * Sets the value of the '{@link computer.Computer#getCdDrive <em>Cd Drive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cd Drive</em>' containment reference.
	 * @see #getCdDrive()
	 * @generated
	 */
	void setCdDrive(CDDrive value);

	/**
	 * Returns the value of the '<em><b>Peripherals</b></em>' containment reference list.
	 * The list contents are of type {@link computer.Peripheral}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Peripherals</em>' containment reference list.
	 * @see computer.ComputerPackage#getComputer_Peripherals()
	 * @model containment="true"
	 * @generated
	 */
	EList<Peripheral> getPeripherals();

	/**
	 * Returns the value of the '<em><b>Power Supply</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Power Supply</em>' containment reference.
	 * @see #setPowerSupply(PowerSupply)
	 * @see computer.ComputerPackage#getComputer_PowerSupply()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PowerSupply getPowerSupply();

	/**
	 * Sets the value of the '{@link computer.Computer#getPowerSupply <em>Power Supply</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Power Supply</em>' containment reference.
	 * @see #getPowerSupply()
	 * @generated
	 */
	void setPowerSupply(PowerSupply value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Tuple { message : String = \'Power supply capacity is lower than the total power draw of the installed components\', status : Boolean = powerSupply.capacityWatts &gt;= motherboard.powerConsumption + processor.powerConsumption + (if graphicsCard.oclIsUndefined() then 0 else graphicsCard.powerConsumption endif) + memory-&gt;collect(powerConsumption)-&gt;sum() + hardDisks-&gt;collect(powerConsumption)-&gt;sum() + (if cdDrive.oclIsUndefined() then 0 else cdDrive.powerConsumption endif) + peripherals-&gt;collect(powerConsumption)-&gt;sum() }.status'"
	 * @generated
	 */
	boolean PowerSupplyCapacitySufficient(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Tuple { message : String = \'Motherboard does not expose a port for every connected peripheral\', status : Boolean = peripherals-&gt;forAll(p | motherboard.ports-&gt;includes(p.requiredPort)) }.status'"
	 * @generated
	 */
	boolean PeripheralPortsAvailable(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='Tuple { message : String = \'Processor socket \' + processor.socket.toString() + \' does not match motherboard socket \' + motherboard.socket.toString(), status : Boolean = motherboard.socket = processor.socket }.status'"
	 * @generated
	 */
	boolean MotherboardProcessorCompatible(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Computer
