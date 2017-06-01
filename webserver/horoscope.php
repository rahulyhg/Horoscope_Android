<!DOCTYPE html>
<html lang="ru">
  <head>
    <meta charset="utf-8">
    <title>RJump.net - Персональный сайт программиста Хайдарова Радика</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Radik">
    <link type="text/plain" rel="author" href="http://rjump.net/humans.txt" />

    <link href="css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <link rel="shortcut icon" href="ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
  </head>

  <body>

    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="brand" href="index.php"><img src="img/logo.png" alt="RJump.net - Персональный сайт программиста Хайдарова Радика" style="padding-right:10px;"/>Random Jump</a>          
            <ul class="nav">
<li class="dropdown">
                <a href="index.php" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-th-list"></i> Приложения<b class="caret"></b></a>
                <ul class="dropdown-menu"> 
		<li><a href="android.php">Андроид</a></li><li><a href="arduino.php">Arduino</a></li><li><a href="windows8.php">Windows 8</a></li>  
 		<li class="dropdown-submenu"><a href="freeware.php">Windows. Бесплатные программы и утилиты</a></li>
                </ul>
              </li>              
		<li class="dropdown">
                <a href="index.php" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-tasks"></i> Web-разработки<b class="caret"></b></a>
                <ul class="dropdown-menu"> 
		<li><a href="flash.php">Flash игры</a></li> 
		<li><a href="site.php">Сайты</a></li>
                </ul>
              </li> 
              <li><a href="news.php"><i class="icon-list-alt"></i> Новости</a></li>         
            </ul>    
	<a class="btn btn-info" role="button" href=="mailto:info@rjump.net" data-toggle="modal"><i class="icon-envelope"></i> info@rjump.net</a>          
        </div>
      </div>
    </div>
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span2"><br><br>
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Web-разработки</li>
              <li><a href="flash.php">Flash игры</a></li>
              <li><a href="site.php">Сайты</a></li>
              <li class="nav-header">Приложения</li>
              <li><a href="android.php">Андроид</a></li><li><a href="arduino.php">Arduino</a></li><li><a href="windows8.php">Windows 8</a></li>
              <li><a href="freeware.php">Бесплатные программы и утилиты под Windows</a></li>
             
            </ul>
          </div><!--/.well -->
	<div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Технологии</li><li><a href="http://arduino.cc"><img alt="" src="img/arduino.jpg" style="width: 135px; height: 43px;"></a></li><li><a href="http://msdn.microsoft.com/ru-ru/windows/"><img alt="" src="img/windev.jpg" style="width: 135px; height: 43px;"></a></li>
              <li><a href="http://github.com"><img alt="" src="img/github.jpg" style="width: 135px; height: 43px;"></a></li>
              <li><a href="http://developer.android.com/index.html"><img alt="" src="img/bg_logo.jpg" style="width: 135px; height: 43px;"></a></li>              
              <li><a href="http://phonegap.com"><img alt="" src="img/phonegap.jpg" style="width: 135px; height: 43px;"></a></li>
<li><a href="http://prestashop.org"><img alt="" src="img/presta.jpg" style="width: 135px; height: 43px;"></a></li>
<li><a href="http://drupal.com"><img alt="" src="img/drupal.jpg" style="width: 135px; height: 43px;"></a></li>
<li><a href="http://joomla.org"><img alt="" src="img/joomla.jpg" style="width: 135px; height: 43px;"></a></li>
<li><a href="http://wordpress.org"><img alt="" src="img/wp-header-logo.jpg" style="width: 135px; height: 43px;"></a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span10"><br><br>
<h3>Программа Horoscope (Гороскоп)</h3>
<p>Приложение позволяет читать ежедневный гороскоп на вашем телефоне:<br> - зодиакальный<br> - лунный гороскоп<br> - Феншуй-прогноз<br> - Китайский гороскоп<br><br>Выскажите свое мнение - проголосуйте за приложение.</p>
<hr>
<img src="img/horoscope_scr1.jpg"  width="250px" height="auto" style="cursor:pointer;" onClick="$('#horoscope_scr1').modal('show')">
<img src="img/horoscope_scr2.jpg"  width="250px" height="auto" style="cursor:pointer;" onClick="$('#horoscope_scr2').modal('show')">
<img src="img/horoscope_scr3.jpg"  width="250px" height="auto" style="cursor:pointer;" onClick="$('#horoscope_scr3').modal('show')">
<img src="img/horoscope_scr4.jpg"  width="250px" height="auto" style="cursor:pointer;" onClick="$('#horoscope_scr4').modal('show')">

<!-- Modal -->
<div class="modal fade" id="horoscope_scr1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:auto;" >
  <div class="modal-dialog">
    <div class="modal-content">
	<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">&nbsp;</h4>
      </div>
      <div class="modal-body" style="max-height: 510px;"><p>
        <img src="img/horoscope_scr1.jpg" style="width:auto;max-height: 500px;"></p>
      </div>      
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- Modal -->
<div class="modal fade" id="horoscope_scr2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:auto;" >
  <div class="modal-dialog">
    <div class="modal-content">
	<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">&nbsp;</h4>
      </div>
      <div class="modal-body" style="max-height: 510px;"><p>
        <img src="img/horoscope_scr2.jpg" style="width:auto;max-height: 500px;"></p>
      </div>      
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- Modal -->
<div class="modal fade" id="horoscope_scr3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:auto;" >
  <div class="modal-dialog">
    <div class="modal-content">
	<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">&nbsp;</h4>
      </div>
      <div class="modal-body" style="max-height: 510px;"><p>
        <img src="img/horoscope_scr3.jpg" style="width:auto;max-height: 500px;"></p>
      </div>      
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- Modal -->
<div class="modal fade" id="horoscope_scr4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:auto;" >
  <div class="modal-dialog">
    <div class="modal-content">
	<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">&nbsp;</h4>
      </div>
      <div class="modal-body" style="max-height: 510px;"><p>
        <img src="img/horoscope_scr4.jpg" style="width:auto;max-height: 500px;"></p>
      </div>      
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<p align="left"><br><i class="icon-download"></i> <a href="https://play.google.com/store/apps/details?id=com.radik.horoscope">Google play</a></p>
<p align="left"><br><a href="http://www.amazon.com/Radik-Apps-Horoscope/dp/B00AY96QLE/ref=sr_1_1?s=mobile-apps&ie=UTF8&qid=1358780768&sr=1-1"><img alt="amazon.com" src="img/amazon.png"></a></p>
<br>Поделиться: <script type="text/javascript" src="//yandex.st/share/share.js" charset="utf-8"></script>
<div class="yashare-auto-init" data-yashareL10n="ru" data-yashareType="none" data-yashareQuickServices="yaru,vkontakte,facebook,twitter,odnoklassniki,moimir,lj,gplus"></div> 
</div>
</div>
    <hr>
    <footer>      
<p>
<!-- Yandex.Metrika informer -->
<a href="https://metrika.yandex.ru/stat/?id=26976906&amp;from=informer"
target="_blank" rel="nofollow"><img src="//bs.yandex.ru/informer/26976906/3_1_FFFFFFFF_FFFFFFFF_0_pageviews"
style="width:88px; height:31px; border:0;" alt="Яндекс.Метрика" title="Яндекс.Метрика: данные за сегодня (просмотры, визиты и уникальные посетители)" /></a>
<!-- /Yandex.Metrika informer -->

<!-- Yandex.Metrika counter -->
<script type="text/javascript">
(function (d, w, c) {
    (w[c] = w[c] || []).push(function() {
        try {
            w.yaCounter26976906 = new Ya.Metrika({id:26976906,
                    clickmap:true,
                    trackLinks:true,
                    accurateTrackBounce:true});
        } catch(e) { }
    });

    var n = d.getElementsByTagName("script")[0],
        s = d.createElement("script"),
        f = function () { n.parentNode.insertBefore(s, n); };
    s.type = "text/javascript";
    s.async = true;
    s.src = (d.location.protocol == "https:" ? "https:" : "http:") + "//mc.yandex.ru/metrika/watch.js";

    if (w.opera == "[object Opera]") {
        d.addEventListener("DOMContentLoaded", f, false);
    } else { f(); }
})(document, window, "yandex_metrika_callbacks");
</script>
<noscript><div><img src="//mc.yandex.ru/watch/26976906" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
<!-- /Yandex.Metrika counter --><br><a href="http://rjump.net/humans.txt" target="_blank"><img src="img/humanstxt-isolated-blank.gif" alt="" style="padding-right:10px;"/></a>
<br>
&copy; RJump.net 2011-<?php echo date("Y"); ?></p>
    </footer>
    </div> <!-- /container -->

    <!-- javascript	
    ================================================== -->
    <script src="js/jquery.js"></script>   
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
