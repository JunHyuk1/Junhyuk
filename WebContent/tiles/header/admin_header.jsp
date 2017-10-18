<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


		<!--=====================================
				Top Fixed Navigation Menu BEGIN
		======================================-->
		<div id="menu_div">
			<div id="navigation">
				<div id="menu">
					<ul id="nav">

						<li>
							<a href="main.action">
								<img src="image/icon/logo2.png" alt="main" height="70px">
							</a>
						</li>
						
						<li><a href="#">관리자페이지</a></li>
						
						<li><a href="admin_member.action">회원 관리</a>
							<ul>
								<li><a href="admin_member.action">회원리스트</a></li>
								<li><a href="admin_qna.action">1:1문의</a>
									<ul>
										<li><a href="admin_nc_qna.action">미 완료된 문의보기</a></li>
										<li><a href="admin_ok_qna.action">완료된 문의보기</a></li>
									</ul>
								</li>					
							</ul> 
						</li> 
						<!-- 회원관리  END -->
						
						<li><a href="admin_order.action">예약 관리</a>
							<ul>
								<li><a href="admin_order.action">예약 리스트</a></li>						
							</ul>
						</li>
						<!-- 예약관리 END -->
						
						<li><a href="admin_item.action">상품 관리</a>
							<ul>
								<li><a href="admin_item.action">상품리스트</a>
									<ul>
										<li><a href="admin_ok_item.action">판매중인 상품 </a></li>
										<li><a href="admin_nc_item.action">승인대기 상품 </a></li>
									</ul>
								</li>
							</ul>
						</li>
						<!-- 상품관리 END-->
						 
						<li><a href="#">게시판 관리</a>
							<ul>
								<li><a href="admin_notice.action">공지사항</a>
								</li>
								<li><a href="admin_faq.action">자주묻는 질문</a>
								</li>
							</ul>
						</li>
						<!-- 게시판관리 END-->

						<li><a href="#">카테고리 관리</a>
							<ul>
								<li><a href="admin_mainCat.action">메인 카테고리</a>
								</li>
								<li><a href="admin_areaCat.action">지역 카테고리</a></li>
							</ul>
						</li>
						<!-- 카테고리 관리 END-->
						
					</ul>
					 
				</div><!-- #menu END--> 
			</div><!-- #navigation END-->
		</div><!-- #menu_div END-->
		<!--=====================================
				/Top Fixed Navigation Menu END 
		======================================-->	