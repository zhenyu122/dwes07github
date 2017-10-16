<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Primer ejemplo de PHP</title>
</head>
<body>
<?php
echo "<h1>Mi primera web escrita en PHP</h1>\n";
echo "<p>PHP es un preprocesador de hipertexto <em>(Hypertext Preprocessor)</em></p>\n";
?>
<p>Permite insertar código de programación intercalado en el lenguaje HTML sin que el usuario final tenga constancia de que el código que está viendo en pantalla haya sido generado por PHP.</p>
<?php
echo "<p>Examina el código fuente de esta página y compruébalo.</p>\n";
// el código PHP queda oculto al usuario final
echo "<!-- sólo se verá lo que nosotros queramos-->\n";
$variableSecreta = 12345;
?>
</body>
</html>