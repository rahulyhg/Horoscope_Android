<?php
header('Content-Type: text/html; charset=utf-8');
error_reporting(0);$s = $_GET['s'];
$text=file_get_contents('http://horoscopes.rambler.ru/moon/');
if(strlen($text)<=0){echo "<p>Ошибка соединения. Повторите польже</p>";}else{
$data=explode('<index>',$text);
$text2=$data[1];
$data=explode('</index>',$text2);
echo  '<font size="'.$s.'">'.$data[0]."</font><hr><p>© horoscopes.rambler.ru</p>";
}

?>