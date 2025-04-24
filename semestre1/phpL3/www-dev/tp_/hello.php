<?php
if(key_exists('teste',$_GET) && $_GET['teste'] === 'mode')
  header("Content-Type: text/plain");
http_response_code(404);
echo "Hello\n";
echo "<strong>\n";
echo "World!\n";
//var_export(getallheaders());
//var_export($_GET);
