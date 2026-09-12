/**
 */
package computer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Efficiency</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see computer.ComputerPackage#getEfficiency()
 * @model
 * @generated
 */
public enum Efficiency implements Enumerator {
	/**
	 * The '<em><b>Bronze</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRONZE_VALUE
	 * @generated
	 * @ordered
	 */
	BRONZE(0, "Bronze", "Bronze"),

	/**
	 * The '<em><b>Silver</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SILVER_VALUE
	 * @generated
	 * @ordered
	 */
	SILVER(1, "Silver", "Silver"),

	/**
	 * The '<em><b>Gold</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GOLD_VALUE
	 * @generated
	 * @ordered
	 */
	GOLD(2, "Gold", "Gold"),

	/**
	 * The '<em><b>Platinum</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLATINUM_VALUE
	 * @generated
	 * @ordered
	 */
	PLATINUM(3, "Platinum", "Platinum"),

	/**
	 * The '<em><b>Titanium</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TITANIUM_VALUE
	 * @generated
	 * @ordered
	 */
	TITANIUM(4, "Titanium", "Titanium");

	/**
	 * The '<em><b>Bronze</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRONZE
	 * @model name="Bronze"
	 * @generated
	 * @ordered
	 */
	public static final int BRONZE_VALUE = 0;

	/**
	 * The '<em><b>Silver</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SILVER
	 * @model name="Silver"
	 * @generated
	 * @ordered
	 */
	public static final int SILVER_VALUE = 1;

	/**
	 * The '<em><b>Gold</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GOLD
	 * @model name="Gold"
	 * @generated
	 * @ordered
	 */
	public static final int GOLD_VALUE = 2;

	/**
	 * The '<em><b>Platinum</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLATINUM
	 * @model name="Platinum"
	 * @generated
	 * @ordered
	 */
	public static final int PLATINUM_VALUE = 3;

	/**
	 * The '<em><b>Titanium</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TITANIUM
	 * @model name="Titanium"
	 * @generated
	 * @ordered
	 */
	public static final int TITANIUM_VALUE = 4;

	/**
	 * An array of all the '<em><b>Efficiency</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Efficiency[] VALUES_ARRAY =
		new Efficiency[] {
			BRONZE,
			SILVER,
			GOLD,
			PLATINUM,
			TITANIUM,
		};

	/**
	 * A public read-only list of all the '<em><b>Efficiency</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Efficiency> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Efficiency</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Efficiency get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Efficiency result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Efficiency</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Efficiency getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Efficiency result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Efficiency</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Efficiency get(int value) {
		switch (value) {
			case BRONZE_VALUE: return BRONZE;
			case SILVER_VALUE: return SILVER;
			case GOLD_VALUE: return GOLD;
			case PLATINUM_VALUE: return PLATINUM;
			case TITANIUM_VALUE: return TITANIUM;
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
	private Efficiency(int value, String name, String literal) {
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
	
} //Efficiency
