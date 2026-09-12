/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /practical2/model/practical.ecore
 * using:
 *   /practical2/model/computer.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package computer;

// import computer.ComputerPackage;
// import computer.ComputerTables;
import java.lang.String;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorEnumeration;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorEnumerationLiteral;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreLibraryOppositeProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPropertyWithImplementation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorType;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.AbstractTables;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;

/**
 * ComputerTables provides the dispatch tables for the computer for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class ComputerTables extends AbstractTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(ComputerPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
	public static final /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore = IdManager.getNsURIPackageId("http://www.example.org/examples/example.ecore", null, ComputerPackage.eINSTANCE);
	public static final /*@NonInvalid*/ ClassId CLSSid_CDDrive = ComputerTables.PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore.getClassId("CDDrive", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_Computer = ComputerTables.PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore.getClassId("Computer", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_GraphicsCard = ComputerTables.PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore.getClassId("GraphicsCard", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_HardDisk = ComputerTables.PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore.getClassId("HardDisk", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_Memory = ComputerTables.PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore.getClassId("Memory", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_Motherboard = ComputerTables.PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore.getClassId("Motherboard", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_Peripheral = ComputerTables.PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore.getClassId("Peripheral", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_PowerSupply = ComputerTables.PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore.getClassId("PowerSupply", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_Processor = ComputerTables.PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore.getClassId("Processor", 0);
	public static final /*@NonInvalid*/ DataTypeId DATAid_EInt = ComputerTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EInt", 0);
	public static final /*@NonInvalid*/ EnumerationId ENUMid_CDDriveType = ComputerTables.PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore.getEnumerationId("CDDriveType");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_CPUSocket = ComputerTables.PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore.getEnumerationId("CPUSocket");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_Efficiency = ComputerTables.PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore.getEnumerationId("Efficiency");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_MemoryType = ComputerTables.PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore.getEnumerationId("MemoryType");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_MotherboardType = ComputerTables.PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore.getEnumerationId("MotherboardType");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_PortType = ComputerTables.PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore.getEnumerationId("PortType");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_StorageType = ComputerTables.PACKid_http_c_s_s_www_example_org_s_examples_s_example_ecore.getEnumerationId("StorageType");
	public static final /*@NonInvalid*/ IntegerValue INT_0 = ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ TuplePartId PARTid_ = IdManager.getTuplePartId(0, "message", TypeId.STRING);
	public static final /*@NonInvalid*/ TuplePartId PARTid__0 = IdManager.getTuplePartId(1, "status", TypeId.BOOLEAN);
	public static final /*@NonInvalid*/ String STR_Motherboard_32_does_32_not_32_expose_32_a_32_port_32_for_32_every_32_connected_32_periphera = "Motherboard does not expose a port for every connected peripheral";
	public static final /*@NonInvalid*/ String STR_Power_32_supply_32_capacity_32_is_32_lower_32_than_32_the_32_total_32_power_32_draw_32_of_32_the_32 = "Power supply capacity is lower than the total power draw of the installed components";
	public static final /*@NonInvalid*/ String STR_Processor_32_socket_32 = "Processor socket ";
	public static final /*@NonInvalid*/ String STR__32_does_32_not_32_match_32_motherboard_32_socket_32 = " does not match motherboard socket ";
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_HardDisk = TypeId.ORDERED_SET.getSpecializedId(ComputerTables.CLSSid_HardDisk, true, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Memory = TypeId.ORDERED_SET.getSpecializedId(ComputerTables.CLSSid_Memory, true, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Peripheral = TypeId.ORDERED_SET.getSpecializedId(ComputerTables.CLSSid_Peripheral, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId SEQ_DATAid_EInt = TypeId.SEQUENCE.getSpecializedId(ComputerTables.DATAid_EInt, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId SET_ENUMid_PortType = TypeId.SET.getSpecializedId(ComputerTables.ENUMid_PortType, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ TupleTypeId TUPLid_ = IdManager.getTupleTypeId("Tuple", ComputerTables.PARTid_, ComputerTables.PARTid__0);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			ComputerTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ComputerTables::TypeParameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The type descriptors for each type.
	 */
	public static class Types {
		static {
			Init.initStart();
			TypeParameters.init();
		}

		public static final EcoreExecutorType _CDDrive = new EcoreExecutorType(ComputerPackage.Literals.CD_DRIVE, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _CDDriveType = new EcoreExecutorEnumeration(ComputerPackage.Literals.CD_DRIVE_TYPE, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _CPUSocket = new EcoreExecutorEnumeration(ComputerPackage.Literals.CPU_SOCKET, PACKAGE, 0);
		public static final EcoreExecutorType _Component = new EcoreExecutorType(ComputerPackage.Literals.COMPONENT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final EcoreExecutorType _Computer = new EcoreExecutorType(ComputerPackage.Literals.COMPUTER, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _Efficiency = new EcoreExecutorEnumeration(ComputerPackage.Literals.EFFICIENCY, PACKAGE, 0);
		public static final EcoreExecutorType _GraphicsCard = new EcoreExecutorType(ComputerPackage.Literals.GRAPHICS_CARD, PACKAGE, 0);
		public static final EcoreExecutorType _HardDisk = new EcoreExecutorType(ComputerPackage.Literals.HARD_DISK, PACKAGE, 0);
		public static final EcoreExecutorType _Keyboard = new EcoreExecutorType(ComputerPackage.Literals.KEYBOARD, PACKAGE, 0);
		public static final EcoreExecutorType _Memory = new EcoreExecutorType(ComputerPackage.Literals.MEMORY, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _MemoryType = new EcoreExecutorEnumeration(ComputerPackage.Literals.MEMORY_TYPE, PACKAGE, 0);
		public static final EcoreExecutorType _Monitor = new EcoreExecutorType(ComputerPackage.Literals.MONITOR, PACKAGE, 0);
		public static final EcoreExecutorType _Motherboard = new EcoreExecutorType(ComputerPackage.Literals.MOTHERBOARD, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _MotherboardType = new EcoreExecutorEnumeration(ComputerPackage.Literals.MOTHERBOARD_TYPE, PACKAGE, 0);
		public static final EcoreExecutorType _Mouse = new EcoreExecutorType(ComputerPackage.Literals.MOUSE, PACKAGE, 0);
		public static final EcoreExecutorType _Peripheral = new EcoreExecutorType(ComputerPackage.Literals.PERIPHERAL, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final EcoreExecutorEnumeration _PortType = new EcoreExecutorEnumeration(ComputerPackage.Literals.PORT_TYPE, PACKAGE, 0);
		public static final EcoreExecutorType _PowerSupply = new EcoreExecutorType(ComputerPackage.Literals.POWER_SUPPLY, PACKAGE, 0);
		public static final EcoreExecutorType _Printer = new EcoreExecutorType(ComputerPackage.Literals.PRINTER, PACKAGE, 0);
		public static final EcoreExecutorType _Processor = new EcoreExecutorType(ComputerPackage.Literals.PROCESSOR, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _StorageType = new EcoreExecutorEnumeration(ComputerPackage.Literals.STORAGE_TYPE, PACKAGE, 0);

		private static final EcoreExecutorType /*@NonNull*/ [] types = {
			_CDDrive,
			_CDDriveType,
			_CPUSocket,
			_Component,
			_Computer,
			_Efficiency,
			_GraphicsCard,
			_HardDisk,
			_Keyboard,
			_Memory,
			_MemoryType,
			_Monitor,
			_Motherboard,
			_MotherboardType,
			_Mouse,
			_Peripheral,
			_PortType,
			_PowerSupply,
			_Printer,
			_Processor,
			_StorageType
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ComputerTables::Types and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragment descriptors for the local elements of each type and its supertypes.
	 */
	public static class Fragments {
		static {
			Init.initStart();
			Types.init();
		}

		private static final ExecutorFragment _CDDrive__CDDrive = new ExecutorFragment(Types._CDDrive, ComputerTables.Types._CDDrive);
		private static final ExecutorFragment _CDDrive__Component = new ExecutorFragment(Types._CDDrive, ComputerTables.Types._Component);
		private static final ExecutorFragment _CDDrive__OclAny = new ExecutorFragment(Types._CDDrive, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CDDrive__OclElement = new ExecutorFragment(Types._CDDrive, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _CDDriveType__CDDriveType = new ExecutorFragment(Types._CDDriveType, ComputerTables.Types._CDDriveType);
		private static final ExecutorFragment _CDDriveType__OclAny = new ExecutorFragment(Types._CDDriveType, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CDDriveType__OclElement = new ExecutorFragment(Types._CDDriveType, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CDDriveType__OclEnumeration = new ExecutorFragment(Types._CDDriveType, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _CDDriveType__OclType = new ExecutorFragment(Types._CDDriveType, OCLstdlibTables.Types._OclType);

		private static final ExecutorFragment _CPUSocket__CPUSocket = new ExecutorFragment(Types._CPUSocket, ComputerTables.Types._CPUSocket);
		private static final ExecutorFragment _CPUSocket__OclAny = new ExecutorFragment(Types._CPUSocket, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CPUSocket__OclElement = new ExecutorFragment(Types._CPUSocket, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CPUSocket__OclEnumeration = new ExecutorFragment(Types._CPUSocket, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _CPUSocket__OclType = new ExecutorFragment(Types._CPUSocket, OCLstdlibTables.Types._OclType);

		private static final ExecutorFragment _Component__Component = new ExecutorFragment(Types._Component, ComputerTables.Types._Component);
		private static final ExecutorFragment _Component__OclAny = new ExecutorFragment(Types._Component, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Component__OclElement = new ExecutorFragment(Types._Component, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _Computer__Computer = new ExecutorFragment(Types._Computer, ComputerTables.Types._Computer);
		private static final ExecutorFragment _Computer__OclAny = new ExecutorFragment(Types._Computer, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Computer__OclElement = new ExecutorFragment(Types._Computer, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _Efficiency__Efficiency = new ExecutorFragment(Types._Efficiency, ComputerTables.Types._Efficiency);
		private static final ExecutorFragment _Efficiency__OclAny = new ExecutorFragment(Types._Efficiency, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Efficiency__OclElement = new ExecutorFragment(Types._Efficiency, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Efficiency__OclEnumeration = new ExecutorFragment(Types._Efficiency, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _Efficiency__OclType = new ExecutorFragment(Types._Efficiency, OCLstdlibTables.Types._OclType);

		private static final ExecutorFragment _GraphicsCard__Component = new ExecutorFragment(Types._GraphicsCard, ComputerTables.Types._Component);
		private static final ExecutorFragment _GraphicsCard__GraphicsCard = new ExecutorFragment(Types._GraphicsCard, ComputerTables.Types._GraphicsCard);
		private static final ExecutorFragment _GraphicsCard__OclAny = new ExecutorFragment(Types._GraphicsCard, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _GraphicsCard__OclElement = new ExecutorFragment(Types._GraphicsCard, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _HardDisk__Component = new ExecutorFragment(Types._HardDisk, ComputerTables.Types._Component);
		private static final ExecutorFragment _HardDisk__HardDisk = new ExecutorFragment(Types._HardDisk, ComputerTables.Types._HardDisk);
		private static final ExecutorFragment _HardDisk__OclAny = new ExecutorFragment(Types._HardDisk, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _HardDisk__OclElement = new ExecutorFragment(Types._HardDisk, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _Keyboard__Component = new ExecutorFragment(Types._Keyboard, ComputerTables.Types._Component);
		private static final ExecutorFragment _Keyboard__Keyboard = new ExecutorFragment(Types._Keyboard, ComputerTables.Types._Keyboard);
		private static final ExecutorFragment _Keyboard__OclAny = new ExecutorFragment(Types._Keyboard, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Keyboard__OclElement = new ExecutorFragment(Types._Keyboard, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Keyboard__Peripheral = new ExecutorFragment(Types._Keyboard, ComputerTables.Types._Peripheral);

		private static final ExecutorFragment _Memory__Component = new ExecutorFragment(Types._Memory, ComputerTables.Types._Component);
		private static final ExecutorFragment _Memory__Memory = new ExecutorFragment(Types._Memory, ComputerTables.Types._Memory);
		private static final ExecutorFragment _Memory__OclAny = new ExecutorFragment(Types._Memory, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Memory__OclElement = new ExecutorFragment(Types._Memory, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _MemoryType__MemoryType = new ExecutorFragment(Types._MemoryType, ComputerTables.Types._MemoryType);
		private static final ExecutorFragment _MemoryType__OclAny = new ExecutorFragment(Types._MemoryType, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _MemoryType__OclElement = new ExecutorFragment(Types._MemoryType, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _MemoryType__OclEnumeration = new ExecutorFragment(Types._MemoryType, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _MemoryType__OclType = new ExecutorFragment(Types._MemoryType, OCLstdlibTables.Types._OclType);

		private static final ExecutorFragment _Monitor__Component = new ExecutorFragment(Types._Monitor, ComputerTables.Types._Component);
		private static final ExecutorFragment _Monitor__Monitor = new ExecutorFragment(Types._Monitor, ComputerTables.Types._Monitor);
		private static final ExecutorFragment _Monitor__OclAny = new ExecutorFragment(Types._Monitor, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Monitor__OclElement = new ExecutorFragment(Types._Monitor, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Monitor__Peripheral = new ExecutorFragment(Types._Monitor, ComputerTables.Types._Peripheral);

		private static final ExecutorFragment _Motherboard__Component = new ExecutorFragment(Types._Motherboard, ComputerTables.Types._Component);
		private static final ExecutorFragment _Motherboard__Motherboard = new ExecutorFragment(Types._Motherboard, ComputerTables.Types._Motherboard);
		private static final ExecutorFragment _Motherboard__OclAny = new ExecutorFragment(Types._Motherboard, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Motherboard__OclElement = new ExecutorFragment(Types._Motherboard, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _MotherboardType__MotherboardType = new ExecutorFragment(Types._MotherboardType, ComputerTables.Types._MotherboardType);
		private static final ExecutorFragment _MotherboardType__OclAny = new ExecutorFragment(Types._MotherboardType, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _MotherboardType__OclElement = new ExecutorFragment(Types._MotherboardType, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _MotherboardType__OclEnumeration = new ExecutorFragment(Types._MotherboardType, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _MotherboardType__OclType = new ExecutorFragment(Types._MotherboardType, OCLstdlibTables.Types._OclType);

		private static final ExecutorFragment _Mouse__Component = new ExecutorFragment(Types._Mouse, ComputerTables.Types._Component);
		private static final ExecutorFragment _Mouse__Mouse = new ExecutorFragment(Types._Mouse, ComputerTables.Types._Mouse);
		private static final ExecutorFragment _Mouse__OclAny = new ExecutorFragment(Types._Mouse, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Mouse__OclElement = new ExecutorFragment(Types._Mouse, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Mouse__Peripheral = new ExecutorFragment(Types._Mouse, ComputerTables.Types._Peripheral);

		private static final ExecutorFragment _Peripheral__Component = new ExecutorFragment(Types._Peripheral, ComputerTables.Types._Component);
		private static final ExecutorFragment _Peripheral__OclAny = new ExecutorFragment(Types._Peripheral, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Peripheral__OclElement = new ExecutorFragment(Types._Peripheral, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Peripheral__Peripheral = new ExecutorFragment(Types._Peripheral, ComputerTables.Types._Peripheral);

		private static final ExecutorFragment _PortType__OclAny = new ExecutorFragment(Types._PortType, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PortType__OclElement = new ExecutorFragment(Types._PortType, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PortType__OclEnumeration = new ExecutorFragment(Types._PortType, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _PortType__OclType = new ExecutorFragment(Types._PortType, OCLstdlibTables.Types._OclType);
		private static final ExecutorFragment _PortType__PortType = new ExecutorFragment(Types._PortType, ComputerTables.Types._PortType);

		private static final ExecutorFragment _PowerSupply__OclAny = new ExecutorFragment(Types._PowerSupply, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PowerSupply__OclElement = new ExecutorFragment(Types._PowerSupply, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PowerSupply__PowerSupply = new ExecutorFragment(Types._PowerSupply, ComputerTables.Types._PowerSupply);

		private static final ExecutorFragment _Printer__Component = new ExecutorFragment(Types._Printer, ComputerTables.Types._Component);
		private static final ExecutorFragment _Printer__OclAny = new ExecutorFragment(Types._Printer, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Printer__OclElement = new ExecutorFragment(Types._Printer, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Printer__Peripheral = new ExecutorFragment(Types._Printer, ComputerTables.Types._Peripheral);
		private static final ExecutorFragment _Printer__Printer = new ExecutorFragment(Types._Printer, ComputerTables.Types._Printer);

		private static final ExecutorFragment _Processor__Component = new ExecutorFragment(Types._Processor, ComputerTables.Types._Component);
		private static final ExecutorFragment _Processor__OclAny = new ExecutorFragment(Types._Processor, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Processor__OclElement = new ExecutorFragment(Types._Processor, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Processor__Processor = new ExecutorFragment(Types._Processor, ComputerTables.Types._Processor);

		private static final ExecutorFragment _StorageType__OclAny = new ExecutorFragment(Types._StorageType, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _StorageType__OclElement = new ExecutorFragment(Types._StorageType, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _StorageType__OclEnumeration = new ExecutorFragment(Types._StorageType, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _StorageType__OclType = new ExecutorFragment(Types._StorageType, OCLstdlibTables.Types._OclType);
		private static final ExecutorFragment _StorageType__StorageType = new ExecutorFragment(Types._StorageType, ComputerTables.Types._StorageType);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ComputerTables::Fragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The parameter lists shared by operations.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Parameters {
		static {
			Init.initStart();
			Fragments.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ComputerTables::Parameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The operation descriptors for each operation of each type.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Operations {
		static {
			Init.initStart();
			Parameters.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ComputerTables::Operations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The property descriptors for each property of each type.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Properties {
		static {
			Init.initStart();
			Operations.init();
		}

		public static final ExecutorProperty _CDDrive__type = new EcoreExecutorProperty(ComputerPackage.Literals.CD_DRIVE__TYPE, Types._CDDrive, 0);
		public static final ExecutorProperty _CDDrive__Computer__cdDrive = new ExecutorPropertyWithImplementation("Computer", Types._CDDrive, 1, new EcoreLibraryOppositeProperty(ComputerPackage.Literals.COMPUTER__CD_DRIVE));

		public static final ExecutorProperty _Component__powerConsumption = new EcoreExecutorProperty(ComputerPackage.Literals.COMPONENT__POWER_CONSUMPTION, Types._Component, 0);

		public static final ExecutorProperty _Computer__cdDrive = new EcoreExecutorProperty(ComputerPackage.Literals.COMPUTER__CD_DRIVE, Types._Computer, 0);
		public static final ExecutorProperty _Computer__graphicsCard = new EcoreExecutorProperty(ComputerPackage.Literals.COMPUTER__GRAPHICS_CARD, Types._Computer, 1);
		public static final ExecutorProperty _Computer__hardDisks = new EcoreExecutorProperty(ComputerPackage.Literals.COMPUTER__HARD_DISKS, Types._Computer, 2);
		public static final ExecutorProperty _Computer__memory = new EcoreExecutorProperty(ComputerPackage.Literals.COMPUTER__MEMORY, Types._Computer, 3);
		public static final ExecutorProperty _Computer__motherboard = new EcoreExecutorProperty(ComputerPackage.Literals.COMPUTER__MOTHERBOARD, Types._Computer, 4);
		public static final ExecutorProperty _Computer__peripherals = new EcoreExecutorProperty(ComputerPackage.Literals.COMPUTER__PERIPHERALS, Types._Computer, 5);
		public static final ExecutorProperty _Computer__powerSupply = new EcoreExecutorProperty(ComputerPackage.Literals.COMPUTER__POWER_SUPPLY, Types._Computer, 6);
		public static final ExecutorProperty _Computer__processor = new EcoreExecutorProperty(ComputerPackage.Literals.COMPUTER__PROCESSOR, Types._Computer, 7);

		public static final ExecutorProperty _GraphicsCard__model = new EcoreExecutorProperty(ComputerPackage.Literals.GRAPHICS_CARD__MODEL, Types._GraphicsCard, 0);
		public static final ExecutorProperty _GraphicsCard__vramGB = new EcoreExecutorProperty(ComputerPackage.Literals.GRAPHICS_CARD__VRAM_GB, Types._GraphicsCard, 1);
		public static final ExecutorProperty _GraphicsCard__Computer__graphicsCard = new ExecutorPropertyWithImplementation("Computer", Types._GraphicsCard, 2, new EcoreLibraryOppositeProperty(ComputerPackage.Literals.COMPUTER__GRAPHICS_CARD));

		public static final ExecutorProperty _HardDisk__capacityGB = new EcoreExecutorProperty(ComputerPackage.Literals.HARD_DISK__CAPACITY_GB, Types._HardDisk, 0);
		public static final ExecutorProperty _HardDisk__type = new EcoreExecutorProperty(ComputerPackage.Literals.HARD_DISK__TYPE, Types._HardDisk, 1);
		public static final ExecutorProperty _HardDisk__Computer__hardDisks = new ExecutorPropertyWithImplementation("Computer", Types._HardDisk, 2, new EcoreLibraryOppositeProperty(ComputerPackage.Literals.COMPUTER__HARD_DISKS));

		public static final ExecutorProperty _Memory__capacityGB = new EcoreExecutorProperty(ComputerPackage.Literals.MEMORY__CAPACITY_GB, Types._Memory, 0);
		public static final ExecutorProperty _Memory__type = new EcoreExecutorProperty(ComputerPackage.Literals.MEMORY__TYPE, Types._Memory, 1);
		public static final ExecutorProperty _Memory__Computer__memory = new ExecutorPropertyWithImplementation("Computer", Types._Memory, 2, new EcoreLibraryOppositeProperty(ComputerPackage.Literals.COMPUTER__MEMORY));

		public static final ExecutorProperty _Motherboard__chipset = new EcoreExecutorProperty(ComputerPackage.Literals.MOTHERBOARD__CHIPSET, Types._Motherboard, 0);
		public static final ExecutorProperty _Motherboard__ports = new EcoreExecutorProperty(ComputerPackage.Literals.MOTHERBOARD__PORTS, Types._Motherboard, 1);
		public static final ExecutorProperty _Motherboard__socket = new EcoreExecutorProperty(ComputerPackage.Literals.MOTHERBOARD__SOCKET, Types._Motherboard, 2);
		public static final ExecutorProperty _Motherboard__type = new EcoreExecutorProperty(ComputerPackage.Literals.MOTHERBOARD__TYPE, Types._Motherboard, 3);
		public static final ExecutorProperty _Motherboard__Computer__motherboard = new ExecutorPropertyWithImplementation("Computer", Types._Motherboard, 4, new EcoreLibraryOppositeProperty(ComputerPackage.Literals.COMPUTER__MOTHERBOARD));

		public static final ExecutorProperty _Peripheral__requiredPort = new EcoreExecutorProperty(ComputerPackage.Literals.PERIPHERAL__REQUIRED_PORT, Types._Peripheral, 0);
		public static final ExecutorProperty _Peripheral__Computer__peripherals = new ExecutorPropertyWithImplementation("Computer", Types._Peripheral, 1, new EcoreLibraryOppositeProperty(ComputerPackage.Literals.COMPUTER__PERIPHERALS));

		public static final ExecutorProperty _PowerSupply__capacityWatts = new EcoreExecutorProperty(ComputerPackage.Literals.POWER_SUPPLY__CAPACITY_WATTS, Types._PowerSupply, 0);
		public static final ExecutorProperty _PowerSupply__efficiency = new EcoreExecutorProperty(ComputerPackage.Literals.POWER_SUPPLY__EFFICIENCY, Types._PowerSupply, 1);
		public static final ExecutorProperty _PowerSupply__Computer__powerSupply = new ExecutorPropertyWithImplementation("Computer", Types._PowerSupply, 2, new EcoreLibraryOppositeProperty(ComputerPackage.Literals.COMPUTER__POWER_SUPPLY));

		public static final ExecutorProperty _Processor__cores = new EcoreExecutorProperty(ComputerPackage.Literals.PROCESSOR__CORES, Types._Processor, 0);
		public static final ExecutorProperty _Processor__model = new EcoreExecutorProperty(ComputerPackage.Literals.PROCESSOR__MODEL, Types._Processor, 1);
		public static final ExecutorProperty _Processor__socket = new EcoreExecutorProperty(ComputerPackage.Literals.PROCESSOR__SOCKET, Types._Processor, 2);
		public static final ExecutorProperty _Processor__Computer__processor = new ExecutorPropertyWithImplementation("Computer", Types._Processor, 3, new EcoreLibraryOppositeProperty(ComputerPackage.Literals.COMPUTER__PROCESSOR));
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ComputerTables::Properties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragments for all base types in depth order: OclAny first, OclSelf last.
	 */
	public static class TypeFragments {
		static {
			Init.initStart();
			Properties.init();
		}

		private static final ExecutorFragment /*@NonNull*/ [] _CDDrive =
			{
				Fragments._CDDrive__OclAny /* 0 */,
				Fragments._CDDrive__OclElement /* 1 */,
				Fragments._CDDrive__Component /* 2 */,
				Fragments._CDDrive__CDDrive /* 3 */
			};
		private static final int /*@NonNull*/ [] __CDDrive = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CDDriveType =
			{
				Fragments._CDDriveType__OclAny /* 0 */,
				Fragments._CDDriveType__OclElement /* 1 */,
				Fragments._CDDriveType__OclType /* 2 */,
				Fragments._CDDriveType__OclEnumeration /* 3 */,
				Fragments._CDDriveType__CDDriveType /* 4 */
			};
		private static final int /*@NonNull*/ [] __CDDriveType = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CPUSocket =
			{
				Fragments._CPUSocket__OclAny /* 0 */,
				Fragments._CPUSocket__OclElement /* 1 */,
				Fragments._CPUSocket__OclType /* 2 */,
				Fragments._CPUSocket__OclEnumeration /* 3 */,
				Fragments._CPUSocket__CPUSocket /* 4 */
			};
		private static final int /*@NonNull*/ [] __CPUSocket = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Component =
			{
				Fragments._Component__OclAny /* 0 */,
				Fragments._Component__OclElement /* 1 */,
				Fragments._Component__Component /* 2 */
			};
		private static final int /*@NonNull*/ [] __Component = { 1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Computer =
			{
				Fragments._Computer__OclAny /* 0 */,
				Fragments._Computer__OclElement /* 1 */,
				Fragments._Computer__Computer /* 2 */
			};
		private static final int /*@NonNull*/ [] __Computer = { 1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Efficiency =
			{
				Fragments._Efficiency__OclAny /* 0 */,
				Fragments._Efficiency__OclElement /* 1 */,
				Fragments._Efficiency__OclType /* 2 */,
				Fragments._Efficiency__OclEnumeration /* 3 */,
				Fragments._Efficiency__Efficiency /* 4 */
			};
		private static final int /*@NonNull*/ [] __Efficiency = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _GraphicsCard =
			{
				Fragments._GraphicsCard__OclAny /* 0 */,
				Fragments._GraphicsCard__OclElement /* 1 */,
				Fragments._GraphicsCard__Component /* 2 */,
				Fragments._GraphicsCard__GraphicsCard /* 3 */
			};
		private static final int /*@NonNull*/ [] __GraphicsCard = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _HardDisk =
			{
				Fragments._HardDisk__OclAny /* 0 */,
				Fragments._HardDisk__OclElement /* 1 */,
				Fragments._HardDisk__Component /* 2 */,
				Fragments._HardDisk__HardDisk /* 3 */
			};
		private static final int /*@NonNull*/ [] __HardDisk = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Keyboard =
			{
				Fragments._Keyboard__OclAny /* 0 */,
				Fragments._Keyboard__OclElement /* 1 */,
				Fragments._Keyboard__Component /* 2 */,
				Fragments._Keyboard__Peripheral /* 3 */,
				Fragments._Keyboard__Keyboard /* 4 */
			};
		private static final int /*@NonNull*/ [] __Keyboard = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Memory =
			{
				Fragments._Memory__OclAny /* 0 */,
				Fragments._Memory__OclElement /* 1 */,
				Fragments._Memory__Component /* 2 */,
				Fragments._Memory__Memory /* 3 */
			};
		private static final int /*@NonNull*/ [] __Memory = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _MemoryType =
			{
				Fragments._MemoryType__OclAny /* 0 */,
				Fragments._MemoryType__OclElement /* 1 */,
				Fragments._MemoryType__OclType /* 2 */,
				Fragments._MemoryType__OclEnumeration /* 3 */,
				Fragments._MemoryType__MemoryType /* 4 */
			};
		private static final int /*@NonNull*/ [] __MemoryType = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Monitor =
			{
				Fragments._Monitor__OclAny /* 0 */,
				Fragments._Monitor__OclElement /* 1 */,
				Fragments._Monitor__Component /* 2 */,
				Fragments._Monitor__Peripheral /* 3 */,
				Fragments._Monitor__Monitor /* 4 */
			};
		private static final int /*@NonNull*/ [] __Monitor = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Motherboard =
			{
				Fragments._Motherboard__OclAny /* 0 */,
				Fragments._Motherboard__OclElement /* 1 */,
				Fragments._Motherboard__Component /* 2 */,
				Fragments._Motherboard__Motherboard /* 3 */
			};
		private static final int /*@NonNull*/ [] __Motherboard = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _MotherboardType =
			{
				Fragments._MotherboardType__OclAny /* 0 */,
				Fragments._MotherboardType__OclElement /* 1 */,
				Fragments._MotherboardType__OclType /* 2 */,
				Fragments._MotherboardType__OclEnumeration /* 3 */,
				Fragments._MotherboardType__MotherboardType /* 4 */
			};
		private static final int /*@NonNull*/ [] __MotherboardType = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Mouse =
			{
				Fragments._Mouse__OclAny /* 0 */,
				Fragments._Mouse__OclElement /* 1 */,
				Fragments._Mouse__Component /* 2 */,
				Fragments._Mouse__Peripheral /* 3 */,
				Fragments._Mouse__Mouse /* 4 */
			};
		private static final int /*@NonNull*/ [] __Mouse = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Peripheral =
			{
				Fragments._Peripheral__OclAny /* 0 */,
				Fragments._Peripheral__OclElement /* 1 */,
				Fragments._Peripheral__Component /* 2 */,
				Fragments._Peripheral__Peripheral /* 3 */
			};
		private static final int /*@NonNull*/ [] __Peripheral = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PortType =
			{
				Fragments._PortType__OclAny /* 0 */,
				Fragments._PortType__OclElement /* 1 */,
				Fragments._PortType__OclType /* 2 */,
				Fragments._PortType__OclEnumeration /* 3 */,
				Fragments._PortType__PortType /* 4 */
			};
		private static final int /*@NonNull*/ [] __PortType = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PowerSupply =
			{
				Fragments._PowerSupply__OclAny /* 0 */,
				Fragments._PowerSupply__OclElement /* 1 */,
				Fragments._PowerSupply__PowerSupply /* 2 */
			};
		private static final int /*@NonNull*/ [] __PowerSupply = { 1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Printer =
			{
				Fragments._Printer__OclAny /* 0 */,
				Fragments._Printer__OclElement /* 1 */,
				Fragments._Printer__Component /* 2 */,
				Fragments._Printer__Peripheral /* 3 */,
				Fragments._Printer__Printer /* 4 */
			};
		private static final int /*@NonNull*/ [] __Printer = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Processor =
			{
				Fragments._Processor__OclAny /* 0 */,
				Fragments._Processor__OclElement /* 1 */,
				Fragments._Processor__Component /* 2 */,
				Fragments._Processor__Processor /* 3 */
			};
		private static final int /*@NonNull*/ [] __Processor = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _StorageType =
			{
				Fragments._StorageType__OclAny /* 0 */,
				Fragments._StorageType__OclElement /* 1 */,
				Fragments._StorageType__OclType /* 2 */,
				Fragments._StorageType__OclEnumeration /* 3 */,
				Fragments._StorageType__StorageType /* 4 */
			};
		private static final int /*@NonNull*/ [] __StorageType = { 1,1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._CDDrive.initFragments(_CDDrive, __CDDrive);
			Types._CDDriveType.initFragments(_CDDriveType, __CDDriveType);
			Types._CPUSocket.initFragments(_CPUSocket, __CPUSocket);
			Types._Component.initFragments(_Component, __Component);
			Types._Computer.initFragments(_Computer, __Computer);
			Types._Efficiency.initFragments(_Efficiency, __Efficiency);
			Types._GraphicsCard.initFragments(_GraphicsCard, __GraphicsCard);
			Types._HardDisk.initFragments(_HardDisk, __HardDisk);
			Types._Keyboard.initFragments(_Keyboard, __Keyboard);
			Types._Memory.initFragments(_Memory, __Memory);
			Types._MemoryType.initFragments(_MemoryType, __MemoryType);
			Types._Monitor.initFragments(_Monitor, __Monitor);
			Types._Motherboard.initFragments(_Motherboard, __Motherboard);
			Types._MotherboardType.initFragments(_MotherboardType, __MotherboardType);
			Types._Mouse.initFragments(_Mouse, __Mouse);
			Types._Peripheral.initFragments(_Peripheral, __Peripheral);
			Types._PortType.initFragments(_PortType, __PortType);
			Types._PowerSupply.initFragments(_PowerSupply, __PowerSupply);
			Types._Printer.initFragments(_Printer, __Printer);
			Types._Processor.initFragments(_Processor, __Processor);
			Types._StorageType.initFragments(_StorageType, __StorageType);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ComputerTables::TypeFragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local operations or local operation overrides for each fragment of each type.
	 */
	public static class FragmentOperations {
		static {
			Init.initStart();
			TypeFragments.init();
		}

		private static final ExecutorOperation /*@NonNull*/ [] _CDDrive__CDDrive = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CDDrive__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CDDrive__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CDDrive__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _CDDriveType__CDDriveType = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CDDriveType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CDDriveType__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CDDriveType__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CDDriveType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _CPUSocket__CPUSocket = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CPUSocket__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CPUSocket__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CPUSocket__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CPUSocket__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Component__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Component__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Component__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Computer__Computer = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Computer__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Computer__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Efficiency__Efficiency = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Efficiency__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Efficiency__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Efficiency__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Efficiency__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _GraphicsCard__GraphicsCard = {};
		private static final ExecutorOperation /*@NonNull*/ [] _GraphicsCard__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _GraphicsCard__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _GraphicsCard__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _HardDisk__HardDisk = {};
		private static final ExecutorOperation /*@NonNull*/ [] _HardDisk__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _HardDisk__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _HardDisk__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Keyboard__Keyboard = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Keyboard__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Keyboard__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Keyboard__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Keyboard__Peripheral = {};

		private static final ExecutorOperation /*@NonNull*/ [] _Memory__Memory = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Memory__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Memory__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Memory__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _MemoryType__MemoryType = {};
		private static final ExecutorOperation /*@NonNull*/ [] _MemoryType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _MemoryType__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _MemoryType__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _MemoryType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Monitor__Monitor = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Monitor__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Monitor__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Monitor__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Monitor__Peripheral = {};

		private static final ExecutorOperation /*@NonNull*/ [] _Motherboard__Motherboard = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Motherboard__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Motherboard__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Motherboard__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _MotherboardType__MotherboardType = {};
		private static final ExecutorOperation /*@NonNull*/ [] _MotherboardType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _MotherboardType__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _MotherboardType__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _MotherboardType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Mouse__Mouse = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Mouse__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Mouse__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Mouse__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Mouse__Peripheral = {};

		private static final ExecutorOperation /*@NonNull*/ [] _Peripheral__Peripheral = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Peripheral__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Peripheral__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Peripheral__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _PortType__PortType = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PortType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PortType__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PortType__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PortType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _PowerSupply__PowerSupply = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PowerSupply__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PowerSupply__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Printer__Printer = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Printer__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Printer__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Printer__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Printer__Peripheral = {};

		private static final ExecutorOperation /*@NonNull*/ [] _Processor__Processor = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Processor__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Processor__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Processor__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _StorageType__StorageType = {};
		private static final ExecutorOperation /*@NonNull*/ [] _StorageType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _StorageType__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _StorageType__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _StorageType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._CDDrive__CDDrive.initOperations(_CDDrive__CDDrive);
			Fragments._CDDrive__Component.initOperations(_CDDrive__Component);
			Fragments._CDDrive__OclAny.initOperations(_CDDrive__OclAny);
			Fragments._CDDrive__OclElement.initOperations(_CDDrive__OclElement);

			Fragments._CDDriveType__CDDriveType.initOperations(_CDDriveType__CDDriveType);
			Fragments._CDDriveType__OclAny.initOperations(_CDDriveType__OclAny);
			Fragments._CDDriveType__OclElement.initOperations(_CDDriveType__OclElement);
			Fragments._CDDriveType__OclEnumeration.initOperations(_CDDriveType__OclEnumeration);
			Fragments._CDDriveType__OclType.initOperations(_CDDriveType__OclType);

			Fragments._CPUSocket__CPUSocket.initOperations(_CPUSocket__CPUSocket);
			Fragments._CPUSocket__OclAny.initOperations(_CPUSocket__OclAny);
			Fragments._CPUSocket__OclElement.initOperations(_CPUSocket__OclElement);
			Fragments._CPUSocket__OclEnumeration.initOperations(_CPUSocket__OclEnumeration);
			Fragments._CPUSocket__OclType.initOperations(_CPUSocket__OclType);

			Fragments._Component__Component.initOperations(_Component__Component);
			Fragments._Component__OclAny.initOperations(_Component__OclAny);
			Fragments._Component__OclElement.initOperations(_Component__OclElement);

			Fragments._Computer__Computer.initOperations(_Computer__Computer);
			Fragments._Computer__OclAny.initOperations(_Computer__OclAny);
			Fragments._Computer__OclElement.initOperations(_Computer__OclElement);

			Fragments._Efficiency__Efficiency.initOperations(_Efficiency__Efficiency);
			Fragments._Efficiency__OclAny.initOperations(_Efficiency__OclAny);
			Fragments._Efficiency__OclElement.initOperations(_Efficiency__OclElement);
			Fragments._Efficiency__OclEnumeration.initOperations(_Efficiency__OclEnumeration);
			Fragments._Efficiency__OclType.initOperations(_Efficiency__OclType);

			Fragments._GraphicsCard__Component.initOperations(_GraphicsCard__Component);
			Fragments._GraphicsCard__GraphicsCard.initOperations(_GraphicsCard__GraphicsCard);
			Fragments._GraphicsCard__OclAny.initOperations(_GraphicsCard__OclAny);
			Fragments._GraphicsCard__OclElement.initOperations(_GraphicsCard__OclElement);

			Fragments._HardDisk__Component.initOperations(_HardDisk__Component);
			Fragments._HardDisk__HardDisk.initOperations(_HardDisk__HardDisk);
			Fragments._HardDisk__OclAny.initOperations(_HardDisk__OclAny);
			Fragments._HardDisk__OclElement.initOperations(_HardDisk__OclElement);

			Fragments._Keyboard__Component.initOperations(_Keyboard__Component);
			Fragments._Keyboard__Keyboard.initOperations(_Keyboard__Keyboard);
			Fragments._Keyboard__OclAny.initOperations(_Keyboard__OclAny);
			Fragments._Keyboard__OclElement.initOperations(_Keyboard__OclElement);
			Fragments._Keyboard__Peripheral.initOperations(_Keyboard__Peripheral);

			Fragments._Memory__Component.initOperations(_Memory__Component);
			Fragments._Memory__Memory.initOperations(_Memory__Memory);
			Fragments._Memory__OclAny.initOperations(_Memory__OclAny);
			Fragments._Memory__OclElement.initOperations(_Memory__OclElement);

			Fragments._MemoryType__MemoryType.initOperations(_MemoryType__MemoryType);
			Fragments._MemoryType__OclAny.initOperations(_MemoryType__OclAny);
			Fragments._MemoryType__OclElement.initOperations(_MemoryType__OclElement);
			Fragments._MemoryType__OclEnumeration.initOperations(_MemoryType__OclEnumeration);
			Fragments._MemoryType__OclType.initOperations(_MemoryType__OclType);

			Fragments._Monitor__Component.initOperations(_Monitor__Component);
			Fragments._Monitor__Monitor.initOperations(_Monitor__Monitor);
			Fragments._Monitor__OclAny.initOperations(_Monitor__OclAny);
			Fragments._Monitor__OclElement.initOperations(_Monitor__OclElement);
			Fragments._Monitor__Peripheral.initOperations(_Monitor__Peripheral);

			Fragments._Motherboard__Component.initOperations(_Motherboard__Component);
			Fragments._Motherboard__Motherboard.initOperations(_Motherboard__Motherboard);
			Fragments._Motherboard__OclAny.initOperations(_Motherboard__OclAny);
			Fragments._Motherboard__OclElement.initOperations(_Motherboard__OclElement);

			Fragments._MotherboardType__MotherboardType.initOperations(_MotherboardType__MotherboardType);
			Fragments._MotherboardType__OclAny.initOperations(_MotherboardType__OclAny);
			Fragments._MotherboardType__OclElement.initOperations(_MotherboardType__OclElement);
			Fragments._MotherboardType__OclEnumeration.initOperations(_MotherboardType__OclEnumeration);
			Fragments._MotherboardType__OclType.initOperations(_MotherboardType__OclType);

			Fragments._Mouse__Component.initOperations(_Mouse__Component);
			Fragments._Mouse__Mouse.initOperations(_Mouse__Mouse);
			Fragments._Mouse__OclAny.initOperations(_Mouse__OclAny);
			Fragments._Mouse__OclElement.initOperations(_Mouse__OclElement);
			Fragments._Mouse__Peripheral.initOperations(_Mouse__Peripheral);

			Fragments._Peripheral__Component.initOperations(_Peripheral__Component);
			Fragments._Peripheral__OclAny.initOperations(_Peripheral__OclAny);
			Fragments._Peripheral__OclElement.initOperations(_Peripheral__OclElement);
			Fragments._Peripheral__Peripheral.initOperations(_Peripheral__Peripheral);

			Fragments._PortType__OclAny.initOperations(_PortType__OclAny);
			Fragments._PortType__OclElement.initOperations(_PortType__OclElement);
			Fragments._PortType__OclEnumeration.initOperations(_PortType__OclEnumeration);
			Fragments._PortType__OclType.initOperations(_PortType__OclType);
			Fragments._PortType__PortType.initOperations(_PortType__PortType);

			Fragments._PowerSupply__OclAny.initOperations(_PowerSupply__OclAny);
			Fragments._PowerSupply__OclElement.initOperations(_PowerSupply__OclElement);
			Fragments._PowerSupply__PowerSupply.initOperations(_PowerSupply__PowerSupply);

			Fragments._Printer__Component.initOperations(_Printer__Component);
			Fragments._Printer__OclAny.initOperations(_Printer__OclAny);
			Fragments._Printer__OclElement.initOperations(_Printer__OclElement);
			Fragments._Printer__Peripheral.initOperations(_Printer__Peripheral);
			Fragments._Printer__Printer.initOperations(_Printer__Printer);

			Fragments._Processor__Component.initOperations(_Processor__Component);
			Fragments._Processor__OclAny.initOperations(_Processor__OclAny);
			Fragments._Processor__OclElement.initOperations(_Processor__OclElement);
			Fragments._Processor__Processor.initOperations(_Processor__Processor);

			Fragments._StorageType__OclAny.initOperations(_StorageType__OclAny);
			Fragments._StorageType__OclElement.initOperations(_StorageType__OclElement);
			Fragments._StorageType__OclEnumeration.initOperations(_StorageType__OclEnumeration);
			Fragments._StorageType__OclType.initOperations(_StorageType__OclType);
			Fragments._StorageType__StorageType.initOperations(_StorageType__StorageType);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ComputerTables::FragmentOperations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local properties for the local fragment of each type.
	 */
	public static class FragmentProperties {
		static {
			Init.initStart();
			FragmentOperations.init();
		}

		private static final ExecutorProperty /*@NonNull*/ [] _CDDrive = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			ComputerTables.Properties._Component__powerConsumption,
			ComputerTables.Properties._CDDrive__type
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CDDriveType = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CPUSocket = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Component = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			ComputerTables.Properties._Component__powerConsumption
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Computer = {
			ComputerTables.Properties._Computer__cdDrive,
			ComputerTables.Properties._Computer__graphicsCard,
			ComputerTables.Properties._Computer__hardDisks,
			ComputerTables.Properties._Computer__memory,
			ComputerTables.Properties._Computer__motherboard,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			ComputerTables.Properties._Computer__peripherals,
			ComputerTables.Properties._Computer__powerSupply,
			ComputerTables.Properties._Computer__processor
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Efficiency = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _GraphicsCard = {
			ComputerTables.Properties._GraphicsCard__model,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			ComputerTables.Properties._Component__powerConsumption,
			ComputerTables.Properties._GraphicsCard__vramGB
		};

		private static final ExecutorProperty /*@NonNull*/ [] _HardDisk = {
			ComputerTables.Properties._HardDisk__capacityGB,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			ComputerTables.Properties._Component__powerConsumption,
			ComputerTables.Properties._HardDisk__type
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Keyboard = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			ComputerTables.Properties._Component__powerConsumption,
			ComputerTables.Properties._Peripheral__requiredPort
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Memory = {
			ComputerTables.Properties._Memory__capacityGB,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			ComputerTables.Properties._Component__powerConsumption,
			ComputerTables.Properties._Memory__type
		};

		private static final ExecutorProperty /*@NonNull*/ [] _MemoryType = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Monitor = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			ComputerTables.Properties._Component__powerConsumption,
			ComputerTables.Properties._Peripheral__requiredPort
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Motherboard = {
			ComputerTables.Properties._Motherboard__chipset,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			ComputerTables.Properties._Motherboard__ports,
			ComputerTables.Properties._Component__powerConsumption,
			ComputerTables.Properties._Motherboard__socket,
			ComputerTables.Properties._Motherboard__type
		};

		private static final ExecutorProperty /*@NonNull*/ [] _MotherboardType = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Mouse = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			ComputerTables.Properties._Component__powerConsumption,
			ComputerTables.Properties._Peripheral__requiredPort
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Peripheral = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			ComputerTables.Properties._Component__powerConsumption,
			ComputerTables.Properties._Peripheral__requiredPort
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PortType = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PowerSupply = {
			ComputerTables.Properties._PowerSupply__capacityWatts,
			ComputerTables.Properties._PowerSupply__efficiency,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Printer = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			ComputerTables.Properties._Component__powerConsumption,
			ComputerTables.Properties._Peripheral__requiredPort
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Processor = {
			ComputerTables.Properties._Processor__cores,
			ComputerTables.Properties._Processor__model,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			ComputerTables.Properties._Component__powerConsumption,
			ComputerTables.Properties._Processor__socket
		};

		private static final ExecutorProperty /*@NonNull*/ [] _StorageType = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._CDDrive__CDDrive.initProperties(_CDDrive);
			Fragments._CDDriveType__CDDriveType.initProperties(_CDDriveType);
			Fragments._CPUSocket__CPUSocket.initProperties(_CPUSocket);
			Fragments._Component__Component.initProperties(_Component);
			Fragments._Computer__Computer.initProperties(_Computer);
			Fragments._Efficiency__Efficiency.initProperties(_Efficiency);
			Fragments._GraphicsCard__GraphicsCard.initProperties(_GraphicsCard);
			Fragments._HardDisk__HardDisk.initProperties(_HardDisk);
			Fragments._Keyboard__Keyboard.initProperties(_Keyboard);
			Fragments._Memory__Memory.initProperties(_Memory);
			Fragments._MemoryType__MemoryType.initProperties(_MemoryType);
			Fragments._Monitor__Monitor.initProperties(_Monitor);
			Fragments._Motherboard__Motherboard.initProperties(_Motherboard);
			Fragments._MotherboardType__MotherboardType.initProperties(_MotherboardType);
			Fragments._Mouse__Mouse.initProperties(_Mouse);
			Fragments._Peripheral__Peripheral.initProperties(_Peripheral);
			Fragments._PortType__PortType.initProperties(_PortType);
			Fragments._PowerSupply__PowerSupply.initProperties(_PowerSupply);
			Fragments._Printer__Printer.initProperties(_Printer);
			Fragments._Processor__Processor.initProperties(_Processor);
			Fragments._StorageType__StorageType.initProperties(_StorageType);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ComputerTables::FragmentProperties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of enumeration literals for each enumeration.
	 */
	public static class EnumerationLiterals {
		static {
			Init.initStart();
			FragmentProperties.init();
		}

		public static final EcoreExecutorEnumerationLiteral _CDDriveType__CD_ROM = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.CD_DRIVE_TYPE.getEEnumLiteral("CD_ROM"), Types._CDDriveType, 0);
		public static final EcoreExecutorEnumerationLiteral _CDDriveType__CD_R = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.CD_DRIVE_TYPE.getEEnumLiteral("CD_R"), Types._CDDriveType, 1);
		public static final EcoreExecutorEnumerationLiteral _CDDriveType__CD_RW = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.CD_DRIVE_TYPE.getEEnumLiteral("CD_RW"), Types._CDDriveType, 2);
		public static final EcoreExecutorEnumerationLiteral _CDDriveType__DVD_ROM = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.CD_DRIVE_TYPE.getEEnumLiteral("DVD_ROM"), Types._CDDriveType, 3);
		public static final EcoreExecutorEnumerationLiteral _CDDriveType__Blu_Ray = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.CD_DRIVE_TYPE.getEEnumLiteral("Blu_Ray"), Types._CDDriveType, 4);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _CDDriveType = {
			_CDDriveType__CD_ROM,
			_CDDriveType__CD_R,
			_CDDriveType__CD_RW,
			_CDDriveType__DVD_ROM,
			_CDDriveType__Blu_Ray
		};

		public static final EcoreExecutorEnumerationLiteral _CPUSocket__AM4 = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.CPU_SOCKET.getEEnumLiteral("AM4"), Types._CPUSocket, 0);
		public static final EcoreExecutorEnumerationLiteral _CPUSocket__AM5 = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.CPU_SOCKET.getEEnumLiteral("AM5"), Types._CPUSocket, 1);
		public static final EcoreExecutorEnumerationLiteral _CPUSocket__LGA1200 = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.CPU_SOCKET.getEEnumLiteral("LGA1200"), Types._CPUSocket, 2);
		public static final EcoreExecutorEnumerationLiteral _CPUSocket__LGA1700 = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.CPU_SOCKET.getEEnumLiteral("LGA1700"), Types._CPUSocket, 3);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _CPUSocket = {
			_CPUSocket__AM4,
			_CPUSocket__AM5,
			_CPUSocket__LGA1200,
			_CPUSocket__LGA1700
		};

		public static final EcoreExecutorEnumerationLiteral _Efficiency__Bronze = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.EFFICIENCY.getEEnumLiteral("Bronze"), Types._Efficiency, 0);
		public static final EcoreExecutorEnumerationLiteral _Efficiency__Silver = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.EFFICIENCY.getEEnumLiteral("Silver"), Types._Efficiency, 1);
		public static final EcoreExecutorEnumerationLiteral _Efficiency__Gold = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.EFFICIENCY.getEEnumLiteral("Gold"), Types._Efficiency, 2);
		public static final EcoreExecutorEnumerationLiteral _Efficiency__Platinum = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.EFFICIENCY.getEEnumLiteral("Platinum"), Types._Efficiency, 3);
		public static final EcoreExecutorEnumerationLiteral _Efficiency__Titanium = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.EFFICIENCY.getEEnumLiteral("Titanium"), Types._Efficiency, 4);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _Efficiency = {
			_Efficiency__Bronze,
			_Efficiency__Silver,
			_Efficiency__Gold,
			_Efficiency__Platinum,
			_Efficiency__Titanium
		};

		public static final EcoreExecutorEnumerationLiteral _MemoryType__DDR4 = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.MEMORY_TYPE.getEEnumLiteral("DDR4"), Types._MemoryType, 0);
		public static final EcoreExecutorEnumerationLiteral _MemoryType__DDR5 = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.MEMORY_TYPE.getEEnumLiteral("DDR5"), Types._MemoryType, 1);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _MemoryType = {
			_MemoryType__DDR4,
			_MemoryType__DDR5
		};

		public static final EcoreExecutorEnumerationLiteral _MotherboardType__ATX = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.MOTHERBOARD_TYPE.getEEnumLiteral("ATX"), Types._MotherboardType, 0);
		public static final EcoreExecutorEnumerationLiteral _MotherboardType__MicroATX = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.MOTHERBOARD_TYPE.getEEnumLiteral("MicroATX"), Types._MotherboardType, 1);
		public static final EcoreExecutorEnumerationLiteral _MotherboardType__MiniITX = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.MOTHERBOARD_TYPE.getEEnumLiteral("MiniITX"), Types._MotherboardType, 2);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _MotherboardType = {
			_MotherboardType__ATX,
			_MotherboardType__MicroATX,
			_MotherboardType__MiniITX
		};

		public static final EcoreExecutorEnumerationLiteral _PortType__USB = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.PORT_TYPE.getEEnumLiteral("USB"), Types._PortType, 0);
		public static final EcoreExecutorEnumerationLiteral _PortType__PS2 = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.PORT_TYPE.getEEnumLiteral("PS2"), Types._PortType, 1);
		public static final EcoreExecutorEnumerationLiteral _PortType__HDMI = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.PORT_TYPE.getEEnumLiteral("HDMI"), Types._PortType, 2);
		public static final EcoreExecutorEnumerationLiteral _PortType__DisplayPort = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.PORT_TYPE.getEEnumLiteral("DisplayPort"), Types._PortType, 3);
		public static final EcoreExecutorEnumerationLiteral _PortType__VGA = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.PORT_TYPE.getEEnumLiteral("VGA"), Types._PortType, 4);
		public static final EcoreExecutorEnumerationLiteral _PortType__Ethernet = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.PORT_TYPE.getEEnumLiteral("Ethernet"), Types._PortType, 5);
		public static final EcoreExecutorEnumerationLiteral _PortType__Audio = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.PORT_TYPE.getEEnumLiteral("Audio"), Types._PortType, 6);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _PortType = {
			_PortType__USB,
			_PortType__PS2,
			_PortType__HDMI,
			_PortType__DisplayPort,
			_PortType__VGA,
			_PortType__Ethernet,
			_PortType__Audio
		};

		public static final EcoreExecutorEnumerationLiteral _StorageType__HDD = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.STORAGE_TYPE.getEEnumLiteral("HDD"), Types._StorageType, 0);
		public static final EcoreExecutorEnumerationLiteral _StorageType__SSD = new EcoreExecutorEnumerationLiteral(ComputerPackage.Literals.STORAGE_TYPE.getEEnumLiteral("SSD"), Types._StorageType, 1);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _StorageType = {
			_StorageType__HDD,
			_StorageType__SSD
		};

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
			Types._CDDriveType.initLiterals(_CDDriveType);
			Types._CPUSocket.initLiterals(_CPUSocket);
			Types._Efficiency.initLiterals(_Efficiency);
			Types._MemoryType.initLiterals(_MemoryType);
			Types._MotherboardType.initLiterals(_MotherboardType);
			Types._PortType.initLiterals(_PortType);
			Types._StorageType.initLiterals(_StorageType);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ComputerTables::EnumerationLiterals and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 * The multiple packages above avoid problems with the Java 65536 byte limit but introduce a difficulty in ensuring that
	 * static construction occurs in the disciplined order of the packages when construction may start in any of the packages.
	 * The problem is resolved by ensuring that the static construction of each package first initializes its immediate predecessor.
	 * On completion of predecessor initialization, the residual packages are initialized by starting an initialization in the last package.
	 * This class maintains a count so that the various predecessors can distinguish whether they are the starting point and so
	 * ensure that residual construction occurs just once after all predecessors.
	 */
	private static class Init {
		/**
		 * Counter of nested static constructions. On return to zero residual construction starts. -ve once residual construction started.
		 */
		private static int initCount = 0;

		/**
		 * Invoked at the start of a static construction to defer residual construction until primary constructions complete.
		 */
		private static void initStart() {
			if (initCount >= 0) {
				initCount++;
			}
		}

		/**
		 * Invoked at the end of a static construction to activate residual construction once primary constructions complete.
		 */
		private static void initEnd() {
			if (initCount > 0) {
				if (--initCount == 0) {
					initCount = -1;
					EnumerationLiterals.init();
				}
			}
		}
	}

	static {
		Init.initEnd();
	}

	/*
	 * Force initialization of outer fields. Inner fields are lazily initialized.
	 */
	public static void init() {
		new ComputerTables();
	}

	private ComputerTables() {
		super(ComputerPackage.eNS_URI);
	}
}
