package app;
import static spark.Spark.*;

public class Main {

	 public static void main(String[] args) {
	    	port(6789);
	    	
	     	get("/hello", (req, res) -> "hello");

	 }
}
