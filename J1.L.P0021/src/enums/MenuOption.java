/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author admin
 */
public enum MenuOption {
    CREATE(1),
    FIND_AND_SORT(2),
    UPDATE_OR_DELETE(3),
    REPORT(4),
    EXIT(5);

    private final int value;

    /**
     * Private enum constructor linking symbol to numerical menu option code.
     *
     * @param value raw integer choice mapped to enum
     */
    MenuOption(int value) {
        this.value = value;
    }

    /**
     * Gets numerical integer option value.
     *
     * @return sequential integer option index code
     */
    public int getValue() {
        return value;
    }

    /**
     * Converts a raw integer input choice into its matching type-safe Enum
     * option symbol.
     *
     * @param value integer selection choice code
     * @return corresponding valid MenuOption enum symbol, or null if unmatched
     */
    public static MenuOption fromInt(int value) {
        for (MenuOption option : MenuOption.values()) {
            if (option.getValue() == value) {
                return option;
            }
        }
        return null;
    }
}
