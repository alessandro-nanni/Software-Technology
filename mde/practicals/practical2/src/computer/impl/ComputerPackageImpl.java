/**
 */
package computer.impl;

import computer.CDDrive;
import computer.CDDriveType;
import computer.CPUSocket;
import computer.Component;
import computer.Computer;
import computer.ComputerFactory;
import computer.ComputerPackage;
import computer.Efficiency;
import computer.GraphicsCard;
import computer.HardDisk;
import computer.Keyboard;
import computer.Memory;
import computer.MemoryType;
import computer.Monitor;
import computer.Motherboard;
import computer.MotherboardType;
import computer.Mouse;
import computer.Peripheral;
import computer.PortType;
import computer.PowerSupply;
import computer.Printer;
import computer.Processor;
import computer.StorageType;

import computer.util.ComputerValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComputerPackageImpl extends EPackageImpl implements ComputerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass motherboardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphicsCardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hardDiskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cdDriveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass peripheralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass monitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyboardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mouseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass printerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerSupplyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cpuSocketEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum portTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum motherboardTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum memoryTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum storageTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cdDriveTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum efficiencyEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see computer.ComputerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ComputerPackageImpl() {
		super(eNS_URI, ComputerFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ComputerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ComputerPackage init() {
		if (isInited) return (ComputerPackage)EPackage.Registry.INSTANCE.getEPackage(ComputerPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredComputerPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ComputerPackageImpl theComputerPackage = registeredComputerPackage instanceof ComputerPackageImpl ? (ComputerPackageImpl)registeredComputerPackage : new ComputerPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theComputerPackage.createPackageContents();

		// Initialize created meta-data
		theComputerPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theComputerPackage,
			 new EValidator.Descriptor() {
				 @Override
				 public EValidator getEValidator() {
					 return ComputerValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theComputerPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ComputerPackage.eNS_URI, theComputerPackage);
		return theComputerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComponent() {
		return componentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getComponent_PowerConsumption() {
		return (EAttribute)componentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMotherboard() {
		return motherboardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMotherboard_Type() {
		return (EAttribute)motherboardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMotherboard_Chipset() {
		return (EAttribute)motherboardEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMotherboard_Socket() {
		return (EAttribute)motherboardEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMotherboard_Ports() {
		return (EAttribute)motherboardEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProcessor() {
		return processorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProcessor_Model() {
		return (EAttribute)processorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProcessor_Socket() {
		return (EAttribute)processorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProcessor_Cores() {
		return (EAttribute)processorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGraphicsCard() {
		return graphicsCardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGraphicsCard_Model() {
		return (EAttribute)graphicsCardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGraphicsCard_VramGB() {
		return (EAttribute)graphicsCardEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMemory() {
		return memoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMemory_Type() {
		return (EAttribute)memoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMemory_CapacityGB() {
		return (EAttribute)memoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHardDisk() {
		return hardDiskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getHardDisk_Type() {
		return (EAttribute)hardDiskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getHardDisk_CapacityGB() {
		return (EAttribute)hardDiskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCDDrive() {
		return cdDriveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCDDrive_Type() {
		return (EAttribute)cdDriveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPeripheral() {
		return peripheralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPeripheral_RequiredPort() {
		return (EAttribute)peripheralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMonitor() {
		return monitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getKeyboard() {
		return keyboardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMouse() {
		return mouseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrinter() {
		return printerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPowerSupply() {
		return powerSupplyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPowerSupply_CapacityWatts() {
		return (EAttribute)powerSupplyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPowerSupply_Efficiency() {
		return (EAttribute)powerSupplyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComputer() {
		return computerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputer_Motherboard() {
		return (EReference)computerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputer_Processor() {
		return (EReference)computerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputer_GraphicsCard() {
		return (EReference)computerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputer_Memory() {
		return (EReference)computerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputer_HardDisks() {
		return (EReference)computerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputer_CdDrive() {
		return (EReference)computerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputer_Peripherals() {
		return (EReference)computerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputer_PowerSupply() {
		return (EReference)computerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getComputer__PowerSupplyCapacitySufficient__DiagnosticChain_Map() {
		return computerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getComputer__PeripheralPortsAvailable__DiagnosticChain_Map() {
		return computerEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getComputer__MotherboardProcessorCompatible__DiagnosticChain_Map() {
		return computerEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getCPUSocket() {
		return cpuSocketEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getPortType() {
		return portTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getMotherboardType() {
		return motherboardTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getMemoryType() {
		return memoryTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getStorageType() {
		return storageTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getCDDriveType() {
		return cdDriveTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEfficiency() {
		return efficiencyEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComputerFactory getComputerFactory() {
		return (ComputerFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		componentEClass = createEClass(COMPONENT);
		createEAttribute(componentEClass, COMPONENT__POWER_CONSUMPTION);

		motherboardEClass = createEClass(MOTHERBOARD);
		createEAttribute(motherboardEClass, MOTHERBOARD__TYPE);
		createEAttribute(motherboardEClass, MOTHERBOARD__CHIPSET);
		createEAttribute(motherboardEClass, MOTHERBOARD__SOCKET);
		createEAttribute(motherboardEClass, MOTHERBOARD__PORTS);

		processorEClass = createEClass(PROCESSOR);
		createEAttribute(processorEClass, PROCESSOR__MODEL);
		createEAttribute(processorEClass, PROCESSOR__SOCKET);
		createEAttribute(processorEClass, PROCESSOR__CORES);

		graphicsCardEClass = createEClass(GRAPHICS_CARD);
		createEAttribute(graphicsCardEClass, GRAPHICS_CARD__MODEL);
		createEAttribute(graphicsCardEClass, GRAPHICS_CARD__VRAM_GB);

		memoryEClass = createEClass(MEMORY);
		createEAttribute(memoryEClass, MEMORY__TYPE);
		createEAttribute(memoryEClass, MEMORY__CAPACITY_GB);

		hardDiskEClass = createEClass(HARD_DISK);
		createEAttribute(hardDiskEClass, HARD_DISK__TYPE);
		createEAttribute(hardDiskEClass, HARD_DISK__CAPACITY_GB);

		cdDriveEClass = createEClass(CD_DRIVE);
		createEAttribute(cdDriveEClass, CD_DRIVE__TYPE);

		peripheralEClass = createEClass(PERIPHERAL);
		createEAttribute(peripheralEClass, PERIPHERAL__REQUIRED_PORT);

		monitorEClass = createEClass(MONITOR);

		keyboardEClass = createEClass(KEYBOARD);

		mouseEClass = createEClass(MOUSE);

		printerEClass = createEClass(PRINTER);

		powerSupplyEClass = createEClass(POWER_SUPPLY);
		createEAttribute(powerSupplyEClass, POWER_SUPPLY__CAPACITY_WATTS);
		createEAttribute(powerSupplyEClass, POWER_SUPPLY__EFFICIENCY);

		computerEClass = createEClass(COMPUTER);
		createEReference(computerEClass, COMPUTER__MOTHERBOARD);
		createEReference(computerEClass, COMPUTER__PROCESSOR);
		createEReference(computerEClass, COMPUTER__GRAPHICS_CARD);
		createEReference(computerEClass, COMPUTER__MEMORY);
		createEReference(computerEClass, COMPUTER__HARD_DISKS);
		createEReference(computerEClass, COMPUTER__CD_DRIVE);
		createEReference(computerEClass, COMPUTER__PERIPHERALS);
		createEReference(computerEClass, COMPUTER__POWER_SUPPLY);
		createEOperation(computerEClass, COMPUTER___POWER_SUPPLY_CAPACITY_SUFFICIENT__DIAGNOSTICCHAIN_MAP);
		createEOperation(computerEClass, COMPUTER___PERIPHERAL_PORTS_AVAILABLE__DIAGNOSTICCHAIN_MAP);
		createEOperation(computerEClass, COMPUTER___MOTHERBOARD_PROCESSOR_COMPATIBLE__DIAGNOSTICCHAIN_MAP);

		// Create enums
		cpuSocketEEnum = createEEnum(CPU_SOCKET);
		portTypeEEnum = createEEnum(PORT_TYPE);
		motherboardTypeEEnum = createEEnum(MOTHERBOARD_TYPE);
		memoryTypeEEnum = createEEnum(MEMORY_TYPE);
		storageTypeEEnum = createEEnum(STORAGE_TYPE);
		cdDriveTypeEEnum = createEEnum(CD_DRIVE_TYPE);
		efficiencyEEnum = createEEnum(EFFICIENCY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		motherboardEClass.getESuperTypes().add(this.getComponent());
		processorEClass.getESuperTypes().add(this.getComponent());
		graphicsCardEClass.getESuperTypes().add(this.getComponent());
		memoryEClass.getESuperTypes().add(this.getComponent());
		hardDiskEClass.getESuperTypes().add(this.getComponent());
		cdDriveEClass.getESuperTypes().add(this.getComponent());
		peripheralEClass.getESuperTypes().add(this.getComponent());
		monitorEClass.getESuperTypes().add(this.getPeripheral());
		keyboardEClass.getESuperTypes().add(this.getPeripheral());
		mouseEClass.getESuperTypes().add(this.getPeripheral());
		printerEClass.getESuperTypes().add(this.getPeripheral());

		// Initialize classes, features, and operations; add parameters
		initEClass(componentEClass, Component.class, "Component", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComponent_PowerConsumption(), ecorePackage.getEInt(), "powerConsumption", null, 1, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(motherboardEClass, Motherboard.class, "Motherboard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMotherboard_Type(), this.getMotherboardType(), "type", null, 1, 1, Motherboard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMotherboard_Chipset(), ecorePackage.getEString(), "chipset", null, 1, 1, Motherboard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMotherboard_Socket(), this.getCPUSocket(), "socket", null, 1, 1, Motherboard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMotherboard_Ports(), this.getPortType(), "ports", null, 0, -1, Motherboard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(processorEClass, Processor.class, "Processor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProcessor_Model(), ecorePackage.getEString(), "model", null, 0, 1, Processor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessor_Socket(), this.getCPUSocket(), "socket", null, 1, 1, Processor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessor_Cores(), ecorePackage.getEInt(), "cores", null, 1, 1, Processor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphicsCardEClass, GraphicsCard.class, "GraphicsCard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGraphicsCard_Model(), ecorePackage.getEString(), "model", null, 0, 1, GraphicsCard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicsCard_VramGB(), ecorePackage.getEInt(), "vramGB", null, 1, 1, GraphicsCard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(memoryEClass, Memory.class, "Memory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMemory_Type(), this.getMemoryType(), "type", null, 1, 1, Memory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemory_CapacityGB(), ecorePackage.getEInt(), "capacityGB", null, 1, 1, Memory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hardDiskEClass, HardDisk.class, "HardDisk", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHardDisk_Type(), this.getStorageType(), "type", null, 1, 1, HardDisk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHardDisk_CapacityGB(), ecorePackage.getEInt(), "capacityGB", null, 1, 1, HardDisk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cdDriveEClass, CDDrive.class, "CDDrive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCDDrive_Type(), this.getCDDriveType(), "type", null, 1, 1, CDDrive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(peripheralEClass, Peripheral.class, "Peripheral", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPeripheral_RequiredPort(), this.getPortType(), "requiredPort", null, 1, 1, Peripheral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(monitorEClass, Monitor.class, "Monitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(keyboardEClass, Keyboard.class, "Keyboard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mouseEClass, Mouse.class, "Mouse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(printerEClass, Printer.class, "Printer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(powerSupplyEClass, PowerSupply.class, "PowerSupply", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPowerSupply_CapacityWatts(), ecorePackage.getEInt(), "capacityWatts", null, 1, 1, PowerSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPowerSupply_Efficiency(), this.getEfficiency(), "efficiency", null, 1, 1, PowerSupply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(computerEClass, Computer.class, "Computer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputer_Motherboard(), this.getMotherboard(), null, "motherboard", null, 1, 1, Computer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputer_Processor(), this.getProcessor(), null, "processor", null, 1, 1, Computer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputer_GraphicsCard(), this.getGraphicsCard(), null, "graphicsCard", null, 0, 1, Computer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputer_Memory(), this.getMemory(), null, "memory", null, 1, -1, Computer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputer_HardDisks(), this.getHardDisk(), null, "hardDisks", null, 1, -1, Computer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputer_CdDrive(), this.getCDDrive(), null, "cdDrive", null, 0, 1, Computer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputer_Peripherals(), this.getPeripheral(), null, "peripherals", null, 0, -1, Computer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputer_PowerSupply(), this.getPowerSupply(), null, "powerSupply", null, 1, 1, Computer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getComputer__PowerSupplyCapacitySufficient__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "PowerSupplyCapacitySufficient", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getComputer__PeripheralPortsAvailable__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "PeripheralPortsAvailable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getComputer__MotherboardProcessorCompatible__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "MotherboardProcessorCompatible", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(cpuSocketEEnum, CPUSocket.class, "CPUSocket");
		addEEnumLiteral(cpuSocketEEnum, CPUSocket.AM4);
		addEEnumLiteral(cpuSocketEEnum, CPUSocket.AM5);
		addEEnumLiteral(cpuSocketEEnum, CPUSocket.LGA1200);
		addEEnumLiteral(cpuSocketEEnum, CPUSocket.LGA1700);

		initEEnum(portTypeEEnum, PortType.class, "PortType");
		addEEnumLiteral(portTypeEEnum, PortType.USB);
		addEEnumLiteral(portTypeEEnum, PortType.PS2);
		addEEnumLiteral(portTypeEEnum, PortType.HDMI);
		addEEnumLiteral(portTypeEEnum, PortType.DISPLAY_PORT);
		addEEnumLiteral(portTypeEEnum, PortType.VGA);
		addEEnumLiteral(portTypeEEnum, PortType.ETHERNET);
		addEEnumLiteral(portTypeEEnum, PortType.AUDIO);

		initEEnum(motherboardTypeEEnum, MotherboardType.class, "MotherboardType");
		addEEnumLiteral(motherboardTypeEEnum, MotherboardType.ATX);
		addEEnumLiteral(motherboardTypeEEnum, MotherboardType.MICRO_ATX);
		addEEnumLiteral(motherboardTypeEEnum, MotherboardType.MINI_ITX);

		initEEnum(memoryTypeEEnum, MemoryType.class, "MemoryType");
		addEEnumLiteral(memoryTypeEEnum, MemoryType.DDR4);
		addEEnumLiteral(memoryTypeEEnum, MemoryType.DDR5);

		initEEnum(storageTypeEEnum, StorageType.class, "StorageType");
		addEEnumLiteral(storageTypeEEnum, StorageType.HDD);
		addEEnumLiteral(storageTypeEEnum, StorageType.SSD);

		initEEnum(cdDriveTypeEEnum, CDDriveType.class, "CDDriveType");
		addEEnumLiteral(cdDriveTypeEEnum, CDDriveType.CD_ROM);
		addEEnumLiteral(cdDriveTypeEEnum, CDDriveType.CD_R);
		addEEnumLiteral(cdDriveTypeEEnum, CDDriveType.CD_RW);
		addEEnumLiteral(cdDriveTypeEEnum, CDDriveType.DVD_ROM);
		addEEnumLiteral(cdDriveTypeEEnum, CDDriveType.BLU_RAY);

		initEEnum(efficiencyEEnum, Efficiency.class, "Efficiency");
		addEEnumLiteral(efficiencyEEnum, Efficiency.BRONZE);
		addEEnumLiteral(efficiencyEEnum, Efficiency.SILVER);
		addEEnumLiteral(efficiencyEEnum, Efficiency.GOLD);
		addEEnumLiteral(efficiencyEEnum, Efficiency.PLATINUM);
		addEEnumLiteral(efficiencyEEnum, Efficiency.TITANIUM);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation
		  (this,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (computerEClass,
		   source,
		   new String[] {
			   "constraints", "MotherboardProcessorCompatible"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
		addAnnotation
		  (getComputer__PowerSupplyCapacitySufficient__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "Tuple { message : String = \'Power supply capacity is lower than the total power draw of the installed components\', status : Boolean = powerSupply.capacityWatts >= motherboard.powerConsumption + processor.powerConsumption + (if graphicsCard.oclIsUndefined() then 0 else graphicsCard.powerConsumption endif) + memory->collect(powerConsumption)->sum() + hardDisks->collect(powerConsumption)->sum() + (if cdDrive.oclIsUndefined() then 0 else cdDrive.powerConsumption endif) + peripherals->collect(powerConsumption)->sum() }.status"
		   });
		addAnnotation
		  (getComputer__PeripheralPortsAvailable__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "Tuple { message : String = \'Motherboard does not expose a port for every connected peripheral\', status : Boolean = peripherals->forAll(p | motherboard.ports->includes(p.requiredPort)) }.status"
		   });
		addAnnotation
		  (getComputer__MotherboardProcessorCompatible__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "Tuple { message : String = \'Processor socket \' + processor.socket.toString() + \' does not match motherboard socket \' + motherboard.socket.toString(), status : Boolean = motherboard.socket = processor.socket }.status"
		   });
	}

} //ComputerPackageImpl
