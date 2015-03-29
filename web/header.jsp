<%-- 
    Document   : accueil.jsp
    Created on : Mar 24, 2015, 4:00:33 PM
    Author     : mathieu,damien,alexandre
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="ecommerce" class="modele.EcommerceBean" scope="session"/>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">  
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="./style.css" />
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid ">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index?action=accueil">Bienvenue sur notre site de e-commerce</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <c:choose>
                            <c:when test="${empty isUserRegistered}" >
                                <li><a href="index?action=connexion">Connexion</a></li>
                                <li><a href="index?action=inscription">Inscription</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="#">Bienvenue ${sessionScope.user.nom}</a></li>
                                <li><a href="#">Deconnexion</a></li>
                            </c:otherwise>
                        </c:choose>
                        
                            
                    </ul>
                </div>
            </div>
        </nav> 
        <c:if test="${not empty msgSuccess}" >
            <div class="alert alert-success alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                ${msgSuccess}
            </div>
        </c:if>
        <c:if test="${not empty msgError}" >
            <div class="alert alert-danger alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                ${msgError}
            </div>
        </c:if>
        <div class="container">