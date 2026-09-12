/**
 */
package computer;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see computer.ComputerFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore"
 * @generated
 */
public interface ComputerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "computer";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/examples/example.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ex";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComputerPackage eINSTANCE = computer.impl.ComputerPackageImpl.init();

	/**
	 * The meta object id for the '{@link computer.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.impl.ComponentImpl
	 * @see computer.impl.ComputerPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Power Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__POWER_CONSUMPTION = 0;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link computer.impl.MotherboardImpl <em>Motherboard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.impl.MotherboardImpl
	 * @see computer.impl.ComputerPackageImpl#getMotherboard()
	 * @generated
	 */
	int MOTHERBOARD = 1;

	/**
	 * The feature id for the '<em><b>Power Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTHERBOARD__POWER_CONSUMPTION = COMPONENT__POWER_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTHERBOARD__TYPE = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Chipset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTHERBOARD__CHIPSET = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Socket</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTHERBOARD__SOCKET = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTHERBOARD__PORTS = COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Motherboard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTHERBOARD_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Motherboard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTHERBOARD_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link computer.impl.ProcessorImpl <em>Processor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.impl.ProcessorImpl
	 * @see computer.impl.ComputerPackageImpl#getProcessor()
	 * @generated
	 */
	int PROCESSOR = 2;

	/**
	 * The feature id for the '<em><b>Power Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR__POWER_CONSUMPTION = COMPONENT__POWER_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR__MODEL = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Socket</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR__SOCKET = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Cores</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR__CORES = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link computer.impl.GraphicsCardImpl <em>Graphics Card</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.impl.GraphicsCardImpl
	 * @see computer.impl.ComputerPackageImpl#getGraphicsCard()
	 * @generated
	 */
	int GRAPHICS_CARD = 3;

	/**
	 * The feature id for the '<em><b>Power Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_CARD__POWER_CONSUMPTION = COMPONENT__POWER_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_CARD__MODEL = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Vram GB</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_CARD__VRAM_GB = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Graphics Card</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_CARD_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Graphics Card</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_CARD_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link computer.impl.MemoryImpl <em>Memory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.impl.MemoryImpl
	 * @see computer.impl.ComputerPackageImpl#getMemory()
	 * @generated
	 */
	int MEMORY = 4;

	/**
	 * The feature id for the '<em><b>Power Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY__POWER_CONSUMPTION = COMPONENT__POWER_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY__TYPE = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Capacity GB</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY__CAPACITY_GB = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Memory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Memory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link computer.impl.HardDiskImpl <em>Hard Disk</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.impl.HardDiskImpl
	 * @see computer.impl.ComputerPackageImpl#getHardDisk()
	 * @generated
	 */
	int HARD_DISK = 5;

	/**
	 * The feature id for the '<em><b>Power Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARD_DISK__POWER_CONSUMPTION = COMPONENT__POWER_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARD_DISK__TYPE = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Capacity GB</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARD_DISK__CAPACITY_GB = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Hard Disk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARD_DISK_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Hard Disk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARD_DISK_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link computer.impl.CDDriveImpl <em>CD Drive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.impl.CDDriveImpl
	 * @see computer.impl.ComputerPackageImpl#getCDDrive()
	 * @generated
	 */
	int CD_DRIVE = 6;

	/**
	 * The feature id for the '<em><b>Power Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CD_DRIVE__POWER_CONSUMPTION = COMPONENT__POWER_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CD_DRIVE__TYPE = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CD Drive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CD_DRIVE_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CD Drive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CD_DRIVE_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link computer.impl.PeripheralImpl <em>Peripheral</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.impl.PeripheralImpl
	 * @see computer.impl.ComputerPackageImpl#getPeripheral()
	 * @generated
	 */
	int PERIPHERAL = 7;

	/**
	 * The feature id for the '<em><b>Power Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIPHERAL__POWER_CONSUMPTION = COMPONENT__POWER_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Required Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIPHERAL__REQUIRED_PORT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Peripheral</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIPHERAL_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Peripheral</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIPHERAL_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link computer.impl.MonitorImpl <em>Monitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.impl.MonitorImpl
	 * @see computer.impl.ComputerPackageImpl#getMonitor()
	 * @generated
	 */
	int MONITOR = 8;

	/**
	 * The feature id for the '<em><b>Power Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__POWER_CONSUMPTION = PERIPHERAL__POWER_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Required Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__REQUIRED_PORT = PERIPHERAL__REQUIRED_PORT;

	/**
	 * The number of structural features of the '<em>Monitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR_FEATURE_COUNT = PERIPHERAL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Monitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR_OPERATION_COUNT = PERIPHERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link computer.impl.KeyboardImpl <em>Keyboard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.impl.KeyboardImpl
	 * @see computer.impl.ComputerPackageImpl#getKeyboard()
	 * @generated
	 */
	int KEYBOARD = 9;

	/**
	 * The feature id for the '<em><b>Power Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYBOARD__POWER_CONSUMPTION = PERIPHERAL__POWER_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Required Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYBOARD__REQUIRED_PORT = PERIPHERAL__REQUIRED_PORT;

	/**
	 * The number of structural features of the '<em>Keyboard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYBOARD_FEATURE_COUNT = PERIPHERAL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Keyboard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYBOARD_OPERATION_COUNT = PERIPHERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link computer.impl.MouseImpl <em>Mouse</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.impl.MouseImpl
	 * @see computer.impl.ComputerPackageImpl#getMouse()
	 * @generated
	 */
	int MOUSE = 10;

	/**
	 * The feature id for the '<em><b>Power Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE__POWER_CONSUMPTION = PERIPHERAL__POWER_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Required Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE__REQUIRED_PORT = PERIPHERAL__REQUIRED_PORT;

	/**
	 * The number of structural features of the '<em>Mouse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_FEATURE_COUNT = PERIPHERAL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mouse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_OPERATION_COUNT = PERIPHERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link computer.impl.PrinterImpl <em>Printer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.impl.PrinterImpl
	 * @see computer.impl.ComputerPackageImpl#getPrinter()
	 * @generated
	 */
	int PRINTER = 11;

	/**
	 * The feature id for the '<em><b>Power Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINTER__POWER_CONSUMPTION = PERIPHERAL__POWER_CONSUMPTION;

	/**
	 * The feature id for the '<em><b>Required Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINTER__REQUIRED_PORT = PERIPHERAL__REQUIRED_PORT;

	/**
	 * The number of structural features of the '<em>Printer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINTER_FEATURE_COUNT = PERIPHERAL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Printer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINTER_OPERATION_COUNT = PERIPHERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link computer.impl.PowerSupplyImpl <em>Power Supply</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.impl.PowerSupplyImpl
	 * @see computer.impl.ComputerPackageImpl#getPowerSupply()
	 * @generated
	 */
	int POWER_SUPPLY = 12;

	/**
	 * The feature id for the '<em><b>Capacity Watts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY__CAPACITY_WATTS = 0;

	/**
	 * The feature id for the '<em><b>Efficiency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY__EFFICIENCY = 1;

	/**
	 * The number of structural features of the '<em>Power Supply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Power Supply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link computer.impl.ComputerImpl <em>Computer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.impl.ComputerImpl
	 * @see computer.impl.ComputerPackageImpl#getComputer()
	 * @generated
	 */
	int COMPUTER = 13;

	/**
	 * The feature id for the '<em><b>Motherboard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__MOTHERBOARD = 0;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__PROCESSOR = 1;

	/**
	 * The feature id for the '<em><b>Graphics Card</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__GRAPHICS_CARD = 2;

	/**
	 * The feature id for the '<em><b>Memory</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__MEMORY = 3;

	/**
	 * The feature id for the '<em><b>Hard Disks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__HARD_DISKS = 4;

	/**
	 * The feature id for the '<em><b>Cd Drive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__CD_DRIVE = 5;

	/**
	 * The feature id for the '<em><b>Peripherals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__PERIPHERALS = 6;

	/**
	 * The feature id for the '<em><b>Power Supply</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__POWER_SUPPLY = 7;

	/**
	 * The number of structural features of the '<em>Computer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER_FEATURE_COUNT = 8;

	/**
	 * The operation id for the '<em>Power Supply Capacity Sufficient</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER___POWER_SUPPLY_CAPACITY_SUFFICIENT__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The operation id for the '<em>Peripheral Ports Available</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER___PERIPHERAL_PORTS_AVAILABLE__DIAGNOSTICCHAIN_MAP = 1;

	/**
	 * The operation id for the '<em>Motherboard Processor Compatible</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER___MOTHERBOARD_PROCESSOR_COMPATIBLE__DIAGNOSTICCHAIN_MAP = 2;

	/**
	 * The number of operations of the '<em>Computer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link computer.CPUSocket <em>CPU Socket</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.CPUSocket
	 * @see computer.impl.ComputerPackageImpl#getCPUSocket()
	 * @generated
	 */
	int CPU_SOCKET = 14;

	/**
	 * The meta object id for the '{@link computer.PortType <em>Port Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.PortType
	 * @see computer.impl.ComputerPackageImpl#getPortType()
	 * @generated
	 */
	int PORT_TYPE = 15;

	/**
	 * The meta object id for the '{@link computer.MotherboardType <em>Motherboard Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.MotherboardType
	 * @see computer.impl.ComputerPackageImpl#getMotherboardType()
	 * @generated
	 */
	int MOTHERBOARD_TYPE = 16;

	/**
	 * The meta object id for the '{@link computer.MemoryType <em>Memory Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.MemoryType
	 * @see computer.impl.ComputerPackageImpl#getMemoryType()
	 * @generated
	 */
	int MEMORY_TYPE = 17;

	/**
	 * The meta object id for the '{@link computer.StorageType <em>Storage Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.StorageType
	 * @see computer.impl.ComputerPackageImpl#getStorageType()
	 * @generated
	 */
	int STORAGE_TYPE = 18;

	/**
	 * The meta object id for the '{@link computer.CDDriveType <em>CD Drive Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.CDDriveType
	 * @see computer.impl.ComputerPackageImpl#getCDDriveType()
	 * @generated
	 */
	int CD_DRIVE_TYPE = 19;

	/**
	 * The meta object id for the '{@link computer.Efficiency <em>Efficiency</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see computer.Efficiency
	 * @see computer.impl.ComputerPackageImpl#getEfficiency()
	 * @generated
	 */
	int EFFICIENCY = 20;


	/**
	 * Returns the meta object for class '{@link computer.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see computer.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the attribute '{@link computer.Component#getPowerConsumption <em>Power Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Power Consumption</em>'.
	 * @see computer.Component#getPowerConsumption()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_PowerConsumption();

	/**
	 * Returns the meta object for class '{@link computer.Motherboard <em>Motherboard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Motherboard</em>'.
	 * @see computer.Motherboard
	 * @generated
	 */
	EClass getMotherboard();

	/**
	 * Returns the meta object for the attribute '{@link computer.Motherboard#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see computer.Motherboard#getType()
	 * @see #getMotherboard()
	 * @generated
	 */
	EAttribute getMotherboard_Type();

	/**
	 * Returns the meta object for the attribute '{@link computer.Motherboard#getChipset <em>Chipset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chipset</em>'.
	 * @see computer.Motherboard#getChipset()
	 * @see #getMotherboard()
	 * @generated
	 */
	EAttribute getMotherboard_Chipset();

	/**
	 * Returns the meta object for the attribute '{@link computer.Motherboard#getSocket <em>Socket</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Socket</em>'.
	 * @see computer.Motherboard#getSocket()
	 * @see #getMotherboard()
	 * @generated
	 */
	EAttribute getMotherboard_Socket();

	/**
	 * Returns the meta object for the attribute list '{@link computer.Motherboard#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Ports</em>'.
	 * @see computer.Motherboard#getPorts()
	 * @see #getMotherboard()
	 * @generated
	 */
	EAttribute getMotherboard_Ports();

	/**
	 * Returns the meta object for class '{@link computer.Processor <em>Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processor</em>'.
	 * @see computer.Processor
	 * @generated
	 */
	EClass getProcessor();

	/**
	 * Returns the meta object for the attribute '{@link computer.Processor#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model</em>'.
	 * @see computer.Processor#getModel()
	 * @see #getProcessor()
	 * @generated
	 */
	EAttribute getProcessor_Model();

	/**
	 * Returns the meta object for the attribute '{@link computer.Processor#getSocket <em>Socket</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Socket</em>'.
	 * @see computer.Processor#getSocket()
	 * @see #getProcessor()
	 * @generated
	 */
	EAttribute getProcessor_Socket();

	/**
	 * Returns the meta object for the attribute '{@link computer.Processor#getCores <em>Cores</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cores</em>'.
	 * @see computer.Processor#getCores()
	 * @see #getProcessor()
	 * @generated
	 */
	EAttribute getProcessor_Cores();

	/**
	 * Returns the meta object for class '{@link computer.GraphicsCard <em>Graphics Card</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphics Card</em>'.
	 * @see computer.GraphicsCard
	 * @generated
	 */
	EClass getGraphicsCard();

	/**
	 * Returns the meta object for the attribute '{@link computer.GraphicsCard#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model</em>'.
	 * @see computer.GraphicsCard#getModel()
	 * @see #getGraphicsCard()
	 * @generated
	 */
	EAttribute getGraphicsCard_Model();

	/**
	 * Returns the meta object for the attribute '{@link computer.GraphicsCard#getVramGB <em>Vram GB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vram GB</em>'.
	 * @see computer.GraphicsCard#getVramGB()
	 * @see #getGraphicsCard()
	 * @generated
	 */
	EAttribute getGraphicsCard_VramGB();

	/**
	 * Returns the meta object for class '{@link computer.Memory <em>Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory</em>'.
	 * @see computer.Memory
	 * @generated
	 */
	EClass getMemory();

	/**
	 * Returns the meta object for the attribute '{@link computer.Memory#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see computer.Memory#getType()
	 * @see #getMemory()
	 * @generated
	 */
	EAttribute getMemory_Type();

	/**
	 * Returns the meta object for the attribute '{@link computer.Memory#getCapacityGB <em>Capacity GB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity GB</em>'.
	 * @see computer.Memory#getCapacityGB()
	 * @see #getMemory()
	 * @generated
	 */
	EAttribute getMemory_CapacityGB();

	/**
	 * Returns the meta object for class '{@link computer.HardDisk <em>Hard Disk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hard Disk</em>'.
	 * @see computer.HardDisk
	 * @generated
	 */
	EClass getHardDisk();

	/**
	 * Returns the meta object for the attribute '{@link computer.HardDisk#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see computer.HardDisk#getType()
	 * @see #getHardDisk()
	 * @generated
	 */
	EAttribute getHardDisk_Type();

	/**
	 * Returns the meta object for the attribute '{@link computer.HardDisk#getCapacityGB <em>Capacity GB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity GB</em>'.
	 * @see computer.HardDisk#getCapacityGB()
	 * @see #getHardDisk()
	 * @generated
	 */
	EAttribute getHardDisk_CapacityGB();

	/**
	 * Returns the meta object for class '{@link computer.CDDrive <em>CD Drive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CD Drive</em>'.
	 * @see computer.CDDrive
	 * @generated
	 */
	EClass getCDDrive();

	/**
	 * Returns the meta object for the attribute '{@link computer.CDDrive#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see computer.CDDrive#getType()
	 * @see #getCDDrive()
	 * @generated
	 */
	EAttribute getCDDrive_Type();

	/**
	 * Returns the meta object for class '{@link computer.Peripheral <em>Peripheral</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Peripheral</em>'.
	 * @see computer.Peripheral
	 * @generated
	 */
	EClass getPeripheral();

	/**
	 * Returns the meta object for the attribute '{@link computer.Peripheral#getRequiredPort <em>Required Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required Port</em>'.
	 * @see computer.Peripheral#getRequiredPort()
	 * @see #getPeripheral()
	 * @generated
	 */
	EAttribute getPeripheral_RequiredPort();

	/**
	 * Returns the meta object for class '{@link computer.Monitor <em>Monitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Monitor</em>'.
	 * @see computer.Monitor
	 * @generated
	 */
	EClass getMonitor();

	/**
	 * Returns the meta object for class '{@link computer.Keyboard <em>Keyboard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Keyboard</em>'.
	 * @see computer.Keyboard
	 * @generated
	 */
	EClass getKeyboard();

	/**
	 * Returns the meta object for class '{@link computer.Mouse <em>Mouse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mouse</em>'.
	 * @see computer.Mouse
	 * @generated
	 */
	EClass getMouse();

	/**
	 * Returns the meta object for class '{@link computer.Printer <em>Printer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Printer</em>'.
	 * @see computer.Printer
	 * @generated
	 */
	EClass getPrinter();

	/**
	 * Returns the meta object for class '{@link computer.PowerSupply <em>Power Supply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Power Supply</em>'.
	 * @see computer.PowerSupply
	 * @generated
	 */
	EClass getPowerSupply();

	/**
	 * Returns the meta object for the attribute '{@link computer.PowerSupply#getCapacityWatts <em>Capacity Watts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity Watts</em>'.
	 * @see computer.PowerSupply#getCapacityWatts()
	 * @see #getPowerSupply()
	 * @generated
	 */
	EAttribute getPowerSupply_CapacityWatts();

	/**
	 * Returns the meta object for the attribute '{@link computer.PowerSupply#getEfficiency <em>Efficiency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Efficiency</em>'.
	 * @see computer.PowerSupply#getEfficiency()
	 * @see #getPowerSupply()
	 * @generated
	 */
	EAttribute getPowerSupply_Efficiency();

	/**
	 * Returns the meta object for class '{@link computer.Computer <em>Computer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computer</em>'.
	 * @see computer.Computer
	 * @generated
	 */
	EClass getComputer();

	/**
	 * Returns the meta object for the containment reference '{@link computer.Computer#getMotherboard <em>Motherboard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Motherboard</em>'.
	 * @see computer.Computer#getMotherboard()
	 * @see #getComputer()
	 * @generated
	 */
	EReference getComputer_Motherboard();

	/**
	 * Returns the meta object for the containment reference '{@link computer.Computer#getProcessor <em>Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Processor</em>'.
	 * @see computer.Computer#getProcessor()
	 * @see #getComputer()
	 * @generated
	 */
	EReference getComputer_Processor();

	/**
	 * Returns the meta object for the containment reference '{@link computer.Computer#getGraphicsCard <em>Graphics Card</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Graphics Card</em>'.
	 * @see computer.Computer#getGraphicsCard()
	 * @see #getComputer()
	 * @generated
	 */
	EReference getComputer_GraphicsCard();

	/**
	 * Returns the meta object for the containment reference list '{@link computer.Computer#getMemory <em>Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Memory</em>'.
	 * @see computer.Computer#getMemory()
	 * @see #getComputer()
	 * @generated
	 */
	EReference getComputer_Memory();

	/**
	 * Returns the meta object for the containment reference list '{@link computer.Computer#getHardDisks <em>Hard Disks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Hard Disks</em>'.
	 * @see computer.Computer#getHardDisks()
	 * @see #getComputer()
	 * @generated
	 */
	EReference getComputer_HardDisks();

	/**
	 * Returns the meta object for the containment reference '{@link computer.Computer#getCdDrive <em>Cd Drive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cd Drive</em>'.
	 * @see computer.Computer#getCdDrive()
	 * @see #getComputer()
	 * @generated
	 */
	EReference getComputer_CdDrive();

	/**
	 * Returns the meta object for the containment reference list '{@link computer.Computer#getPeripherals <em>Peripherals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Peripherals</em>'.
	 * @see computer.Computer#getPeripherals()
	 * @see #getComputer()
	 * @generated
	 */
	EReference getComputer_Peripherals();

	/**
	 * Returns the meta object for the containment reference '{@link computer.Computer#getPowerSupply <em>Power Supply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Power Supply</em>'.
	 * @see computer.Computer#getPowerSupply()
	 * @see #getComputer()
	 * @generated
	 */
	EReference getComputer_PowerSupply();

	/**
	 * Returns the meta object for the '{@link computer.Computer#PowerSupplyCapacitySufficient(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Power Supply Capacity Sufficient</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Power Supply Capacity Sufficient</em>' operation.
	 * @see computer.Computer#PowerSupplyCapacitySufficient(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getComputer__PowerSupplyCapacitySufficient__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link computer.Computer#PeripheralPortsAvailable(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Peripheral Ports Available</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Peripheral Ports Available</em>' operation.
	 * @see computer.Computer#PeripheralPortsAvailable(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getComputer__PeripheralPortsAvailable__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link computer.Computer#MotherboardProcessorCompatible(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Motherboard Processor Compatible</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Motherboard Processor Compatible</em>' operation.
	 * @see computer.Computer#MotherboardProcessorCompatible(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getComputer__MotherboardProcessorCompatible__DiagnosticChain_Map();

	/**
	 * Returns the meta object for enum '{@link computer.CPUSocket <em>CPU Socket</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>CPU Socket</em>'.
	 * @see computer.CPUSocket
	 * @generated
	 */
	EEnum getCPUSocket();

	/**
	 * Returns the meta object for enum '{@link computer.PortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Port Type</em>'.
	 * @see computer.PortType
	 * @generated
	 */
	EEnum getPortType();

	/**
	 * Returns the meta object for enum '{@link computer.MotherboardType <em>Motherboard Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Motherboard Type</em>'.
	 * @see computer.MotherboardType
	 * @generated
	 */
	EEnum getMotherboardType();

	/**
	 * Returns the meta object for enum '{@link computer.MemoryType <em>Memory Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Memory Type</em>'.
	 * @see computer.MemoryType
	 * @generated
	 */
	EEnum getMemoryType();

	/**
	 * Returns the meta object for enum '{@link computer.StorageType <em>Storage Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Storage Type</em>'.
	 * @see computer.StorageType
	 * @generated
	 */
	EEnum getStorageType();

	/**
	 * Returns the meta object for enum '{@link computer.CDDriveType <em>CD Drive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>CD Drive Type</em>'.
	 * @see computer.CDDriveType
	 * @generated
	 */
	EEnum getCDDriveType();

	/**
	 * Returns the meta object for enum '{@link computer.Efficiency <em>Efficiency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Efficiency</em>'.
	 * @see computer.Efficiency
	 * @generated
	 */
	EEnum getEfficiency();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComputerFactory getComputerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link computer.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.impl.ComponentImpl
		 * @see computer.impl.ComputerPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Power Consumption</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__POWER_CONSUMPTION = eINSTANCE.getComponent_PowerConsumption();

		/**
		 * The meta object literal for the '{@link computer.impl.MotherboardImpl <em>Motherboard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.impl.MotherboardImpl
		 * @see computer.impl.ComputerPackageImpl#getMotherboard()
		 * @generated
		 */
		EClass MOTHERBOARD = eINSTANCE.getMotherboard();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOTHERBOARD__TYPE = eINSTANCE.getMotherboard_Type();

		/**
		 * The meta object literal for the '<em><b>Chipset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOTHERBOARD__CHIPSET = eINSTANCE.getMotherboard_Chipset();

		/**
		 * The meta object literal for the '<em><b>Socket</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOTHERBOARD__SOCKET = eINSTANCE.getMotherboard_Socket();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOTHERBOARD__PORTS = eINSTANCE.getMotherboard_Ports();

		/**
		 * The meta object literal for the '{@link computer.impl.ProcessorImpl <em>Processor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.impl.ProcessorImpl
		 * @see computer.impl.ComputerPackageImpl#getProcessor()
		 * @generated
		 */
		EClass PROCESSOR = eINSTANCE.getProcessor();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR__MODEL = eINSTANCE.getProcessor_Model();

		/**
		 * The meta object literal for the '<em><b>Socket</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR__SOCKET = eINSTANCE.getProcessor_Socket();

		/**
		 * The meta object literal for the '<em><b>Cores</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR__CORES = eINSTANCE.getProcessor_Cores();

		/**
		 * The meta object literal for the '{@link computer.impl.GraphicsCardImpl <em>Graphics Card</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.impl.GraphicsCardImpl
		 * @see computer.impl.ComputerPackageImpl#getGraphicsCard()
		 * @generated
		 */
		EClass GRAPHICS_CARD = eINSTANCE.getGraphicsCard();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHICS_CARD__MODEL = eINSTANCE.getGraphicsCard_Model();

		/**
		 * The meta object literal for the '<em><b>Vram GB</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHICS_CARD__VRAM_GB = eINSTANCE.getGraphicsCard_VramGB();

		/**
		 * The meta object literal for the '{@link computer.impl.MemoryImpl <em>Memory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.impl.MemoryImpl
		 * @see computer.impl.ComputerPackageImpl#getMemory()
		 * @generated
		 */
		EClass MEMORY = eINSTANCE.getMemory();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMORY__TYPE = eINSTANCE.getMemory_Type();

		/**
		 * The meta object literal for the '<em><b>Capacity GB</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMORY__CAPACITY_GB = eINSTANCE.getMemory_CapacityGB();

		/**
		 * The meta object literal for the '{@link computer.impl.HardDiskImpl <em>Hard Disk</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.impl.HardDiskImpl
		 * @see computer.impl.ComputerPackageImpl#getHardDisk()
		 * @generated
		 */
		EClass HARD_DISK = eINSTANCE.getHardDisk();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HARD_DISK__TYPE = eINSTANCE.getHardDisk_Type();

		/**
		 * The meta object literal for the '<em><b>Capacity GB</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HARD_DISK__CAPACITY_GB = eINSTANCE.getHardDisk_CapacityGB();

		/**
		 * The meta object literal for the '{@link computer.impl.CDDriveImpl <em>CD Drive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.impl.CDDriveImpl
		 * @see computer.impl.ComputerPackageImpl#getCDDrive()
		 * @generated
		 */
		EClass CD_DRIVE = eINSTANCE.getCDDrive();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CD_DRIVE__TYPE = eINSTANCE.getCDDrive_Type();

		/**
		 * The meta object literal for the '{@link computer.impl.PeripheralImpl <em>Peripheral</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.impl.PeripheralImpl
		 * @see computer.impl.ComputerPackageImpl#getPeripheral()
		 * @generated
		 */
		EClass PERIPHERAL = eINSTANCE.getPeripheral();

		/**
		 * The meta object literal for the '<em><b>Required Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIPHERAL__REQUIRED_PORT = eINSTANCE.getPeripheral_RequiredPort();

		/**
		 * The meta object literal for the '{@link computer.impl.MonitorImpl <em>Monitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.impl.MonitorImpl
		 * @see computer.impl.ComputerPackageImpl#getMonitor()
		 * @generated
		 */
		EClass MONITOR = eINSTANCE.getMonitor();

		/**
		 * The meta object literal for the '{@link computer.impl.KeyboardImpl <em>Keyboard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.impl.KeyboardImpl
		 * @see computer.impl.ComputerPackageImpl#getKeyboard()
		 * @generated
		 */
		EClass KEYBOARD = eINSTANCE.getKeyboard();

		/**
		 * The meta object literal for the '{@link computer.impl.MouseImpl <em>Mouse</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.impl.MouseImpl
		 * @see computer.impl.ComputerPackageImpl#getMouse()
		 * @generated
		 */
		EClass MOUSE = eINSTANCE.getMouse();

		/**
		 * The meta object literal for the '{@link computer.impl.PrinterImpl <em>Printer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.impl.PrinterImpl
		 * @see computer.impl.ComputerPackageImpl#getPrinter()
		 * @generated
		 */
		EClass PRINTER = eINSTANCE.getPrinter();

		/**
		 * The meta object literal for the '{@link computer.impl.PowerSupplyImpl <em>Power Supply</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.impl.PowerSupplyImpl
		 * @see computer.impl.ComputerPackageImpl#getPowerSupply()
		 * @generated
		 */
		EClass POWER_SUPPLY = eINSTANCE.getPowerSupply();

		/**
		 * The meta object literal for the '<em><b>Capacity Watts</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POWER_SUPPLY__CAPACITY_WATTS = eINSTANCE.getPowerSupply_CapacityWatts();

		/**
		 * The meta object literal for the '<em><b>Efficiency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POWER_SUPPLY__EFFICIENCY = eINSTANCE.getPowerSupply_Efficiency();

		/**
		 * The meta object literal for the '{@link computer.impl.ComputerImpl <em>Computer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.impl.ComputerImpl
		 * @see computer.impl.ComputerPackageImpl#getComputer()
		 * @generated
		 */
		EClass COMPUTER = eINSTANCE.getComputer();

		/**
		 * The meta object literal for the '<em><b>Motherboard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTER__MOTHERBOARD = eINSTANCE.getComputer_Motherboard();

		/**
		 * The meta object literal for the '<em><b>Processor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTER__PROCESSOR = eINSTANCE.getComputer_Processor();

		/**
		 * The meta object literal for the '<em><b>Graphics Card</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTER__GRAPHICS_CARD = eINSTANCE.getComputer_GraphicsCard();

		/**
		 * The meta object literal for the '<em><b>Memory</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTER__MEMORY = eINSTANCE.getComputer_Memory();

		/**
		 * The meta object literal for the '<em><b>Hard Disks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTER__HARD_DISKS = eINSTANCE.getComputer_HardDisks();

		/**
		 * The meta object literal for the '<em><b>Cd Drive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTER__CD_DRIVE = eINSTANCE.getComputer_CdDrive();

		/**
		 * The meta object literal for the '<em><b>Peripherals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTER__PERIPHERALS = eINSTANCE.getComputer_Peripherals();

		/**
		 * The meta object literal for the '<em><b>Power Supply</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTER__POWER_SUPPLY = eINSTANCE.getComputer_PowerSupply();

		/**
		 * The meta object literal for the '<em><b>Power Supply Capacity Sufficient</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPUTER___POWER_SUPPLY_CAPACITY_SUFFICIENT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getComputer__PowerSupplyCapacitySufficient__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Peripheral Ports Available</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPUTER___PERIPHERAL_PORTS_AVAILABLE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getComputer__PeripheralPortsAvailable__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Motherboard Processor Compatible</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPUTER___MOTHERBOARD_PROCESSOR_COMPATIBLE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getComputer__MotherboardProcessorCompatible__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link computer.CPUSocket <em>CPU Socket</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.CPUSocket
		 * @see computer.impl.ComputerPackageImpl#getCPUSocket()
		 * @generated
		 */
		EEnum CPU_SOCKET = eINSTANCE.getCPUSocket();

		/**
		 * The meta object literal for the '{@link computer.PortType <em>Port Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.PortType
		 * @see computer.impl.ComputerPackageImpl#getPortType()
		 * @generated
		 */
		EEnum PORT_TYPE = eINSTANCE.getPortType();

		/**
		 * The meta object literal for the '{@link computer.MotherboardType <em>Motherboard Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.MotherboardType
		 * @see computer.impl.ComputerPackageImpl#getMotherboardType()
		 * @generated
		 */
		EEnum MOTHERBOARD_TYPE = eINSTANCE.getMotherboardType();

		/**
		 * The meta object literal for the '{@link computer.MemoryType <em>Memory Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.MemoryType
		 * @see computer.impl.ComputerPackageImpl#getMemoryType()
		 * @generated
		 */
		EEnum MEMORY_TYPE = eINSTANCE.getMemoryType();

		/**
		 * The meta object literal for the '{@link computer.StorageType <em>Storage Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.StorageType
		 * @see computer.impl.ComputerPackageImpl#getStorageType()
		 * @generated
		 */
		EEnum STORAGE_TYPE = eINSTANCE.getStorageType();

		/**
		 * The meta object literal for the '{@link computer.CDDriveType <em>CD Drive Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.CDDriveType
		 * @see computer.impl.ComputerPackageImpl#getCDDriveType()
		 * @generated
		 */
		EEnum CD_DRIVE_TYPE = eINSTANCE.getCDDriveType();

		/**
		 * The meta object literal for the '{@link computer.Efficiency <em>Efficiency</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see computer.Efficiency
		 * @see computer.impl.ComputerPackageImpl#getEfficiency()
		 * @generated
		 */
		EEnum EFFICIENCY = eINSTANCE.getEfficiency();

	}

} //ComputerPackage
