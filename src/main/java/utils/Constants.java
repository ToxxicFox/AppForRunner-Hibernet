package utils;

public class Constants {

    public static final String SCHEMA = "SELECT schema_name FROM information_schema.schemata";
    public static final String TABLE = "SELECT datname FROM pg_database";
    public static final String NAME = "SELECT TABLE_SCHEMA FROM information_schema.tables";
    public static final String DETAILS = "Select pg_size_pretty(pg_database_size(datname)) from pg_database";

    public static final String QUERY = "FROM %s";
    public static final String NO_ARGS = "No args given";
    public static final String TOO_FEW_ARGS = "Too few args";
    public static final String BAD_ARGS = "Wrong args given";
}
