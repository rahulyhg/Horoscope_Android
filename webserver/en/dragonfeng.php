<?php
header('Content-Type: text/html; charset=utf-8');
error_reporting(0);$s = $_GET['s'];

$url = 'http://www.wofs.com/index.php?option=com_jumi&fileid=12';
$curl = curl_init();
curl_setopt($curl, CURLOPT_URL, $url);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
curl_setopt($curl, CURLOPT_HEADER, false);
$text = curl_exec($curl);
curl_close($curl);

if(strlen($text)<=0){echo "<p>It was not possible to load. Repeat again.</p>";}else{
$data=explode('horoscope_div.gif',$text);
$text2=$data[2];
$data=explode('horoscope_rat.jpg',$text2);
$text2=explode('horoscope_div.gif',$data[1]);


$messageutf8 = str_replace('<img src=','',$text2[0]);
$messageutf8 = str_replace('templates','',$messageutf8);
$messageutf8 = str_replace('wofs-2.5','',$messageutf8);
$messageutf8 = str_replace('images','',$messageutf8);$messageutf8 = str_replace('.jpg','',$messageutf8);
$messageutf8 = str_replace('horoscope_','',$messageutf8);
$messageutf8 = str_replace('///ox','',$messageutf8);
$messageutf8 = str_replace('///tiger','',$messageutf8);
$messageutf8 = str_replace('///rabbit','',$messageutf8);
$messageutf8 = str_replace('///dragon','',$messageutf8);
$messageutf8 = str_replace('///snake','',$messageutf8);
$messageutf8 = str_replace('///horse','',$messageutf8);
$messageutf8 = str_replace('///sheep','',$messageutf8);
$messageutf8 = str_replace('///monkey','',$messageutf8);
$messageutf8 = str_replace('///rooster','',$messageutf8);
$messageutf8 = str_replace('///dog','',$messageutf8);
$messageutf8 = str_replace('///boar','',$messageutf8);$messageutf8 = str_replace('///','',$messageutf8);
$messageutf8 = str_replace('<td>','',$messageutf8);
$messageutf8 = str_replace('</td>','',$messageutf8);
$messageutf8 = str_replace('<tr>','',$messageutf8);
$messageutf8 = str_replace('</tr>','',$messageutf8);
$messageutf8 = str_replace('border=0>','',$messageutf8);
echo '<html><body style="width:500px"><font size="'.$s.'">'.$messageutf8."</font><hr><p>© by www.wofs.com</p></body></html>";
}
?>