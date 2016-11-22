<?php
include 'connection.php';
$connect = mysqli_connect($host, $user, $pass, $database);

$id_beacon = $_GET['id_beacon'];
$query = "SELECT * FROM `beacons` WHERE id_beacon='".$id_beacon."';";

//print($query);

$result = mysqli_query($connect, $query);

$resultdata = array();

while ($row = mysqli_fetch_array($result)) {
	$row_array['id_beacon'] = $row['id_beacon'];
	$row_array['name'] = $row['name'];
	$row_array['author'] = $row['author'];
	$row_array['year'] = $row['year'];
	$row_array['description'] = $row['description'];
	$row_array['image_url'] = $row['image_url'];
	$row_array['showroom'] = $row['showroom'];

	array_push($resultdata, $row_array);
  	$print['object'][] = $resultdata;

  	
}
	//echo $print[];
	
    print json_encode($resultdata);
?>