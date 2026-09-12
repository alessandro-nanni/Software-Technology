/**
 */
package computer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Motherboard Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see computer.ComputerPackage#getMotherboardType()
 * @model
 * @generated
 */
public enum MotherboardType implements Enumerator {
	/**
	 * The '<em><b>ATX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATX_VALUE
	 * @generated
	 * @ordered
	 */
	ATX(0, "ATX", "ATX"),

	/**
	 * The '<em><b>Micro ATX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MICRO_ATX_VALUE
	 * @generated
	 * @ordered
	 */
	MICRO_ATX(1, "MicroATX", "MicroATX"),

	/**
	 * The '<em><b>Mini ITX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINI_ITX_VALUE
	 * @generated
	 * @ordered
	 */
	MINI_ITX(2, "MiniITX", "MiniITX");

	/**
	 * The '<em><b>ATX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATX
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ATX_VALUE = 0;

	/**
	 * The '<em><b>Micro ATX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MICRO_ATX
	 * @model name="MicroATX"
	 * @generated
	 * @ordered
	 */
	public static final int MICRO_ATX_VALUE = 1;

	/**
	 * The '<em><b>Mini ITX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINI_ITX
	 * @model name="MiniITX"
	 * @generated
	 * @ordered
	 */
	public static final int MINI_ITX_VALUE = 2;

	/**
	 * An array of all the '<em><b>Motherboard Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MotherboardType[] VALUES_ARRAY =
		new MotherboardType[] {
			ATX,
			MICRO_ATX,
			MINI_ITX,
		};

	/**
	 * A public read-only list of all the '<em><b>Motherboard Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MotherboardType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Motherboard Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MotherboardType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MotherboardType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Motherboard Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MotherboardType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MotherboardType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Motherboard Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MotherboardType get(int value) {
		switch (value) {
			case ATX_VALUE: return ATX;
			case MICRO_ATX_VALUE: return MICRO_ATX;
			case MINI_ITX_VALUE: return MINI_ITX;
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
	private MotherboardType(int value, String name, String literal) {
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
	
} //MotherboardType
