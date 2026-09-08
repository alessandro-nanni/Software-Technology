/**
 */
package practice1.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import practice1.AllColumnsSelection;
import practice1.Practice1Package;
import practice1.TableReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>All Columns Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link practice1.impl.AllColumnsSelectionImpl#getTable <em>Table</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AllColumnsSelectionImpl extends SelectionImpl implements AllColumnsSelection {
	/**
	 * The cached value of the '{@link #getTable() <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTable()
	 * @generated
	 * @ordered
	 */
	protected TableReference table;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllColumnsSelectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Practice1Package.Literals.ALL_COLUMNS_SELECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TableReference getTable() {
		if (table != null && table.eIsProxy()) {
			InternalEObject oldTable = (InternalEObject) table;
			table = (TableReference) eResolveProxy(oldTable);
			if (table != oldTable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Practice1Package.ALL_COLUMNS_SELECTION__TABLE, oldTable, table));
			}
		}
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableReference basicGetTable() {
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTable(TableReference newTable) {
		TableReference oldTable = table;
		table = newTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Practice1Package.ALL_COLUMNS_SELECTION__TABLE,
					oldTable, table));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Practice1Package.ALL_COLUMNS_SELECTION__TABLE:
			if (resolve)
				return getTable();
			return basicGetTable();
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
		case Practice1Package.ALL_COLUMNS_SELECTION__TABLE:
			setTable((TableReference) newValue);
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
		case Practice1Package.ALL_COLUMNS_SELECTION__TABLE:
			setTable((TableReference) null);
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
		case Practice1Package.ALL_COLUMNS_SELECTION__TABLE:
			return table != null;
		}
		return super.eIsSet(featureID);
	}

} //AllColumnsSelectionImpl
