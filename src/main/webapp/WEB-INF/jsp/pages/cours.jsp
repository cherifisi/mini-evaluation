<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div>
    <jsp:include page="welcome.jsp" />
    <div class="container mt-5">
        <div class="row">
            <div class="d-flex justify-content-end mb-3">
                <a href="cours/new" class="btn btn-success">Ajouter un cours</a>
            </div>
            <div class="col-sm-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Liste des cours</h5>
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Matière</th>
                                <th>Professeur</th>
                                <th>Classe</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${coursList}" var="cours">
                                <tr>
                                    <td>${cours.id}</td>
                                    <td>${cours.matiere}</td>
                                    <td>${cours.professeur}</td>
                                    <td>${cours.classe}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
