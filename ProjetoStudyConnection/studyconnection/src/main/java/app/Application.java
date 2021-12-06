package app;

//import spark.utils.IOUtils;
import static spark.Spark.*;
import static spark.Spark.port;
import static spark.Spark.staticFiles;
import static spark.Spark.post;
import spark.Request;
import spark.Response;


import service.StudyService;


public class Application {
	private static StudyService service = new StudyService();

    public static void main(String[] args) {
    	port(6789);
    	staticFiles.location("/"); 
    	
     	post("/criar-conta", (req, res) -> service.create(req, res));
     	post("/login", (req, res) -> service.login(req, res));

    }
}
     			