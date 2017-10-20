package totalDelete;

import com.opensymphony.xwork2.ActionSupport;

import model.*;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

import java.io.Reader;
import java.sql.SQLException;
import java.io.File;
import java.io.IOException;

public class DeleteAction extends ActionSupport implements  ServletRequestAware {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	  
	HttpServletRequest request;
	private int currentPage;
	private int no;
	private String mem_id;
	private String userReq;
	private String img;
	private String fileUploadPath;
	

	public DeleteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	@SuppressWarnings("deprecation")
	public String execute() throws Exception {

		fileUploadPath = request.getRealPath("/image/"+ getUserReq() + "/");

		try {
			if (getUserReq().equals("member")) {
				memberDelete();
			} else if (getUserReq().equals("notice")) {
				noticeDelete();
			}
		} catch (Exception ex) {
			return ERROR;
		} 	

		return SUCCESS;
	}

	public void faqDelete() throws SQLException, IOException {
		sqlMapper.update("deleteFaq", getNo());
	}
	
	public void memberDelete() throws SQLException, IOException {

		MemberVO resultClass = new MemberVO();
		resultClass = (MemberVO) sqlMapper.queryForObject("selectMemberOne", getMem_id());
		sqlMapper.update("deleteMember", getMem_id());
		deleteImg(resultClass.getImg());
		
	}
	
	public void areaCatDelete() throws SQLException, IOException {
		sqlMapper.update("deleteMainCat", getNo());
	}
	
	public void noticeDelete() throws SQLException, IOException {
		sqlMapper.update("deleteNotice", getNo());
	}

	public void orderDelete() throws SQLException, IOException {
		sqlMapper.update("deleteOrder", getNo());
	}

	public void itemDelete() throws SQLException, IOException {
		System.out.println(getNo());
		sqlMapper.update("deleteItem", getNo());
	}

	public void deleteImg(String img) throws IOException {
	
		File deleteFile = new File(fileUploadPath + img);
		deleteFile.delete();
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		DeleteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		DeleteAction.sqlMapper = sqlMapper;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	
}