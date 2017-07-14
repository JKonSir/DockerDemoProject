package org.mycompany.controllers;

/**
 * Created by konstantinamp on 7/10/17.
 */
public class RestApi {

    public static final String API_V1 = "/app/postgres";
    public static final String API_ROOT_V1 = API_V1 + "/subjects";

    public static final String API_V2 = "/app/mongo";
    public static final String API_ROOT_V2 = API_V2 + "/subjects";

    public static final String SUBJECT = "/{subjectId}";
}
