package board.controller;

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
			initParams = {@WebInitParam(name = "propertyConfig", value ="command.properties" )}
)
public class boardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 요청정보와 데이터 처리 클래스를 쌍으로 저장할 Map 클래스
    private Map<String, Object> map = new HashMap<String, Object>();
    
    
    public boardController() {
    	super();
    }

	
	// 요청정보와 데이터 처리 클래스가 매핑되어 있는 properties 파일을 읽어서, 
    // 요청정보와 생성되어진 데이터 처리 클래스를 Map 클래스에 저장
    @Override
	public void init(ServletConfig config) throws ServletException {
    	// 파일이름: initParams에서 propertyConfig 값 읽어옴
    	String propertyConfig = config.getInitParameter("propertyConfig");
    	// propertyConfig = command.properties
    	System.out.println("propertyConfig = " + propertyConfig);
    	
    	// 폴더위치: "property" 폴더의 절대 경로 구하기
    	String realFolder = config.getServletContext().getRealPath("/property");
    	
    	// 전체 경로 완성 : 폴더위치 + 파일이름
    	String realPath = realFolder + "/" + propertyConfig;
    	
    	// 요청정보와 처리 클래스의 매핑정보를 저장할 Properties 객체 생성
    	Properties properties = new Properties();
    	
    	// 파일을 읽어올 IO 클래스
    	FileInputStream fis = null;
    	try {
    		// command.properties 파일을 오픈시킴
			fis = new FileInputStream(realPath);
			// command.properties 파일의 내용을  Properties 객체에 저장
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				} 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	// Set 객체의 iterator() 메소드를 사용해서 Iterator 객체를 얻어냄
    	// ? : 어떤 자료형이든 상관없이 사용하겠다
    	Iterator<?> iterator = properties.keySet().iterator();
    	// Iterator 객체에 저장된 명령어와 명령어 처리 클래스를 Map 객체에 저장
    	while (iterator.hasNext()) {
			String command = (String) iterator.next();
			String className = properties.getProperty(command);
			//	command = /boardWriteForm.do
			//	className = board.action.BoardWriteFormAction
			System.out.println("command = " + command);
			System.out.println("className = " + className);
			
			try {
				Class<?> commandClass = Class.forName(className);
				// commandClass = class board.action.BoardWriteFormAction
				System.out.println("commandClass = " + commandClass);
				// 명령어 처리 객체 생성
				Object commandInstance = commandClass.newInstance();
				// commandInstance = board.action.BoardWriteFormAction@68cefaf3
				System.out.println("commandInstance = " + commandInstance);
			    // 요청정보와 생성되어진 데이터 처리 클래스를 Map 클래스에 저장
				//	command = /boardWriteForm.do 
				// commandInstance = board.action.BoardWriteFormAction@68cefaf3
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
		// TODO Auto-generated method stub
		doprocess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doprocess(request, response);
	}
	/*	1. 웹브라우저의 요청을 분석하고, 해당 요청의 처리를 수행할 model 실행
	 * 	2. 처리결과를 view에 보냄
	 */
	protected void doprocess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = null;	// view 처리 파일이름 저장
		Action action = null;	// Data 처리 클래스 저장
		
		//	요청 정보 확인
		String command = request.getServletPath();
		// command = /boardWriteForm.do
		System.out.println("command = " + command);
		
		// 요청 작업 처리
		action = (Action) map.get(command);
		
		if(action != null) {
			try {
				// process() 동작 : 데이터 처리 + 데이터 공유 + view 처리 파일 선택 
				result = action.process(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 응답을 위한 view 파일을 forward로 처리
		if(result != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(result);
			dispatcher.forward(request, response);
		}
	}

}
