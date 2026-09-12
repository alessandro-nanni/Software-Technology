/**
 */
package computer.impl;

import computer.CPUSocket;
import computer.ComputerPackage;
import computer.Processor;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Processor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link computer.impl.ProcessorImpl#getModel <em>Model</em>}</li>
 *   <li>{@link computer.impl.ProcessorImpl#getSocket <em>Socket</em>}</li>
 *   <li>{@link computer.impl.ProcessorImpl#getCores <em>Cores</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessorImpl extends ComponentImpl implements Processor {
	/**
	 * The default value of the '{@link #getModel() <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected String model = MODEL_EDEFAULT;

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
	 * The default value of the '{@link #getCores() <em>Cores</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCores()
	 * @generated
	 * @ordered
	 */
	protected static final int CORES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCores() <em>Cores</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCores()
	 * @generated
	 * @ordered
	 */
	protected int cores = CORES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputerPackage.Literals.PROCESSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModel(String newModel) {
		String oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.PROCESSOR__MODEL, oldModel, model));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.PROCESSOR__SOCKET, oldSocket, socket));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCores() {
		return cores;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCores(int newCores) {
		int oldCores = cores;
		cores = newCores;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.PROCESSOR__CORES, oldCores, cores));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComputerPackage.PROCESSOR__MODEL:
				return getModel();
			case ComputerPackage.PROCESSOR__SOCKET:
				return getSocket();
			case ComputerPackage.PROCESSOR__CORES:
				return getCores();
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
			case ComputerPackage.PROCESSOR__MODEL:
				setModel((String)newValue);
				return;
			case ComputerPackage.PROCESSOR__SOCKET:
				setSocket((CPUSocket)newValue);
				return;
			case ComputerPackage.PROCESSOR__CORES:
				setCores((Integer)newValue);
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
			case ComputerPackage.PROCESSOR__MODEL:
				setModel(MODEL_EDEFAULT);
				return;
			case ComputerPackage.PROCESSOR__SOCKET:
				setSocket(SOCKET_EDEFAULT);
				return;
			case ComputerPackage.PROCESSOR__CORES:
				setCores(CORES_EDEFAULT);
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
			case ComputerPackage.PROCESSOR__MODEL:
				return MODEL_EDEFAULT == null ? model != null : !MODEL_EDEFAULT.equals(model);
			case ComputerPackage.PROCESSOR__SOCKET:
				return socket != SOCKET_EDEFAULT;
			case ComputerPackage.PROCESSOR__CORES:
				return cores != CORES_EDEFAULT;
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
		result.append(" (model: ");
		result.append(model);
		result.append(", socket: ");
		result.append(socket);
		result.append(", cores: ");
		result.append(cores);
		result.append(')');
		return result.toString();
	}

} //ProcessorImpl
