package ru.praktikum.diplom_3.config;

public class Config {
    private static final String EMAIL = "olenskii_16@gmail.com";
    private static final String PASSWORD = "1234567";
    private static final String ACTIVE_SECTION = "tab_tab_type_current__2BEPc";

    public static String getEmail() {
        return EMAIL;
    }

    public static String getPassword() {
        return PASSWORD;
    }
    public static String getActiveSection() {return ACTIVE_SECTION; };
}
