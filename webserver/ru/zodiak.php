<?php
header('Content-Type: text/html; charset=utf-8');
error_reporting(0);
if(isset($_GET['z'])){
$zod = $_GET['z'];$s = $_GET['s'];
$t = $_GET['t'];
$day="today";
if($t=='0'){$day="yesterday";}
if($t=='2'){$day="tomorrow";}
$url = 'https://touch.horo.mail.ru/prediction/'.$zod.'/'.$day.'/';
$curl = curl_init();
curl_setopt($curl, CURLOPT_URL, $url);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
curl_setopt($curl, CURLOPT_HEADER, false);
$text = curl_exec($curl);
curl_close($curl);


if(strlen($text)<=0){echo "<p>Ошибка соединения. Повторите позднее</p>";}else{
$data=explode('<p>',$text);
$text2=$data[1];

$data=explode('<div',$text2);

echo  '<font size="'.$s.'">'.$data[0].'</font><hr><p>© Lady.mail.ru, эксклюзивный прогноз</p>';
}
}
?>