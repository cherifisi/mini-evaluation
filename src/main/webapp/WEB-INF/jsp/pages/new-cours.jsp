<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div>
    <jsp:include page="welcome.jsp" />
    <div class="container mt-5">
        <div class="row">
            <div class="col-sm-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Ajouter un cours</h5>
                        <form action="create" method="post">
                            <div class="mb-3">
                                <label for="matiere" class="form-label">Matière</label>
                                <input type="text" name="matiere" class="form-control" id="matiere" required>
                            </div>
                            <div class="mb-3">
                                <label for="professeur" class="form-label">Professeur</label>
                                <input type="text" name="professeur" class="form-control" id="professeur" required>
                            </div>
                            <div class="mb-3">
                                <label for="classe" class="form-label">Classe</label>
                                <input type="text" name="classe" class="form-control" id="classe" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Enregistrer</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>