package service;

import DAO.StudyDao;
import model.Usuario;
import spark.Request;
import spark.Response;

public class StudyService {
	private StudyDao studyDao;
	
	public StudyService() {
		studyDao = new StudyDao();
		studyDao.conectar();
	}
	
	public Object create(Request request, Response response) {
		String email = request.queryParams("email");
		String name = request.queryParams("name");
		String lastname = request.queryParams("lastname");
		String password = request.queryParams("password");
		int id = studyDao.getMaxIdTopico();
		Usuario usuario = new Usuario(email, name, lastname, password, id);

		
		
		boolean status = studyDao.inserirUsuario(usuario);
		if(status) {
			response.status(201);
		}
		else {
			response.status(400);
		}
		return "ok";

		}
		
	public Object login(Request request, Response response) {
		String email = request.queryParams("nome");
		String password = request.queryParams("password");
		
		int id = studyDao.login(email, password);
		if(id >= 0) {
			response.status(201);
		}
		else {
			response.status(400);
		}
		return id;
	}
}