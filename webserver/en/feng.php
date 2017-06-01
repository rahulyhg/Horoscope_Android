<?php
header('Content-Type: text/html; charset=utf-8');error_reporting(0);
$s = $_GET['s'];
$url = 'http://www.astrology.com/horoscopes/details/'.date("Y-m-d").'/daily-feng-shui';
$curl = curl_init();
curl_setopt($curl, CURLOPT_URL, $url);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
curl_setopt($curl, CURLOPT_HEADER, false);
$text = curl_exec($curl);
curl_close($curl);
if(strlen($text)<=0){echo "<p>It was not possible to load. Repeat again.</p>";}else{
$data=explode("details_text'>",$text);
$text2=$data[1];
$data=explode('</p>',$text2);
echo date("Y-m-d");
echo '<font size="'.$s.'">'.$data[0]."</font><hr><p>© by www.astrology.com</p>";
echo $text=file_get_contents('http://online.geomancy.net/public/code/html-fs-daily-forecast');
}
?>