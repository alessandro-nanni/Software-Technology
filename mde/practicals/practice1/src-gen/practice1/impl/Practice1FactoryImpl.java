/**
 */
package practice1.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import practice1.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Practice1FactoryImpl extends EFactoryImpl implements Practice1Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Practice1Factory init() {
		try {
			Practice1Factory thePractice1Factory = (Practice1Factory) EPackage.Registry.INSTANCE
					.getEFactory(Practice1Package.eNS_URI);
			if (thePractice1Factory != null) {
				return thePractice1Factory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Practice1FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Practice1FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case Practice1Package.SELECT:
			return createSelect();
		case Practice1Package.UNION:
			return createUnion();
		case Practice1Package.TABLE_REFERENCE:
			return createTableReference();
		case Practice1Package.COLUMN_SELECTION:
			return createColumnSelection();
		case Practice1Package.ALL_COLUMNS_SELECTION:
			return createAllColumnsSelection();
		case Practice1Package.COMPARISON:
			return createComparison();
		case Practice1Package.AND:
			return createAND();
		case Practice1Package.OR:
			return createOR();
		case Practice1Package.NOT:
			return createNOT();
		case Practice1Package.EXIST:
			return createEXIST();
		case Practice1Package.ATTRIBUTE_REFERENCE:
			return createAttributeReference();
		case Practice1Package.LITERAL:
			return createLiteral();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case Practice1Package.COMPARISON_OP:
			return createComparisonOpFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case Practice1Package.COMPARISON_OP:
			return convertComparisonOpToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Select createSelect() {
		SelectImpl select = new SelectImpl();
		return select;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Union createUnion() {
		UnionImpl union = new UnionImpl();
		return union;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TableReference createTableReference() {
		TableReferenceImpl tableReference = new TableReferenceImpl();
		return tableReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ColumnSelection createColumnSelection() {
		ColumnSelectionImpl columnSelection = new ColumnSelectionImpl();
		return columnSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AllColumnsSelection createAllColumnsSelection() {
		AllColumnsSelectionImpl allColumnsSelection = new AllColumnsSelectionImpl();
		return allColumnsSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Comparison createComparison() {
		ComparisonImpl comparison = new ComparisonImpl();
		return comparison;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AND createAND() {
		ANDImpl and = new ANDImpl();
		return and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OR createOR() {
		ORImpl or = new ORImpl();
		return or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NOT createNOT() {
		NOTImpl not = new NOTImpl();
		return not;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EXIST createEXIST() {
		EXISTImpl exist = new EXISTImpl();
		return exist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeReference createAttributeReference() {
		AttributeReferenceImpl attributeReference = new AttributeReferenceImpl();
		return attributeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Literal createLiteral() {
		LiteralImpl literal = new LiteralImpl();
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComparisonOp createComparisonOpFromString(EDataType eDataType, String initialValue) {
		ComparisonOp result = ComparisonOp.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertComparisonOpToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Practice1Package getPractice1Package() {
		return (Practice1Package) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Practice1Package getPackage() {
		return Practice1Package.eINSTANCE;
	}

} //Practice1FactoryImpl
