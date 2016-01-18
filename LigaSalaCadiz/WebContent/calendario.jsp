<%@ page import="entidades.Noticia"%>
<%@ page import="entidades.Partido"%>
<%@ page import="entidades.Jornada"%>
<%@ page import="entidades.Categoria"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>F�tbol Sala C�diz | Calendario</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/tablas.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/noticia.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery.min.js"></script>
<script src="js/angular.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script><link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Passion+One:400,700,900' rel='stylesheet' type='text/css'>
 <script src="js/responsiveslides.min.js"></script>
 <script>
    
    $(function () {
      $("#slider2").responsiveSlides({
        auto: true,
        pager: true,
        speed: 300,
        namespace: "callbacks",
      });
    });
  </script>
</head>
<body> 

	<div class="header">
	<div class="header-bottom-top">
		<div class="container">
			<div class="clearfix"> </div>
			<div class="header-bottom">			
				<div class="logo">
					<a href="index.html"><img src="images/log.png" alt=" " /></a>
				</div>
				<div class="top-nav">
					<span class="menu"> </span>
					<ul>
						<li><a href="index.html" class="scroll">Inicio</a></li>
						<li><a href="ListarNoticias" class="scroll"> Noticias</a></li>
						<li class="active" ><a href="ObtenerCalendario" class="scroll">Calendario</a></li>
						<li><a href="FormularioClasificacion" class="scroll">Clasificaci�n</a></li>
						<li><a href="contact.html" class="scroll">Contacto</a></li>
						<li><a href="logadmin.html" class="scroll">Administraci�n</a></li>
					</ul>
					
				<script>
					$("span.menu").click(function(){
						$(".top-nav ul").slideToggle(500, function(){
						});
					});
			</script>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		</div>
	</div>
		
		<div class="container-fluid">
			<% ArrayList<Categoria> n = new ArrayList<Categoria>();%>
    		<% n= (ArrayList<Categoria>) request.getAttribute("categorias"); %>
			<% for(Categoria s : n){ %>
				<h3><%= s.getNombre() %></h3>
				<% for(Jornada j : s.getJornadas()){ %>
			<div class="col-xs-12 col-sm-6 minimo">
				<div class="wrapper"> 
					  <div class="table">
					    
					    <div class="row header blue">
					      <div class="cell">
					        Jornada <%=j.getNum() %>
					      </div>
					      <div class="cell">
					        <%=j.getInicio() %>
					      </div>
					    </div>
					    <% for(Partido p : j.getPartidos()){ %>
					    <div class="row">
					      <div class="cell">
					      	<div class="tg-wrap"><table class="tg">
  <tr>
  <%
  	java.util.Date dt = p.getHora();

	java.text.SimpleDateFormat sdf = 
	     new java.text.SimpleDateFormat("HH:mm"); 
  %>
    <td class="tg-yw4l"><p class="celda1"><%= p.getFecha() %></p></td>
    <td class="tg-yw4l"><p class="celda1"><%=p.getEquipolocal().getNombre() %></p></td>
    <td class="tg-yw4l"><img src="subidas/<%= p.getEquipolocal().getImagen() %>" width="25px" height="25px" alt="" /></td>
    <% if(p.isJugado()) {%>
    <td class="tg-yw4l"><%= p.getGoleslocal() %></td>
    <% } %>
	<% if(!p.isJugado()) {%>
    <td class="tg-yw4l"><%= sdf.format(dt)%></td>
    <% } %>
    <% if(p.isJugado()) {%>
    <td class="tg-yw4l">-</td>
    <% } %>
    <% if(p.isJugado()) {%>
    <td class="tg-yw4l"><%= p.getGolesvisitante() %></td>
    <% } %>
	<% if(!p.isJugado()) {%>
    <td class="tg-yw4l"></td>
    <% } %>
    <td class="tg-yw4l"><img src="subidas/<%= p.getEquipovisitante().getImagen() %>" width="25px" height="25px" alt="" /></td>
    <td class="tg-yw4l"><p class="celda2"></p></td>
    <td class="tg-yw4l"><p class="celda2"><%=p.getEquipovisitante().getNombre() %></p></td>
    
  </tr>
</table></div>
					      </div>
					    </div>
					    <% } %>
					  </div> 
				</div> 
  			</div>
		<%} %>
	<%} %>
	</div>
	<div class="footer" ng-app="miAplicacion" ng-controller="miControlador">
		<div class="container">
		
			<div class="foter-bottom">
			<button type="button" class="botonFooter" ng-click="showName();"> Realizadores </button>
				<div class=" nav-top">					
					<ul>
						<li><a href="index.html" class="scroll">Inicio</a></li>
						<li><a href="ListarNoticias" class="scroll"> Noticias</a></li>
						<li class="active" ><a href="ObtenerCalendario" class="scroll">Calendario</a></li>
						<li><a href="FormularioClasificacion" class="scroll">Clasificaci�n</a></li>
						<li><a href="contact.html" class="scroll">Contacto</a></li>
						<li><a href="logadmin.html" class="scroll">Administraci�n</a></li>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
            </div>
            <div class="container" >
                   <div class="contact">
                   <div class="col-md-12 send-contact" >



                   <ul ng-show="mostrar" style="font-weight: 600; margin-top: 2%; margin-left: 2%; margin-right: 20%; color: white;">

                    <div class="ng-xs-12"><h4>Web creada por: </h4></div>

                    <div class="col-xs-12 col-md-4" style="text-align: center;">Jos� Antonio Soler Jim�nez
                     <div style="margin-top: 20px; margin-bottom: 20px;">
                      <img class="img-circle" src="images/jose.png"  height="90" width="90">
                     </div>
                    Estudiante de Ingenier�a Inform�tica en la Universidad de C�diz<br/><br/>
                     <a href="#"><img src="images/Facebook2.png" style="margin-left:5px; margin-right: 5px;"></img></a>
                     <a href="#"><img src="images/Twitter2.png" style="margin-left:5px; margin-right: 5px;"></img></a>
                     <a href="#"><img src="images/Email2.png" style="margin-left:5px; margin-right: 5px;"></img></a>
                    </div>


                    <div class="col-xs-12 col-md-4" style="text-align: center;">Miguel �ngel Fern�ndez Montilla
                     <div style="margin-top: 20px; margin-bottom: 20px;">
                      <img class="img-circle" src="images/miguel.png"  height="90" width="90">
                     </div>
                     Estudiante de Ingenier�a Inform�tica en la Universidad de C�diz<br/><br/>
                     <a href="https://www.facebook.com/miguelangel.fernandezmontilla"><img src="images/Facebook2.png" style="margin-left:5px; margin-right: 5px;"></img></a>
                     <a href="https://twitter.com/MigueFM93"><img src="images/Twitter2.png" style="margin-left:5px; margin-right: 5px;"></img></a>
                     <a href="mailto:miguel.fernandezmontilla@alum.uca.es"><img src="images/Email2.png" style="margin-left:5px; margin-right: 5px;"></img></a>
                    </div>


                    <div class="col-xs-12 col-md-4" style="text-align: center;">�ngel Luis Bay�n Romero
                     <div style="margin-top: 20px; margin-bottom: 20px;">
                      <img class="img-circle" src="images/angel.png"  height="90" width="90">
                     </div>
                     Estudiante de Ingenier�a Inform�tica en la Universidad de C�diz<br/><br/>
                     <a href="https://www.facebook.com/angel.bayonromero"><img src="images/Facebook2.png" style="margin-left:5px; margin-right: 5px;"></img></a>
                     <a href="https://twitter.com/AngelBayRo"><img src="images/Twitter2.png" style="margin-left:5px; margin-right: 5px;"></img></a>
                     <a href="mailto:angelluis.bayonromero@alum.uca.es"><img src="images/Email2.png" style="margin-left:5px; margin-right: 5px;"></img></a>
                    </div>

                   </ul>

                                </div>
                   <div class="clearfix"> </div>
                </div>
                </div>
			</div>
			<script>
                 var miaplicacion= angular.module('miAplicacion', []);

                  miaplicacion.controller('miControlador', ['$scope', function($scope) {
                   $scope.mostrar = false;
                   $scope.showName = function() {
                   $scope.mostrar = !$scope.mostrar;
                   } 
                  }]);
                 </script>
			    <script>
     function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#blah')
                        .attr('src', e.target.result)
                        .width(300)
                        .height(300);
                };

                reader.readAsDataURL(input.files[0]);
            }
        }</script>
		</body>
		</html>