/**
 */
package computer.impl;

import computer.ComputerPackage;
import computer.HardDisk;
import computer.StorageType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hard Disk</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link computer.impl.HardDiskImpl#getType <em>Type</em>}</li>
 *   <li>{@link computer.impl.HardDiskImpl#getCapacityGB <em>Capacity GB</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HardDiskImpl extends ComponentImpl implements HardDisk {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final StorageType TYPE_EDEFAULT = StorageType.HDD;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected StorageType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCapacityGB() <em>Capacity GB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacityGB()
	 * @generated
	 * @ordered
	 */
	protected static final int CAPACITY_GB_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCapacityGB() <em>Capacity GB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacityGB()
	 * @generated
	 * @ordered
	 */
	protected int capacityGB = CAPACITY_GB_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HardDiskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputerPackage.Literals.HARD_DISK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StorageType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(StorageType newType) {
		StorageType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.HARD_DISK__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCapacityGB() {
		return capacityGB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCapacityGB(int newCapacityGB) {
		int oldCapacityGB = capacityGB;
		capacityGB = newCapacityGB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.HARD_DISK__CAPACITY_GB, oldCapacityGB, capacityGB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComputerPackage.HARD_DISK__TYPE:
				return getType();
			case ComputerPackage.HARD_DISK__CAPACITY_GB:
				return getCapacityGB();
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
			case ComputerPackage.HARD_DISK__TYPE:
				setType((StorageType)newValue);
				return;
			case ComputerPackage.HARD_DISK__CAPACITY_GB:
				setCapacityGB((Integer)newValue);
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
			case ComputerPackage.HARD_DISK__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ComputerPackage.HARD_DISK__CAPACITY_GB:
				setCapacityGB(CAPACITY_GB_EDEFAULT);
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
			case ComputerPackage.HARD_DISK__TYPE:
				return type != TYPE_EDEFAULT;
			case ComputerPackage.HARD_DISK__CAPACITY_GB:
				return capacityGB != CAPACITY_GB_EDEFAULT;
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
		result.append(" (type: ");
		result.append(type);
		result.append(", capacityGB: ");
		result.append(capacityGB);
		result.append(')');
		return result.toString();
	}

} //HardDiskImpl
