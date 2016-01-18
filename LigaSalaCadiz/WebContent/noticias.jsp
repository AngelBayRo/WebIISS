<%@ page import="entidades.Noticia"%>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Fútbol Sala Cádiz | Noticias</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/noticia.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<script src="js/jquery.min.js"></script>
<script src="js/angular.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
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
						<li class="active" ><a href="ListarNoticias" class="scroll"> Noticias</a></li>
						<li><a href="ObtenerCalendario" class="scroll">Calendario</a></li>
						<li><a href="FormularioClasificacion" class="scroll">Clasificación</a></li>
						<li><a href="contact.html" class="scroll">Contacto</a></li>
						<li><a href="logadmin.html" class="scroll">Administración</a></li>
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
		
			<div class="content">
				
		<div class="content-app-up">
			<div class="container">
			<span class="line"> </span>
			<h3>NOTICIAS</h3>
			<div class="regard">
				<% ArrayList<Noticia> n = new ArrayList<Noticia>();%>
    			<% n= (ArrayList<Noticia>) request.getAttribute("noticias"); %>
    			<% for(Noticia not : n){ %>
				<div class="regard-in row">
				
					<div class="titulo col-xs-12"><%= not.getTitular() %></div>
					<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
							<img class="img-responsive img-rounded" src="subidas/<%= not.getImagen() %>" alt="">
					</div>
					<p class="col-xs-12 col-sm-12 col-md-6 col-lg-6"><%= not.getTitular() %></p>
					
					
				<div class="clearfix">
			  		
				  </div>
				
					<a href="NoticiaIndividual?noticia=<%= not.getId() %>"><button type="button" class="boton2" >Leer más</button></a>
				
				</div>
				<% }%>
				
				
			</div>
			</div>		
		</div>
	</div>
	
	<div class="footer" ng-app="miAplicacion" ng-controller="miControlador">
		<div class="container">
		
			<div class="foter-bottom">
			<button type="button" class="botonFooter" ng-click="showName();"> Realizadores </button>
				<div class=" nav-top">					
					<ul>
						<li><a href="index.html" class="scroll">Inicio</a></li>
						<li class="active" ><a href="ListarNoticias" class="scroll"> Noticias</a></li>
						<li><a href="ObtenerCalendario" class="scroll">Calendario</a></li>
						<li><a href="FormularioClasificacion" class="scroll">Clasificación</a></li>
						<li><a href="contact.html" class="scroll">Contacto</a></li>
						<li><a href="logadmin.html" class="scroll">Administración</a></li>
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

                    <div class="col-xs-12 col-md-4" style="text-align: center;">José Antonio Soler Jiménez
                     <div style="margin-top: 20px; margin-bottom: 20px;">
                      <img class="img-circle" src="images/jose.png"  height="90" width="90">
                     </div>
                    Estudiante de Ingeniería Informática en la Universidad de Cádiz<br/><br/>
                     <a href="#"><img src="images/Facebook2.png" style="margin-left:5px; margin-right: 5px;"></img></a>
                     <a href="#"><img src="images/Twitter2.png" style="margin-left:5px; margin-right: 5px;"></img></a>
                     <a href="#"><img src="images/Email2.png" style="margin-left:5px; margin-right: 5px;"></img></a>
                    </div>


                    <div class="col-xs-12 col-md-4" style="text-align: center;">Miguel Ángel Fernández Montilla
                     <div style="margin-top: 20px; margin-bottom: 20px;">
                      <img class="img-circle" src="images/miguel.png"  height="90" width="90">
                     </div>
                     Estudiante de Ingeniería Informática en la Universidad de Cádiz<br/><br/>
                     <a href="https://www.facebook.com/miguelangel.fernandezmontilla"><img src="images/Facebook2.png" style="margin-left:5px; margin-right: 5px;"></img></a>
                     <a href="https://twitter.com/MigueFM93"><img src="images/Twitter2.png" style="margin-left:5px; margin-right: 5px;"></img></a>
                     <a href="mailto:miguel.fernandezmontilla@alum.uca.es"><img src="images/Email2.png" style="margin-left:5px; margin-right: 5px;"></img></a>
                    </div>


                    <div class="col-xs-12 col-md-4" style="text-align: center;">Ángel Luis Bayón Romero
                     <div style="margin-top: 20px; margin-bottom: 20px;">
                      <img class="img-circle" src="images/angel.png"  height="90" width="90">
                     </div>
                     Estudiante de Ingeniería Informática en la Universidad de Cádiz<br/><br/>
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
		</body>
	</html>