<?php
include 'connection.php';
$connect = mysqli_connect($host, $user, $pass, $database);
$result = mysqli_query($connect, "select * from beacons");

$id_beacon = $_GET['id_beacon'];
$query = "DELETE FROM `beacons` WHERE id_beacon='".$id_beacon."';";

//print($query);

$result = mysqli_query($connect, $query);

$resultdata = array();

while ($row = mysqli_fetch_array($result)) {
	
}
	//echo $print[];
	
    print $result;
?>