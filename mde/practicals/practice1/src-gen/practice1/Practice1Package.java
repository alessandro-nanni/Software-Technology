/**
 */
package practice1;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see practice1.Practice1Factory
 * @model kind="package"
 * @generated
 */
public interface Practice1Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "practice1";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/practice1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "practice1";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Practice1Package eINSTANCE = practice1.impl.Practice1PackageImpl.init();

	/**
	 * The meta object id for the '{@link practice1.impl.QueryImpl <em>Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.impl.QueryImpl
	 * @see practice1.impl.Practice1PackageImpl#getQuery()
	 * @generated
	 */
	int QUERY = 0;

	/**
	 * The number of structural features of the '<em>Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link practice1.impl.SelectImpl <em>Select</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.impl.SelectImpl
	 * @see practice1.impl.Practice1PackageImpl#getSelect()
	 * @generated
	 */
	int SELECT = 1;

	/**
	 * The feature id for the '<em><b>Selections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__SELECTIONS = QUERY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__TABLES = QUERY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__CONDITION = QUERY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Select</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_FEATURE_COUNT = QUERY_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Select</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_OPERATION_COUNT = QUERY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link practice1.impl.UnionImpl <em>Union</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.impl.UnionImpl
	 * @see practice1.impl.Practice1PackageImpl#getUnion()
	 * @generated
	 */
	int UNION = 2;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION__LEFT = QUERY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION__RIGHT = QUERY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Union</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_FEATURE_COUNT = QUERY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Union</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNION_OPERATION_COUNT = QUERY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link practice1.impl.SelectionImpl <em>Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.impl.SelectionImpl
	 * @see practice1.impl.Practice1PackageImpl#getSelection()
	 * @generated
	 */
	int SELECTION = 3;

	/**
	 * The number of structural features of the '<em>Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link practice1.impl.TableReferenceImpl <em>Table Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.impl.TableReferenceImpl
	 * @see practice1.impl.Practice1PackageImpl#getTableReference()
	 * @generated
	 */
	int TABLE_REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_REFERENCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_REFERENCE__ALIAS = 1;

	/**
	 * The number of structural features of the '<em>Table Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_REFERENCE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Table Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link practice1.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.impl.ConditionImpl
	 * @see practice1.impl.Practice1PackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 5;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link practice1.impl.ColumnSelectionImpl <em>Column Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.impl.ColumnSelectionImpl
	 * @see practice1.impl.Practice1PackageImpl#getColumnSelection()
	 * @generated
	 */
	int COLUMN_SELECTION = 6;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_SELECTION__ATTRIBUTE = SELECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_SELECTION__ALIAS = SELECTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_SELECTION__TABLE = SELECTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Column Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_SELECTION_FEATURE_COUNT = SELECTION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Column Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_SELECTION_OPERATION_COUNT = SELECTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link practice1.impl.AllColumnsSelectionImpl <em>All Columns Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.impl.AllColumnsSelectionImpl
	 * @see practice1.impl.Practice1PackageImpl#getAllColumnsSelection()
	 * @generated
	 */
	int ALL_COLUMNS_SELECTION = 7;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_COLUMNS_SELECTION__TABLE = SELECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>All Columns Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_COLUMNS_SELECTION_FEATURE_COUNT = SELECTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>All Columns Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_COLUMNS_SELECTION_OPERATION_COUNT = SELECTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link practice1.impl.ComparisonImpl <em>Comparison</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.impl.ComparisonImpl
	 * @see practice1.impl.Practice1PackageImpl#getComparison()
	 * @generated
	 */
	int COMPARISON = 8;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON__LEFT = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON__RIGHT = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON__OPERATOR = CONDITION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Comparison</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Comparison</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARISON_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link practice1.impl.ANDImpl <em>AND</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.impl.ANDImpl
	 * @see practice1.impl.Practice1PackageImpl#getAND()
	 * @generated
	 */
	int AND = 9;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__LEFT = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__RIGHT = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>AND</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>AND</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link practice1.impl.ORImpl <em>OR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.impl.ORImpl
	 * @see practice1.impl.Practice1PackageImpl#getOR()
	 * @generated
	 */
	int OR = 10;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__LEFT = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__RIGHT = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>OR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>OR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link practice1.impl.NOTImpl <em>NOT</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.impl.NOTImpl
	 * @see practice1.impl.Practice1PackageImpl#getNOT()
	 * @generated
	 */
	int NOT = 11;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__CONDITION = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>NOT</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>NOT</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link practice1.impl.EXISTImpl <em>EXIST</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.impl.EXISTImpl
	 * @see practice1.impl.Practice1PackageImpl#getEXIST()
	 * @generated
	 */
	int EXIST = 12;

	/**
	 * The feature id for the '<em><b>Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIST__QUERY = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EXIST</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIST_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>EXIST</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIST_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link practice1.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.impl.ValueImpl
	 * @see practice1.impl.Practice1PackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 13;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link practice1.impl.AttributeReferenceImpl <em>Attribute Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.impl.AttributeReferenceImpl
	 * @see practice1.impl.Practice1PackageImpl#getAttributeReference()
	 * @generated
	 */
	int ATTRIBUTE_REFERENCE = 14;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_REFERENCE__ATTRIBUTE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_REFERENCE__TABLE = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_REFERENCE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_REFERENCE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link practice1.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.impl.LiteralImpl
	 * @see practice1.impl.Practice1PackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 15;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link practice1.ComparisonOp <em>Comparison Op</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see practice1.ComparisonOp
	 * @see practice1.impl.Practice1PackageImpl#getComparisonOp()
	 * @generated
	 */
	int COMPARISON_OP = 16;

	/**
	 * Returns the meta object for class '{@link practice1.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query</em>'.
	 * @see practice1.Query
	 * @generated
	 */
	EClass getQuery();

	/**
	 * Returns the meta object for class '{@link practice1.Select <em>Select</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select</em>'.
	 * @see practice1.Select
	 * @generated
	 */
	EClass getSelect();

	/**
	 * Returns the meta object for the containment reference list '{@link practice1.Select#getSelections <em>Selections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Selections</em>'.
	 * @see practice1.Select#getSelections()
	 * @see #getSelect()
	 * @generated
	 */
	EReference getSelect_Selections();

	/**
	 * Returns the meta object for the containment reference list '{@link practice1.Select#getTables <em>Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tables</em>'.
	 * @see practice1.Select#getTables()
	 * @see #getSelect()
	 * @generated
	 */
	EReference getSelect_Tables();

	/**
	 * Returns the meta object for the containment reference '{@link practice1.Select#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see practice1.Select#getCondition()
	 * @see #getSelect()
	 * @generated
	 */
	EReference getSelect_Condition();

	/**
	 * Returns the meta object for class '{@link practice1.Union <em>Union</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Union</em>'.
	 * @see practice1.Union
	 * @generated
	 */
	EClass getUnion();

	/**
	 * Returns the meta object for the containment reference '{@link practice1.Union#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see practice1.Union#getLeft()
	 * @see #getUnion()
	 * @generated
	 */
	EReference getUnion_Left();

	/**
	 * Returns the meta object for the containment reference '{@link practice1.Union#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see practice1.Union#getRight()
	 * @see #getUnion()
	 * @generated
	 */
	EReference getUnion_Right();

	/**
	 * Returns the meta object for class '{@link practice1.Selection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection</em>'.
	 * @see practice1.Selection
	 * @generated
	 */
	EClass getSelection();

	/**
	 * Returns the meta object for class '{@link practice1.TableReference <em>Table Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table Reference</em>'.
	 * @see practice1.TableReference
	 * @generated
	 */
	EClass getTableReference();

	/**
	 * Returns the meta object for the attribute '{@link practice1.TableReference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see practice1.TableReference#getName()
	 * @see #getTableReference()
	 * @generated
	 */
	EAttribute getTableReference_Name();

	/**
	 * Returns the meta object for the attribute '{@link practice1.TableReference#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see practice1.TableReference#getAlias()
	 * @see #getTableReference()
	 * @generated
	 */
	EAttribute getTableReference_Alias();

	/**
	 * Returns the meta object for class '{@link practice1.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see practice1.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for class '{@link practice1.ColumnSelection <em>Column Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Column Selection</em>'.
	 * @see practice1.ColumnSelection
	 * @generated
	 */
	EClass getColumnSelection();

	/**
	 * Returns the meta object for the attribute '{@link practice1.ColumnSelection#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute</em>'.
	 * @see practice1.ColumnSelection#getAttribute()
	 * @see #getColumnSelection()
	 * @generated
	 */
	EAttribute getColumnSelection_Attribute();

	/**
	 * Returns the meta object for the attribute '{@link practice1.ColumnSelection#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see practice1.ColumnSelection#getAlias()
	 * @see #getColumnSelection()
	 * @generated
	 */
	EAttribute getColumnSelection_Alias();

	/**
	 * Returns the meta object for the reference '{@link practice1.ColumnSelection#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see practice1.ColumnSelection#getTable()
	 * @see #getColumnSelection()
	 * @generated
	 */
	EReference getColumnSelection_Table();

	/**
	 * Returns the meta object for class '{@link practice1.AllColumnsSelection <em>All Columns Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All Columns Selection</em>'.
	 * @see practice1.AllColumnsSelection
	 * @generated
	 */
	EClass getAllColumnsSelection();

	/**
	 * Returns the meta object for the reference '{@link practice1.AllColumnsSelection#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see practice1.AllColumnsSelection#getTable()
	 * @see #getAllColumnsSelection()
	 * @generated
	 */
	EReference getAllColumnsSelection_Table();

	/**
	 * Returns the meta object for class '{@link practice1.Comparison <em>Comparison</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comparison</em>'.
	 * @see practice1.Comparison
	 * @generated
	 */
	EClass getComparison();

	/**
	 * Returns the meta object for the reference '{@link practice1.Comparison#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left</em>'.
	 * @see practice1.Comparison#getLeft()
	 * @see #getComparison()
	 * @generated
	 */
	EReference getComparison_Left();

	/**
	 * Returns the meta object for the reference '{@link practice1.Comparison#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right</em>'.
	 * @see practice1.Comparison#getRight()
	 * @see #getComparison()
	 * @generated
	 */
	EReference getComparison_Right();

	/**
	 * Returns the meta object for the attribute '{@link practice1.Comparison#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see practice1.Comparison#getOperator()
	 * @see #getComparison()
	 * @generated
	 */
	EAttribute getComparison_Operator();

	/**
	 * Returns the meta object for class '{@link practice1.AND <em>AND</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AND</em>'.
	 * @see practice1.AND
	 * @generated
	 */
	EClass getAND();

	/**
	 * Returns the meta object for the reference '{@link practice1.AND#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left</em>'.
	 * @see practice1.AND#getLeft()
	 * @see #getAND()
	 * @generated
	 */
	EReference getAND_Left();

	/**
	 * Returns the meta object for the reference '{@link practice1.AND#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right</em>'.
	 * @see practice1.AND#getRight()
	 * @see #getAND()
	 * @generated
	 */
	EReference getAND_Right();

	/**
	 * Returns the meta object for class '{@link practice1.OR <em>OR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OR</em>'.
	 * @see practice1.OR
	 * @generated
	 */
	EClass getOR();

	/**
	 * Returns the meta object for the reference '{@link practice1.OR#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left</em>'.
	 * @see practice1.OR#getLeft()
	 * @see #getOR()
	 * @generated
	 */
	EReference getOR_Left();

	/**
	 * Returns the meta object for the reference '{@link practice1.OR#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right</em>'.
	 * @see practice1.OR#getRight()
	 * @see #getOR()
	 * @generated
	 */
	EReference getOR_Right();

	/**
	 * Returns the meta object for class '{@link practice1.NOT <em>NOT</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NOT</em>'.
	 * @see practice1.NOT
	 * @generated
	 */
	EClass getNOT();

	/**
	 * Returns the meta object for the reference '{@link practice1.NOT#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see practice1.NOT#getCondition()
	 * @see #getNOT()
	 * @generated
	 */
	EReference getNOT_Condition();

	/**
	 * Returns the meta object for class '{@link practice1.EXIST <em>EXIST</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EXIST</em>'.
	 * @see practice1.EXIST
	 * @generated
	 */
	EClass getEXIST();

	/**
	 * Returns the meta object for the reference '{@link practice1.EXIST#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Query</em>'.
	 * @see practice1.EXIST#getQuery()
	 * @see #getEXIST()
	 * @generated
	 */
	EReference getEXIST_Query();

	/**
	 * Returns the meta object for class '{@link practice1.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see practice1.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for class '{@link practice1.AttributeReference <em>Attribute Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Reference</em>'.
	 * @see practice1.AttributeReference
	 * @generated
	 */
	EClass getAttributeReference();

	/**
	 * Returns the meta object for the attribute '{@link practice1.AttributeReference#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute</em>'.
	 * @see practice1.AttributeReference#getAttribute()
	 * @see #getAttributeReference()
	 * @generated
	 */
	EAttribute getAttributeReference_Attribute();

	/**
	 * Returns the meta object for the reference '{@link practice1.AttributeReference#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see practice1.AttributeReference#getTable()
	 * @see #getAttributeReference()
	 * @generated
	 */
	EReference getAttributeReference_Table();

	/**
	 * Returns the meta object for class '{@link practice1.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see practice1.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for the attribute '{@link practice1.Literal#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see practice1.Literal#getValue()
	 * @see #getLiteral()
	 * @generated
	 */
	EAttribute getLiteral_Value();

	/**
	 * Returns the meta object for enum '{@link practice1.ComparisonOp <em>Comparison Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Comparison Op</em>'.
	 * @see practice1.ComparisonOp
	 * @generated
	 */
	EEnum getComparisonOp();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Practice1Factory getPractice1Factory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link practice1.impl.QueryImpl <em>Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.impl.QueryImpl
		 * @see practice1.impl.Practice1PackageImpl#getQuery()
		 * @generated
		 */
		EClass QUERY = eINSTANCE.getQuery();

		/**
		 * The meta object literal for the '{@link practice1.impl.SelectImpl <em>Select</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.impl.SelectImpl
		 * @see practice1.impl.Practice1PackageImpl#getSelect()
		 * @generated
		 */
		EClass SELECT = eINSTANCE.getSelect();

		/**
		 * The meta object literal for the '<em><b>Selections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT__SELECTIONS = eINSTANCE.getSelect_Selections();

		/**
		 * The meta object literal for the '<em><b>Tables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT__TABLES = eINSTANCE.getSelect_Tables();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT__CONDITION = eINSTANCE.getSelect_Condition();

		/**
		 * The meta object literal for the '{@link practice1.impl.UnionImpl <em>Union</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.impl.UnionImpl
		 * @see practice1.impl.Practice1PackageImpl#getUnion()
		 * @generated
		 */
		EClass UNION = eINSTANCE.getUnion();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNION__LEFT = eINSTANCE.getUnion_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNION__RIGHT = eINSTANCE.getUnion_Right();

		/**
		 * The meta object literal for the '{@link practice1.impl.SelectionImpl <em>Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.impl.SelectionImpl
		 * @see practice1.impl.Practice1PackageImpl#getSelection()
		 * @generated
		 */
		EClass SELECTION = eINSTANCE.getSelection();

		/**
		 * The meta object literal for the '{@link practice1.impl.TableReferenceImpl <em>Table Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.impl.TableReferenceImpl
		 * @see practice1.impl.Practice1PackageImpl#getTableReference()
		 * @generated
		 */
		EClass TABLE_REFERENCE = eINSTANCE.getTableReference();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_REFERENCE__NAME = eINSTANCE.getTableReference_Name();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_REFERENCE__ALIAS = eINSTANCE.getTableReference_Alias();

		/**
		 * The meta object literal for the '{@link practice1.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.impl.ConditionImpl
		 * @see practice1.impl.Practice1PackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '{@link practice1.impl.ColumnSelectionImpl <em>Column Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.impl.ColumnSelectionImpl
		 * @see practice1.impl.Practice1PackageImpl#getColumnSelection()
		 * @generated
		 */
		EClass COLUMN_SELECTION = eINSTANCE.getColumnSelection();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN_SELECTION__ATTRIBUTE = eINSTANCE.getColumnSelection_Attribute();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN_SELECTION__ALIAS = eINSTANCE.getColumnSelection_Alias();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN_SELECTION__TABLE = eINSTANCE.getColumnSelection_Table();

		/**
		 * The meta object literal for the '{@link practice1.impl.AllColumnsSelectionImpl <em>All Columns Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.impl.AllColumnsSelectionImpl
		 * @see practice1.impl.Practice1PackageImpl#getAllColumnsSelection()
		 * @generated
		 */
		EClass ALL_COLUMNS_SELECTION = eINSTANCE.getAllColumnsSelection();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALL_COLUMNS_SELECTION__TABLE = eINSTANCE.getAllColumnsSelection_Table();

		/**
		 * The meta object literal for the '{@link practice1.impl.ComparisonImpl <em>Comparison</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.impl.ComparisonImpl
		 * @see practice1.impl.Practice1PackageImpl#getComparison()
		 * @generated
		 */
		EClass COMPARISON = eINSTANCE.getComparison();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARISON__LEFT = eINSTANCE.getComparison_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARISON__RIGHT = eINSTANCE.getComparison_Right();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARISON__OPERATOR = eINSTANCE.getComparison_Operator();

		/**
		 * The meta object literal for the '{@link practice1.impl.ANDImpl <em>AND</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.impl.ANDImpl
		 * @see practice1.impl.Practice1PackageImpl#getAND()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAND();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AND__LEFT = eINSTANCE.getAND_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AND__RIGHT = eINSTANCE.getAND_Right();

		/**
		 * The meta object literal for the '{@link practice1.impl.ORImpl <em>OR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.impl.ORImpl
		 * @see practice1.impl.Practice1PackageImpl#getOR()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOR();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OR__LEFT = eINSTANCE.getOR_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OR__RIGHT = eINSTANCE.getOR_Right();

		/**
		 * The meta object literal for the '{@link practice1.impl.NOTImpl <em>NOT</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.impl.NOTImpl
		 * @see practice1.impl.Practice1PackageImpl#getNOT()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNOT();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT__CONDITION = eINSTANCE.getNOT_Condition();

		/**
		 * The meta object literal for the '{@link practice1.impl.EXISTImpl <em>EXIST</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.impl.EXISTImpl
		 * @see practice1.impl.Practice1PackageImpl#getEXIST()
		 * @generated
		 */
		EClass EXIST = eINSTANCE.getEXIST();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXIST__QUERY = eINSTANCE.getEXIST_Query();

		/**
		 * The meta object literal for the '{@link practice1.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.impl.ValueImpl
		 * @see practice1.impl.Practice1PackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '{@link practice1.impl.AttributeReferenceImpl <em>Attribute Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.impl.AttributeReferenceImpl
		 * @see practice1.impl.Practice1PackageImpl#getAttributeReference()
		 * @generated
		 */
		EClass ATTRIBUTE_REFERENCE = eINSTANCE.getAttributeReference();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_REFERENCE__ATTRIBUTE = eINSTANCE.getAttributeReference_Attribute();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_REFERENCE__TABLE = eINSTANCE.getAttributeReference_Table();

		/**
		 * The meta object literal for the '{@link practice1.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.impl.LiteralImpl
		 * @see practice1.impl.Practice1PackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL__VALUE = eINSTANCE.getLiteral_Value();

		/**
		 * The meta object literal for the '{@link practice1.ComparisonOp <em>Comparison Op</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see practice1.ComparisonOp
		 * @see practice1.impl.Practice1PackageImpl#getComparisonOp()
		 * @generated
		 */
		EEnum COMPARISON_OP = eINSTANCE.getComparisonOp();

	}

} //Practice1Package
