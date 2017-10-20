package totalWrite;

import com.opensymphony.xwork2.ActionSupport;

import model.*;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import java.util.*;

import org.apache.commons.io.FileUtils;

import java.io.Reader;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.io.File;
import java.io.IOException;


public class WriteAction extends ActionSupport implements  ServletRequestAware {

	public static Reader reader; 
	public static SqlMapClient sqlMapper; 
	
	private int currentPage; 
	HttpServletRequest request;
	Calendar today = Calendar.getInstance(); 
	
	private File upload;
	private String uploadContentType; 
	private String uploadFileName; 
	private String fileUploadPath;
	
	private String userReq;
	private String modifyReq="";

	private int no = 0;
	private String name;
	private String content;
	private Date todate;
	private String answer;
	private int answer_check;
	private String cat_code;
	
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_phone;
	private String memo;
	private int mem_lev;

	private String re_item;
	private String re_mem_name;
	private String re_sal_id;
	private int re_price;
	private String checkin_date;
	private String checkout_date;
	private String re_cat_no;
	private Date order_date;
	private String order_dtl;

	private int price;
	private int cat_no;
	private int area_cat_no;
	private String item_sum;
	private String item_detail;
	private int item_readhit;
	private String sal_id;
	private String sal_name;
	private String re_date;
	private String mainCat;

	private int area_no;
	private String area_name;
	

	private String img = "";
	
	public WriteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}


	public String form() throws Exception {
		return SUCCESS;
	}


	@SuppressWarnings("deprecation")
	public String execute() throws Exception {
		System.out.println(getUserReq() + "asdfjkasfd");
		todate = today.getTime();
		fileUploadPath = request.getRealPath("/image/"+ getUserReq() + "/");
		
		System.out.println(getUserReq() + "asdfjkasfd");

			if (getUserReq().equals("member")) {
				memberWrite();
			} else if (getUserReq().equals("notice")) {
				noticeWrite();
			}
		
		
		return SUCCESS;
	
	}

	public void memberWrite() throws SQLException, IOException {

		MemberVO paramClass = new MemberVO();
		
		
		//file upload start
		if (getUpload() != null) {
			if(no == 0 ) {
				no = (int) sqlMapper.queryForObject("memberSeqNo");
			} else {
				no = getNo();
			}
			img = uploadImg();
		}
		paramClass.setImg(img);
		//file upload end
		
		paramClass.setNo(getNo());
		paramClass.setMem_id(getMem_id());
		paramClass.setMem_pwd(getMem_pwd());
		paramClass.setMem_name(getMem_name());
		paramClass.setMem_phone(getMem_phone());
		paramClass.setMemo(getMemo());
		paramClass.setMem_lev(getMem_lev());
		paramClass.setTodate(todate);
		
		if (getModifyReq().equals("") || getModifyReq() == null ) {
			sqlMapper.insert("insertMember", paramClass);
		} else {
			sqlMapper.update("memberModify", paramClass);
		}
	}
	
	public void noticeWrite() throws SQLException, IOException {

		NoticeVO paramClass = new NoticeVO();
		
		paramClass.setNo(getNo());
		paramClass.setTodate(todate);
		paramClass.setName(getName());
		paramClass.setContent(getContent());
		
		System.out.println("testttttt");
		
		if (getModifyReq().equals("") || getModifyReq() == null ) {
			sqlMapper.insert("insertNotice", paramClass);
		} else {
			System.out.println("testtttt222222222222t");
			sqlMapper.update("noticeModify", paramClass);
		}
	}
	
	public String uploadImg() throws IOException {
	
		String file_name = userReq + no;
		String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.') 
			+ 1, getUploadFileName().length());
		
		File destFile = new File(fileUploadPath + file_name + "." + file_ext);
		
		FileUtils.copyFile(getUpload(), destFile);


		String resultName = file_name + "." + file_ext;
		return resultName;
		
	}



	public static Reader getReader() {
		return reader;
	}


	public static void setReader(Reader reader) {
		WriteAction.reader = reader;
	}


	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}


	public static void setSqlMapper(SqlMapClient sqlMapper) { 
		WriteAction.sqlMapper = sqlMapper;
	}


	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
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

	public String getUserReq() {
		return userReq;
	}

	public void setUserReq(String userReq) {
		this.userReq = userReq;
	}


	public Calendar getToday() {
		return today;
	}


	public void setToday(Calendar today) {
		this.today = today;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getTodate() {
		return todate;
	}


	public void setTodate(Date todate) {
		this.todate = todate;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public int getAnswer_check() {
		return answer_check;
	}


	public void setAnswer_check(int answer_check) {
		this.answer_check = answer_check;
	}


	public String getCat_code() {
		return cat_code;
	}


	public void setCat_code(String cat_code) {
		this.cat_code = cat_code;
	}


	public String getMem_id() {
		return mem_id;
	}


	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}


	public String getMem_pwd() {
		return mem_pwd;
	}


	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}


	public String getMem_name() {
		return mem_name;
	}


	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}


	public String getMem_phone() {
		return mem_phone;
	}


	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	public int getMem_lev() {
		return mem_lev;
	}


	public void setMem_lev(int mem_lev) {
		this.mem_lev = mem_lev;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getModifyReq() {
		return modifyReq;
	}


	public void setModifyReq(String modifyReq) {
		this.modifyReq = modifyReq;
	}


	public String getRe_item() {
		return re_item;
	}


	public void setRe_item(String re_item) {
		this.re_item = re_item;
	}


	public String getRe_mem_name() {
		return re_mem_name;
	}


	public void setRe_mem_name(String re_mem_name) {
		this.re_mem_name = re_mem_name;
	}


	public String getRe_sal_id() {
		return re_sal_id;
	}


	public void setRe_sal_id(String re_sal_id) {
		this.re_sal_id = re_sal_id;
	}


	public int getRe_price() {
		return re_price;
	}


	public void setRe_price(int re_price) {
		this.re_price = re_price;
	}


	public String getCheckin_date() {
		return checkin_date;
	}


	public void setCheckin_date(String checkin_date) {
		this.checkin_date = checkin_date;
	}


	public String getCheckout_date() {
		return checkout_date;
	}


	public void setCheckout_date(String checkout_date) {
		this.checkout_date = checkout_date;
	}


	public String getRe_cat_no() {
		return re_cat_no;
	}


	public void setRe_cat_no(String re_cat_no) {
		this.re_cat_no = re_cat_no;
	}


	public Date getOrder_date() {
		return order_date;
	}


	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}


	public String getOrder_dtl() {
		return order_dtl;
	}


	public void setOrder_dtl(String order_dtl) {
		this.order_dtl = order_dtl;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getCat_no() {
		return cat_no;
	}


	public void setCat_no(int cat_no) {
		this.cat_no = cat_no;
	}


	public int getArea_cat_no() {
		return area_cat_no;
	}


	public void setArea_cat_no(int area_cat_no) {
		this.area_cat_no = area_cat_no;
	}


	public String getItem_sum() {
		return item_sum;
	}


	public void setItem_sum(String item_sum) {
		this.item_sum = item_sum;
	}


	public String getItem_detail() {
		return item_detail;
	}


	public void setItem_detail(String item_detail) {
		this.item_detail = item_detail;
	}


	public int getItem_readhit() {
		return item_readhit;
	}


	public void setItem_readhit(int item_readhit) {
		this.item_readhit = item_readhit;
	}


	public String getSal_id() {
		return sal_id;
	}


	public void setSal_id(String sal_id) {
		this.sal_id = sal_id;
	}


	public String getSal_name() {
		return sal_name;
	}


	public void setSal_name(String sal_name) {
		this.sal_name = sal_name;
	}


	public String getRe_date() {
		return re_date;
	}


	public void setRe_date(String re_date) {
		this.re_date = re_date;
	}
	
	public void setMainCat(String mainCat) {
		this.mainCat = mainCat;
	}

	public String getMainCat () {
		return mainCat;
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