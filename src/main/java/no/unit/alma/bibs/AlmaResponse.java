package no.unit.alma.bibs;

import no.bibsys.alma.rest.error.WebServiceResult;

public class AlmaResponse<E> {

	private E resultObject;
	private int status;
	private boolean success;
	private WebServiceResult webServiceResult;
	private String errorString;
	private int limit = -1;
	private int offset = -1;
	private String uri;
	private Object payload;
	
	public static <T> AlmaResponse<T> createDefaultErrorResponse(){
		AlmaResponse<T> almaResponse = new AlmaResponse<T>(null, 999, false, "");
		almaResponse.setErrorString("Undefined error calling AlmaContext");
		return almaResponse;
	}

	public AlmaResponse(E resultObject, int status, boolean success, String uri, Object payload){
		this.uri = uri;
		this.payload = payload;
		this.resultObject = resultObject;
		this.status = status;
		this.success = success;
		webServiceResult = null;
		errorString = "";
	}

	
	public AlmaResponse(E resultObject, int status, boolean success, String uri){
		this(resultObject, status, success, uri, null);
	}

	public void setWebServiceResult(WebServiceResult webServiceResult){
		this.webServiceResult = webServiceResult;
	}

	public WebServiceResult webServiceResult(){
		return webServiceResult;
	}

	public E resultObject(){

		return resultObject;
	}

	public int status(){
		return status;
	}

	public boolean success() {
		return success;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

	public String errorString(){
		return errorString;
	}

	public String almaErrorMessage(){

		if(webServiceResult != null){
			if(webServiceResult.getErrorList() != null && webServiceResult.getErrorList().getError() != null && webServiceResult.getErrorList().getError().size() > 0){
				return webServiceResult.getErrorList().getError().get(0).getErrorMessage();
			}
		}

		return "";
	}
	
	public String almaErrorCode(){
		
		if(webServiceResult != null){
			if(webServiceResult.getErrorList() != null && webServiceResult.getErrorList().getError() != null && webServiceResult.getErrorList().getError().size() > 0){
				return webServiceResult.getErrorList().getError().get(0).getErrorCode();
			}
		}
		
		return "";
	}
	
	public void setLimit(int limit){
		this.limit = limit;
	}
	
	public int limit(){
		return limit;
	}
	
	public void setOffset(int offset){
		this.offset = offset;
	}
	
	public int offset(){
		return offset;
	}

	public String uri(){
		return uri;
	}
	
	public Object payload(){
		return payload;
	}
	
	@Override
	public String toString() {
		return "AlmaResponse [status=" + status + ", success=" + success + ", errorString=" + errorString + ", uri="
				+ uri + "]";
	}
}
