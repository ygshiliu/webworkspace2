<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="scott">
    <c:choose>
        <c:when test="${page.totalPage<=5}">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="${page.totalPage}"></c:set>
        </c:when>
        <c:when test="${page.pageNo<=3}">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="5"></c:set>
        </c:when>
        <c:otherwise>
            <c:set var="begin" value="${page.pageNo-2}"></c:set>
            <c:set var="end" value="${page.pageNo+2}"></c:set>
            <c:if test="${end >= page.totalPage}">
                <c:set var="begin" value="${page.totalPage-4}"></c:set>
                <c:set var="end" value="${page.totalPage}"></c:set>
            </c:if>
        </c:otherwise>
    </c:choose>
    <a href="${page.url}&pageNo=${page.pageNo-1}"> &lt; </a>
    <c:forEach begin="${begin}" end="${end}" var="index">
        <c:choose>
            <c:when test="${page.pageNo==index}">
                <span class="current">${index}</span>
            </c:when>
            <c:otherwise>
                <a href="${page.url}&pageNo=${index}">${index}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <a href="${page.url}&pageNo=${page.pageNo+1}"> &gt; </a>
    共${page.totalPage}页，${page.totalRecord}条记录 到第<input value="${page.pageNo}" name="pn" id="pn_input" />页
    <input id="sendBtn" type="button" value="确定">

    <script>

        $("#sendBtn").click(function(){
            var pageNo = $("#pn_input").val();
            location.href = "${page.url}&pageNo="+pageNo;
        })

    </script>
</div>
