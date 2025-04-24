<!DOCTYPE html>
<html lang="fr">
<head>
	<title>Inclusion</title>
	<meta charset="UTF-8" />
	<style>blockquote { border: 3px outset #555; padding: .4em; }</style>
</head>
<body>

<h2>Inclusion du fragment HTML</h2>
<blockquote>
<?php
$frg=file_get_contents('fragmentHTML.txt');
echo $frg;
?>
</blockquote>

<h2>Inclusion du fragment PHP</h2>
<blockquote>
<?php
ob_start();
include 'fragmentPHP.txt';
$frg=ob_get_clean();
echo $frg;
?>
<h2>Conclusion</h2>
<p>Lorem ipsum dolor sit amet.</p>



</body>
</html>
