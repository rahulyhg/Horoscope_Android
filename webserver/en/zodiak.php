<?php
header('Content-Type: text/html; charset=utf-8');
error_reporting(0);
if(isset($_GET['z'])){
$zod = $_GET['z'];
$s = $_GET['s'];
$t = $_GET['t'];
$day=date("Y-m-d");
if($t=='0'){$date = new DateTime();
$date->sub(new DateInterval('P1D'));
$day=$date->format('Y-m-d');}
if($t=='2'){
$date = new DateTime();
$date->add(new DateInterval('P1D'));
$day=$date->format('Y-m-d');
}
$text=file_get_contents('http://glo.com/horoscopes/sunsign/daily?date='.$day.'&sign='.$zod);
echo $day;
if(strlen($text)<=0){echo "<p>Ошибка соединения. Повторите позднее</p>";}else{
$data=explode('class="description"',$text);
$text='<div class="description"'.$data[1];
$data=explode('<strong',$text);
echo '<font size="'.$s.'">'.$data[0]."</font><hr><p>© The AstroTwins, Tali & Ophira Edut via mysign.com</p>";
}
}
?>