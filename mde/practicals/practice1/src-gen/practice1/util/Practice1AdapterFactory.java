/**
 */
package practice1.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import practice1.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see practice1.Practice1Package
 * @generated
 */
public class Practice1AdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Practice1Package modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Practice1AdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Practice1Package.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Practice1Switch<Adapter> modelSwitch = new Practice1Switch<Adapter>() {
		@Override
		public Adapter caseQuery(Query object) {
			return createQueryAdapter();
		}

		@Override
		public Adapter caseSelect(Select object) {
			return createSelectAdapter();
		}

		@Override
		public Adapter caseUnion(Union object) {
			return createUnionAdapter();
		}

		@Override
		public Adapter caseSelection(Selection object) {
			return createSelectionAdapter();
		}

		@Override
		public Adapter caseTableReference(TableReference object) {
			return createTableReferenceAdapter();
		}

		@Override
		public Adapter caseCondition(Condition object) {
			return createConditionAdapter();
		}

		@Override
		public Adapter caseColumnSelection(ColumnSelection object) {
			return createColumnSelectionAdapter();
		}

		@Override
		public Adapter caseAllColumnsSelection(AllColumnsSelection object) {
			return createAllColumnsSelectionAdapter();
		}

		@Override
		public Adapter caseComparison(Comparison object) {
			return createComparisonAdapter();
		}

		@Override
		public Adapter caseAND(AND object) {
			return createANDAdapter();
		}

		@Override
		public Adapter caseOR(OR object) {
			return createORAdapter();
		}

		@Override
		public Adapter caseNOT(NOT object) {
			return createNOTAdapter();
		}

		@Override
		public Adapter caseEXIST(EXIST object) {
			return createEXISTAdapter();
		}

		@Override
		public Adapter caseValue(Value object) {
			return createValueAdapter();
		}

		@Override
		public Adapter caseAttributeReference(AttributeReference object) {
			return createAttributeReferenceAdapter();
		}

		@Override
		public Adapter caseLiteral(Literal object) {
			return createLiteralAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link practice1.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see practice1.Query
	 * @generated
	 */
	public Adapter createQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link practice1.Select <em>Select</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see practice1.Select
	 * @generated
	 */
	public Adapter createSelectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link practice1.Union <em>Union</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see practice1.Union
	 * @generated
	 */
	public Adapter createUnionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link practice1.Selection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see practice1.Selection
	 * @generated
	 */
	public Adapter createSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link practice1.TableReference <em>Table Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see practice1.TableReference
	 * @generated
	 */
	public Adapter createTableReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link practice1.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see practice1.Condition
	 * @generated
	 */
	public Adapter createConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link practice1.ColumnSelection <em>Column Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see practice1.ColumnSelection
	 * @generated
	 */
	public Adapter createColumnSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link practice1.AllColumnsSelection <em>All Columns Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see practice1.AllColumnsSelection
	 * @generated
	 */
	public Adapter createAllColumnsSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link practice1.Comparison <em>Comparison</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see practice1.Comparison
	 * @generated
	 */
	public Adapter createComparisonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link practice1.AND <em>AND</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see practice1.AND
	 * @generated
	 */
	public Adapter createANDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link practice1.OR <em>OR</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see practice1.OR
	 * @generated
	 */
	public Adapter createORAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link practice1.NOT <em>NOT</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see practice1.NOT
	 * @generated
	 */
	public Adapter createNOTAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link practice1.EXIST <em>EXIST</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see practice1.EXIST
	 * @generated
	 */
	public Adapter createEXISTAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link practice1.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see practice1.Value
	 * @generated
	 */
	public Adapter createValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link practice1.AttributeReference <em>Attribute Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see practice1.AttributeReference
	 * @generated
	 */
	public Adapter createAttributeReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link practice1.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see practice1.Literal
	 * @generated
	 */
	public Adapter createLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Practice1AdapterFactory
