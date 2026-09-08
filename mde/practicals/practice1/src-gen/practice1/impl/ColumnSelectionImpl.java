/**
 */
package practice1.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import practice1.ColumnSelection;
import practice1.Practice1Package;
import practice1.TableReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link practice1.impl.ColumnSelectionImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link practice1.impl.ColumnSelectionImpl#getAlias <em>Alias</em>}</li>
 *   <li>{@link practice1.impl.ColumnSelectionImpl#getTable <em>Table</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ColumnSelectionImpl extends SelectionImpl implements ColumnSelection {
	/**
	 * The default value of the '{@link #getAttribute() <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected String attribute = ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlias() <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String ALIAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlias() <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlias()
	 * @generated
	 * @ordered
	 */
	protected String alias = ALIAS_EDEFAULT;

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
	protected ColumnSelectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Practice1Package.Literals.COLUMN_SELECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAttribute(String newAttribute) {
		String oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Practice1Package.COLUMN_SELECTION__ATTRIBUTE,
					oldAttribute, attribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAlias() {
		return alias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAlias(String newAlias) {
		String oldAlias = alias;
		alias = newAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Practice1Package.COLUMN_SELECTION__ALIAS, oldAlias,
					alias));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Practice1Package.COLUMN_SELECTION__TABLE,
							oldTable, table));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Practice1Package.COLUMN_SELECTION__TABLE, oldTable,
					table));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Practice1Package.COLUMN_SELECTION__ATTRIBUTE:
			return getAttribute();
		case Practice1Package.COLUMN_SELECTION__ALIAS:
			return getAlias();
		case Practice1Package.COLUMN_SELECTION__TABLE:
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
		case Practice1Package.COLUMN_SELECTION__ATTRIBUTE:
			setAttribute((String) newValue);
			return;
		case Practice1Package.COLUMN_SELECTION__ALIAS:
			setAlias((String) newValue);
			return;
		case Practice1Package.COLUMN_SELECTION__TABLE:
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
		case Practice1Package.COLUMN_SELECTION__ATTRIBUTE:
			setAttribute(ATTRIBUTE_EDEFAULT);
			return;
		case Practice1Package.COLUMN_SELECTION__ALIAS:
			setAlias(ALIAS_EDEFAULT);
			return;
		case Practice1Package.COLUMN_SELECTION__TABLE:
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
		case Practice1Package.COLUMN_SELECTION__ATTRIBUTE:
			return ATTRIBUTE_EDEFAULT == null ? attribute != null : !ATTRIBUTE_EDEFAULT.equals(attribute);
		case Practice1Package.COLUMN_SELECTION__ALIAS:
			return ALIAS_EDEFAULT == null ? alias != null : !ALIAS_EDEFAULT.equals(alias);
		case Practice1Package.COLUMN_SELECTION__TABLE:
			return table != null;
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
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (attribute: ");
		result.append(attribute);
		result.append(", alias: ");
		result.append(alias);
		result.append(')');
		return result.toString();
	}

} //ColumnSelectionImpl
