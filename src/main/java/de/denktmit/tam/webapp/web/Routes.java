package de.denktmit.tam.webapp.web;

public final class Routes {

    private Routes() {
        throw new AssertionError("this constant class is not intended for instantiation");
    }

    public static final String HOME = "/";
    public static final String HOME_INDEX = "/index.html";
    public static final String TIMESHEET_UPLOAD_PART1 = "/timesheet/upload/part1";
    public static final String TIMESHEET_UPLOAD_PART2 = "/timesheet/upload/part2";
    public static final String TIMESHEET_UPLOAD_PART3 = "/timesheet/upload/part3";
    public static final String USERS = "/users";
    public static final String USER = USERS + "/{loginName}";
    public static final String ME = "/me";
    public static final String REST = "/rest";
    public static final String REST_UPLOAD = "/rest/upload";
    public static final String COSTUMER = "/customer";
    public static final String COSTUMER_SIMPLE = "/customer/simplelist";
}
