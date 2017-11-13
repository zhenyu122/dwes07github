<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Validación</title>
<style type="text/css">
label {display:inline-block;width: 80px;}
input[type="text"]{width: 200px;margin-bottom: 5px;}
input[type="email"]{width: 200px;margin-bottom: 5px;}
input[type="password"]{width: 200px;margin-bottom: 5px;}
input[type="tel"]{width: 200px;margin-bottom: 5px;}
input[type="date"]{width: 200px;margin-bottom: 5px;}
a{color:red;}
</style>
</head>
<body> 
<h1>Validación</h1>
    <fieldset>
    <legend>Introduce los datos</legend>
    <form action="Procesamiento.php" method="post">
    <label>Nombre</label><input type="text" name="nombre" value="<?php if (isset($_POST["eviar"]))echo $nombre?>" required="required"><br>
    <label>Apellido</label><input type="text" name="apellido" value="<?php if (isset($_POST["eviar"]))echo $ape?>"><br>
    <label>Password</label><input type="password" name="pass" value="<?php if (isset($_POST["eviar"]))echo $pass?>" required="required"><br>
    <label>E-mail</label><input type="email" name="email" value="<?php if (isset($_POST["eviar"]))echo $email?>" required="required"><br>
    <label>Fecha nacimiento</label><input type="date" name="fecha" value="<?php if (isset($_POST["eviar"]))echo $fecha?>" required="required"><br>
    <label>Dirección</label><input type="text" name="direccion" value="<?php if (isset($_POST["eviar"]))echo $dir?>"><br>
    <label>Teléfono</label><input type="tel" name="tel" value="<?php if (isset($_POST["eviar"]))echo $tel?>"><br>
    <label>Ciclo</label>
    <select name="ciclo">
    	<option value="DAW">DAW</option>
    	<option value="ASIR">ASIR</option>
    </select><br>
    <input type="submit" name=enviar>
    </form>
    </fieldset>
</body>
</html>