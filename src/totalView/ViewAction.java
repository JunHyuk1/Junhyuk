package totalView;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import model.*;
import auth.*;

import java.io.Reader;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

public class ViewAction extends ActionSupport implements ServletRequestAware {
	
	HttpServletRequest request;
	HttpSession session;
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	  
	private int currentPage;
	private int no;
	private String mem_id;
	private String userReq;
	private String result = SUCCESS;

	private int area_no;
	private String area_name;
	
	Object resultClass;
	LoginAction loginAction = new LoginAction();


	 
	public ViewAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}



	public String execute() throws Exception {

		System.out.println(getUserReq());
		
		if (getUserReq().equals("member")) {
			result = memberView();
		} else if (getUserReq().equals("notice")) {
			noticeView();
		} else {
			result = ERROR;
		}

		return result;
	}


	

	public String memberView() throws SQLException {

		resultClass = new MemberVO();
		resultClass = (MemberVO) sqlMapper.queryForObject("selectMemberOne", getMem_id());

		String mem_id = (String) request.getSession().getAttribute("mem_id").toString();
		String dbMem_id = (String) ((MemberVO) resultClass).getMem_id();
		
		if (loginAction.userAuth(dbMem_id, mem_id)) {
			result = SUCCESS;
		} else {
			result = ERROR;
		}
		
		return result;

	}

	public void noticeView() throws SQLException {

		resultClass = new NoticeVO();
		resultClass = (NoticeVO) sqlMapper.queryForObject("noticeSelectOne", getNo());
	}

	public static Reader getReader() {
		return reader;
	}



	public static void setReader(Reader reader) {
		ViewAction.reader = reader;
	}



	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}



	public static void setSqlMapper(SqlMapClient sqlMapper) {
		ViewAction.sqlMapper = sqlMapper;
	}



	public int getCurrentPage() {
		return currentPage;
	}



	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}



	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}


	public String getMem_id() {
		return mem_id;
	}



	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}



	public String getUserReq() {
		return userReq;
	}



	public void setUserReq(String userReq) {
		this.userReq = userReq;
	}



	public Object getResultClass() {
		return resultClass;
	}



	public void setResultClass(Object resultClass) {
		this.resultClass = resultClass;
	}


	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}



	public int getArea_no() {
		return area_no;
	}



	public void setArea_no(int area_no) {
		this.area_no = area_no;
	}



	public String getArea_name() {
		return area_name;
	}



	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	
	
}