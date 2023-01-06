<%@ tag pageEncoding="utf-8" %>
<%@attribute name="css" fragment="true" required="false" %>
<%@attribute name="js" fragment="true" required="false" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>E-Commerce Web Application</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="././template/css/style.css">

    <jsp:invoke fragment="css" />
</head>
<body>
    <jsp:include page="/views/partials/navg.jsp" />
    <div class="container-fluid mt-4 mb-3">
        <div class="row">
            <jsp:doBody/>
          <%--  <div class="col-sm-3">
                <jsp:include page="/views/partials/category_left.jsp" />
            </div>
            <div class="col-sm-9">
                <jsp:doBody/>
            </div>--%>

        </div>
    </div>
    <jsp:include page="/views/partials/footer.jsp"/>
    <script src="././template/js/main.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
<jsp:invoke fragment="js" />
</body>
</html>