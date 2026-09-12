/**
 */
package computer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Port Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see computer.ComputerPackage#getPortType()
 * @model
 * @generated
 */
public enum PortType implements Enumerator {
	/**
	 * The '<em><b>USB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USB_VALUE
	 * @generated
	 * @ordered
	 */
	USB(0, "USB", "USB"),

	/**
	 * The '<em><b>PS2</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PS2_VALUE
	 * @generated
	 * @ordered
	 */
	PS2(1, "PS2", "PS2"),

	/**
	 * The '<em><b>HDMI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HDMI_VALUE
	 * @generated
	 * @ordered
	 */
	HDMI(2, "HDMI", "HDMI"),

	/**
	 * The '<em><b>Display Port</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISPLAY_PORT_VALUE
	 * @generated
	 * @ordered
	 */
	DISPLAY_PORT(3, "DisplayPort", "DisplayPort"),

	/**
	 * The '<em><b>VGA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VGA_VALUE
	 * @generated
	 * @ordered
	 */
	VGA(4, "VGA", "VGA"),

	/**
	 * The '<em><b>Ethernet</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETHERNET_VALUE
	 * @generated
	 * @ordered
	 */
	ETHERNET(5, "Ethernet", "Ethernet"),

	/**
	 * The '<em><b>Audio</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUDIO_VALUE
	 * @generated
	 * @ordered
	 */
	AUDIO(6, "Audio", "Audio");

	/**
	 * The '<em><b>USB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USB_VALUE = 0;

	/**
	 * The '<em><b>PS2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PS2
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PS2_VALUE = 1;

	/**
	 * The '<em><b>HDMI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HDMI
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HDMI_VALUE = 2;

	/**
	 * The '<em><b>Display Port</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISPLAY_PORT
	 * @model name="DisplayPort"
	 * @generated
	 * @ordered
	 */
	public static final int DISPLAY_PORT_VALUE = 3;

	/**
	 * The '<em><b>VGA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VGA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VGA_VALUE = 4;

	/**
	 * The '<em><b>Ethernet</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETHERNET
	 * @model name="Ethernet"
	 * @generated
	 * @ordered
	 */
	public static final int ETHERNET_VALUE = 5;

	/**
	 * The '<em><b>Audio</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUDIO
	 * @model name="Audio"
	 * @generated
	 * @ordered
	 */
	public static final int AUDIO_VALUE = 6;

	/**
	 * An array of all the '<em><b>Port Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PortType[] VALUES_ARRAY =
		new PortType[] {
			USB,
			PS2,
			HDMI,
			DISPLAY_PORT,
			VGA,
			ETHERNET,
			AUDIO,
		};

	/**
	 * A public read-only list of all the '<em><b>Port Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<PortType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Port Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PortType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PortType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Port Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PortType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PortType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Port Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PortType get(int value) {
		switch (value) {
			case USB_VALUE: return USB;
			case PS2_VALUE: return PS2;
			case HDMI_VALUE: return HDMI;
			case DISPLAY_PORT_VALUE: return DISPLAY_PORT;
			case VGA_VALUE: return VGA;
			case ETHERNET_VALUE: return ETHERNET;
			case AUDIO_VALUE: return AUDIO;
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
	private PortType(int value, String name, String literal) {
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
	
} //PortType
