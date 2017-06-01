<?php
header('Content-Type: text/html; charset=utf-8');$s = $_GET['s'];
error_reporting(0);
$url = 'http://www.yasminboland.com/category/moon-meditation/';
$curl = curl_init();
curl_setopt($curl, CURLOPT_URL, $url);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
curl_setopt($curl, CURLOPT_HEADER, false);
$text = curl_exec($curl);
curl_close($curl);
if(strlen($text)<=0){echo "<p>It was not possible to load. Repeat again.</p>";}else{
$data=explode('"hfeed">',$text);
$text2=$data[1];
$data=explode('<strong>',$text2);
$text2=$data[1];
$data=explode('Get your Soul Profile',$text2);

echo '<font size="'.$s.'">'.$data[0]."</font><hr><p>© by www.yasminboland.com</p>";
}
?>