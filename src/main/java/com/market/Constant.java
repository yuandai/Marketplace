package com.market;

public class Constant {
	
	protected static final String errMsg = "Oops, wrong url or paramaters or data ...";
	protected static final String successMsg = "Succeeded!";

	
	protected static final String PROJECT = "projects";
	protected static final String BID = "bids";
	protected static final String PERSON = "persons";
	protected static final String ASSIGN = "assign";
	protected static final String INITIAL = "initial";
	protected static final String PROJECT_NAME = "projectName";
	protected static final String NAME = "name";

	
	
	protected static final int OK = 200; // OK – Eyerything is working
	protected static final int OKNew = 201; // OK – New resource has been created
	protected static final int OKDelete = 204; // OK – The resource was successfully deleted

	protected static final int NotModify = 304; // Not Modified – The client can use cached data

	protected static final int BadRequest = 400; // Bad Request – The request was invalid or cannot be served. The exact error should be explained in the error payload. E.g. „The JSON is not valid“
	protected static final int Unauth = 401; // Unauthorized – The request requires an user authentication
	protected static final int Forbidden = 403; // Forbidden – The server understood the request, but is refusing it or the access is not allowed.
	protected static final int NotFound = 404; // Not found – There is no resource behind the URI.
	protected static final int Unproducable = 422; // Unprocessable Entity – Should be used if the server cannot process the enitity, e.g. if an image cannot be formatted or mandatory fields are missing in the payload.

	protected static final int InternalErr = 500; // Internal Server Error – API developers should avoid this error. If an error occurs in the global catch blog, the stracktrace should be logged and not returned as response.


}
