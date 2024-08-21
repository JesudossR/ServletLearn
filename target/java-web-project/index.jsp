<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <body>
            <h2>Hello from JesuDoss</h2>
            

            <form action="./hello" method="post"> 
                create:: id<input type="text" name="id" />
                modelName<input type="text" name="modelName" />
                year<input type="text" name="year" />
                price<input type="text" name="price" />
                company<input type="text" name="company" />
                <input type="submit" value="submit" />
            </form>
            <!-- ${
            modelList
            } -->
            <table>
                <c:forEach var="user" items="${modelList}">
                    <tr>
                        <td>
                            <c:out value="${user.id}" />
                        </td>
                        <td>
                            <c:out value="${user.modelName}" />
                        </td>
                        <td>
                            <c:out value="${user.year}" />
                        </td>
                        <td>
                            <c:out value="${user.price}" />
                        </td>
                        <td>
                            <c:out value="${user.company}" />
                        </td>
                    </tr>

                </c:forEach>
            </table>
        </body>

        </html>