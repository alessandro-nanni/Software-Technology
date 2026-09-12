/**
 */
package computer.impl;

import computer.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComputerFactoryImpl extends EFactoryImpl implements ComputerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ComputerFactory init() {
		try {
			ComputerFactory theComputerFactory = (ComputerFactory)EPackage.Registry.INSTANCE.getEFactory(ComputerPackage.eNS_URI);
			if (theComputerFactory != null) {
				return theComputerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ComputerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ComputerPackage.MOTHERBOARD: return createMotherboard();
			case ComputerPackage.PROCESSOR: return createProcessor();
			case ComputerPackage.GRAPHICS_CARD: return createGraphicsCard();
			case ComputerPackage.MEMORY: return createMemory();
			case ComputerPackage.HARD_DISK: return createHardDisk();
			case ComputerPackage.CD_DRIVE: return createCDDrive();
			case ComputerPackage.MONITOR: return createMonitor();
			case ComputerPackage.KEYBOARD: return createKeyboard();
			case ComputerPackage.MOUSE: return createMouse();
			case ComputerPackage.PRINTER: return createPrinter();
			case ComputerPackage.POWER_SUPPLY: return createPowerSupply();
			case ComputerPackage.COMPUTER: return createComputer();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ComputerPackage.CPU_SOCKET:
				return createCPUSocketFromString(eDataType, initialValue);
			case ComputerPackage.PORT_TYPE:
				return createPortTypeFromString(eDataType, initialValue);
			case ComputerPackage.MOTHERBOARD_TYPE:
				return createMotherboardTypeFromString(eDataType, initialValue);
			case ComputerPackage.MEMORY_TYPE:
				return createMemoryTypeFromString(eDataType, initialValue);
			case ComputerPackage.STORAGE_TYPE:
				return createStorageTypeFromString(eDataType, initialValue);
			case ComputerPackage.CD_DRIVE_TYPE:
				return createCDDriveTypeFromString(eDataType, initialValue);
			case ComputerPackage.EFFICIENCY:
				return createEfficiencyFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ComputerPackage.CPU_SOCKET:
				return convertCPUSocketToString(eDataType, instanceValue);
			case ComputerPackage.PORT_TYPE:
				return convertPortTypeToString(eDataType, instanceValue);
			case ComputerPackage.MOTHERBOARD_TYPE:
				return convertMotherboardTypeToString(eDataType, instanceValue);
			case ComputerPackage.MEMORY_TYPE:
				return convertMemoryTypeToString(eDataType, instanceValue);
			case ComputerPackage.STORAGE_TYPE:
				return convertStorageTypeToString(eDataType, instanceValue);
			case ComputerPackage.CD_DRIVE_TYPE:
				return convertCDDriveTypeToString(eDataType, instanceValue);
			case ComputerPackage.EFFICIENCY:
				return convertEfficiencyToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Motherboard createMotherboard() {
		MotherboardImpl motherboard = new MotherboardImpl();
		return motherboard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Processor createProcessor() {
		ProcessorImpl processor = new ProcessorImpl();
		return processor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicsCard createGraphicsCard() {
		GraphicsCardImpl graphicsCard = new GraphicsCardImpl();
		return graphicsCard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Memory createMemory() {
		MemoryImpl memory = new MemoryImpl();
		return memory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HardDisk createHardDisk() {
		HardDiskImpl hardDisk = new HardDiskImpl();
		return hardDisk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CDDrive createCDDrive() {
		CDDriveImpl cdDrive = new CDDriveImpl();
		return cdDrive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Monitor createMonitor() {
		MonitorImpl monitor = new MonitorImpl();
		return monitor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Keyboard createKeyboard() {
		KeyboardImpl keyboard = new KeyboardImpl();
		return keyboard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mouse createMouse() {
		MouseImpl mouse = new MouseImpl();
		return mouse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Printer createPrinter() {
		PrinterImpl printer = new PrinterImpl();
		return printer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PowerSupply createPowerSupply() {
		PowerSupplyImpl powerSupply = new PowerSupplyImpl();
		return powerSupply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Computer createComputer() {
		ComputerImpl computer = new ComputerImpl();
		return computer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CPUSocket createCPUSocketFromString(EDataType eDataType, String initialValue) {
		CPUSocket result = CPUSocket.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCPUSocketToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortType createPortTypeFromString(EDataType eDataType, String initialValue) {
		PortType result = PortType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPortTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MotherboardType createMotherboardTypeFromString(EDataType eDataType, String initialValue) {
		MotherboardType result = MotherboardType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMotherboardTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryType createMemoryTypeFromString(EDataType eDataType, String initialValue) {
		MemoryType result = MemoryType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMemoryTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorageType createStorageTypeFromString(EDataType eDataType, String initialValue) {
		StorageType result = StorageType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStorageTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CDDriveType createCDDriveTypeFromString(EDataType eDataType, String initialValue) {
		CDDriveType result = CDDriveType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCDDriveTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Efficiency createEfficiencyFromString(EDataType eDataType, String initialValue) {
		Efficiency result = Efficiency.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEfficiencyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComputerPackage getComputerPackage() {
		return (ComputerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ComputerPackage getPackage() {
		return ComputerPackage.eINSTANCE;
	}

} //ComputerFactoryImpl
