/**
 */
package computer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>CD Drive Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see computer.ComputerPackage#getCDDriveType()
 * @model
 * @generated
 */
public enum CDDriveType implements Enumerator {
	/**
	 * The '<em><b>CD ROM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CD_ROM_VALUE
	 * @generated
	 * @ordered
	 */
	CD_ROM(0, "CD_ROM", "CD_ROM"),

	/**
	 * The '<em><b>CD R</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CD_R_VALUE
	 * @generated
	 * @ordered
	 */
	CD_R(1, "CD_R", "CD_R"),

	/**
	 * The '<em><b>CD RW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CD_RW_VALUE
	 * @generated
	 * @ordered
	 */
	CD_RW(2, "CD_RW", "CD_RW"),

	/**
	 * The '<em><b>DVD ROM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DVD_ROM_VALUE
	 * @generated
	 * @ordered
	 */
	DVD_ROM(3, "DVD_ROM", "DVD_ROM"),

	/**
	 * The '<em><b>Blu Ray</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLU_RAY_VALUE
	 * @generated
	 * @ordered
	 */
	BLU_RAY(4, "Blu_Ray", "Blu_Ray");

	/**
	 * The '<em><b>CD ROM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CD_ROM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CD_ROM_VALUE = 0;

	/**
	 * The '<em><b>CD R</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CD_R
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CD_R_VALUE = 1;

	/**
	 * The '<em><b>CD RW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CD_RW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CD_RW_VALUE = 2;

	/**
	 * The '<em><b>DVD ROM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DVD_ROM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DVD_ROM_VALUE = 3;

	/**
	 * The '<em><b>Blu Ray</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLU_RAY
	 * @model name="Blu_Ray"
	 * @generated
	 * @ordered
	 */
	public static final int BLU_RAY_VALUE = 4;

	/**
	 * An array of all the '<em><b>CD Drive Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CDDriveType[] VALUES_ARRAY =
		new CDDriveType[] {
			CD_ROM,
			CD_R,
			CD_RW,
			DVD_ROM,
			BLU_RAY,
		};

	/**
	 * A public read-only list of all the '<em><b>CD Drive Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CDDriveType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>CD Drive Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CDDriveType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CDDriveType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>CD Drive Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CDDriveType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CDDriveType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>CD Drive Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CDDriveType get(int value) {
		switch (value) {
			case CD_ROM_VALUE: return CD_ROM;
			case CD_R_VALUE: return CD_R;
			case CD_RW_VALUE: return CD_RW;
			case DVD_ROM_VALUE: return DVD_ROM;
			case BLU_RAY_VALUE: return BLU_RAY;
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
	private CDDriveType(int value, String name, String literal) {
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
	
} //CDDriveType
