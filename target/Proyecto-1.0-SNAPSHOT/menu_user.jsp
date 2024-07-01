
<header class="main-header">
    <a href="#" class="logo">
        <!-- Apartado responsive de 50x50 pixeles -->
        <span class="logo-mini"><b> P.I.D.E.</b></span>
        <!-- logo regular y móviles -->
        <span class="logo-lg pull-left" alt="User Image"><img src="img/logomuni.png" style="border-radius: 50%;" /><b>Sistema </b>P.I.D.E.
        </span>
    </a>
    <!-- Header -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>
        <!-- Menu derecho -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- Menu de la cuenta -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <!-- Imagen usuario -->
                        <img src="dist/img/user1-128x128.jpg" class="user-image" alt="User Image">
                        <!-- hidden-xs hides the username on small devices so only the image appears. -->
                        <span class="hidden-xs"> ${usuario.nombreUsuario}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- Imagen del usuario usado en el menu -->
                        <li class="user-header">
                            <img src="dist/img/user1-128x128.jpg" class="img-circle" alt="User Image">
                            <p>                    
                                Bienvenido - ${usuario.nombreUsuario}
                                <small>Usted es,${usuario.cargo.nombreCargo} </small>
                            </p>
                        </li>
                        <!-- Apartado del menu footer con el boton de cerrar sesion-->
                        <li class="user-footer">
                            <div class="pull-right">
                                <a href="srvUsuario?accion=cerrar" class="btn btn-default btn-flat">Cerrar Session</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>
<!-- apartado izquierdo del menu -->
<aside class="main-sidebar">
    <section class="sidebar">
        <!-- barra adicional del usuario logeado -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="dist/img/user1-128x128.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Bienvenido,  ${usuario.nombreUsuario} </p>
                <!-- Estado(online, ocupado, en servicio,offline) -->
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- Apartado de busqueda para acceso rapido de menus -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                    <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                    </button>
                </span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- Barra de menu horizontal de apartados -->
        <jsp:include page="/menu.jsp" />

        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>
        
        
        <!-- inicio de codigo para insertar el chatbot -->
        <script type="text/javascript">
            
            // definir objeto
            window.__be = window.__be || {};
            
            // id del chatbot
            window.__be.id = "6681d44df95a26000705f8e8"; 
            
            // definir objeto
            var BE_API = window.BE_API || {};
            
            // abrir el chatbot despues de cargar la pagina
            BE_API.onLoad = function () {
                BE_API.openChatWindow();
            };
            
            // creacion del elemento que contiene el script para el plugin 
            (function () {
               
                var be = document.createElement('script');  // crear elemento script
                
                be.type = 'text/javascript'; // tipo de script
                be.async = true;    // cargar el script de forma asincrona
                
                // url del script 'plugin.js'
                be.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'cdn.botengine.ai/widget/plugin.js';
                
                // colocar el script antes del primer elemento del tipo 'script'
                var s = document.getElementsByTagName('script')[0]; 
                s.parentNode.insertBefore(be, s);
            })();
        </script>
        
        <!-- Estilo para el ancho del elemento chatbot -->
        <style type="text/css">
            #botengine-chat {
                width: 100% !important;
            }
        </style>
        
        <!-- fin de codigo chatbot -->