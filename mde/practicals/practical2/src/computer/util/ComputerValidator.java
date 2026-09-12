/**
 */
package computer.util;

import computer.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see computer.ComputerPackage
 * @generated
 */
public class ComputerValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ComputerValidator INSTANCE = new ComputerValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "computer";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Power Supply Capacity Sufficient' of 'Computer'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COMPUTER__POWER_SUPPLY_CAPACITY_SUFFICIENT = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Peripheral Ports Available' of 'Computer'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COMPUTER__PERIPHERAL_PORTS_AVAILABLE = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Motherboard Processor Compatible' of 'Computer'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COMPUTER__MOTHERBOARD_PROCESSOR_COMPATIBLE = 3;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 3;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputerValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return ComputerPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case ComputerPackage.COMPONENT:
				return validateComponent((Component)value, diagnostics, context);
			case ComputerPackage.MOTHERBOARD:
				return validateMotherboard((Motherboard)value, diagnostics, context);
			case ComputerPackage.PROCESSOR:
				return validateProcessor((Processor)value, diagnostics, context);
			case ComputerPackage.GRAPHICS_CARD:
				return validateGraphicsCard((GraphicsCard)value, diagnostics, context);
			case ComputerPackage.MEMORY:
				return validateMemory((Memory)value, diagnostics, context);
			case ComputerPackage.HARD_DISK:
				return validateHardDisk((HardDisk)value, diagnostics, context);
			case ComputerPackage.CD_DRIVE:
				return validateCDDrive((CDDrive)value, diagnostics, context);
			case ComputerPackage.PERIPHERAL:
				return validatePeripheral((Peripheral)value, diagnostics, context);
			case ComputerPackage.MONITOR:
				return validateMonitor((Monitor)value, diagnostics, context);
			case ComputerPackage.KEYBOARD:
				return validateKeyboard((Keyboard)value, diagnostics, context);
			case ComputerPackage.MOUSE:
				return validateMouse((Mouse)value, diagnostics, context);
			case ComputerPackage.PRINTER:
				return validatePrinter((Printer)value, diagnostics, context);
			case ComputerPackage.POWER_SUPPLY:
				return validatePowerSupply((PowerSupply)value, diagnostics, context);
			case ComputerPackage.COMPUTER:
				return validateComputer((Computer)value, diagnostics, context);
			case ComputerPackage.CPU_SOCKET:
				return validateCPUSocket((CPUSocket)value, diagnostics, context);
			case ComputerPackage.PORT_TYPE:
				return validatePortType((PortType)value, diagnostics, context);
			case ComputerPackage.MOTHERBOARD_TYPE:
				return validateMotherboardType((MotherboardType)value, diagnostics, context);
			case ComputerPackage.MEMORY_TYPE:
				return validateMemoryType((MemoryType)value, diagnostics, context);
			case ComputerPackage.STORAGE_TYPE:
				return validateStorageType((StorageType)value, diagnostics, context);
			case ComputerPackage.CD_DRIVE_TYPE:
				return validateCDDriveType((CDDriveType)value, diagnostics, context);
			case ComputerPackage.EFFICIENCY:
				return validateEfficiency((Efficiency)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponent(Component component, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(component, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMotherboard(Motherboard motherboard, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(motherboard, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessor(Processor processor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processor, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGraphicsCard(GraphicsCard graphicsCard, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(graphicsCard, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemory(Memory memory, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(memory, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHardDisk(HardDisk hardDisk, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(hardDisk, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCDDrive(CDDrive cdDrive, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(cdDrive, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePeripheral(Peripheral peripheral, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(peripheral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMonitor(Monitor monitor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(monitor, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKeyboard(Keyboard keyboard, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(keyboard, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMouse(Mouse mouse, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mouse, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrinter(Printer printer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(printer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePowerSupply(PowerSupply powerSupply, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(powerSupply, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComputer(Computer computer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(computer, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(computer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(computer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(computer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(computer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(computer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(computer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(computer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(computer, diagnostics, context);
		if (result || diagnostics != null) result &= validateComputer_MotherboardProcessorCompatible(computer, diagnostics, context);
		if (result || diagnostics != null) result &= validateComputer_PowerSupplyCapacitySufficient(computer, diagnostics, context);
		if (result || diagnostics != null) result &= validateComputer_PeripheralPortsAvailable(computer, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MotherboardProcessorCompatible constraint of '<em>Computer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComputer_MotherboardProcessorCompatible(Computer computer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return computer.MotherboardProcessorCompatible(diagnostics, context);
	}

	/**
	 * Validates the PowerSupplyCapacitySufficient constraint of '<em>Computer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComputer_PowerSupplyCapacitySufficient(Computer computer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return computer.PowerSupplyCapacitySufficient(diagnostics, context);
	}

	/**
	 * Validates the PeripheralPortsAvailable constraint of '<em>Computer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComputer_PeripheralPortsAvailable(Computer computer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return computer.PeripheralPortsAvailable(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCPUSocket(CPUSocket cpuSocket, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortType(PortType portType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMotherboardType(MotherboardType motherboardType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemoryType(MemoryType memoryType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStorageType(StorageType storageType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCDDriveType(CDDriveType cdDriveType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEfficiency(Efficiency efficiency, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //ComputerValidator
