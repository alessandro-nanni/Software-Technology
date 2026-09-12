/**
 */
package computer.impl;

import computer.ComputerPackage;
import computer.Peripheral;
import computer.PortType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Peripheral</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link computer.impl.PeripheralImpl#getRequiredPort <em>Required Port</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PeripheralImpl extends ComponentImpl implements Peripheral {
	/**
	 * The default value of the '{@link #getRequiredPort() <em>Required Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredPort()
	 * @generated
	 * @ordered
	 */
	protected static final PortType REQUIRED_PORT_EDEFAULT = PortType.USB;

	/**
	 * The cached value of the '{@link #getRequiredPort() <em>Required Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredPort()
	 * @generated
	 * @ordered
	 */
	protected PortType requiredPort = REQUIRED_PORT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PeripheralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputerPackage.Literals.PERIPHERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortType getRequiredPort() {
		return requiredPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequiredPort(PortType newRequiredPort) {
		PortType oldRequiredPort = requiredPort;
		requiredPort = newRequiredPort == null ? REQUIRED_PORT_EDEFAULT : newRequiredPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.PERIPHERAL__REQUIRED_PORT, oldRequiredPort, requiredPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComputerPackage.PERIPHERAL__REQUIRED_PORT:
				return getRequiredPort();
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
			case ComputerPackage.PERIPHERAL__REQUIRED_PORT:
				setRequiredPort((PortType)newValue);
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
			case ComputerPackage.PERIPHERAL__REQUIRED_PORT:
				setRequiredPort(REQUIRED_PORT_EDEFAULT);
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
			case ComputerPackage.PERIPHERAL__REQUIRED_PORT:
				return requiredPort != REQUIRED_PORT_EDEFAULT;
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
		result.append(" (requiredPort: ");
		result.append(requiredPort);
		result.append(')');
		return result.toString();
	}

} //PeripheralImpl
