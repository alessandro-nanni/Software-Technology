/**
 */
package practice1.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import practice1.Practice1Factory;
import practice1.Practice1Package;

/**
 * This is the item provider adapter for a {@link practice1.Select} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SelectItemProvider extends QueryItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSelectionsPropertyDescriptor(object);
			addTablesPropertyDescriptor(object);
			addConditionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Selections feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSelectionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Select_selections_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Select_selections_feature",
								"_UI_Select_type"),
						Practice1Package.Literals.SELECT__SELECTIONS, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Tables feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTablesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Select_tables_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Select_tables_feature", "_UI_Select_type"),
						Practice1Package.Literals.SELECT__TABLES, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Condition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConditionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Select_condition_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Select_condition_feature",
								"_UI_Select_type"),
						Practice1Package.Literals.SELECT__CONDITION, true, false, true, null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(Practice1Package.Literals.SELECT__SELECTIONS);
			childrenFeatures.add(Practice1Package.Literals.SELECT__TABLES);
			childrenFeatures.add(Practice1Package.Literals.SELECT__CONDITION);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Select.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Select"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_Select_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(Practice1Package.Literals.SELECT__SELECTIONS,
				Practice1Factory.eINSTANCE.createColumnSelection()));

		newChildDescriptors.add(createChildParameter(Practice1Package.Literals.SELECT__SELECTIONS,
				Practice1Factory.eINSTANCE.createAllColumnsSelection()));

		newChildDescriptors.add(createChildParameter(Practice1Package.Literals.SELECT__TABLES,
				Practice1Factory.eINSTANCE.createTableReference()));

		newChildDescriptors.add(createChildParameter(Practice1Package.Literals.SELECT__CONDITION,
				Practice1Factory.eINSTANCE.createComparison()));

		newChildDescriptors.add(createChildParameter(Practice1Package.Literals.SELECT__CONDITION,
				Practice1Factory.eINSTANCE.createAND()));

		newChildDescriptors.add(createChildParameter(Practice1Package.Literals.SELECT__CONDITION,
				Practice1Factory.eINSTANCE.createOR()));

		newChildDescriptors.add(createChildParameter(Practice1Package.Literals.SELECT__CONDITION,
				Practice1Factory.eINSTANCE.createNOT()));

		newChildDescriptors.add(createChildParameter(Practice1Package.Literals.SELECT__CONDITION,
				Practice1Factory.eINSTANCE.createEXIST()));
	}

}
