<h3>Users List</h3>
<c:if test="${!empty listUsers}">
    <table class="tg">
        <tr>
            <th width="80">User ID</th>
            <th width="120">User Name</th>
            <th width="120">User Age</th>
            <th width="60">Admin</th>
            <th width="120">Create Date</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach var="user" items="${listUsers}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.isAdmin}</td>
                <td>${user.createDate}</td>
                <%--<td><a href="<c:url value='/edit/${user.id}' />" >Edit</a></td>--%>
                <%--<td><a href="<c:url value='/remove/${user.id}' />" >Delete</a></td>--%>
                <td><a href="<c:url value='/edit/?page=${currentPage}&id=${user.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/remove/?page=${currentPage}&id=${user.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
    <td><a href="users?page=${currentPage - 1}">Previous</a></td>
</c:if>

<%--For displaying Page numbers.
The when condition does not display a link for the current page--%>
<c:if  test="${noOfPages > 0}">
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="/users?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
</c:if>

<%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
    <td><a href="users?page=${currentPage + 1}">Next</a></td>
</c:if>