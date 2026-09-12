/**
 */
package computer.impl;

import computer.CDDrive;
import computer.CPUSocket;
import computer.Computer;
import computer.ComputerPackage;
import computer.ComputerTables;
import computer.GraphicsCard;
import computer.HardDisk;
import computer.Memory;
import computer.Motherboard;
import computer.Peripheral;
import computer.PortType;
import computer.PowerSupply;
import computer.Processor;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.pivot.evaluation.Executor;

import org.eclipse.ocl.pivot.ids.EnumerationLiteralId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;

import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSumOperation;

import org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation;

import org.eclipse.ocl.pivot.library.oclany.OclAnyToStringOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanEqualOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;

import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;

import org.eclipse.ocl.pivot.messages.PivotMessages;

import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;

import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;

import org.eclipse.ocl.pivot.values.SequenceValue.Accumulator;

import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.pivot.values.TupleValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link computer.impl.ComputerImpl#getMotherboard <em>Motherboard</em>}</li>
 *   <li>{@link computer.impl.ComputerImpl#getProcessor <em>Processor</em>}</li>
 *   <li>{@link computer.impl.ComputerImpl#getGraphicsCard <em>Graphics Card</em>}</li>
 *   <li>{@link computer.impl.ComputerImpl#getMemory <em>Memory</em>}</li>
 *   <li>{@link computer.impl.ComputerImpl#getHardDisks <em>Hard Disks</em>}</li>
 *   <li>{@link computer.impl.ComputerImpl#getCdDrive <em>Cd Drive</em>}</li>
 *   <li>{@link computer.impl.ComputerImpl#getPeripherals <em>Peripherals</em>}</li>
 *   <li>{@link computer.impl.ComputerImpl#getPowerSupply <em>Power Supply</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComputerImpl extends MinimalEObjectImpl.Container implements Computer {
	/**
	 * The cached value of the '{@link #getMotherboard() <em>Motherboard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMotherboard()
	 * @generated
	 * @ordered
	 */
	protected Motherboard motherboard;

	/**
	 * The cached value of the '{@link #getProcessor() <em>Processor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessor()
	 * @generated
	 * @ordered
	 */
	protected Processor processor;

	/**
	 * The cached value of the '{@link #getGraphicsCard() <em>Graphics Card</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphicsCard()
	 * @generated
	 * @ordered
	 */
	protected GraphicsCard graphicsCard;

	/**
	 * The cached value of the '{@link #getMemory() <em>Memory</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemory()
	 * @generated
	 * @ordered
	 */
	protected EList<Memory> memory;

	/**
	 * The cached value of the '{@link #getHardDisks() <em>Hard Disks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHardDisks()
	 * @generated
	 * @ordered
	 */
	protected EList<HardDisk> hardDisks;

	/**
	 * The cached value of the '{@link #getCdDrive() <em>Cd Drive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCdDrive()
	 * @generated
	 * @ordered
	 */
	protected CDDrive cdDrive;

	/**
	 * The cached value of the '{@link #getPeripherals() <em>Peripherals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeripherals()
	 * @generated
	 * @ordered
	 */
	protected EList<Peripheral> peripherals;

	/**
	 * The cached value of the '{@link #getPowerSupply() <em>Power Supply</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPowerSupply()
	 * @generated
	 * @ordered
	 */
	protected PowerSupply powerSupply;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputerPackage.Literals.COMPUTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Motherboard getMotherboard() {
		return motherboard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMotherboard(Motherboard newMotherboard, NotificationChain msgs) {
		Motherboard oldMotherboard = motherboard;
		motherboard = newMotherboard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputerPackage.COMPUTER__MOTHERBOARD, oldMotherboard, newMotherboard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMotherboard(Motherboard newMotherboard) {
		if (newMotherboard != motherboard) {
			NotificationChain msgs = null;
			if (motherboard != null)
				msgs = ((InternalEObject)motherboard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputerPackage.COMPUTER__MOTHERBOARD, null, msgs);
			if (newMotherboard != null)
				msgs = ((InternalEObject)newMotherboard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputerPackage.COMPUTER__MOTHERBOARD, null, msgs);
			msgs = basicSetMotherboard(newMotherboard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.COMPUTER__MOTHERBOARD, newMotherboard, newMotherboard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Processor getProcessor() {
		return processor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcessor(Processor newProcessor, NotificationChain msgs) {
		Processor oldProcessor = processor;
		processor = newProcessor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputerPackage.COMPUTER__PROCESSOR, oldProcessor, newProcessor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProcessor(Processor newProcessor) {
		if (newProcessor != processor) {
			NotificationChain msgs = null;
			if (processor != null)
				msgs = ((InternalEObject)processor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputerPackage.COMPUTER__PROCESSOR, null, msgs);
			if (newProcessor != null)
				msgs = ((InternalEObject)newProcessor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputerPackage.COMPUTER__PROCESSOR, null, msgs);
			msgs = basicSetProcessor(newProcessor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.COMPUTER__PROCESSOR, newProcessor, newProcessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicsCard getGraphicsCard() {
		return graphicsCard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraphicsCard(GraphicsCard newGraphicsCard, NotificationChain msgs) {
		GraphicsCard oldGraphicsCard = graphicsCard;
		graphicsCard = newGraphicsCard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputerPackage.COMPUTER__GRAPHICS_CARD, oldGraphicsCard, newGraphicsCard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGraphicsCard(GraphicsCard newGraphicsCard) {
		if (newGraphicsCard != graphicsCard) {
			NotificationChain msgs = null;
			if (graphicsCard != null)
				msgs = ((InternalEObject)graphicsCard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputerPackage.COMPUTER__GRAPHICS_CARD, null, msgs);
			if (newGraphicsCard != null)
				msgs = ((InternalEObject)newGraphicsCard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputerPackage.COMPUTER__GRAPHICS_CARD, null, msgs);
			msgs = basicSetGraphicsCard(newGraphicsCard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.COMPUTER__GRAPHICS_CARD, newGraphicsCard, newGraphicsCard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Memory> getMemory() {
		if (memory == null) {
			memory = new EObjectContainmentEList<Memory>(Memory.class, this, ComputerPackage.COMPUTER__MEMORY);
		}
		return memory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<HardDisk> getHardDisks() {
		if (hardDisks == null) {
			hardDisks = new EObjectContainmentEList<HardDisk>(HardDisk.class, this, ComputerPackage.COMPUTER__HARD_DISKS);
		}
		return hardDisks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CDDrive getCdDrive() {
		return cdDrive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCdDrive(CDDrive newCdDrive, NotificationChain msgs) {
		CDDrive oldCdDrive = cdDrive;
		cdDrive = newCdDrive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputerPackage.COMPUTER__CD_DRIVE, oldCdDrive, newCdDrive);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCdDrive(CDDrive newCdDrive) {
		if (newCdDrive != cdDrive) {
			NotificationChain msgs = null;
			if (cdDrive != null)
				msgs = ((InternalEObject)cdDrive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputerPackage.COMPUTER__CD_DRIVE, null, msgs);
			if (newCdDrive != null)
				msgs = ((InternalEObject)newCdDrive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputerPackage.COMPUTER__CD_DRIVE, null, msgs);
			msgs = basicSetCdDrive(newCdDrive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.COMPUTER__CD_DRIVE, newCdDrive, newCdDrive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Peripheral> getPeripherals() {
		if (peripherals == null) {
			peripherals = new EObjectContainmentEList<Peripheral>(Peripheral.class, this, ComputerPackage.COMPUTER__PERIPHERALS);
		}
		return peripherals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PowerSupply getPowerSupply() {
		return powerSupply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPowerSupply(PowerSupply newPowerSupply, NotificationChain msgs) {
		PowerSupply oldPowerSupply = powerSupply;
		powerSupply = newPowerSupply;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputerPackage.COMPUTER__POWER_SUPPLY, oldPowerSupply, newPowerSupply);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPowerSupply(PowerSupply newPowerSupply) {
		if (newPowerSupply != powerSupply) {
			NotificationChain msgs = null;
			if (powerSupply != null)
				msgs = ((InternalEObject)powerSupply).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputerPackage.COMPUTER__POWER_SUPPLY, null, msgs);
			if (newPowerSupply != null)
				msgs = ((InternalEObject)newPowerSupply).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputerPackage.COMPUTER__POWER_SUPPLY, null, msgs);
			msgs = basicSetPowerSupply(newPowerSupply, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.COMPUTER__POWER_SUPPLY, newPowerSupply, newPowerSupply));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean PowerSupplyCapacitySufficient(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final String constraintName = "Computer::PowerSupplyCapacitySufficient";
		try {
			/**
			 *
			 * inv PowerSupplyCapacitySufficient:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : OclAny[1] = let status : Boolean[1] = powerSupply.capacityWatts >= motherboard.powerConsumption + processor.powerConsumption +
			 *           if graphicsCard.oclIsUndefined()
			 *           then 0
			 *           else graphicsCard.powerConsumption
			 *           endif +
			 *           memory->collect(powerConsumption)
			 *           ->sum() +
			 *           hardDisks->collect(powerConsumption)
			 *           ->sum() +
			 *           if cdDrive.oclIsUndefined()
			 *           then 0
			 *           else cdDrive.powerConsumption
			 *           endif +
			 *           peripherals->collect(powerConsumption)
			 *           ->sum()
			 *         in
			 *           if status = true
			 *           then true
			 *           else
			 *             Tuple{message = 'Power supply capacity is lower than the total power draw of the installed components', status = status
			 *             }
			 *           endif
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, ComputerPackage.Literals.COMPUTER___POWER_SUPPLY_CAPACITY_SUFFICIENT__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, ComputerTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ Object CAUGHT_IF_status;
				try {
					final /*@NonInvalid*/ CDDrive cdDrive = this.getCdDrive();
					final /*@NonInvalid*/ GraphicsCard graphicsCard = this.getGraphicsCard();
					final /*@NonInvalid*/ PowerSupply powerSupply = this.getPowerSupply();
					final /*@NonInvalid*/ int capacityWatts = powerSupply.getCapacityWatts();
					final /*@NonInvalid*/ IntegerValue BOXED_capacityWatts = ValueUtil.integerValueOf(capacityWatts);
					final /*@NonInvalid*/ Motherboard motherboard = this.getMotherboard();
					final /*@NonInvalid*/ int powerConsumption = motherboard.getPowerConsumption();
					final /*@NonInvalid*/ IntegerValue BOXED_powerConsumption = ValueUtil.integerValueOf(powerConsumption);
					final /*@NonInvalid*/ Processor processor = this.getProcessor();
					final /*@NonInvalid*/ int powerConsumption_0 = processor.getPowerConsumption();
					final /*@NonInvalid*/ IntegerValue BOXED_powerConsumption_0 = ValueUtil.integerValueOf(powerConsumption_0);
					final /*@NonInvalid*/ IntegerValue sum = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(BOXED_powerConsumption, BOXED_powerConsumption_0);
					final /*@NonInvalid*/ boolean oclIsUndefined = graphicsCard == null;
					/*@Thrown*/ IntegerValue IF_oclIsUndefined;
					if (oclIsUndefined) {
						IF_oclIsUndefined = ComputerTables.INT_0;
					}
					else {
						if (graphicsCard == null) {
							throw new InvalidValueException("Null source for \'\'http://www.example.org/examples/example.ecore\'::Component::powerConsumption\'");
						}
						final /*@Thrown*/ int powerConsumption_1 = graphicsCard.getPowerConsumption();
						final /*@Thrown*/ IntegerValue BOXED_powerConsumption_1 = ValueUtil.integerValueOf(powerConsumption_1);
						IF_oclIsUndefined = BOXED_powerConsumption_1;
					}
					if (IF_oclIsUndefined instanceof InvalidValueException) {
						throw (InvalidValueException)IF_oclIsUndefined;
					}
					final /*@Thrown*/ IntegerValue sum_0 = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(sum, IF_oclIsUndefined);
					final /*@NonInvalid*/ List<Memory> memory = this.getMemory();
					final /*@NonInvalid*/ OrderedSetValue BOXED_memory = idResolver.createOrderedSetOfAll(ComputerTables.ORD_CLSSid_Memory, memory);
					/*@Thrown*/ Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(ComputerTables.SEQ_DATAid_EInt);
					Iterator<Object> ITERATOR__1 = BOXED_memory.iterator();
					/*@NonInvalid*/ SequenceValue collect;
					while (true) {
						if (!ITERATOR__1.hasNext()) {
							collect = accumulator;
							break;
						}
						/*@NonInvalid*/ Memory _1 = (Memory)ITERATOR__1.next();
						/**
						 * powerConsumption
						 */
						final /*@NonInvalid*/ int powerConsumption_2 = _1.getPowerConsumption();
						final /*@NonInvalid*/ IntegerValue BOXED_powerConsumption_2 = ValueUtil.integerValueOf(powerConsumption_2);
						//
						accumulator.add(BOXED_powerConsumption_2);
					}
					final /*@NonInvalid*/ IntegerValue sum_1 = (IntegerValue)CollectionSumOperation.INSTANCE.evaluate(executor, ComputerTables.DATAid_EInt, collect);
					final /*@Thrown*/ IntegerValue sum_2 = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(sum_0, sum_1);
					final /*@NonInvalid*/ List<HardDisk> hardDisks = this.getHardDisks();
					final /*@NonInvalid*/ OrderedSetValue BOXED_hardDisks = idResolver.createOrderedSetOfAll(ComputerTables.ORD_CLSSid_HardDisk, hardDisks);
					/*@Thrown*/ Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(ComputerTables.SEQ_DATAid_EInt);
					Iterator<Object> ITERATOR__1_0 = BOXED_hardDisks.iterator();
					/*@NonInvalid*/ SequenceValue collect_0;
					while (true) {
						if (!ITERATOR__1_0.hasNext()) {
							collect_0 = accumulator_0;
							break;
						}
						/*@NonInvalid*/ HardDisk _1_0 = (HardDisk)ITERATOR__1_0.next();
						/**
						 * powerConsumption
						 */
						final /*@NonInvalid*/ int powerConsumption_3 = _1_0.getPowerConsumption();
						final /*@NonInvalid*/ IntegerValue BOXED_powerConsumption_3 = ValueUtil.integerValueOf(powerConsumption_3);
						//
						accumulator_0.add(BOXED_powerConsumption_3);
					}
					final /*@NonInvalid*/ IntegerValue sum_3 = (IntegerValue)CollectionSumOperation.INSTANCE.evaluate(executor, ComputerTables.DATAid_EInt, collect_0);
					final /*@Thrown*/ IntegerValue sum_4 = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(sum_2, sum_3);
					final /*@NonInvalid*/ boolean oclIsUndefined_0 = cdDrive == null;
					/*@Thrown*/ IntegerValue IF_oclIsUndefined_0;
					if (oclIsUndefined_0) {
						IF_oclIsUndefined_0 = ComputerTables.INT_0;
					}
					else {
						if (cdDrive == null) {
							throw new InvalidValueException("Null source for \'\'http://www.example.org/examples/example.ecore\'::Component::powerConsumption\'");
						}
						final /*@Thrown*/ int powerConsumption_4 = cdDrive.getPowerConsumption();
						final /*@Thrown*/ IntegerValue BOXED_powerConsumption_4 = ValueUtil.integerValueOf(powerConsumption_4);
						IF_oclIsUndefined_0 = BOXED_powerConsumption_4;
					}
					if (IF_oclIsUndefined_0 instanceof InvalidValueException) {
						throw (InvalidValueException)IF_oclIsUndefined_0;
					}
					final /*@Thrown*/ IntegerValue sum_5 = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(sum_4, IF_oclIsUndefined_0);
					final /*@NonInvalid*/ List<Peripheral> peripherals = this.getPeripherals();
					final /*@NonInvalid*/ OrderedSetValue BOXED_peripherals = idResolver.createOrderedSetOfAll(ComputerTables.ORD_CLSSid_Peripheral, peripherals);
					/*@Thrown*/ Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(ComputerTables.SEQ_DATAid_EInt);
					Iterator<Object> ITERATOR__1_1 = BOXED_peripherals.iterator();
					/*@NonInvalid*/ SequenceValue collect_1;
					while (true) {
						if (!ITERATOR__1_1.hasNext()) {
							collect_1 = accumulator_1;
							break;
						}
						/*@NonInvalid*/ Peripheral _1_1 = (Peripheral)ITERATOR__1_1.next();
						/**
						 * powerConsumption
						 */
						final /*@NonInvalid*/ int powerConsumption_5 = _1_1.getPowerConsumption();
						final /*@NonInvalid*/ IntegerValue BOXED_powerConsumption_5 = ValueUtil.integerValueOf(powerConsumption_5);
						//
						accumulator_1.add(BOXED_powerConsumption_5);
					}
					final /*@NonInvalid*/ IntegerValue sum_6 = (IntegerValue)CollectionSumOperation.INSTANCE.evaluate(executor, ComputerTables.DATAid_EInt, collect_1);
					final /*@Thrown*/ IntegerValue sum_7 = (IntegerValue)NumericPlusOperation.INSTANCE.evaluate(sum_5, sum_6);
					if (sum_7 instanceof InvalidValueException) {
						throw (InvalidValueException)sum_7;
					}
					final /*@Thrown*/ boolean status = OclComparableGreaterThanEqualOperation.INSTANCE.evaluate(executor, BOXED_capacityWatts, sum_7).booleanValue();
					/*@Thrown*/ Object IF_status;
					if (status) {
						IF_status = ValueUtil.TRUE_VALUE;
					}
					else {
						final /*@Thrown*/ TupleValue TUP_ = ValueUtil.createTupleOfEach(ComputerTables.TUPLid_, ComputerTables.STR_Power_32_supply_32_capacity_32_is_32_lower_32_than_32_the_32_total_32_power_32_draw_32_of_32_the_32, status);
						IF_status = TUP_;
					}
					CAUGHT_IF_status = IF_status;
				}
				catch (Exception e) {
					CAUGHT_IF_status = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_IF_status, ComputerTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic(constraintName, this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean PeripheralPortsAvailable(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final String constraintName = "Computer::PeripheralPortsAvailable";
		try {
			/**
			 *
			 * inv PeripheralPortsAvailable:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : OclAny[1] = let
			 *           status : Boolean[?] = peripherals->forAll(p |
			 *             motherboard.ports->includes(p.requiredPort))
			 *         in
			 *           if status = true
			 *           then true
			 *           else
			 *             Tuple{message = 'Motherboard does not expose a port for every connected peripheral', status = status
			 *             }
			 *           endif
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, ComputerPackage.Literals.COMPUTER___PERIPHERAL_PORTS_AVAILABLE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, ComputerTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				final /*@NonInvalid*/ List<Peripheral> peripherals = this.getPeripherals();
				final /*@NonInvalid*/ OrderedSetValue BOXED_peripherals = idResolver.createOrderedSetOfAll(ComputerTables.ORD_CLSSid_Peripheral, peripherals);
				/*@Thrown*/ Object accumulator = ValueUtil.TRUE_VALUE;
				Iterator<Object> ITERATOR_p = BOXED_peripherals.iterator();
				/*@NonInvalid*/ Boolean status;
				while (true) {
					if (!ITERATOR_p.hasNext()) {
						if (accumulator == ValueUtil.TRUE_VALUE) {
							status = ValueUtil.TRUE_VALUE;
						}
						else {
							throw (InvalidValueException)accumulator;
						}
						break;
					}
					/*@NonInvalid*/ Peripheral p = (Peripheral)ITERATOR_p.next();
					/**
					 * motherboard.ports->includes(p.requiredPort)
					 */
					final /*@NonInvalid*/ Motherboard motherboard = this.getMotherboard();
					final /*@NonInvalid*/ List<PortType> ports = motherboard.getPorts();
					final /*@NonInvalid*/ SetValue BOXED_ports = idResolver.createSetOfAll(ComputerTables.SET_ENUMid_PortType, ports);
					final /*@NonInvalid*/ PortType requiredPort = p.getRequiredPort();
					final /*@NonInvalid*/ EnumerationLiteralId BOXED_requiredPort = ComputerTables.ENUMid_PortType.getEnumerationLiteralId(ClassUtil.nonNullState(requiredPort.getName()));
					final /*@NonInvalid*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ports, BOXED_requiredPort).booleanValue();
					//
					if (!includes) {					// Normal unsuccessful body evaluation result
						status = ValueUtil.FALSE_VALUE;
						break;														// Stop immediately
					}
					else if (includes) {				// Normal successful body evaluation result
						;															// Carry on
					}
					else {															// Impossible badly typed result
						accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
					}
				}
				final /*@NonInvalid*/ boolean eq = status == Boolean.TRUE;
				/*@NonInvalid*/ Object IF_eq;
				if (eq) {
					IF_eq = ValueUtil.TRUE_VALUE;
				}
				else {
					final /*@NonInvalid*/ TupleValue TUP_ = ValueUtil.createTupleOfEach(ComputerTables.TUPLid_, ComputerTables.STR_Motherboard_32_does_32_not_32_expose_32_a_32_port_32_for_32_every_32_connected_32_periphera, status);
					IF_eq = TUP_;
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, IF_eq, ComputerTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic(constraintName, this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean MotherboardProcessorCompatible(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final String constraintName = "Computer::MotherboardProcessorCompatible";
		try {
			/**
			 *
			 * inv MotherboardProcessorCompatible:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : OclAny[1] = let status : Boolean[1] = motherboard.socket = processor.socket
			 *         in
			 *           if status = true
			 *           then true
			 *           else
			 *             Tuple{message = 'Processor socket ' +
			 *               processor.socket.toString() + ' does not match motherboard socket ' +
			 *               motherboard.socket.toString(), status = status
			 *             }
			 *           endif
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, ComputerPackage.Literals.COMPUTER___MOTHERBOARD_PROCESSOR_COMPATIBLE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, ComputerTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				final /*@NonInvalid*/ Motherboard motherboard = this.getMotherboard();
				final /*@NonInvalid*/ Processor processor = this.getProcessor();
				final /*@NonInvalid*/ CPUSocket socket = motherboard.getSocket();
				final /*@NonInvalid*/ CPUSocket socket_0 = processor.getSocket();
				final /*@NonInvalid*/ boolean status = socket.equals(socket_0);
				/*@NonInvalid*/ Object IF_status;
				if (status) {
					IF_status = ValueUtil.TRUE_VALUE;
				}
				else {
					final /*@NonInvalid*/ EnumerationLiteralId BOXED_socket_1 = ComputerTables.ENUMid_CPUSocket.getEnumerationLiteralId(ClassUtil.nonNullState(socket_0.getName()));
					final /*@NonInvalid*/ String toString = OclAnyToStringOperation.INSTANCE.evaluate(BOXED_socket_1);
					final /*@NonInvalid*/ String sum = StringConcatOperation.INSTANCE.evaluate(ComputerTables.STR_Processor_32_socket_32, toString);
					final /*@NonInvalid*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, ComputerTables.STR__32_does_32_not_32_match_32_motherboard_32_socket_32);
					final /*@NonInvalid*/ EnumerationLiteralId BOXED_socket_2 = ComputerTables.ENUMid_CPUSocket.getEnumerationLiteralId(ClassUtil.nonNullState(socket.getName()));
					final /*@NonInvalid*/ String toString_0 = OclAnyToStringOperation.INSTANCE.evaluate(BOXED_socket_2);
					final /*@NonInvalid*/ String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, toString_0);
					final /*@NonInvalid*/ TupleValue TUP_ = ValueUtil.createTupleOfEach(ComputerTables.TUPLid_, sum_1, status);
					IF_status = TUP_;
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, IF_status, ComputerTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic(constraintName, this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComputerPackage.COMPUTER__MOTHERBOARD:
				return basicSetMotherboard(null, msgs);
			case ComputerPackage.COMPUTER__PROCESSOR:
				return basicSetProcessor(null, msgs);
			case ComputerPackage.COMPUTER__GRAPHICS_CARD:
				return basicSetGraphicsCard(null, msgs);
			case ComputerPackage.COMPUTER__MEMORY:
				return ((InternalEList<?>)getMemory()).basicRemove(otherEnd, msgs);
			case ComputerPackage.COMPUTER__HARD_DISKS:
				return ((InternalEList<?>)getHardDisks()).basicRemove(otherEnd, msgs);
			case ComputerPackage.COMPUTER__CD_DRIVE:
				return basicSetCdDrive(null, msgs);
			case ComputerPackage.COMPUTER__PERIPHERALS:
				return ((InternalEList<?>)getPeripherals()).basicRemove(otherEnd, msgs);
			case ComputerPackage.COMPUTER__POWER_SUPPLY:
				return basicSetPowerSupply(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComputerPackage.COMPUTER__MOTHERBOARD:
				return getMotherboard();
			case ComputerPackage.COMPUTER__PROCESSOR:
				return getProcessor();
			case ComputerPackage.COMPUTER__GRAPHICS_CARD:
				return getGraphicsCard();
			case ComputerPackage.COMPUTER__MEMORY:
				return getMemory();
			case ComputerPackage.COMPUTER__HARD_DISKS:
				return getHardDisks();
			case ComputerPackage.COMPUTER__CD_DRIVE:
				return getCdDrive();
			case ComputerPackage.COMPUTER__PERIPHERALS:
				return getPeripherals();
			case ComputerPackage.COMPUTER__POWER_SUPPLY:
				return getPowerSupply();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComputerPackage.COMPUTER__MOTHERBOARD:
				setMotherboard((Motherboard)newValue);
				return;
			case ComputerPackage.COMPUTER__PROCESSOR:
				setProcessor((Processor)newValue);
				return;
			case ComputerPackage.COMPUTER__GRAPHICS_CARD:
				setGraphicsCard((GraphicsCard)newValue);
				return;
			case ComputerPackage.COMPUTER__MEMORY:
				getMemory().clear();
				getMemory().addAll((Collection<? extends Memory>)newValue);
				return;
			case ComputerPackage.COMPUTER__HARD_DISKS:
				getHardDisks().clear();
				getHardDisks().addAll((Collection<? extends HardDisk>)newValue);
				return;
			case ComputerPackage.COMPUTER__CD_DRIVE:
				setCdDrive((CDDrive)newValue);
				return;
			case ComputerPackage.COMPUTER__PERIPHERALS:
				getPeripherals().clear();
				getPeripherals().addAll((Collection<? extends Peripheral>)newValue);
				return;
			case ComputerPackage.COMPUTER__POWER_SUPPLY:
				setPowerSupply((PowerSupply)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ComputerPackage.COMPUTER__MOTHERBOARD:
				setMotherboard((Motherboard)null);
				return;
			case ComputerPackage.COMPUTER__PROCESSOR:
				setProcessor((Processor)null);
				return;
			case ComputerPackage.COMPUTER__GRAPHICS_CARD:
				setGraphicsCard((GraphicsCard)null);
				return;
			case ComputerPackage.COMPUTER__MEMORY:
				getMemory().clear();
				return;
			case ComputerPackage.COMPUTER__HARD_DISKS:
				getHardDisks().clear();
				return;
			case ComputerPackage.COMPUTER__CD_DRIVE:
				setCdDrive((CDDrive)null);
				return;
			case ComputerPackage.COMPUTER__PERIPHERALS:
				getPeripherals().clear();
				return;
			case ComputerPackage.COMPUTER__POWER_SUPPLY:
				setPowerSupply((PowerSupply)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ComputerPackage.COMPUTER__MOTHERBOARD:
				return motherboard != null;
			case ComputerPackage.COMPUTER__PROCESSOR:
				return processor != null;
			case ComputerPackage.COMPUTER__GRAPHICS_CARD:
				return graphicsCard != null;
			case ComputerPackage.COMPUTER__MEMORY:
				return memory != null && !memory.isEmpty();
			case ComputerPackage.COMPUTER__HARD_DISKS:
				return hardDisks != null && !hardDisks.isEmpty();
			case ComputerPackage.COMPUTER__CD_DRIVE:
				return cdDrive != null;
			case ComputerPackage.COMPUTER__PERIPHERALS:
				return peripherals != null && !peripherals.isEmpty();
			case ComputerPackage.COMPUTER__POWER_SUPPLY:
				return powerSupply != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ComputerPackage.COMPUTER___POWER_SUPPLY_CAPACITY_SUFFICIENT__DIAGNOSTICCHAIN_MAP:
				return PowerSupplyCapacitySufficient((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ComputerPackage.COMPUTER___PERIPHERAL_PORTS_AVAILABLE__DIAGNOSTICCHAIN_MAP:
				return PeripheralPortsAvailable((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ComputerPackage.COMPUTER___MOTHERBOARD_PROCESSOR_COMPATIBLE__DIAGNOSTICCHAIN_MAP:
				return MotherboardProcessorCompatible((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ComputerImpl
