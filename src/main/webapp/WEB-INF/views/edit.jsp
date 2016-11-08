<h3>
    User
</h3>

<c:url var="addAction" value="/user/add" ></c:url>

<form:form action="${addAction}" commandName="user">
    <table>
        <c:if test="${!empty user.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name" required="required" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="age">
                    <spring:message text="Age"/>
                </form:label>
            </td>
            <td>
                <form:input path="age" type="number" min="0" required="required" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="isAdmin">
                    <spring:message text="admin"/>
                </form:label>
            </td>
            <td>
                <form:checkbox path="isAdmin" />
            </td>
        </tr>
        <c:if test="${!empty user.createDate}">
            <tr>
                <td>
                    <form:label path="createDate">
                        <spring:message text="Create Date"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="createDate" readonly="true" disabled="true" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td colspan="2">
                <c:if test="${!empty user.name}">
                    <input type="submit"
                           value="<spring:message text="Edit User"/>" />
                </c:if>
                <c:if test="${empty user.name}">
                    <input type="submit"
                           value="<spring:message text="Add User"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
