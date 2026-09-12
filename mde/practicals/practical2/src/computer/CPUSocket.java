/**
 */
package computer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>CPU Socket</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see computer.ComputerPackage#getCPUSocket()
 * @model
 * @generated
 */
public enum CPUSocket implements Enumerator {
	/**
	 * The '<em><b>AM4</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AM4_VALUE
	 * @generated
	 * @ordered
	 */
	AM4(0, "AM4", "AM4"),

	/**
	 * The '<em><b>AM5</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AM5_VALUE
	 * @generated
	 * @ordered
	 */
	AM5(1, "AM5", "AM5"),

	/**
	 * The '<em><b>LGA1200</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LGA1200_VALUE
	 * @generated
	 * @ordered
	 */
	LGA1200(2, "LGA1200", "LGA1200"),

	/**
	 * The '<em><b>LGA1700</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LGA1700_VALUE
	 * @generated
	 * @ordered
	 */
	LGA1700(3, "LGA1700", "LGA1700");

	/**
	 * The '<em><b>AM4</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AM4
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AM4_VALUE = 0;

	/**
	 * The '<em><b>AM5</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AM5
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AM5_VALUE = 1;

	/**
	 * The '<em><b>LGA1200</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LGA1200
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LGA1200_VALUE = 2;

	/**
	 * The '<em><b>LGA1700</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LGA1700
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LGA1700_VALUE = 3;

	/**
	 * An array of all the '<em><b>CPU Socket</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CPUSocket[] VALUES_ARRAY =
		new CPUSocket[] {
			AM4,
			AM5,
			LGA1200,
			LGA1700,
		};

	/**
	 * A public read-only list of all the '<em><b>CPU Socket</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CPUSocket> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>CPU Socket</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CPUSocket get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CPUSocket result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>CPU Socket</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CPUSocket getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CPUSocket result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>CPU Socket</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CPUSocket get(int value) {
		switch (value) {
			case AM4_VALUE: return AM4;
			case AM5_VALUE: return AM5;
			case LGA1200_VALUE: return LGA1200;
			case LGA1700_VALUE: return LGA1700;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CPUSocket(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //CPUSocket
