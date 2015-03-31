<%@include file="./header.jsp" %>

<table class="table table-hover table-bordered">
    <thead>
        <tr>
            <th>Image</th><th>Nom</th>
        </tr>
    </thead>
<c:forEach items="${listeArticles}" var="article">
    
        
            <tr>
                <td style="width: 140px">
                    <a  href="index?action=detailArticle&articleId=${article.id}">
                        <img  src="${article.srcImage}"  class="" style="width: 140px;height:140px;">
                    </a>
                </td>
                <td style="vertical-align: middle">
                    <a  href="index?action=detailArticle&articleId=${article.id}">
                        <h4>${article.nom} <span class="badge">${article.prix} &euro;</span></h4>
                    </a>
                </td>
                
            </tr>
        </a>
</c:forEach>
    </table>

<%@include file="./footer.jsp" %>