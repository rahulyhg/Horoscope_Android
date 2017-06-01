<?php
header('Content-Type: text/html; charset=utf-8');
error_reporting(0);$s = $_GET['s'];
$text=file_get_contents('http://ru.gbtimes.com/horoscope');
if(strlen($text)<=0){echo "<p>Ошибка соединения. Повторите позднее</p>";}else{
$data=explode('<section class="horoscope-day-animal">',$text);
$text2=$data[1];
$data=explode('</section>',$text2);
$messageutf8 = str_replace('<td>','',$data[0]);
$messageutf8 = str_replace('</td>','',$messageutf8);
$messageutf8 = str_replace('<tr>','',$messageutf8);
$messageutf8 = str_replace('</tr>','',$messageutf8);

$messageutf8 ='<font size="'.$s.'">'.$messageutf8."</font><hr><p>© ru.gbtimes.com</p>";
echo $messageutf8;
}
?>