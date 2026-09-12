/**
 */
package computer.impl;

import computer.ComputerPackage;
import computer.GraphicsCard;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graphics Card</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link computer.impl.GraphicsCardImpl#getModel <em>Model</em>}</li>
 *   <li>{@link computer.impl.GraphicsCardImpl#getVramGB <em>Vram GB</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphicsCardImpl extends ComponentImpl implements GraphicsCard {
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
	 * The default value of the '{@link #getVramGB() <em>Vram GB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVramGB()
	 * @generated
	 * @ordered
	 */
	protected static final int VRAM_GB_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVramGB() <em>Vram GB</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVramGB()
	 * @generated
	 * @ordered
	 */
	protected int vramGB = VRAM_GB_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicsCardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputerPackage.Literals.GRAPHICS_CARD;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.GRAPHICS_CARD__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getVramGB() {
		return vramGB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVramGB(int newVramGB) {
		int oldVramGB = vramGB;
		vramGB = newVramGB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputerPackage.GRAPHICS_CARD__VRAM_GB, oldVramGB, vramGB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComputerPackage.GRAPHICS_CARD__MODEL:
				return getModel();
			case ComputerPackage.GRAPHICS_CARD__VRAM_GB:
				return getVramGB();
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
			case ComputerPackage.GRAPHICS_CARD__MODEL:
				setModel((String)newValue);
				return;
			case ComputerPackage.GRAPHICS_CARD__VRAM_GB:
				setVramGB((Integer)newValue);
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
			case ComputerPackage.GRAPHICS_CARD__MODEL:
				setModel(MODEL_EDEFAULT);
				return;
			case ComputerPackage.GRAPHICS_CARD__VRAM_GB:
				setVramGB(VRAM_GB_EDEFAULT);
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
			case ComputerPackage.GRAPHICS_CARD__MODEL:
				return MODEL_EDEFAULT == null ? model != null : !MODEL_EDEFAULT.equals(model);
			case ComputerPackage.GRAPHICS_CARD__VRAM_GB:
				return vramGB != VRAM_GB_EDEFAULT;
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
		result.append(", vramGB: ");
		result.append(vramGB);
		result.append(')');
		return result.toString();
	}

} //GraphicsCardImpl
