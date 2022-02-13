package de.denktmit.tam.webapp.web;

public final class Routes {

    private Routes() {
        throw new AssertionError("this constant class is not intended for instantiation");
    }

    public static final String HOME = "/";
    public static final String HOME_INDEX = "/index.html";
    public static final String USERS = "/users";
    public static final String USER = USERS + "/{loginName}";
    public static final String ME = "/me";


}
