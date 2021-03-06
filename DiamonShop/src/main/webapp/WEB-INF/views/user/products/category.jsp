<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>Sản - phẩm</title>
<style>
.pagination {
	display: flex;
	justify-content: center;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
</head>
<body>
	<div class="well well-small">
		<div class="row">
			<span style="margin-left: 25px;">Danh sách sản phẩm</span> <select
				class="pull-right">
				<option>A - Z</option>
				<option>Cao - Thấp</option>
			</select>
		</div>
		<c:if test="${productsPaginate.size() > 0}">
			<c:forEach var="item" items="${productsPaginate}" varStatus="loop">
				${loop.first ? '<div class="row-fluid"><ul class="thumbnails">': ''}
				${(loop.index)!=0 && (loop.index)%3==0? '</ul></div><div class="row-fluid"><ul class="thumbnails">': ''}
				<li class="span4">
					<div class="thumbnail">
						<a href="product_details.html" class="overlay"></a> <a
							class="zoomTool" href="product_details.html" title="add to cart"><span
							class="icon-search"></span> QUICK VIEW</a> <a
							href="<c:url value="/chi-tiet-san-pham/${item.productId}"/>"><img src="<c:url value="/assets/user/img/${item.img }"/>"
							alt=""></a>
						<div class="caption cntr">
							<p>${item.name} ${loop.index + 1 }</p>
							<p>
								<strong> <fmt:formatNumber type="number" groupingUsed="true" value="${item.price}" /></strong>
							</p>
							<h4>
								<a class="shopBtn" href="#" title="add to cart"> Add to cart
								</a>
							</h4>
							<div class="actionList">
								<a class="pull-left" href="#">Add to Wish List </a> <a
									class="pull-left" href="#"> Add to Compare </a>
							</div>
							<br class="clr">
						</div>
					</div>
				</li>
				${(loop.index+1) >= productsPaginate.size()? '</ul></div>': ''}
			</c:forEach>
		</c:if>

	</div>
	<div class="pagination">
	<c:forEach var="item" begin="1" end="${paginateInfo.totalPage}" varStatus="loop">
		<c:if test="${loop.first && paginateInfo.currentPage != 1}">
			<a href="<c:url value="/product/${categoryId}/${paginateInfo.currentPage - 1}"/>">&laquo;</a>
		</c:if>
		<a href="<c:url value="/product/${categoryId}/${loop.index}"/>" class="${loop.index == paginateInfo.currentPage ? 'active':'' }"> ${loop.index}</a>
		<c:if test="${loop.last && paginateInfo.currentPage != paginateInfo.totalPage}">
			<a href="<c:url value="/product/${categoryId}/${paginateInfo.currentPage + 1}"/>">&raquo;</a>
		</c:if>
	</c:forEach>
		
	</div>
</body>