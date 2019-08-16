package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
			urlPatterns = {"*.do"},
			initParams = {@WebInitParam(name = "propertyConfig", value = "command.properties")}
			
		)
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Map<String, Object> map = new HashMap<String, Object>();
    public Controller() {
        super();
       
    }

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String propertyConfig = config.getInitParameter("propertyConfig");
		System.out.println("propertyConfig = " + propertyConfig);
		
		String realFolder = config.getServletContext().getRealPath("/property");
		String realPath = realFolder + "/" + propertyConfig;
		Properties properties = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(realPath);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Iterator<?> iterator = properties.keySet().iterator();
		while (iterator.hasNext()) {
			String command = (String) iterator.next();
			String className = properties.getProperty(command);
			System.out.println("command = " + command);
			System.out.println("className = " + className);
			try {
				Class<?> commandClass = Class.forName(className);
				System.out.println("commandClass = " + commandClass);
				Object commandInstance = commandClass.newInstance();
				System.out.println("commandInstance = " + commandInstance);
				map.put(command, commandInstance);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doprocess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doprocess(request, response);
	}
	protected void doprocess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = null;
		Action action = null;
		String command = request.getServletPath();
		System.out.println("command = " + command);
		action = (Action) map.get(command);
		if(action != null) {
			try {
				result = action.process(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(result != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(result);
			dispatcher.forward(request, response);
		}
		
	}

}
