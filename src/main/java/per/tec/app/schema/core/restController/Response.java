package per.tec.app.schema.core.restController;

public class Response {

	private Object data;
	private String status;
	
	public Response() {
		
	}
	
	public Response(String status,Object data) {
		this.data = data;
		this.status = status;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
