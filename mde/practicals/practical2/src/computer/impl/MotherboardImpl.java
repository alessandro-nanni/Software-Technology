/**
 */
package computer.impl;

import computer.CPUSocket;
import computer.ComputerPackage;
import computer.Motherboard;
import computer.MotherboardType;
import computer.PortType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Motherboard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link computer.impl.MotherboardImpl#getType <em>Type</em>}</li>
 *   <li>{@link computer.impl.MotherboardImpl#getChipset <em>Chipset</em>}</li>
 *   <li>{@link computer.impl.MotherboardImpl#getSocket <em>Socket</em>}</li>
 *   <li>{@link computer.impl.MotherboardImpl#getPorts <em>Ports</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MotherboardImpl extends ComponentImpl implements Motherboard {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final MotherboardType TYPE_EDEFAULT = MotherboardType.ATX;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected MotherboardType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getChipset() <em>Chipset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChipset()
	 * @generated
	 * @ordered
	 */
	protected static final String CHIPSET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChipset() <em>Chipset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChipset()
	 * @generated
	 * @ordered
	 */
	protected String chipset = CHIPSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getSocket() <em>Socket</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSocket()
	 * @generated
	 * @ordered
	 */
	protected static final CPUSocket SOCKET_EDEFAULT = CPUSocket.AM4;

	/**
	 * The cached value of the '{@link #getSocket() <em>Socket</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSocket()
	 * @generated
	 * @ordered
	 */
	protected CPUSocket socket = SOCKET_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<PortType> ports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MotherboardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputerPackage.Literals.MOTHERBOARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MotherboardType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(MotherboardType newType) {
		MotherboardType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.MOTHERBOARD__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getChipset() {
		return chipset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setChipset(String newChipset) {
		String oldChipset = chipset;
		chipset = newChipset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.MOTHERBOARD__CHIPSET, oldChipset, chipset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CPUSocket getSocket() {
		return socket;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSocket(CPUSocket newSocket) {
		CPUSocket oldSocket = socket;
		socket = newSocket == null ? SOCKET_EDEFAULT : newSocket;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.MOTHERBOARD__SOCKET, oldSocket, socket));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PortType> getPorts() {
		if (ports == null) {
			ports = new EDataTypeUniqueEList<PortType>(PortType.class, this, ComputerPackage.MOTHERBOARD__PORTS);
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComputerPackage.MOTHERBOARD__TYPE:
				return getType();
			case ComputerPackage.MOTHERBOARD__CHIPSET:
				return getChipset();
			case ComputerPackage.MOTHERBOARD__SOCKET:
				return getSocket();
			case ComputerPackage.MOTHERBOARD__PORTS:
				return getPorts();
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
			case ComputerPackage.MOTHERBOARD__TYPE:
				setType((MotherboardType)newValue);
				return;
			case ComputerPackage.MOTHERBOARD__CHIPSET:
				setChipset((String)newValue);
				return;
			case ComputerPackage.MOTHERBOARD__SOCKET:
				setSocket((CPUSocket)newValue);
				return;
			case ComputerPackage.MOTHERBOARD__PORTS:
				getPorts().clear();
				getPorts().addAll((Collection<? extends PortType>)newValue);
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
			case ComputerPackage.MOTHERBOARD__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ComputerPackage.MOTHERBOARD__CHIPSET:
				setChipset(CHIPSET_EDEFAULT);
				return;
			case ComputerPackage.MOTHERBOARD__SOCKET:
				setSocket(SOCKET_EDEFAULT);
				return;
			case ComputerPackage.MOTHERBOARD__PORTS:
				getPorts().clear();
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
			case ComputerPackage.MOTHERBOARD__TYPE:
				return type != TYPE_EDEFAULT;
			case ComputerPackage.MOTHERBOARD__CHIPSET:
				return CHIPSET_EDEFAULT == null ? chipset != null : !CHIPSET_EDEFAULT.equals(chipset);
			case ComputerPackage.MOTHERBOARD__SOCKET:
				return socket != SOCKET_EDEFAULT;
			case ComputerPackage.MOTHERBOARD__PORTS:
				return ports != null && !ports.isEmpty();
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
		result.append(", chipset: ");
		result.append(chipset);
		result.append(", socket: ");
		result.append(socket);
		result.append(", ports: ");
		result.append(ports);
		result.append(')');
		return result.toString();
	}

} //MotherboardImpl
