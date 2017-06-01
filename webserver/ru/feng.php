<?php
header('Content-Type: text/html; charset=utf-8');
error_reporting(0);$s = $_GET['s'];
$text=file_get_contents('http://oculus.ru/goroskop_na_segodnya/feng-shui.html');
if(strlen($text)<=0){echo "<p>Ошибка соединения. Повторите позднее</p>";}else{
$data=explode('<div id="centerCol">',$text);
$text2=$data[1];
$data=explode('<div class="yandex_box">',$text2);
$messageutf8 = iconv('windows-1251', 'UTF-8', '<font size="'.$s.'">'.$data[0]."</font><hr><p>© oculus.ru</p>");
echo $messageutf8;
}

?>