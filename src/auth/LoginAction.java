package auth;

import model.*;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import javax.servlet.http.HttpSession;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.Action;

public class LoginAction implements Action, ServletRequestAware{
	
	public static Reader reader;	
	public static SqlMapClient sqlMapper;	
	
	String mem_id;
	String mem_pwd;	
	int mem_lev;
	int mem_no;
	String mem_name;

	int no;
	String Sal_id;

	HttpServletRequest request;
	HttpSession session;
	
	MemberVO reInfo = new MemberVO();

	public LoginAction() throws IOException { 
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}

	public String loginForm() throws Exception {
		return SUCCESS;
	}
	
	
	
	public String execute() throws Exception {

		boolean result = loginChk(mem_id, mem_pwd);
		
		if (result) {
			
			System.out.println(reInfo.getNo());
			System.out.println(reInfo.getMem_id());
			System.out.println(reInfo.getMem_lev());
			
			request.getSession().setAttribute( "mem_no", reInfo.getNo());
			request.getSession().setAttribute( "mem_id" , reInfo.getMem_id());	
			request.getSession().setAttribute( "mem_lev" , reInfo.getMem_lev());
			request.getSession().setAttribute( "mem_name" , reInfo.getMem_name());
			
			System.out.println("login Success");
			return SUCCESS; //로그인 성공 했을때
		} else {
			System.out.println("login Fail");
			return LOGIN; //로그인 실패 했을때 	
		}
	}
	
	
 
	private boolean loginChk(String mem_id, String mem_pwd) throws Exception {

		reInfo = (MemberVO) sqlMapper.queryForObject("selectMemberOne", mem_id);
			//쿼리문을 실행해서 객체를 받아 초기화한다.

		if (mem_pwd.equals(reInfo.getMem_pwd())) {
			return true; //비번 맞으면 true.
		} else {
			return false; //비번 틀리면 fasle.
		}

	}

/*	public int idCheck() throws SQLException {
		int countId = (int) sqlMapper.queryForObject("idCheck", getMem_id());

		if (countId == 0) {
			return "true";
		} else {
			return "false";
		}
	} */


	
	

	public String logout() throws Exception {

		try {
			System.out.println("logout test");
			request.getSession().invalidate();
			return SUCCESS;
		} catch (Exception ex) {
			return SUCCESS;
		}
		
	}

	public boolean userAuth(String dbMem_id, String mem_id) {
		
		boolean result = false;
		
		if (mem_id.equals("admin")) {
			result = true;
		} else {
			if (dbMem_id.equals(mem_id)) {
				result = true;
			} else {
				result = false;
			}
		}
		
		return result;
	}

	public String itemOk() throws SQLException {
		sqlMapper.update("memLevChange", getSal_id());
		sqlMapper.update("itemCheckChange", getNo());
		return SUCCESS;
	}


	public static Reader getReader() {
		return reader;
	}


	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}


	public String getMem_id() {
		return mem_id;
	}


	public String getMem_pwd() {
		return mem_pwd;
	}


	public int getMem_lev() {
		return mem_lev;
	}


	public HttpServletRequest getRequest() {
		return request;
	}


	public HttpSession getSession() {
		return session;
	}


	public MemberVO getReInfo() {
		return reInfo;
	}


	public static void setReader(Reader reader) {
		LoginAction.reader = reader;
	}


	public static void setSqlMapper(SqlMapClient sqlMapper) {
		LoginAction.sqlMapper = sqlMapper;
	}


	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}


	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}


	public void setMem_lev(int mem_lev) {
		this.mem_lev = mem_lev;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public void setSession(HttpSession session) {
		this.session = session;
	}


	public void setReInfo(MemberVO reInfo) {
		this.reInfo = reInfo;
	}


	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}


	public int getMem_no() {
		return mem_no;
	}


	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getSal_id() {
		return Sal_id;
	}

	public void setSal_id(String sal_id) {
		Sal_id = sal_id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
}
