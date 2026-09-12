/**
 */
package computer.impl;

import computer.ComputerPackage;
import computer.Efficiency;
import computer.PowerSupply;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Power Supply</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link computer.impl.PowerSupplyImpl#getCapacityWatts <em>Capacity Watts</em>}</li>
 *   <li>{@link computer.impl.PowerSupplyImpl#getEfficiency <em>Efficiency</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PowerSupplyImpl extends MinimalEObjectImpl.Container implements PowerSupply {
	/**
	 * The default value of the '{@link #getCapacityWatts() <em>Capacity Watts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacityWatts()
	 * @generated
	 * @ordered
	 */
	protected static final int CAPACITY_WATTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCapacityWatts() <em>Capacity Watts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacityWatts()
	 * @generated
	 * @ordered
	 */
	protected int capacityWatts = CAPACITY_WATTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getEfficiency() <em>Efficiency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEfficiency()
	 * @generated
	 * @ordered
	 */
	protected static final Efficiency EFFICIENCY_EDEFAULT = Efficiency.BRONZE;

	/**
	 * The cached value of the '{@link #getEfficiency() <em>Efficiency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEfficiency()
	 * @generated
	 * @ordered
	 */
	protected Efficiency efficiency = EFFICIENCY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PowerSupplyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputerPackage.Literals.POWER_SUPPLY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCapacityWatts() {
		return capacityWatts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCapacityWatts(int newCapacityWatts) {
		int oldCapacityWatts = capacityWatts;
		capacityWatts = newCapacityWatts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.POWER_SUPPLY__CAPACITY_WATTS, oldCapacityWatts, capacityWatts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Efficiency getEfficiency() {
		return efficiency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEfficiency(Efficiency newEfficiency) {
		Efficiency oldEfficiency = efficiency;
		efficiency = newEfficiency == null ? EFFICIENCY_EDEFAULT : newEfficiency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.POWER_SUPPLY__EFFICIENCY, oldEfficiency, efficiency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComputerPackage.POWER_SUPPLY__CAPACITY_WATTS:
				return getCapacityWatts();
			case ComputerPackage.POWER_SUPPLY__EFFICIENCY:
				return getEfficiency();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComputerPackage.POWER_SUPPLY__CAPACITY_WATTS:
				setCapacityWatts((Integer)newValue);
				return;
			case ComputerPackage.POWER_SUPPLY__EFFICIENCY:
				setEfficiency((Efficiency)newValue);
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
			case ComputerPackage.POWER_SUPPLY__CAPACITY_WATTS:
				setCapacityWatts(CAPACITY_WATTS_EDEFAULT);
				return;
			case ComputerPackage.POWER_SUPPLY__EFFICIENCY:
				setEfficiency(EFFICIENCY_EDEFAULT);
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
			case ComputerPackage.POWER_SUPPLY__CAPACITY_WATTS:
				return capacityWatts != CAPACITY_WATTS_EDEFAULT;
			case ComputerPackage.POWER_SUPPLY__EFFICIENCY:
				return efficiency != EFFICIENCY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (capacityWatts: ");
		result.append(capacityWatts);
		result.append(", efficiency: ");
		result.append(efficiency);
		result.append(')');
		return result.toString();
	}

} //PowerSupplyImpl
