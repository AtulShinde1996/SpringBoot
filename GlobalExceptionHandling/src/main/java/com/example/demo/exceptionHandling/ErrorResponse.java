package com.example.demo.exceptionHandling;

public class ErrorResponse {

	   private int status;
	    private String message;
	    private long timestamp;
	    private String details; // optional
		public ErrorResponse() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ErrorResponse(int status, String message, long timestamp, String details) {
			super();
			this.status = status;
			this.message = message;
			this.timestamp = timestamp;
			this.details = details;
		}
		
		
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public long getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}
		public String getDetails() {
			return details;
		}
		public void setDetails(String details) {
			this.details = details;
		}
		@Override
		public String toString() {
			return " [status=" + status + ", message=" + message + ", timestamp=" + timestamp
					+ ", details=" + details + "]";
		}
	    
}
