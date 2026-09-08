/**
 */
package practice1.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import practice1.Condition;
import practice1.Practice1Package;
import practice1.Select;
import practice1.Selection;
import practice1.TableReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Select</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link practice1.impl.SelectImpl#getSelections <em>Selections</em>}</li>
 *   <li>{@link practice1.impl.SelectImpl#getTables <em>Tables</em>}</li>
 *   <li>{@link practice1.impl.SelectImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SelectImpl extends QueryImpl implements Select {
	/**
	 * The cached value of the '{@link #getSelections() <em>Selections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelections()
	 * @generated
	 * @ordered
	 */
	protected EList<Selection> selections;

	/**
	 * The cached value of the '{@link #getTables() <em>Tables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTables()
	 * @generated
	 * @ordered
	 */
	protected EList<TableReference> tables;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Condition condition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Practice1Package.Literals.SELECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Selection> getSelections() {
		if (selections == null) {
			selections = new EObjectContainmentEList<Selection>(Selection.class, this,
					Practice1Package.SELECT__SELECTIONS);
		}
		return selections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TableReference> getTables() {
		if (tables == null) {
			tables = new EObjectContainmentEList<TableReference>(TableReference.class, this,
					Practice1Package.SELECT__TABLES);
		}
		return tables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Condition getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(Condition newCondition, NotificationChain msgs) {
		Condition oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Practice1Package.SELECT__CONDITION, oldCondition, newCondition);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCondition(Condition newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject) condition).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Practice1Package.SELECT__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject) newCondition).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Practice1Package.SELECT__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Practice1Package.SELECT__CONDITION, newCondition,
					newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Practice1Package.SELECT__SELECTIONS:
			return ((InternalEList<?>) getSelections()).basicRemove(otherEnd, msgs);
		case Practice1Package.SELECT__TABLES:
			return ((InternalEList<?>) getTables()).basicRemove(otherEnd, msgs);
		case Practice1Package.SELECT__CONDITION:
			return basicSetCondition(null, msgs);
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
		case Practice1Package.SELECT__SELECTIONS:
			return getSelections();
		case Practice1Package.SELECT__TABLES:
			return getTables();
		case Practice1Package.SELECT__CONDITION:
			return getCondition();
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
		case Practice1Package.SELECT__SELECTIONS:
			getSelections().clear();
			getSelections().addAll((Collection<? extends Selection>) newValue);
			return;
		case Practice1Package.SELECT__TABLES:
			getTables().clear();
			getTables().addAll((Collection<? extends TableReference>) newValue);
			return;
		case Practice1Package.SELECT__CONDITION:
			setCondition((Condition) newValue);
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
		case Practice1Package.SELECT__SELECTIONS:
			getSelections().clear();
			return;
		case Practice1Package.SELECT__TABLES:
			getTables().clear();
			return;
		case Practice1Package.SELECT__CONDITION:
			setCondition((Condition) null);
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
		case Practice1Package.SELECT__SELECTIONS:
			return selections != null && !selections.isEmpty();
		case Practice1Package.SELECT__TABLES:
			return tables != null && !tables.isEmpty();
		case Practice1Package.SELECT__CONDITION:
			return condition != null;
		}
		return super.eIsSet(featureID);
	}

} //SelectImpl
