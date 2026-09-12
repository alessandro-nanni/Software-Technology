/**
 */
package computer.impl;

import computer.ComputerPackage;
import computer.Memory;
import computer.MemoryType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Memory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link computer.impl.MemoryImpl#getType <em>Type</em>}</li>
 *   <li>{@link computer.impl.MemoryImpl#getCapacityGB <em>Capacity GB</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MemoryImpl extends ComponentImpl implements Memory {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final MemoryType TYPE_EDEFAULT = MemoryType.DDR4;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected MemoryType type = TYPE_EDEFAULT;

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
	protected MemoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputerPackage.Literals.MEMORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MemoryType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(MemoryType newType) {
		MemoryType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.MEMORY__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.MEMORY__CAPACITY_GB, oldCapacityGB, capacityGB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComputerPackage.MEMORY__TYPE:
				return getType();
			case ComputerPackage.MEMORY__CAPACITY_GB:
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
			case ComputerPackage.MEMORY__TYPE:
				setType((MemoryType)newValue);
				return;
			case ComputerPackage.MEMORY__CAPACITY_GB:
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
			case ComputerPackage.MEMORY__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ComputerPackage.MEMORY__CAPACITY_GB:
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
			case ComputerPackage.MEMORY__TYPE:
				return type != TYPE_EDEFAULT;
			case ComputerPackage.MEMORY__CAPACITY_GB:
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

} //MemoryImpl
